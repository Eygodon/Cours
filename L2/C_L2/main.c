#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

int exercice1(){
    char nom[50], prenom[50];
    printf("Nom :");
    scanf("%s", &nom);
    printf("Prenom :");
    scanf("%s", &prenom);

    printf("Bonjour %s %s", nom, prenom);
    return 0;
}

int exercice2 () {
    int a = 38;
    int b = 125;
    printf("%d %d", a, b );

    return 0;
}

int exercice3() {
    int a, b;
    printf("Valeur 1 :");
    scanf("%d", &a);
    printf("Valeur 2 :");
    scanf("%d", &b);
    printf("a = %d, b = %d \n", a, b);
    int temp = a;
    a = b;
    b = temp;
    printf("a = %d, b = %d", a, b);
    return 0;
}

int exercice31() {
    int a, b, c;
    printf("Valeur 1 : ");
    scanf("%d", &a);
    printf("Valeur 2 : ");
    scanf("%d", &b);
    printf("Valeur 3 : ");
    scanf("%d", &c);
    printf("a = %d, b = %d, c = %d\n", a, b, c);
    int temp = a;
    a = b;
    b = c;
    c = temp;
    printf("a = %d, b = %d, c = %d\n", a, b, c);
    return 0;
}

int exercice4() {
    int a,b;
    printf("Valeur 1 : ");
    scanf("%d", &a);
    printf("Valeur 2 : ");
    scanf("%d", &b);
    int c = a / b;
    printf("%d", c);


    return 0;
}

int exercice2q1() {
    int a;
    bool result = false;
    printf("Annee :");
    scanf("%d", &a);
    if (a % 4 == 0) {
        if (a % 100 == 0) {
            if (a % 400 == 0) {
            result = true;
            }
            else result = false;
        }
        else result = true;
    }
    printf("%d", result);
    return 0;
}

int exercice2q2() {
    int m = 0;
    printf("Numero du mois (commence par 1) :");
    scanf("%d", &m);
    switch (m) {
        case 1:
            printf("31 jours");
            break;
        case 2:
            printf("Soit 28 soit 29 jours");
            break;
        case 3:
            printf("31 jours");
            break;
        case 4:
            printf("30 jours");
            break;
        case 5:
            printf("31 jours");
            break;
        case 6:
            printf("30 jours");
            break;
        case 7:
            printf("31 jours");
            break;
        case 8:
            printf("31 jours");
            break;
        case 9:
            printf("30 jours");
            break;
        case 10:
            printf("31 jours");
            break;
        case 11:
            printf("30 jours");
            break;
        case 12:
            printf("31 jours");
            break;
        default:
            printf("Erreur input");
            break;
    }
    return 0;
}

int exercice2q3(){
    int a, b, c;
    printf("Valeur 1 : ");
    scanf("%d", &a);
    printf("Valeur 2 : ");
    scanf("%d", &b);
    c = a;
    for (int i = 1; i<b; i++) {
        a += c;
    }
    printf("%d", a);

    return 0;
}

int exercice2q4() {
    int h;
    printf("Hauteur :");
    scanf("%d", &h);
    for (int i = 0; i<h; i++) {
        for (int j = 0; j < (h - i); j++) {
            printf(" ");
        }
        for (int j = 0; j < i; j++) {
            printf("%d", j);
        }
        for (int j = i ; j >= 0; j--) {
            printf("%d", j);
        }
        printf("\n");
    }
    return 0;
}


int exercice2q5() {
    int a, b;
    printf("Factoriel :");
    scanf("%d", &a);
    b = a - 1;
    while (b > 0) {
        a *= b;
        b--;
    }
    printf("%d", a);
    return 0;
}

int exercice2q6() {

    int stop = 0;
    int a = 0;
    int b;
    while (stop == 0) {
        printf("Valeur a ajouter :");
        scanf("%d", &b);
        if (b == 0) {
            stop = 1;
            printf("%d", a);
        }
        else {
            a += b;
        }

    }
    return 0;
}

int exercice2q7() {
    int a = 0, b = 0, c = 0 ,d = 0, e = 0, stop = 0; // a = valeur record, b = longueur record, c = valeur actuelle, d = longueur actuelle
    while (stop == 0) {
        printf("Valeur a ajouter :");
        scanf("%d", &e);
        if (e == 0) {
            stop = 1;
            printf("Longueur %d sur valeur %d", a, d);
        }
        else {
            if (e == c) {
                d++;
            }
            else c = e;

            if (a == c && d > b) {
                b++;
            }//marche po encore
        }
    }
    return 0;
}

int exercice2q9() {
    int a, b, c, temp, i = 0;
    printf("U0 :");
    scanf("%d", &a);
    printf("U1 :");
    scanf("%d", &b);
    do {
        if (i == 0) {
            printf("%d\n", a);
            i++;
        }
        else if (i == 1) {
            printf("%d\n", b);
            i++;
        }
        else {
            c = a + b;
            temp = b;
            b = c;
            a = temp;
            printf("%d\n", c);
            i++;
        }

    }while (i < 10);
    return 0;
}

