package EX0.javafxapplication5ajeter;

import java.util.Scanner;

public class Main {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/


    /******************* CONSTRUCTORS *******************/


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int largeur = scanner.nextInt();
        int hauteur = scanner.nextInt();
        int nombreDeCases = scanner.nextInt();
        System.out.format("largeur = %d, hauteur = %d, nombre de cases = %d\n", largeur, hauteur, nombreDeCases);
    }
}
