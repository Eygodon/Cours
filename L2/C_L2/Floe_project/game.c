//
// Created by Eygodon on 08/03/2020.
//

#include "game.h"

/******************** CODE YANN ************/
//affiche le tableau de jeu, la "carte", complexite lineaire
void display_floe (T_floe floe)
{

    for ( int i = 0; i < floe.size; ++i) {
        for (int j = 0; j < floe.size; ++j) {
            if (floe.tab[i][j].player != NULL)
                printf(" %d", floe.tab[i][j].player->ID);
            else
            if (floe.tab[i][j].goal != path)
                printf(" %c", goalToChar(floe.tab[i][j].goal));
            else
            if (floe.tab[i][j].object != none)
                printf(" %c",objectToChar(floe.tab[i][j].object));
            else
                printf(" %c",typeToChar(floe.tab[i][j].type));
        }
        printf("\n");
    }
}

// retourne la position de depart, fonction de debug, complexite lineaire en fonction de floe.size
T_pos getStartPos ( T_floe floe)
{
    T_pos startPos = {0,0};
    for (int i = 0; i < floe.size ; ++i)
    {
        for (int j = 0; j < floe.size ; ++j)
        {
            if (floe.tab[i][j].goal == 1)
            {
                startPos.posY = i;
                startPos.posX = j;
            }
        }
    }
   // printf("X : %d Y : %d \n", startPos.posX, startPos.posY);
    return startPos;
}

//positionne les joueurs autour de la case de depart, complexite constante
T_pos playerPositioning ( T_floe floe, T_player player)
{
    T_pos startPos =  getStartPos(floe);
    int positiveYOffset = startPos.posY+2;
    int positiveXOffset = startPos.posX+2;
    int negativeYOffset = startPos.posY-2;
    int negativeXOffset = startPos.posX-2;
    int playerX = player.pos.posX;
    int playerY = player.pos.posY;
    do
    {
        playerX = startPos.posX + rand()%(positiveXOffset - negativeXOffset) -1;
        playerY = startPos.posY + rand()%(positiveYOffset - negativeYOffset) -1;
    }
    while(
            isFree(floe.tab[playerX][playerY]) != 1
            );
    T_pos playerPos = { playerY, playerX};
    player.pos = playerPos;
    return playerPos;
}
// initialise les joueurs de la liste de taille playerNb, comlplexite lineaire en fonction de playerNb
// (nombre de joueur)

T_player* setPlayers ( T_floe floe, int playerNb )
{
    T_player* playerTab = (T_player*) malloc(playerNb * sizeof(T_player));

    for (int i = 0; i<playerNb; i++)
    {
        printf("Nom du joueur %d :", i+1);
        scanf("%s", playerTab[i].name);
        playerTab[i].color = i;
        playerTab[i].ID = i;
        playerTab[i].score = 0;
        playerTab[i].vec.dX = 0;
        playerTab[i].vec.dY = 0;
        playerTab[i].pos = playerPositioning(floe, playerTab[i]);
       //printf("player  : %d \n", playerTab[i].ID);
        // printf("player %d X : %d Y : %d \n", i+1,playerTab[i].pos.posY, playerTab[i].pos.posX);
    }
    return playerTab;
}



/**************************** CODE ALEXIS **************************/