int exercice3q1() {
    int tab[100];
    for (int i = 0; i<100; i++) {
        tab[i] = i + 1;
    }
    for (int i = 0; i<100; i++) {
        if (i % 2 == 1) {
        printf("%d\n", tab[i]);
        }
    }
    return 0;
}

int exercice3q3() {
    int a, b;
    printf("Valeur min:");
    scanf("%d", &a);
    printf("Valeur max :");
    scanf("%d", &b);
    srand (time (NULL));
    int r = (rand() % b) + a;
    printf("%d", r);
    return 0;
}

int exercice3q4 () {
    int tab[100];
    srand (time (NULL));
    for (int i = 0; i<100; i++) {
        tab[i] = rand() % 999;
    }
    for (int i = 0; i<100; i+=5) {
        printf("%d ", tab[i]);
        printf("%d ", tab[i+1]);
        printf("%d ", tab[i+2]);
        printf("%d ", tab[i+3]);
        printf("%d\n", tab[i+4]);
    }
    return 0;
}

int exercice3q5() {
    int tab[100], a;
    float b;
    srand (time (NULL));
    for (int i = 0; i<100; i++) {
        tab[i] = rand() % 999;
    }
    for (int i = 0; i<100; i++) {
        a = tab[i] + a;
    }
    printf("%2f\n", (float)a / 100.0);
    return 0;
}
int exercice3q6() {
    int tab[100], a = 500, b = 500;
    srand (time (NULL));
    for (int i = 0; i<100; i++) {
        tab[i] = rand() % 999;
    }
    for (int i = 0; i<100; i++) {
        if (tab[i] > b) {
            b = tab[i];
        }
        if (tab[i] < a) {
            a = tab[i];
        }
    }
    printf("%d %d", a, b);
    return 0;
}

int exercice3q7() {
    int tab[100], a[100], b[100];
    srand (time (NULL));
    for (int i = 0; i<100; i++) {
        tab[i] = rand() % 999;
    }
    for (int i = 0; i<100; i++) {
        if (tab[i] % 2 == 0){
            a[i] = tab[i];
        }
        else {
            b[i] = tab[i];
        }
    }
    for (int i = 0; i < 100; i++) {
        if (a[i] == 0){
;
        } else {
            printf("%d\n", a[i]);
        }
    }
    for (int i = 0; i < 100; i++) {
        if (b[i] == 0){
;
        }
        else {
            printf("%d\n", b[i]);
        }
    } //Retourne des valeurs etranges, je ne comprends pas trop pourquoi :/
    return 0;
}

int exercice3q8(){
    int a, r[8], i = 0;
    scanf("%d", &a);
    while (i <8) {
        if (a% 2 == 1) {
            r[i] = 1;
            a = a/2 -1;
            i++;
        }
        else {
            r[i] = 0;
            a = a / 2;
            i++;
        }
    }
    for (int i = 0; i<8; i++) {
        printf("%d", r[i]);
    }
    return 0; // Ne marche pas du tout la, c'est vraiment le pire code que j'ai jamais ecrit.
}


int exercice3q9() {
    int min, temp, n;
    int tab[100];
    srand (time (NULL));
    for (int i = 0; i<100; i++) {
        tab[i] = rand() % 999;
     }                  // Création du tableau de 100 int random entre 0 et 999
     for (int i = 0; i< 100; i++) {
        printf("%d\n", tab[i]);
     }

    printf("-------------------------");

    for (int i = 0; i<100; i++) {
        min = tab[i];
        for (int j = i; j < 100; j++) {
             if (min > tab[j]) {
                min = tab[j];
                n = j;
             }
        }
        if (i != min) {
            temp = tab[i];
            tab[i] = tab[n];
            tab[n] = temp;
        }
    }
    for (int i = 0; i< 100; i++) {
        printf("%d\n", tab[i]);
     }
    return 0;
}

int exercice4q4() {
    char pw[10];
    printf("Entrez chaine de char : ");
    scanf("%s", &pw);
    printf("%s", pw);
    return 0;
}

int exercice4q5() {
    char chaine[50];
    int n;
    printf("Entrez chaine de char a afficher : ");
    scanf("%s", &chaine);
    printf("Entrez la longueure a afficher : ");
    scanf("%d", &n);
    if (strlen(chaine) < n) {
        n = strlen(chaine);
    }
    for (int i = 0; i < n; i++) {

        for (int j = 0; j <= i; j ++) {
            printf("%c ", chaine[j]);
        }
        printf("\n");
    }
    return 0;
}

int exercice4q7() {
    char chaine[50];
    int len;
    bool isPal = true;
    printf("Entrer la chaine :");
    scanf("%s", &chaine);
    len = strlen(chaine);
    for (int i = 0; i < len - 1; i++) {
        if (chaine[i] != chaine[len - 1 -i]) {
            isPal = false;
        }
    }
    printf("%d", isPal);
    return 0;
}

int main()
{
    exercice4q7();
    return 0;
}

