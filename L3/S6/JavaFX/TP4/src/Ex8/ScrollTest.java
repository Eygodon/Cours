package Ex8;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ScrollTest extends Application {

    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private int cpt = 0;

    /******************* CONSTRUCTORS *******************/


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane root = new FlowPane();
        Label compteur = new Label(String.valueOf(cpt));
    }
}
