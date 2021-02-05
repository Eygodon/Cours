//
// Created by Eygodon on 20/02/2020.
//
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "Floe.h"
#include "game.h"


#define pourcent_fonte 2

void fonte_block(T_floe floe,int i,int y) // fonction de fonte des glace suivant un pourcentage et suivant le cas et si il ya un type d'eau a cot�s avec une copléxité constante Alexis louail
{
    T_pos posNow;
    T_pos posAfter_up;
    T_pos posAfter_down;
    T_pos posAfter_right;
    T_pos posAfter_left;
    posNow.posX=i;
    posNow.posY=y;
    posAfter_up.posX=i;
    posAfter_up.posY=y-1;
    posAfter_down.posX=i;
    posAfter_down.posY=y+1;
    posAfter_left.posX=i-1;
    posAfter_left.posY=y;
    posAfter_right.posX=i+1;
    posAfter_right.posY=y;
    if(( isInFloe(floe,posAfter_up)) && (isInFloe(floe,posAfter_down)) && (isInFloe(floe,posAfter_right)) && (isInFloe(floe,posAfter_left)) )
    {
        if( (floe.tab[posAfter_up.posX][posAfter_up.posY].type == water) ||
           (floe.tab[posAfter_down.posX][posAfter_down.posY].type == water) ||
           (floe.tab[posAfter_right.posX][posAfter_right.posY].type == water) ||
           (floe.tab[posAfter_left.posX][posAfter_left.posY].type == water))
        {
             if ((rand()%101 < pourcent_fonte) && (floe.tab[i][y].goal!=finish))
                {
                    floe.tab[i][y].type=water;
                    floe.tab[i][y].object=none;
                }
        }
    }
    else
    {
         if ((rand()%101 < pourcent_fonte)&& (floe.tab[i][y].goal!=finish) )
                {
                    floe.tab[i][y].type=water;
                    floe.tab[i][y].object=none;
                }
    }


}

void fonte_objet(T_floe floe,int i,int y) //fonction de la fonte des glacon si il y en a sur la case complexité constante Alexis louail
{
    if (floe.tab[i][y].object==iceCube)
    {
        if (rand()%101<pourcent_fonte)
        {
            floe.tab[i][y].object=none;
        }
    }
}

void fonteBanquise(T_floe floe,int i,int y) // fonction controlant la fonte pour 1 case en appelant la fonte objet et block complexité constante Alexis louail
{
    fonte_objet(floe,i,y);
    fonte_block(floe,i,y);

}

void fonte(T_floe floe)//fonction qui applique la fonte au tableau de jeu complexité linéaire en foncion de floe.size Alexis louail
{
    for(int y=0 ; y<floe.size ; y++)
    {
        for(int i=0;i<floe.size;i++)
        {
            fonteBanquise(floe,i,y);
        }
    }
}
/**************************** CODE YANN **************************/

// definit une seed pour les aléatoire necessaires a une partie, complexitee constante
void randInit() {
    srand(time(NULL));
}

// alloue l'espace memoire necessaire au tableau de case de la banquise, complexite lineaire
T_tile** floeAlloc (int size)
{
    T_tile ** tab = (T_tile **)malloc(size * sizeof(T_tile *));

    for(int i = 0; i < size; ++i)
    {
        tab[i] = (T_tile *)malloc(size * sizeof(T_tile));
    }
    return tab;
}

/* remplie le tableau de case avec des valeurs d'initialisation : pas d'objet,
  , de joueur , d'arrive ou de depart sur les cases. Une case est soit de l'eau,
  complexite lineaire en fonction de size*/
void floeFill (T_tile** table, int size)
{
    for (int i = 0; i < size ; ++i) {
        for (int j = 0; j < size ; ++j) {
            table[i][j].type = rand()%2;
            table[i][j].object = none;
            table[i][j].player = NULL;
            table[i][j].goal = path;
        }
    }
}

// on choisit le point de depart et on l'entoure de glace afin de placer les joueurs,
// complexite linéaire en fonction de size
void chooseStart (T_tile** table, int size )
{
    int i,j;
    do {
        i = rand() % size;
        j = rand() % size;
    }
    while (table[i][j].type != ice);
    table[i][j].goal = start;
    table[i+1][j].type = ice;
    table[i+1][j+1].type = ice;
    table[i+1][j-1].type = ice;
    table[i][j+1].type = ice;
    table[i][j-1].type = ice;
    table[i-1][j].type = ice;
    table[i-1][j-1].type = ice;
    table[i-1][j+1].type = ice;
}

