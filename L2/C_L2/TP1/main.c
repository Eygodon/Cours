#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>


char FirstName[20];
char LastName[20];
char FullName[40];
int X, Y, temp, a, b, i;
float f, j;




    void PremiersProgrammesQ1() {
    printf("Prenom : ");
    scanf("%s", &FirstName);
    printf("Nom : ");
    scanf("%s", &LastName);
    printf("Bonjour %s %s", FirstName, LastName);

}

    void PremiersProgrammesQ2 () {
       printf("Entrez les valeurs :");
       scanf("%d %d", &a, &b);
       printf("%c %c\n",a, b); //caractère associé
       printf("%d %d\n",a, b); // valeur décimale
       printf("%f %f\n",a, b); // partie décimale
       printf("%i %i\n",a, b); //  entier relatif
       printf("%o %o\n",a, b); // Conversion en Octale
       printf("%O %O\n",a, b); // ??
       printf("%x %x\n",a, b); // hexadecimal
       printf("%X %X\n",a, b); // hexadecimal
}

    void PremiersProgrammesQ3a() {
        printf("Valeurs X et Y :");
        scanf("%d %d", &X, &Y);
        temp = X;
        X = Y;
        Y = temp;
        printf("%d %d", X, Y);
}

    void PremiersProgrammesQ3b() {
        printf(" Entrez les valeurs :");
        scanf("%d %d %d", &a, &b, &X);
        temp = X;
        X = b;
        b = a;
        a = temp;
        printf("%d %d %d", a, b, X);
    }

    void PremiersProgrammesQ4()
    {
        printf("Entrez les valeurs :");
        scanf("%d %f", &a, &f);
        temp = a/f;
        printf("%d", temp);
        //On ne peut pas opérer int and float entre eux
    }

    void StructuresQ1 (int year) {

    if ((year % 4 == 0 && year % 20 != 0) || (year % 400 == 0))
    printf("%d est une annee bissextile", year);
    else printf("%d n'est pas une annee bissextile", year);

}

    void StructuresQ2 (int month) {
        switch (month) {
            case 1 : printf("Le mois %02d contient 31 jours", month);
                break;
            case 2 : printf("Le mois %02d contient 28 ou 29 jours", month);
                break;
            case 3 : printf("Le mois %02d contient 31 jours", month);
                break;
            case 4 : printf("Le mois %02d contient 30 jours", month);
                break;
            case 5 : printf("Le mois %02d contient 31 jours", month);
                break;
            case 6 : printf("Le mois %02d contient 30 jours", month);
                break;
            case 7 : printf("Le mois %02d contient 31 jours", month);
                break;
            case 8 : printf("Le mois %02d contient 31 jours", month);
                break;
            case 9 : printf("Le mois %02d contient 30 jours", month);
                break;
            case 10 : printf("Le mois %02d contient 31 jours", month);
                break;
            case 11 : printf("Le mois %02d contient 30 jours", month);
                break;
            case 12 : printf("Le mois %02d contient 31 jours", month);
                break;
            default : printf("Veuillez entrer un mois valide");
        }
    }

    void StructuresQ3()
    {
        printf("Indiquez les deux entiers a multiplier :\n");
        scanf("%d %d", &a, &b);
        int res = 0;
        for (int k = 0; k < b; ++k) {
           res  = res + a;
        }
        printf("\nResultat : %d", res);
    }

    void StructuresQ4()
    {
        int h;
        printf("Hauteur :");
        scanf("%d", &h);
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < h-i ; ++j) {
                printf(" ");
            }
            for (int j = 0; j < i ; ++j) {
                printf("%d", j);
            }
            for (int j = i; j >= 0 ; --j) {
                printf("%d", j);
            }
            printf("\n");
        }
        return;
    }

    void StructuresQ5()
    {
        int n;
        printf("Saisissez une valuer n :\n");
        scanf("%d", &n);
        int temp = n -1;
        while (temp > 0) {
            n *= temp;
            temp--;
        }
        printf("Le resultat est %d", n);
    }

    void StructuresQ6()
    {
        int stop = 0, a, res = 0;
       printf("Saisissez les valeurs a additioner :\n");
       while (stop == 0)
       {
           scanf("%d",&a);
           if (a == 0)
           {
               stop = 1;
               printf("%d", res);
           }
           else res += a;
       }
    }

    void StructuresQ7()
    {
        int stop = 0, a, res = 0,length = 1, recordl = 0, preval = 0;
       printf("Saisissez les valeurs a additioner :\n");
       while (stop == 0)
       {
           scanf("%d", &a);
           if (a == 0)
           {
               stop = 1;
               printf("Le resultat est : %d\n "
                      "La plus longue chaine est de longueur %d", res, recordl);
           }
           else
               {
               res += a;
               if (a == preval)
               {
                   length += 1;
                   if (length > recordl)
                   {
                       recordl = length;
                   }
                   else recordl = recordl;
               }
               else
               {
                   preval = a;
                   length = 1;
               }

               }
       }
    }

    /* void StructuresQ8()
    {
        int n, res;
        printf("Saisissez la valeur de reference : \n");
        scanf("%d", &n);
        int div[20];
         TROP CHIANT*/

    void StructuresQ9()
    {
        int U0, U1, res, temp, i = 0;
        printf("U0 :");
        scanf("%d", &U0);
        printf("U1 :");
        scanf("%d", &U1);
        printf("%d\n", U0);
        printf("%d\n", U1);
        do {
            res = U0 + U1;
            U0 = U1;
            U1 = res;
            printf("%d \n", res);
            i++;
        }
        while (i < 10);
    }

    void  TableauxQ1 ()
    {
        int tab[100];
        srand( time (NULL));
        for (int k = 0; k < 99; ++k)
        {
          tab[k] = rand() % 100;
          printf("%d : %d \n",k, tab[k]);
        }
    }

    void  TableauxQ2 ()
    {
        int tab[100];
        srand( time (NULL));
        for (int k = 0; k < 99; ++k)
        {
            tab[k] = rand() % 100;
            if (k % 2 == 0)
                printf("%d : %d \n",k, tab[k]);
        }
    }

    void TableauxQ3 ()
    {
        int min, max;
        srand(time(NULL));
        printf("Saisissez la fourchette de valeur : \n min : ");
        scanf("%d", &min);
        printf( "max : ");
        scanf("%d", &max);
        printf("%d",rand() % (max - min) + min);
    }

    void TableauxQ4 ()
    {
        int tab[100];
        srand( time (NULL));
        for (int k = 1; k < 100; ++k)
        {
            tab[k] = rand() % (999 - 0) + 0;
            printf("%d ",tab[k]);
            if (k % 20 == 0)
                printf("\n");
        }
    }

    void TableauxQ5 ()
    {
        int tab[100], res = 0;
        srand( time (NULL));
        for (int k = 1; k < 100; ++k)
        {
            tab[k] = rand() % (999 - 0) + 0;
            printf("%d ",tab[k]);
            if (k % 20 == 0)
                printf("\n");
            res += tab[k];
        }
        printf("\nMoyenne : %.2f", (float) res / 100.0);
    }

    void TableauxQ6 ()
    {
        int tab[100];
        srand( time (NULL));
        for (int k = 0; k < 99; ++k)
        {
            tab[k] = rand() % 100;
            printf("%d : %d \n",k, tab[k]);
        }
        int min = tab [0], max = tab[0], indmin = 0, indmax = 0;
        for (int l = 0; l < 99 ; ++l)
        {
            if (tab[l] < min)
            {
                min = tab[l];
                indmin = l;
            }
            if (tab[l] > max)
            {
                max = tab[l];
                indmax = l;
            }
        }
        printf("Indice du min : %d Min : %d\nIndice du max : %d Max : %d", indmin,min,indmax,max);
    }


int main () { TableauxQ6(); }

    /*
    printf("Entrez la chaine a copier :");
    scanf("%s", &FirstName);
    strcpy(LastName, FirstName );
    printf("La voici en double %s %s", LastName, FirstName);
    */
    /*
    printf("Entrez votre prenom :");
    scanf("%s", &FirstName);
    printf("Entrez votre nom :");
    scanf("%s", &LastName);
    strcpy(FullName, FirstName);
    strcat(FullName, " ");
    strcat(FullName, LastName);
    printf("Votre nom complet est : %s", FullName);
     */
   /* printf("Entrez une chaine et un entier :");
    scanf("%s", &FullName);
    scanf("%d", &a);
    for ( int i = 1; i < a + 1 ; i++) {
        strlen(LastName) == i;
        printf("%d : %s \n",i, strcat(LastName, &FullName[i-1]) );
    }
    */
