package TP1Ex1;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args)
    {
        Bike b1 = new Bike();
        Bike b2 = new Bike("Tesla", Color.CYAN, 20);
        Bike b3 = new Bike(b2);

        Wheel w1 = new Wheel();
        Wheel w2 = new Wheel("roadAgain",19);
        List<Wheel> wList = new ArrayList<>();
        Set<Wheel> wSet = new HashSet<>();

        /********************* MANIPULATION LISTES **********************/
        wList.add(w1);
        wList.add(w2);
        wList.add(1,new Wheel("ZOUBA",20));
        wList.add(w1); // avec List, il est possible d'ajouter deux fois le même élément
        System.out.format("taille de wlist : %d\n", wList.size());

        // [TP1Ex1.Wheel@7daf6ecc, TP1Ex1.Wheel@2e5d6d97, TP1Ex1.Wheel@238e0d81, TP1Ex1.Wheel@7daf6ecc]
        //avant l'override
        System.out.print(wList.toString() + "\n");
        /*[Wheel : [Michelin - 20" - 3,0 bar]
            , Wheel : [ZOUBA - 20" - 3,0 bar]
            , Wheel : [roadAgain - 19" - 3,0 bar]
            , Wheel : [Michelin - 20" - 3,0 bar]
             Après l'override*/

        /******************************* MANIPULATION ENSEMBLE **********************/

        wSet.add(new Wheel("POUET", 21));
        wSet.add(new Wheel("POUET", 21)); //????????????


        /******************* RESTE DE L'EXERCICE *********/

        b1.print();
        b2.print();

        b1.brake();
        for (int i = 0; i<65; i++)
            b2.accelerate();
        b1.print();
        b2.print();

        b1 = b2;
        b1.brake();
        b1.print();
        b2.print();

        w1.print();
        w2.print();
        w1.inflate();
        w2.deflate();
        w1.print();
        w2.print();
        // l'objet référencé par b1 n'est plus référencé il a donc été détruit

        b2.getRearWheel().deflate();
        b2.print();
        b3.print();

    }
}