// on choisit le point d'arrive, complexite linéaire en fonction de size
void chooseEnd (T_tile** table, int size )
{
    int i,j;
    do {
        i = rand() % size+1;
        j = rand() % size+1;
    }
    while (table[i][j].type != ice);
    table[i][j].goal = finish;
}

/*On initialise le tableau de case avec les fonctions precedentes, complexite lineaire*/
T_tile** tabInit (int size)
{
    T_tile** table = floeAlloc(size);
    floeFill(table, size);
    chooseStart(table, size);
    chooseEnd(table, size);
    return table;
}

// initialisation du type banquise qui definit le jeu, complexitee lineaire en fonction de size et
//du nombre de joueur
T_floe floeInit (int size, int playerNb)
{
    T_floe floe;
    floe.tab = tabInit(size);
    floe.size = size;
    floe.player_nb = playerNb;
    floe.players = setPlayers(floe,playerNb);
    objectDisposal(floe);
   // printf ("ID = %d",floe.players[0].ID);
    return floe;
}


char typeToChar (T_tile_type type)
{
    char typeChar;
    switch (type) {
        case 0 : typeChar = (char)' '; //eau
            break;
        case 1 : typeChar = (char) 'X'; //glace
            break;
        default: typeChar = (char)' ' ;
    }
    return typeChar;
}

//convertie une valeur de l'enum T_goal en un caractère afin de faciliter l'affichage
char goalToChar (T_goal goal)
{
    char goalChar;
    switch (goal) {
        case 0 : goalChar = (char)' '; //Chemin
            break;
        case 1 : goalChar = (char)'S'; //Start
            break;
        case 2 : goalChar = (char)'E'; //End
            break;
        default: goalChar = (char)' ';
    }
    return goalChar;
}

// verifie si on peut placer quelque chose sur la case en parametre, complexite constante
int isFree (T_tile tile)
{
    if (tile.player != NULL || tile.object != none || tile.type != ice || tile.goal != path)
        return 0;
    else
        return 1;
}


void printPlayerPos (T_player* playerList, T_floe floe)
{
    for (int i = 0; i <floe.player_nb ; ++i)
    {
      //  floe.tab[playerList[i].pos.posY][playerList[i].pos.posX].player = playerList + i;
        floe.tab[playerList[i].pos.posX][playerList[i].pos.posY].player = &playerList[i];

    }
}

// verifie qu'une position si situe bien dans la banquise, complexite constante
int isInFloe(T_floe floe, T_pos pos) {
    if ((pos.posX < 0)
        || (pos.posY < 0)
        || (pos.posX >= floe.size)
        || (pos.posY >= floe.size)
            ) {
        return 0;
    } else {
        return 1;
    }
}

// attribue la memoire necessaire a une tableau d'int qui
// recouvre tout le tableau de la banquise et les initialise a 0, complexite lieaire
int** tabWay (int size) {
    int **tab = (int **) malloc(size * sizeof(int *));
    for (int i = 0; i < size; i++)
    {
        tab[i] = (int *) malloc(size * sizeof(int));
    }
    for (int i = 0; i < size; i++)
    {
        for (int j = 0; j < size; j++)
        {
            tab[i][j] = 0;
        }
    }
    return tab;
}

// atrtibue la valeur 2 aux cases d'eau afin de gagner en efficacite dans isThereAWayAux,
// complexite lineaire en fonction de size
int** isWater(T_floe floe, int ** tabWay)
{
    for (int i = 0; i < floe.size; i++)
    {
        for (int j = 0; j < floe.size; j++)
        {
            if (floe.tab[i][j].type == 0)
            {
                tabWay[i][j] = 2;
            }
        }
    }
    return tabWay;
}

// calcule un offset, complexite constante
T_pos offset(T_pos pos, int offsetX, int offsetY) {
    pos.posX += offsetX;
    pos.posY += offsetY;
    return pos;
}

/* cherce un chemin entre pos et goalPos, tabWay contient les cases analysées
appelle la fonction pour les cases de glace alentour
 complexite exponentielle en fonction de floe.size */
