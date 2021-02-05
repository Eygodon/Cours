//
// Created by Eygodon on 20/02/2020.
//

#include "Player.h"


// printPlayer print une ligne par joueur, complexité linéaire

void printPlayer (T_player* playerList, int playerNb)
{
    for (int i = 0; i < playerNb ; ++i)
    {
        printf("Player %d :%s \n", i+1, playerList[i].name);
    }
    return;
}

