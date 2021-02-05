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
    if (argc < 2)
    {
        printf("Le programme nécessite au moins deux arguments\n");
        return EXIT_FAILURE;
    }
    
    //execv("/bin/ls", argv);
    execv("Ex7_b",argv);
    return EXIT_SUCCESS;
    
    
    

}