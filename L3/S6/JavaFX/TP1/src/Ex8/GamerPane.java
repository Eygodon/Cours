package Ex8;

import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class GamerPane extends VBox {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private RadioButton radioElfe, radioMage, radioChasseur;
    private ToggleGroup classes;

    /******************* CONSTRUCTORS *******************/
    public GamerPane(){
        super();
        classes = new ToggleGroup();

        radioChasseur = new RadioButton("Chasseur");
        radioMage = new RadioButton("Mage");
        radioElfe = new RadioButton("Elfe");

        radioChasseur.setToggleGroup(classes);
        radioMage.setToggleGroup(classes);
        radioElfe.setToggleGroup(classes);

        this.getChildren().addAll(radioChasseur, radioMage, radioElfe);
        this.setAlignment(Pos.CENTER_LEFT);
    }

    /********************* GETTERS **********************/
    public String getPersonnage (){
        return classes.getSelectedToggle().toString();
    }

    /********************* SETTERS **********************/


    /********************* METHODS **********************/
}
