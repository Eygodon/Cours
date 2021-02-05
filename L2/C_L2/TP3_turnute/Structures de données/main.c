#include <stdio.h>
#include <stdlib.h>

enum jour {lundi, mardi, mercredi, jeudi, vendredi, samedi, dimanche};
enum mois {janvier = 1, fevrier, mars, avril, mai, juin, juillet, aout, septembre, octobre, novembre, decembre};

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

t_date saisieDate()
{
    int jsemaine, jmois, mois, annee;
    printf("Jour de la semaine (0 = Lundi, 1 = Mardi...) : ");
    scanf("%d", &jsemaine);
    printf("Jour du mois : ");
    scanf("%d", &jmois);
    printf("Numero du mois : ");
    scanf("%d", &mois);
    printf("Annee : ");
    scanf("%d", &annee);

    t_date date = {jsemaine, jmois, mois, annee};
    return date;
}

t_date saisieDate2()
{
        int jsemaine, jmois, mois, annee;
    printf("Jour de la semaine (0 = Lundi, 1 = Mardi..., 6 = Dimanche) : ");
    scanf("%d", &jsemaine);
    printf("Jour du mois : ");
    scanf("%d", &jmois);
    printf("Numero du mois (1 = Janvier, 2 = Fevrier..., 12 = Decembre) : ");
    scanf("%d", &mois);
    printf("Annee : ");
    scanf("%d", &annee);

    t_date date = {jsemaine, jmois, mois, annee};
    return date;
}

void modifieDate(t_date *D, int annee)
{
    D ->annee = annee;
}

int main()
{
    /*
    //Q4
    for(int i = 0; i < 8 ; i++){
    t_date date = {i, 6+i, 2+i, 2020+i};
    afficheDate(date);
    }

    //Q5
    afficheDate(saisieDate());

    //Q7
    afficheDate(saisieDate2());
    */
    //Q8&9
    t_date date = saisieDate2();
    modifieDate(&date, date.annee + 1);
    afficheDate(date);



    return 0;
}
