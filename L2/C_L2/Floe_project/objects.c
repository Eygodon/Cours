//
// Created by Eygodon on 08/03/2020.
//


#include "objects.h"


//objectToChar convertie une valeur de l'enum T_object en un caractère afin de faciliter l'affichage


char objectToChar (T_object obj)
{
    char objChar;
    switch (obj) {
        case 0 : objChar = (char)'C';
            break;
        case 1 : objChar = (char)'R';
            break;
        case 2 : objChar = (char)'P';
            break;
        case 3 : objChar = (char)'H';
            break;
        case 4 : objChar = (char)'D';
            break;
        case 5 : objChar = (char)' ';
            break;
        default : objChar = (char)' ';
    }
    return objChar;
}