int isThereAWayAux (T_floe floe, int **tabWay, T_pos pos, T_pos goalPos) {
    if (tabWay[pos.posX][pos.posY] == 0) {
        if (floe.tab[pos.posX][pos.posY].type == water) {
            tabWay[pos.posX][pos.posY] = 2;
            return 0;
        } else {
            if (pos.posX == goalPos.posX && pos.posY == goalPos.posY) {
                tabWay[pos.posX][pos.posY] = 3;
                return 1;
            } else {
                tabWay[pos.posX][pos.posY] = 1;
                int tile1 = 0, tile2 = 0, tile3 = 0, tile4 = 0;
                if (isInFloe(floe, offset(pos, 1, 0))) {
                    tile1 = isThereAWayAux(floe, tabWay, offset(pos, 1, 0), goalPos);
                }
                if (isInFloe(floe, offset(pos, -1, 0))) {
                    tile2 = isThereAWayAux(floe, tabWay, offset(pos, -1, 0), goalPos);
                }
                if (isInFloe(floe, offset(pos, 0, 1))) {
                    tile3 = isThereAWayAux(floe, tabWay, offset(pos, 0, 1), goalPos);
                }
                if (isInFloe(floe, offset(pos, 0, -1))) {
                    tile4 = isThereAWayAux(floe, tabWay, offset(pos, 0, -1), goalPos);
                }
                if (tile1 == 1 || tile2 == 1 || tile3 == 1 || tile4 == 1) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    } else {
        if (tabWay[pos.posX][pos.posY] == 3) {
            return 1;
        } else {
            return 0;
        }
    }
}

//retourne la position de l'arrivee, complexite lineaire en fonction de floe.size,
// complexite lineaire en fonction de floe.size
T_pos goalPos (T_floe floe) {
    T_pos res;
    res.posX = 0;
    res.posY = 0;
    for (int i = 0; i < floe.size; i++)
    {
        for (int j = 0; j < floe.size; j++)
        {
            if (floe.tab[i][j].goal == finish )
            {
                res.posX = i;
                res.posY = j;
            }
        }
    }
    return res;
}
// idem mais pour la position de depart
T_pos startPos (T_floe floe)
{
    T_pos res = {0,0};
    for (int i = 0; i < floe.size; i++)
    {
        for (int j = 0; j < floe.size; j++)
        {
            if (floe.tab[i][j].goal == start )
            {
                res.posX = i;
                res.posY = j;
            }
        }
    }
    return res;
}
/* Determine l'existence d'un chemin entre depart et arrivee
 0 = pas de chemin existant
 1 = au moins un chemin possible
 complexite exponentielle en fonctiond e floe.size*/
int isThereAWay(T_floe floe)
{
    int **search = isWater(floe, tabWay(floe.size));
    T_pos GoalPos = goalPos(floe);
    T_pos startPOS = startPos(floe);
    int result = isThereAWayAux(floe, search, startPOS, GoalPos);
    free(search);
    return result;
}

// compte le nombre de cases de glace sur la carte, complexite lineaire en fonctionde floe.size
int iceCount (T_floe floe)
{
    int res = 0;
    for (int  i = 0;  i < floe.size ; ++ i)
    {
        for (int j = 0; j < floe.size ; ++j)
        {

            if (floe.tab[i][j].type == ice)
                res = res + 1;
        }
    }
    return res;
}

/* dispose des objets aleatoirement sur la carte,
 * ice = le nombre de cases de glaces,
 * on attribue aleatoirement une des 6 valeurs du t_objet sur 1/15 de cette valeur
 * on dispose egalement une tete de marteau sur la case precedant un manche et vice versa
 * complexite lineaire en fonction de floe.size
 */
void objectDisposal (T_floe floe)
{
    int ice = iceCount(floe);
    for (int k = 0; k <ice/15 ; ++k)
    {
        int X = 0, Y = 0;
        do
        {
            X = rand()%floe.size, Y = rand()%floe.size;

        }
        while (isFree(floe.tab[X][Y]) != 1 );
        floe.tab[X][Y].object = rand()%6;
    }
    for (int l = 0; l <floe.size ; ++l)
    {
        for (int i = 0; i < floe.size ; ++i)
        {
            if (floe.tab[l][i].object == 3)
                floe.tab[l][i+1].object = 4;

            if (floe.tab[l][i].object == 4)
                floe.tab[l][i-1].object = 3;
        }
    }
}

