//
// Created by Eygodon on 20/02/2020.
//

#ifndef UNTITLED_OBJECTS_H
#define UNTITLED_OBJECTS_H

#include "Player.h"
/*
 * Le type objet qui définit quel objet se situe sur une case, none = aucun
 */
typedef enum
{
    iceCube = 0,
    rock,
    spring,
    hammerHead,
    hammerHandle,
    trap,
    none
}T_object;

/*
 * Un type pour les blocs de glace
 */
typedef struct
{
    T_pos pos;
    T_vec vec;
}T_iceCube;

//objectToChar convertie une valeur de l'enum T_object en un caractère afin de faciliter l'affichage
char objectToChar (T_object obj);

#endif //UNTITLED_OBJECTS_H
