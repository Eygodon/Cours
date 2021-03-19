/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.logging.Logger;

/**
 *
 * @author bergey
 * Classe des personnages 
 * 
 */
public class Personnage {
    
    
    
    private final TypePersonnage type ; 
    // la taille du damier où il se déplace (entre 1 et size y compris)
    private final int size ; 
    private int x, y ; 

    /**
     * 
     * @param type le type du personnage
     * @param size la taille du damier 
     * @param x la position en x 
     * @param y la position en y 
     */
    public Personnage(TypePersonnage type, int size, int x, int y){
        this.type = type ; 
        this.size = size ; 
        this.x = x ; 
        this.y = y ; 
    }

    /**
     * 
     * @return le type du personnage
     */
    public TypePersonnage getType() {
        return type;
    }
    
    /**
     * 
     * @return la position en X
     */
    public int getX() {
        return x;
    }
    
    /** 
     * 
     * @param x la position en X (doit etre compris >0 et <= size)
     */
    public void setX(int x) {
        if (x > 0 && x<= size) 
            this.x = x;
    }
    
    /** 
     * 
     * @return la position en Y  
     */
    public int getY() {
        return y;
    }

    /**
     * 
     * @param y la position en Y doit etre compris >0 et <= size 
     */
    public void setY(int y) {
        if (y > 0 && y<= size) 
            this.y = y;
    }
    
    /** 
     * 
     * @return la taille du carre ou peut se deplacer le personnage 
     */
    public int getSize() {
        return size;
    }
    
    /**
     * 
     * @param d dans quel sens on se déplace
     */
    public void bouge(Direction d){
        switch (d){
            case N : setY(y-1) ; break ; 
            case E : setX(x+1) ; break ;
            case S : setY(y+1) ; break ;
            case W : setX(x-1) ; break ; 
        }
    }
    
    
}
