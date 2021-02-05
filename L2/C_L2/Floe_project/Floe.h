//
// Created by Eygodon on 20/02/2020.
//

#ifndef UNTITLED_FLOE_H
#define UNTITLED_FLOE_H


#include "objects.h"




/********************************************** CODE YANN *****************************************/

// type définissant si une case est de l'eau ou de la glace
typedef enum
{
    water,
    ice
} T_tile_type;

//type definissant si une case est le point d'arrivee de depart ou aucun des deux (chemin)
typedef enum
{
    path,
    start,
    finish
} T_goal;

// type definissant une case : une case a un type, peut contenir un objet, un joueur,
// etre l'arrivee ou le depart du jeu
typedef struct
{
    T_tile_type type;
    T_player* player;
    T_object object;
    T_goal goal ;
}T_tile;

/* type definissant la banquise : elle contient un tableau de case, un int pour sa taille et le nombre de joueur
 et une lsite de joueurs */
typedef struct
{
    T_tile** tab;
    int size;
    int player_nb;
    T_player* players;
}T_floe;

// chaque fonction est commentee denas le fichier  .c correspondant
void randInit();
T_tile** floeAlloc (int size);
void floeFill (T_tile** tab, int size);
T_floe floeInit (int size, int players);
void chooseStart (T_tile** table, int size );
void chooseEnd (T_tile** table, int size );
T_tile** tabInit (int size);
char typeToChar (T_tile_type type);
char goalToChar (T_goal goal);
int isFree (T_tile tile);
void printPlayerPosAux ( T_player player, T_floe floe );
void printPlayerPos (T_player* playerList, T_floe floe);
int isInFloe(T_floe floe, T_pos pos);
T_pos goalPos (T_floe floe);
T_pos startPos (T_floe floe);
int isThereAWay(T_floe floe);
int isThereAWayAux (T_floe floe, int **tabWay, T_pos pos, T_pos goalPos);
T_pos offset(T_pos pos, int offsetX, int offsetY);
int** isWater(T_floe floe, int ** tabWay);
int** tabWay (int size);
int iceCount (T_floe floe);
void objectDisposal (T_floe floe);




/************************************* CODE ALEXIS ***************************/

void fonte_block(T_floe floe,int i,int y);
void fonte_objet(T_floe floe,int i,int y);
void fonteBanquise(T_floe floe,int i,int y);
void fonte(T_floe floe);

#endif //UNTITLED_FLOE_H
