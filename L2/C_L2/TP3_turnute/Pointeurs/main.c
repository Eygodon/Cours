#include <stdio.h>
#include <stdlib.h>

void Q1(){
    //1
    /*
    int *p;
    int *q = NULL;

    printf("Le contenu du pointeur est %d \n", p);
    printf("L'adresse du pointeur est %d \n", &p);
    printf("La valeur pointee est %d \n", *p);
    printf("L'adresse de la valeur pointee est %d \n", &(*p));
    printf("Le contenu du pointeur est %d \n", q);
    printf("L'adresse du pointeur est %d \n", &q);
    printf("La valeur pointee est %d \n", *q);
    printf("L'adresse de la valeur pointee est %d \n", &(*q));

    //2
    int a = 5;
    int *p = &a;
    int *q = NULL;

    printf("Le contenu du pointeur est %d \n", p);
    printf("L'adresse du pointeur est %d \n", &p);
    printf("La valeur pointee est %d \n", *p);
    printf("L'adresse de la valeur pointee est %d \n", &(*p));
    printf("Le contenu du pointeur est %d \n", q);
    printf("L'adresse du pointeur est %d \n", &q);
    printf("La valeur pointee est %d \n", *q);
    printf("L'adresse de la valeur pointee est %d \n", &(*q));

    //3
    int a = 5;
    int *p = &a;
    int *q = NULL;

    printf("On va changer la valeur de a en utilisant le pointeur : ");
    scanf("%d", p);

    printf("Le contenu du pointeur est %d \n", p);
    printf("L'adresse du pointeur est %d \n", &p);
    printf("La valeur pointee est %d \n", *p);
    printf("L'adresse de la valeur pointee est %d \n", &(*p));
    printf("Le contenu du pointeur est %d \n", q);
    printf("L'adresse du pointeur est %d \n", &q);
    printf("La valeur pointee est %d \n", *q);
    printf("L'adresse de la valeur pointee est %d \n", &(*q));

    //4
    int a = 5;
    int b = 3;
    int *p = &a;
    int *q = NULL;

    *p = b;

    printf("a = %d\n", a);

    printf("Le contenu du pointeur est %d \n", p);
    printf("L'adresse du pointeur est %d \n", &p);
    printf("La valeur pointee est %d \n", *p);
    printf("L'adresse de la valeur pointee est %d \n", &(*p));
    printf("Le contenu du pointeur est %d \n", q);
    printf("L'adresse du pointeur est %d \n", &q);
    printf("La valeur pointee est %d \n", *q);
    printf("L'adresse de la valeur pointee est %d \n", &(*q));
    */
    //5
    int a = 5;
    int *p = &a;
    int *q = NULL;
    int *ptr = p;

    printf("On va changer la valeur de a en utilisant un pointeur vers un pointeur : ");
    scanf("%d", ptr);

    printf("a = %d \n", a);

    printf("Le contenu du pointeur est %d \n", p);
    printf("L'adresse du pointeur est %d \n", &p);
    printf("La valeur pointee est %d \n", *p);
    printf("L'adresse de la valeur pointee est %d \n", &(*p));
    printf("Le contenu du pointeur est %d \n", q);
    printf("L'adresse du pointeur est %d \n", &q);
    printf("La valeur pointee est %d \n", *q);
    printf("L'adresse de la valeur pointee est %d \n", &(*q));
}

void Q2()
{
    int size_tab;
    printf("Taille tableau : ");
    scanf("%d", &size_tab);

    int tab[size_tab];
    int *ptr = &tab[0];

    for(int i = 0 ; i < size_tab ; i++)
    {
        ptr = &tab[0] + i;
        *ptr = rand()%100;
        printf("Le contenu de la case %d est %d\n", i, *ptr);
        printf("L'adresse de la case %d est %p\n", i, ptr);
    }
}

void Q3()
{
    int *p;
    char *q = p + 1;
    int size = sizeof(int);

    printf("l'adresse de p est %p\n", p);
    printf("l'adresse de q est %p\n", q);
    printf("un int ca prend %d d'espace\n", size);
}

//Q4 : rappel des trucs de la date utiles ici

typedef struct {
    int jourSemaine;
    int jourMois;
    int mois;
    int annee;
}t_date;

void afficheDate(t_date D)
{
    int j_semaine = D.jourSemaine;
    int j_mois = D.jourMois;
    int m = D.mois;
    int a = D.annee;

    if(j_semaine > 6 || j_mois > 31 || m > 12)
        printf("y a un probleme");
    else
    {
        switch(j_semaine)
        {
        case 0 :
            printf("On est Lundi, le");
            break;
        case 1 :
            printf("On est Mardi, le");
            break;
        case 2 :
            printf("On est Mercredi, le");
            break;
        case 3 :
            printf("On est Jeudi, le");
            break;
        case 4 :
            printf("On est Vendredi, le");
            break;
        case 5 :
            printf("On est Samedi, le");
            break;
        case 6 :
            printf("On est Dimanche, le");
            break;
        }
        printf(" %d/%d/%d\n", j_mois, m, a);
    }
}

t_date *alloueDate()
{
    t_date *date;
    date = (t_date*)malloc(sizeof(t_date));

    printf("Jour de la semaine (0 = Lundi, 1 = Mardi..., 6 = Dimanche) : ");
    scanf("%d", &date->jourSemaine);
    printf("Jour du mois : ");
    scanf("%d", &date->jourMois);
    printf("Numero du mois (1 = Janvier, 2 = Fevrier..., 12 = Decembre) : ");
    scanf("%d", &date->mois);
    printf("Annee : ");
    scanf("%d", &date->annee);

    return date;
}

void Q4()
{
    t_date *date = alloueDate();
    afficheDate(*date);
}

int main()
{
    //Q1();
    Q2();
    //Q3();
    //Q4();
    return 0;
}
