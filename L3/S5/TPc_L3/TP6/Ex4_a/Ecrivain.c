#define _XOPEN_SOURCE 700

#include<sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <assert.h>
#include <unistd.h>
int main(int argc, char * argv[] )
{
    if(argc != 1)
    return EXIT_FAILURE;
    mkfifo("montube", 0600);

    int fd = open("montube", O_WRONLY);

    assert(fd != -1);
    printf("le tube vient d'être ouvert en écriture\n");
    char c = 'a';
    do
    {
        c = getchar();
        write(fd,&c,sizeof(char));
    }while( c != '*');
    close(fd);
    return EXIT_SUCCESS;
}