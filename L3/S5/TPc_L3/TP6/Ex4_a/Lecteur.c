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
    int fd = open("montube", O_RDONLY);
    assert(fd != -1);
    printf("le tube vient d'être ouvert en lecture\n");
    char c;
    do
    { 
        int test = read(fd, &c, sizeof(char));
        assert(test == sizeof(char));
        printf("%c\n", c);

    }while( c != '*');

    close(fd);
    unlink("montube");
    return EXIT_SUCCESS;
}