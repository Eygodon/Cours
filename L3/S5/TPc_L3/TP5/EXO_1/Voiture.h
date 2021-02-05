#ifndef VOITURE_H
#define VOITURE_H

#include <stdio.h>

typedef VoitureP;
typedef struct VoitureP* Voiture;
typedef const struct VoitureP* Const_Voiture;

Voiture voi_Create (const char* brand, int yearMade, int kilom, int nbimmat, const char* immat[]);

Voiture voi_CpyCreate (Const_Voiture source);

Voiture voi_CreateFromFile (FILE* fd);

Voiture voi_Swap (Voiture v1, Voiture v2);
#endif
