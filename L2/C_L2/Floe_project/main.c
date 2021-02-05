//
// Created by Eygodon on 08/03/2020.
//


#include "game.h"


int main() {
    randInit();
    int playerNb;
    printf("Nombre de joueurs :");
    scanf("%d", &playerNb);
    T_floe floe = floeInit(20,playerNb);

   /* while (isThereAWay(floe,getStartPos(floe)) == 0)
    {
         floe.tab = tabInit(floe.size);
    }*/
    printPlayerPos ( floe.players, floe);
    printPlayer (floe.players, playerNb);
    display_floe(floe);
    gameloop(floe, playerNb);
    free(floe.players);
    free(floe.tab);
    return 0;
}
