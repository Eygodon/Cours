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
    for(int i = 0; i < argc; i++)
    {
        printf("%s\n",argv[i]);
    }
    
    

}