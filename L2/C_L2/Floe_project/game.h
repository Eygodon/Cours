//
// Created by Eygodon on 08/03/2020.
//

#ifndef UNTITLED_GAME_H
#define UNTITLED_GAME_H


#include <windows.h>
#include <string.h>
#include "Floe.h"




/***************** CODE YANN **************/
// fonctions commentee dans game.c

void display_floe (T_floe floe);
T_pos getStartPos ( T_floe floe);
T_player* setPlayers ( T_floe floe, int playerNb );
T_pos playerPositioning ( T_floe floe, T_player player);

/****************** CODE ALEXIS *************************/
void Anobstacle(T_floe floe,int i,int y,int dirx,int diry,int nb_player);
void glaconmove (T_floe floe,int i,int y,int j,int z,int nb_player);
void anobject(T_floe floe,int i,int y,int j,int z,int nb_player);
void next_move (T_floe floe,int i,int y,int nb_player);
void Player_turn(T_floe floe,int nb_player);
void gameloop(T_floe floe,int nb_player);
T_pos findcenter(T_floe floe,int HammerX,int HammerY);
T_pos finddir(T_floe floe,T_vec dir,T_pos center);
void rotationcenter(T_floe floe,int iceCubex,int iceCubey,int hammerx,int hammery,int nb_player);
void hammermove(T_floe floe,int i,int y,int dirx,int diry,int nb_player);
int isOK(T_floe floe,T_pos posAfter);
#endif //UNTITLED_GAME_H
