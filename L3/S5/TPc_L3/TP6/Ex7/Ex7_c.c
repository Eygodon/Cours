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
    if (argc != 3)
    {
        printf("Le programme fonctionne de la sorte : ./Ex7_c int int\n");
        return EXIT_FAILURE;
    }
    //execv("Ex7_b",argv);
    int res = 0;
    res = atoi(argv[1]) + atoi(argv[2]);
    printf("Le résultat de %d + %d est : %d\n", atoi(argv[1]), atoi(argv[2]), res);

    return EXIT_SUCCESS;
}