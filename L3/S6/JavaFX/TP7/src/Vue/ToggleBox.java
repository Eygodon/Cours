package Vue;

import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

public class ToggleBox extends VBox {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private RadioButton radioBambi, radioChassseur;
    private ToggleGroup classes;

    /******************* CONSTRUCTORS *******************/
    public ToggleBox()
    {
        super();
        classes = new ToggleGroup();

        radioBambi = new RadioButton("Bambi");
        radioChassseur = new RadioButton("Chasseur");

        radioBambi.setToggleGroup(classes);
        radioChassseur.setToggleGroup(classes);

        this.getChildren().addAll(radioBambi, radioChassseur);
        this.setAlignment(Pos.CENTER);
    }


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/

}
