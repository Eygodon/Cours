/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Modele.Personnage;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author bergey
 */
public class JeuDesChasseurs {
    
    // la taille du plateau de jeu 
    // les personnages se deplaceront entre 1 et size y compris
    private final int size ;
    // si la partie est finie
    BooleanProperty partieFinie ; 

    // Les personnages
    Personnage chasseur1, chasseur2 ; 
    Personnage bambi ;
    // a qui est le tour, 0 bambi, 1 chasseur1, 2 chasseur2
    IntegerProperty tour ;  
    // combien de coups ont été joués
    IntegerProperty nbCoups ; 
    
    /**
     * 
     * @param size la taille du plateau  
     */
    public JeuDesChasseurs (int size){
        this.size = size ; 
        chasseur1 = new Personnage(TypePersonnage.CHASSEUR,size,1,1); 
        chasseur2 = new Personnage(TypePersonnage.CHASSEUR,size,size,1); 
        bambi = new Personnage(TypePersonnage.CERF,size,size/2,size);
        partieFinie = new SimpleBooleanProperty(false);    
        tour = new SimpleIntegerProperty(0);     
        nbCoups = new SimpleIntegerProperty(0); 
    }
    
    /**
     * reinitialise le plateau de jeu
     */
    public void reset(){
        partieFinie.setValue(false);
        tour.setValue(0);
        nbCoups.setValue(0);
        chasseur1.setX(1);
        chasseur1.setY(1);
        chasseur2.setX(size);
        chasseur2.setX(1);
        bambi.setX(size/2);
        bambi.setY(size);
    
    }
    /**
     * 
     * @return la taille du plateau  
     */
     public int getSize() {
        return size;
    }

    /**
     * 
     * @return la property indiquant vrai si la partie est finie
     */ 
     
    public BooleanProperty getPartieFinieProperty() {
        return partieFinie;
    }
    /**
     * 
     * @return true si la partie est finie
     */
    public boolean isFinie(){
        return partieFinie.getValue();
    }
    
    /**
     * 
     * @return le chasseur1
     */
    public Personnage getChasseur1() {
        return chasseur1;
    }

    /** 
     * 
     * @return le chasseur2 
     */
    public Personnage getChasseur2() {
        return chasseur2;
    }

    /** 
     * 
     * @return le cerf
     */
    public Personnage getBambi() {
        return bambi;
    }

    /** 
     * 
     * @return la property contenant le tour, a qui est à jouer 
     */
    public IntegerProperty getTourProperty() {
        return tour;
    }
    
    /**
     * 
     * @return la property contenant le nombre de coups 
     */
    public IntegerProperty getNbCoupsProperty() {
        return nbCoups;
    }
    
    
    private boolean testFin(Personnage chasseur){
        return (chasseur.getX()== bambi.getX() &&  
               chasseur.getY()== bambi.getY())  ; 
    }
    
    private void bouge(Personnage p, int aqui, Direction d){
        if (partieFinie.getValue())
            System.out.println("PartieFinie "); 
        else {
            if (tour.getValue()== aqui){
                p.bouge(d);
                tour.set((aqui+1)%3);
                nbCoups.set(nbCoups.getValue()+1); 
                partieFinie.set(testFin(chasseur1) || testFin(chasseur2));
            }
            else 
                System.out.println("ce n'est pas ton tour " );
        }
    }
    
    /**
     * Deplace le cerf dans la direction d
     * @param d la direction de deplacement 
     */
    public void bougeBambi(Direction d){
        bouge(bambi,0,d);
    }
    
    /** 
     * Deplace le chasseur 1 dans la direction d
     * @param d la direction de deplacement
     */
    public void bougeChasseur1(Direction d){
        bouge(chasseur1,1,d);
    }
    
    /**
     * Deplace le chasseur 2 dans la direction  d
     * @param d la direction de déplacement
     */
    public void bougeChasseur2(Direction d){
        bouge(chasseur2,2,d);
    }
    
    public static void main(String[] args) {
         JeuDesChasseurs j = new JeuDesChasseurs(10) ;
         j.getChasseur1().setX(4);
         j.getChasseur1().setY(4);
         j.getBambi().setX(4);
         j.getBambi().setY(5);
         System.out.println("Bambi"+j.getBambi().getX()+ j.getBambi().getY() );
         System.out.println("Chasseur2 X : "+j.getChasseur2().getX());
         
         System.out.println("Chasseur 2 "+j.getChasseur2().getX()+j.getChasseur2().getY());
         j.getChasseur2().bouge(Direction.W);
         System.out.println("Chasseur 2 "+j.getChasseur2().getX()+j.getChasseur2().getY());
         j.getChasseur2().bouge(Direction.S);
         System.out.println("Chasseur 2 "+j.getChasseur2().getX()+j.getChasseur2().getY());
         j.getChasseur2().bouge(Direction.N);
         System.out.println("Chasseur 2 "+j.getChasseur2().getX()+j.getChasseur2().getY());
         j.getChasseur2().bouge(Direction.E);
         System.out.println("Chasseur 2 "+j.getChasseur2().getX()+j.getChasseur2().getY());
         
         System.out.println("tour " + j.getTourProperty());
         j.bougeBambi(Direction.E);
System.out.println("Bambi"+j.getBambi().getX()+ j.getBambi().getY() );
         System.out.println("tour " + j.getTourProperty());
         System.out.println("Chasseur 1 "+j.getChasseur1().getX()+j.getChasseur1().getY());
         j.bougeChasseur1(Direction.E);
         System.out.println("Chasseur 1 "+j.getChasseur1().getX()+j.getChasseur1().getY());
         j.bougeChasseur1(Direction.N);
         System.out.println("Chasseur 1 "+j.getChasseur1().getX()+j.getChasseur1().getY());
         j.bougeChasseur1(Direction.N);
         System.out.println("Chasseur 1 "+j.getChasseur1().getX()+j.getChasseur1().getY());
         System.out.println("tour " + j.getTourProperty());

        // System.out.println("finie "+j.getPartieFinie().getValue());
         System.out.println("Chasseur2 X : "+j.getChasseur2().getX());
         j.bougeChasseur2(Direction.W);
         System.out.println("tour " + j.getTourProperty());
         System.out.println("Chasseur2 X : "+j.getChasseur2().getX());
         
         j.bougeBambi(Direction.E);
         System.out.println("Bambi"+j.getBambi().getX()+ j.getBambi().getY() );
         
         
        // System.out.println("finie "+j.getPartieFinie().getValue());
         
         System.out.println("Y"+j.getChasseur1().getY());
         j.bougeChasseur1(Direction.S);
         System.out.println("Y"+j.getChasseur1().getY());
         //System.out.println("finie "+j.getPartieFinie().getValue());
         System.out.println("Y"+j.getChasseur1().getY());
         j.bougeChasseur1(Direction.S);
         System.out.println("Y"+j.getChasseur1().getY());
         
         
          
         
    }
    
    
}
