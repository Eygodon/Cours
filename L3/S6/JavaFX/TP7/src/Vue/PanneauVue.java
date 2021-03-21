package Vue;

import Modele.JeuDesChasseurs;
import javafx.geometry.Insets;
import javafx.scene.control.TabPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class PanneauVue extends BorderPane {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private final TabGamers tabs;
    private JeuDesChasseurs j;
    private Plateau plateau;
    /******************* CONSTRUCTORS *******************/
    public PanneauVue ()
    {
        super();
        this.tabs = new TabGamers();
    }

    public PanneauVue (JeuDesChasseurs j)
    {
        super();
        this.tabs = new TabGamers();
        this.j = j;
        this.plateau = new Plateau(j.getSize());
        this.setRight(tabs);
    }


    /********************* GETTERS **********************/
    public TabGamers getTabs()
    {
        return this.tabs;
    }

    /********************* SETTERS **********************/


    /********************* METHODS **********************/
    public void activateTab (int n) {
        this.getTabs().getOnglets().forEach(tab -> {
            tab.setDisable(true);
            tab.getContent().setDisable(true);
        });
        this.getTabs().getOnglets().get(n).setDisable(false);
        this.getTabs().getOnglets().get(n).getContent().setDisable(false);
    }

    public void activateTabChoicePersonnage ( int n, boolean b)
    {
        this.getTabs().getOnglets().get(n).getContent().setDisable(!b);
    }

    public void affichePlateau ()
    {
        BackgroundFill bgFillChasseur = new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY);
        BackgroundFill bgFillBambi = new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY);
        Background bgChasseur = new Background(bgFillChasseur);
        Background bgBambi = new Background(bgFillBambi);
        plateau.getLabels()[j.getBambi().getX()-1][j.getBambi().getY()-1].setBackground(bgBambi);
        plateau.getLabels()[j.getBambi().getX()-1][j.getBambi().getY()-1].setText("0");
        plateau.getLabels()[j.getChasseur1().getX()-1][j.getChasseur1().getY()-1].setBackground(bgChasseur);
        plateau.getLabels()[j.getChasseur1().getX()-1][j.getChasseur1().getY()-1].setText("1");
        plateau.getLabels()[j.getChasseur2().getX()-1][j.getChasseur2().getY()-1].setBackground(bgChasseur);
        plateau.getLabels()[j.getChasseur2().getX()-1][j.getChasseur2().getY()-1].setText("2");
        this.setLeft(plateau);
    }

    public void resetCase(int x, int y)
    {
        BackgroundFill bgFillReset = new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY);
        Background bgReset = new Background(bgFillReset);
        plateau.getLabels()[x][y].setText("");
        plateau.getLabels()[x][y].setBackground(bgReset);
    }

    public void ajouteBambi(int x, int y)
    {
        BackgroundFill bgFillBambi = new BackgroundFill(Color.BROWN, CornerRadii.EMPTY, Insets.EMPTY);
        Background bgBambi = new Background(bgFillBambi);
        plateau.getLabels()[x][y].setText("0");
        plateau.getLabels()[x][y].setBackground(bgBambi);
    }

    public void ajouteChasseur(int x, int y, int numero)
    {
        BackgroundFill bgFillChasseur = new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY);
        Background bgChasseur = new Background(bgFillChasseur);
        plateau.getLabels()[x][y].setText(String.valueOf(numero));
        plateau.getLabels()[x][y].setBackground(bgChasseur);
    }
}
