#include <stdlib.h>

#include "Collection.h"
#include "myassert.h"

/*----------*
 * initialisation de la structure
 *----------*/
 
struct CollectionP
{
	int size;
	Voiture *voi_arr;
	bool isSorted;
};

Collection col_creer()
{
	Collection self = malloc(sizeof(struct CollectionP));
	
	self->size = 0;
	self->voi_arr = NULL;//  !malloc(sizeof(struct VoitureP));
	self->isSorted = false;
	
	return self;
}

Collection col_creerCopie(const_Collection source)
{
	Collection self = malloc(sizeof(struct CollectionP));
	self->size = source->size;
	self->voi_arr = source->voi_arr;
	self->isSorted = source->isSorted;
	
	return self;
}

void col_detruire(Collection *pself)
{
	
	for(int i = 0; i<(*pself)->size; i++)
	{
		voi_detruire(&((*pself)->voi_arr[i]));
	}
	
	free(*pself);
}

void col_vider(Collection self)
{
	self->isSorted = true;
	self->voi_arr = NULL;
	self->size = 0;
}

/*----------*
 * accesseurs
 *----------*/
 
 int col_getNbVoitures(const_Collection self)
 {
 	return self->size;
 }
 
 Voiture col_getVoiture(const_Collection self, int pos)
 {
 	myassert(self->voi_arr!=NULL, "la collection est vide\n");
 	Voiture aim = voi_creerCopie(self->voi_arr[pos]);
 	return aim;
 }
 
 void col_addVoitureSansTri(Collection self, const_Voiture voiture)
 {
 	myassert(self->voi_arr!=NULL, "la collection est vide\n");
 	self->size++;
 	self->voi_arr = realloc(self->voi_arr, self->size * sizeof(Voiture));
 	self->voi_arr[self->size - 1] = voi_creerCopie(voiture);
 	if (self->size > 1)
 	self->isSorted = false;
 }
 
 void col_addVoitureAvecTri(Collection self, const_Voiture voiture)
 {
 	myassert(self->voi_arr!=NULL, "la collection est vide\n");
 	myassert(self->isSorted, "La collection doit être triée\n");
 	
 	int i;
 	int year = voi_getAnnee(voiture);
 	
	self -> size++;
	self -> voi_arr = realloc(self->voi_arr, self->size * sizeof(Voiture));
	
	for(i = (self->size); (i > 0) && (year < voi_getAnnee(self -> voi_arr[i-1])); i--)
	 	{
	 		self->voi_arr[i] = self -> voi_arr[i-1];
	 	}
	 	
	 self-> voi_arr[i] = voi_creerCopie(voiture);	 
 }
 
void col_supprVoitureSansTri(Collection self, int pos)
{
	myassert(self->voi_arr!=NULL, "la collection est vide\n");
	
	Voiture temp = self->voi_arr[pos];
	Voiture end = self->voi_arr[self->size];
	
	self->voi_arr[pos] = end;
	end = temp;
	voi_detruire(&end);
	
	self-> size++;
	self->voi_arr = realloc(self->voi_arr, self->size * sizeof(Voiture));
	self-> isSorted = false;
}

void col_supprVoitureAvecTri(Collection self, int pos)
{
	myassert(self->voi_arr!=NULL, "la collection est vide\n");
	myassert(self->isSorted, "La collection doit être triée\n");
	int i = 0, end = self->size;
	
	for(i = pos; i < end; i++)
	self->voi_arr[i] = self->voi_arr[i+1];
	
	voi_detruire(&(self->voi_arr[end]));
	
	self->size--;
	self->voi_arr = realloc(self->voi_arr, self->size * sizeof(Voiture));
}
 
 void col_trier(Collection self)
 {
 	//Manque de temps je me suis arrêté ici et je ne suis pas sur que l reste fonctionne...
 }
 
 
 
 
 
 
 
