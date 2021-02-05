#define _XOPEN_SOURCE 700

#include<sys/types.h>
#include <sys/stat.h>
#include <wait.h>
#include <fcntl.h>
#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <assert.h>
#include <unistd.h>

int main (int argc, char* argv[])
{ 
    if (argc != 1)
    {
        printf("le programme ne prend pas d'arguemnts");
        return EXIT_FAILURE;
    }
    int a, b;
    
    printf("Entrez votre premier nombre : ");
    scanf("%d", &a);
    printf("Entrez votre deuxième nombre : ");
    scanf("%d", &b);

    int lengthA = snprintf(NULL, 0, "%d", a);
    int lengthB = snprintf(NULL, 0, "%d", b);

    char * charA = malloc(lengthA +1);
    char * charB = malloc(lengthB +1);

    snprintf(charA, lengthA + 1, "%d", a);
    snprintf(charB, lengthB + 1, "%d", b);
    
    char * const params[] = {"Ex7_c", charA, charB, NULL};
    execv("Ex7_c",params);
    //printf("%d, %d", a, b);
    free(charA);
    free(charB);
    return EXIT_SUCCESS;
}
