package Vue;

import Modele.JeuDesChasseurs;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class PanneauVue extends Pane {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private final TabGamers tabs;
    private JeuDesChasseurs j;

    /******************* CONSTRUCTORS *******************/
    public PanneauVue ()
    {
        super();
        this.tabs = new TabGamers();
        this.getChildren().add(this.tabs);
    }

    public PanneauVue (JeuDesChasseurs j)
    {
        super();
        this.tabs = new TabGamers();
        this.j = j;
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
        GridPane plateau = new GridPane();
        plateau.setHgap(2);
        plateau.setVgap(2);

    }

}
