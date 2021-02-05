//
// Created by Eygodon on 20/02/2020.
//

#ifndef UNTITLED_PLAYER_H
#define UNTITLED_PLAYER_H

#include "stdlib.h"
#include "stdio.h"
#include <string.h>
typedef struct
{
    int posX;
    int posY;
} T_pos;

typedef struct
{
    int dX;
    int dY;
}T_vec;

typedef enum
{
    blue,
    red,
    green,
    yellow
}T_color;

typedef struct
{
    char name[20];
    T_color color;
    int ID;
    T_pos pos;
    T_vec vec;
    int score;
}T_player;

//printPlayer print une ligne par joueur, complexité linéaire

//printPlayer print une ligne par joueur, complexité linéaire

void printPlayer (T_player* playerList, int playerNb);
#endif //UNTITLED_PLAYER_H