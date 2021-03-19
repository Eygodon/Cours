package Vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application {

    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/


    /******************* CONSTRUCTORS *******************/


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/
    /********************* METHODS **********************/
    @Override
    public void start(Stage primaryStage) throws Exception {
        PanneauVue root = new PanneauVue();
        root.activateTab(1);
        root.activateTabChoicePersonnage(0, false);


        Scene scene = new Scene(root);

        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