void Anobstacle(T_floe floe,int i,int y,int dirx,int diry,int nb_player)// fonction controlant le glacon et verifiant les obstacles qu'il rencontre complexité exponanciel suivant la taille de son trajet Alexis louail
{
    if( (i+dirx==floe.size) ||(y+diry==floe.size)||(i+dirx<0)||(y+diry<0))
    {
        floe.tab[i][y].object=none;
    }
    else
    {
        if(floe.tab[i+dirx][y+diry].type==water)
        {
            floe.tab[i+dirx][y+diry].type=ice;
            floe.tab[i][y].object=none;
        }
        else
        {
            if(floe.tab[i+dirx][y+diry].object==spring ||floe.tab[i+dirx][y+diry].object==rock || floe.tab[i+dirx][y+diry].object==hammerHead||floe.tab[i+dirx][y+diry].object==hammerHandle)
            {
                if(floe.tab[i+dirx][y+diry].object==spring)//resort
                {

                    Anobstacle(floe,i,y,0-dirx,0-diry,nb_player);
                }
                //rocher et marteau arrete le bloc de glace
            }
            else{
                if(floe.tab[i+dirx][y+diry].object==hammerHead)//tete de marteau
                {
                    hammermove(floe,i,y,dirx,diry,nb_player);
                }

                else
                    {
                        Anobstacle(floe,i+dirx,y+diry,dirx,diry,nb_player);
                        floe.tab[i][y].object=none;
                    }

            }
        }
    }
}


T_pos findcenter(T_floe floe,int HammerX,int HammerY)// fonction permetant d'avoir la positon du centre/manche du marteau complexité constante  Alexis louail
{
    T_pos center;
    if(floe.tab[HammerX][HammerY-1].object==hammerHandle)
    {
        center.posX=HammerX;
        center.posY=HammerY-1;
        return center;
    }
    else
    {
        if(floe.tab[HammerX+1][HammerY].object==hammerHandle)
        {
            center.posX=HammerX+1;
            center.posY=HammerY;
            return center;
        }
        else
            {
                if(floe.tab[HammerX][HammerY+1].object==hammerHandle)
                {
                    center.posX=HammerX;
                    center.posY=HammerY+1;
                    return center;
                }
                else
                    {
                        center.posX=HammerX-1;
                        center.posY=HammerY;
                        return center;
                    }
            }
    }
}


T_pos finddir(T_floe floe,T_vec dir,T_pos center)// fonction verifiant le sens d'orientation du marteau et quel position le marteau est.  complexité constante Alexis louail
{ T_pos case_dir;
        if((dir.dX==1)&&(dir.dY==0))
        {
            if(floe.tab[center.posX-1][center.posY-1].object==iceCube)
            {
                 case_dir.posX=1;//horraire
                 case_dir.posY=1;//case1
                return case_dir;//case1 (horraire)
            }
            else
                {
                    case_dir.posX=0;//anti-horaire
                    case_dir.posY=3;
                    return case_dir;//case3 (anti-horraire)
                }
        }
        else
            {
                if((dir.dX==-1)&&(dir.dY==0))
                {
                    if(floe.tab[center.posX+1][center.posY+1].object==iceCube)
                    {
                        case_dir.posX=1;
                        case_dir.posY=3;
                        return case_dir;;//case3 (horraire)
                    }
                    else
                        {
                            case_dir.posX=0;
                            case_dir.posY=1;
                            return case_dir;;//case1 (anti-horraire)
                        }
                }
                else
                {
                   if((dir.dX==0)&&(dir.dY==1))
                    {
                        if(floe.tab[center.posX-1][center.posY+1].object==iceCube)
                        {
                            case_dir.posX=1;
                            case_dir.posY=2;
                            return case_dir;;//case2 (horraire
                        }
                        else
                            {
                                case_dir.posX=0;
                                case_dir.posY=4;
                                return case_dir;;//case4 (anti-horraire)
                            }
                    }
                    else
                        {
                            if((dir.dX==0)&&(dir.dY==-1))
                                {
                                    if(floe.tab[center.posX+1][center.posY-1].object==iceCube)
                                    {
                                        case_dir.posX=1;
                                        case_dir.posY=4;
                                        return case_dir;;//case4 (horraire)
                                    }
                                    else
                                        {
                                            case_dir.posX=0;
                                            case_dir.posY=2;
                                            return case_dir;;//case2 (anti-horraire)
                                        }
                                }
                        }
                }
            }

return case_dir;
}


