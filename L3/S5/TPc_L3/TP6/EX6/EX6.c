
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

#define  READ_SIDE 0
#define  WRITE_SIDE 1

void fils(int fds1[2], int fds2 [2])
{
    close(fds1[WRITE_SIDE]);
    close(fds2[READ_SIDE]);

    int a, b, res;

    read(fds1[READ_SIDE], &a, sizeof(int));
    read(fds1[READ_SIDE], &b, sizeof(int));

    res = a + b;

    write(fds2[WRITE_SIDE], &res, sizeof(int));
   
}

void pere(int fds1[2], int fds2[2])
{
    close(fds1[READ_SIDE]);
    close(fds2[WRITE_SIDE]);
    
    int a, b, res;

    printf("Saisir le premier nombre : ");
    scanf("%d", &a);
    printf("Saisir le deuxième nombre : ");
    scanf("%d", &b);

    write(fds1[WRITE_SIDE], &a, sizeof(int));
    write(fds1[WRITE_SIDE], &b, sizeof(int));
    
    read(fds2[READ_SIDE], &res, sizeof(int));
    printf("le résultat est : %d\n", res);
    
    close(fds1[WRITE_SIDE]);
    close(fds2[READ_SIDE]);
}


int main()
{
    int fds1[2], fds2[2];
    pipe(fds1);
    pipe(fds2);

    if (fork() == 0)
    {
        fils(fds1, fds2);
    }
    else
    {
        pere(fds1, fds2);
        wait(NULL);
    }

    return EXIT_SUCCESS;
}
