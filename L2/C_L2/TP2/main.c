
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>
int n, tab[50];
/*

void tribulle(int tab[], int taille)
{
    int i, temp,j;
    srand(time(NULL));

    for ( i=0; i<taille; i++)
    {
        tab[i] = rand() % (200-20)+20;
    }
    for (j=0; j<taille; j++)
    {
        for (i=0; i<taille; i++)
        {
            if (tab[i] > tab[i+1])
            {
                temp = tab[i];
                tab[i] = tab[i+1];
                tab[i+1]= temp;
            }
        }
    }
    for (i=0; i<taille; i++)
    {
        printf("%d\n", tab[i]);
    }
}

void ligne(int n, int m)
{
    int i, j;
    for (i=0; i<n; i++)
    {
        for (j=0; j<m; j++)
        {
            printf("*");
        }

        printf("\n");
    }
}

void moyenne(int params[],int nbOfParams){
    int i,sum;
    sum = 0;
    for (i=0; i<nbOfParams-1; i++){
        sum = sum + params[i];
    }
    float res = (float)sum / (float) nbOfParams;
    printf("\n%f\n", res);
}

void polynome(int a, int b, int c){
    float res = (b*b)-(4*a*c);
    printf("\n leur delta :%f\n", res);
    if (res >= 0){
        float root1, root2;
        root1 = (-b-sqrt(res))/2*a;
        root2 = (-b+sqrt(res))/2*a;
        printf("Et les racines du polynome :\n %f & %f\n", root1, root2);
    }
    else
        printf("Le polynome n'a pas de racine");

}

void triNotes (int n, int m){
    int Marks[n][m];

}
*/
int facto (int n)
{
   if (n<1)
       return 1;
   else
       return n*facto(n-1);
   printf("Saisir un entier n :");
    scanf("%d", &n);
    printf("%d factoriel = %d",n,facto(n));
}

int fibo (int U0, int U1, int n)
{
    if (U0 < 0 || U1 < 1|| n ==1)
        return U1;
    else
        fibo(U1, U0+U1, n-1);

}

void TriInsert (int tab[], int taille) {
    int i, temp,j;
    srand(time(NULL));

    for ( i=0; i<taille; i++)
    {
        tab[i] = rand() % (200-20)+20;
    }
    for (int k = 1; k < taille ; ++k) {
      int j = k;

      while (j > 0 && tab[j-1] > tab[j]){
          temp = tab[j],
          tab[j] = tab[j-1];
          tab[j-1] = temp;
          j--;
      }

    }
    for (i=0; i<taille; i++)
    {
        printf("%d ", tab[i]);
        if ((i+1) % 10 == 0   )
            printf("\n");
    }

}

int main ()
{
    /*int a,b,c, taille;
    printf("Saisir le nombre de valeur a trier : ");
    scanf("%d", &taille);
    int tab[taille];
    tribulle(tab, taille);
    printf("Combien de lignes voulez vous saisir ? ");
    scanf("%d", &a);
    printf("Combien d'etoiles par lignes ? ");
    scanf("%d", &b);
    ligne(a,b);
    polynome(a, b, c);*/
   TriInsert(tab, 50);

}