void rotationcenter(T_floe floe,int iceCubex,int iceCubey,int hammerx,int hammery,int nb_player)// fonction controlant la rotation du marteau complexité linéaire par rapport a coordonée de IceCube Alexis louail
{
    T_pos center =findcenter(floe,hammerx,hammery);
    T_vec dir ;
    dir.dX=hammerx-iceCubex;
    dir.dY=hammery-iceCubey;
    T_pos case_dir= finddir(floe,dir,center);
    int hiticeCube=0;
    if(case_dir.posX==1)//horraire
    {
        while(hiticeCube==0)
            {
                switch(case_dir.posY)
                {
                case 1:
                    if(floe.tab[center.posX+1][center.posY-1].object==iceCube)
                    {
                        glaconmove(floe,center.posX+2,center.posY-1,center.posX+1,center.posY-1, nb_player);
                        hiticeCube=1;
                        break;
                    }
                    else
                    {
                        if(floe.tab[center.posX+1][center.posY].object==iceCube)
                        {
                            glaconmove(floe,center.posX+1,center.posY+1,center.posX+1,center.posY, nb_player);
                            hiticeCube=1;
                            case_dir.posY=4;
                            break;
                        }
                        else
                        {
                            case_dir.posY=4;
                        }
                    }
                break;

                case 2:
                       if(floe.tab[center.posX-1][center.posY-1].object==iceCube)
                    {
                        glaconmove(floe,center.posX-1,center.posY-2,center.posX-1,center.posY-1,nb_player);
                        hiticeCube=1;
                        break;
                    }
                    else
                    {
                        if(floe.tab[center.posX][center.posY-1].object==iceCube)
                        {
                            glaconmove(floe,center.posX+1,center.posY-1,center.posX,center.posY-1,nb_player);
                            hiticeCube=1;
                            case_dir.posY=1;
                            break;
                        }
                        else
                        {
                            case_dir.posY=1;
                        }
                    }
                break;

                case 3:
                       if(floe.tab[center.posX-1][center.posY+1].object==iceCube)
                    {
                        glaconmove(floe,center.posX-2,center.posY+1,center.posX-1,center.posY+1,nb_player);
                        hiticeCube=1;
                        break;
                    }
                    else
                    {
                        if(floe.tab[center.posX-1][center.posY].object==iceCube)
                        {
                            glaconmove(floe,center.posX-1,center.posY-1,center.posX-1,center.posY,nb_player);
                            hiticeCube=1;
                            case_dir.posY=2;
                            break;
                        }
                        else
                        {
                            case_dir.posY=2;
                        }
                    }
                break;

                case 4:
                       if(floe.tab[center.posX+1][center.posY+1].object==iceCube)
                    {
                        glaconmove(floe,center.posX+1,center.posY+2,center.posX+1,center.posY+1,nb_player);
                        hiticeCube=1;
                        break;
                    }
                    else
                    {
                        if(floe.tab[center.posX][center.posY+1].object==iceCube)
                        {
                            glaconmove(floe,center.posX-1,center.posY+1,center.posX,center.posY+1,nb_player);
                            hiticeCube=1;
                            case_dir.posY=3;
                            break;
                        }
                        else
                        {
                            case_dir.posY=3;
                        }
                    }
                break;

                default:
                break;
                }

            }
    }
    else
        {
           while(hiticeCube==0)
            {
                switch(case_dir.posY)
                {
                case 1:
                    if(floe.tab[center.posX-1][center.posY-1].object==iceCube)
                    {
                        glaconmove(floe,center.posX-2,center.posY-1,center.posX-1,center.posY-1,nb_player);
                        hiticeCube=1;
                        break;
                    }
                    else
                    {
                        if(floe.tab[center.posX-1][center.posY].object==iceCube)
                        {
                            glaconmove(floe,center.posX-1,center.posY+1,center.posX-1,center.posY,nb_player);
                            hiticeCube=1;
                            case_dir.posY=2;
                            break;
                        }
                        else
                        {
                            case_dir.posY=2;
                        }
                    }
                break;

                case 2:
                       if(floe.tab[center.posX-1][center.posY+1].object==iceCube)
                    {
                        glaconmove(floe,center.posX-1,center.posY+2,center.posX-1,center.posY+1,nb_player);
                        hiticeCube=1;
                        break;
                    }
                    else
                    {
                        if(floe.tab[center.posX][center.posY-1].object==iceCube)
                        {
                            glaconmove(floe,center.posX+1,center.posY+1,center.posX,center.posY+1,nb_player);
                            hiticeCube=1;
                            case_dir.posY=3;
                            break;
                        }
                        else
                        {
                            case_dir.posY=3;
                        }
                    }
                break;

                case 3:
                       if(floe.tab[center.posX+1][center.posY+1].object==iceCube)
                    {
                        glaconmove(floe,center.posX+2,center.posY+1,center.posX+1,center.posY+1,nb_player);
                        hiticeCube=1;
                        break;
                    }
                    else
                    {
                        if(floe.tab[center.posX+1][center.posY].object==iceCube)
                        {
                            glaconmove(floe,center.posX+1,center.posY-1,center.posX+1,center.posY,nb_player);
                            hiticeCube=1;
                            case_dir.posY=4;
                            break;
                        }
                        else
                        {
                            case_dir.posY=4;
                        }
                    }
                break;

                case 4:
                       if(floe.tab[center.posX+1][center.posY-1].object==iceCube)
                    {
                        glaconmove(floe,center.posX+1,center.posY-2,center.posX+1,center.posY-1,nb_player);
                        hiticeCube=1;
                        break;
                    }
                    else
                    {
                        if(floe.tab[center.posX][center.posY-1].object==iceCube)
                        {
                            glaconmove(floe,center.posX-1,center.posY-1,center.posX,center.posY-1,nb_player);
                            hiticeCube=1;
                            case_dir.posY=1;
                            break;
                        }
                        else
                        {
                            case_dir.posY=1;
                        }
                    }
                break;

                default:
                break;
                }

            }
        }
}

