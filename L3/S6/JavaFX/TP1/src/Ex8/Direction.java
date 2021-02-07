package Ex8;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


public class Direction extends BorderPane {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private Button gauche, droite, haut, bas;
    private Image flecheBas, flecheDroite, flecheGauche, flecheHaut;
    private ImageView iconBas, iconDroite, iconGauche, iconHaut;


    /******************* CONSTRUCTORS *******************/
    public Direction() {
        super();
        flecheBas = new Image(getClass().getResourceAsStream("Ressources/pngdown.png"));
        flecheDroite = new Image(getClass().getResourceAsStream("Ressources/pngright.png"));
        flecheGauche = new Image(getClass().getResourceAsStream("Ressources/pngleft.png"));
        flecheHaut = new Image(getClass().getResourceAsStream("Ressources/pngup.png"));

        iconBas = new ImageView(flecheBas);
        iconDroite = new ImageView(flecheDroite);
        iconGauche = new ImageView(flecheGauche);
        iconHaut = new ImageView(flecheHaut);

        gauche = new Button("", iconGauche);
        droite = new Button("", iconDroite);
        haut = new Button("", iconHaut);
        bas = new Button("", iconBas);

        this.setTop(haut);
        this.setLeft(gauche);
        this.setRight(droite);
        this.setBottom(bas);
        BorderPane.setAlignment(haut, Pos.TOP_CENTER);
        BorderPane.setAlignment(gauche, Pos.CENTER_LEFT);
        BorderPane.setAlignment(droite, Pos.CENTER_RIGHT);
        BorderPane.setAlignment(bas, Pos.BOTTOM_CENTER);
    }

    /********************* GETTERS **********************/
    public Button getGauche()
    {
        return gauche;
    }

    public Button getDroite()
    {
        return droite;
    }

    public Button getBas()
    {
        return bas;
    }

    public Button getHaut()
    {
        return haut;
    }

    /********************* SETTERS **********************/


    /********************* METHODS **********************/
}
