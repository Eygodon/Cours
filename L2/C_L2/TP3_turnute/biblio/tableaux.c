#include "tableaux.h"

float *allocTabFloat(int size)
{
    float *tab;
    tab = (float*)malloc(sizeof(float) * size);
    return tab;
}

void afficheIntTab(int tab[], int size)
{
    for (int i = 0 ; i < size ; i++){
        printf("La case %d contient la valeur %d\n", i, tab[i]);
    }
}

void afficheFloatTab(float tab[], int size)
{
    for (int i = 0 ; i < size ; i++){
        printf("La case %d contient la valeur %f\n", i, tab[i]);
    }
}

int remplitTab(float *tab, int size)
{
    for(int i = 0 ; i < size ; i++){
        float random = rand()%100 + (rand()%11)/10. - 0.1;
        tab[i] = random;
    }
    return 0;
}

void Q1()
{
    int size;
    printf("Taille du tableau : ");
    scanf("%d", &size);

    float *t = allocTabFloat(size);

    remplitTab(t, size);

    afficheFloatTab(t, size);
}