void hammermove(T_floe floe,int i,int y,int dirx,int diry,int nb_player)// fonction verifiant si le glacon touche bien l'un des cotés du marteau complexité constante Alexis louail
{
    if(!(floe.tab[i+(2*dirx)][y+(2*diry)].object==hammerHandle))
       {
            rotationcenter(floe,i,y,i+dirx,y+diry,nb_player);
       }
       else{}
}



void glaconmove (T_floe floe,int i,int y,int j,int z,int nb_player)// fonction controlant la direction du glacon complexité constante Alexis louail
{
    switch(i-j)//dx=?
    {
        case -1:
            Anobstacle(floe,i,y,-1,0,nb_player);
            break;

        case 1:
            Anobstacle(floe,i,y,1,0,nb_player);
            break;

        case 0:

            switch(y-z)
            {
                case -1:
                    Anobstacle(floe,i,y,0,-1,nb_player);
                    break;

                case 1:
                    Anobstacle(floe,i,y,0,1,nb_player);
                    break;

                default:
                    break;

            }

            break;

        default:
            break;
    }
    floe.tab[i][y].player=floe.tab[j][z].player;
    floe.players[nb_player].pos.posY=y;
    floe.players[nb_player].pos.posX=i;
    floe.tab[j][z].player=NULL;
    return;
}

void anobject(T_floe floe,int i,int y,int j,int z ,int nb_player) // fonction qui regarde quel objet le joueur rencontre complexité constante Alexis louail
// i et y coord prochaine case et j et z coordonne case actuelle
{
    switch(floe.tab[i][y].object)
    {
        case 0://glacon
            glaconmove(floe,i,y,j,z,nb_player);
            break;

        case 1://ressort
            printf("you can't ,try another direction \n");
            next_move(floe,j,z, nb_player);
            break;

        case 2://rocher
            printf("you can't ,try another direction \n");
            next_move(floe,j,z, nb_player);
            break;

        case 3://marteau_tete
            printf("you can't ,try another direction \n");
            next_move(floe,j,z, nb_player);
            break;

        case 4://marteau manche
            printf("you can't ,try another direction \n");
            next_move(floe,j,z, nb_player);
            break;

        case 5://piege

            break;

        default:
            break;
    }
}

void next_move(T_floe floe,int i,int y,int nb_player) // fonction controlant les mouvements des joueurs complexité constante Alexis louail
{
    T_pos posNow;
    T_pos posAfter;
    posNow.posX=i;
    posNow.posY=y;
    if(isInFloe(floe,posNow)==1)
       {

        char keypress;
            printf("press a key\n");
            fflush(stdin);
            scanf("%c",&keypress);

            if(keypress=='z')
            {
                posAfter.posX=i-1;
                posAfter.posY=y;
            }
            else
            {
                 if(keypress=='s')
                            {
                                posAfter.posX=i+1;
                                posAfter.posY=y;
                            }
                    else
                        {
                            if(keypress=='q')
                            {
                                posAfter.posX=i;
                                posAfter.posY=y-1;
                            }
                            else
                            {
                                if(keypress=='d')
                                {
                                    posAfter.posX=i;
                                    posAfter.posY=y+1;
                                }
                                else
                                        {
                                            printf("try another key");
                                        }
                            }
                        }
            }
             if(isInFloe(floe,posAfter)==1)
                    {
                        if(isOK(floe,posAfter)==1)
                        {
                            floe.tab[posAfter.posX][posAfter.posY].player=floe.tab[posNow.posX][posNow.posY].player;
                            floe.players[nb_player].pos.posY=posAfter.posY;
                            floe.players[nb_player].pos.posX=posAfter.posX;
                          floe.tab[posNow.posX][posNow.posY].player=NULL;

                        }
                        else
                        {
                            if(floe.tab[posAfter.posX][posAfter.posY].player==NULL && floe.tab[posAfter.posX][posAfter.posY].type==ice)
                            {
                                anobject(floe,posAfter.posX,posAfter.posY,i,y, nb_player);
                            }
                            else
                            {
                                printf("you can't ,try another direction \n");
                                next_move(floe,i,y,nb_player);
                            }
                        }
                    }
       }
}


int isOK(T_floe floe,T_pos posAfter) // fonction verifiant que la position suivante eest accesible complexité constante Alexis louail
{
    if(((floe.tab[posAfter.posX][posAfter.posY].object==none
        || floe.tab[posAfter.posX][posAfter.posY].object==trap)
       && floe.tab[posAfter.posX][posAfter.posY].player==NULL)
       && floe.tab[posAfter.posX][posAfter.posY].type==ice)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}



void Player_turn(T_floe floe,int nb_player) // fonction s'occupant de gerer le tour d'un joueur si il est pieger ou non complexité constante Alexis louail
{
    if(floe.tab[floe.players[nb_player].pos.posX][floe.players[nb_player].pos.posY].object==trap) //si le joueur est sur un case pieger
    {
        floe.tab[floe.players[nb_player].pos.posX][floe.players[nb_player].pos.posY].object=none;
    }
    else
        {
            display_floe(floe);
            next_move(floe,floe.players[nb_player].pos.posX,floe.players[nb_player].pos.posY,nb_player);

        }
}


void gameloop(T_floe floe,int nb_player)// fonction s'occupant d'afficher le tableau et apel les tours de chaque joueurs ainsi que affiche le score complexité linéaire par rapport au nombre de tours Alexis louail
{
    int ending=0;
    do
        {
            fonte(floe);
            for(int i=0; i<nb_player;i++)
            {
                printf("player %d joue \n",i);
                Player_turn(floe,i);
                floe.players[i].score +=1;
                if(floe.tab[floe.players[i].pos.posX][floe.players[i].pos.posY].goal==finish)
                {
                     printf("player %d a atteint la fin ! \n",i);
                    ending=1;
                    break;
                }
            }
        }
    while(ending==0);
    printf("FIN DE JEU ! \n");
    for(int i=0; i<nb_player;i++)
    {
        printf("%s score:%d \n",floe.players[i].name,floe.players[i].score);
    }
}

