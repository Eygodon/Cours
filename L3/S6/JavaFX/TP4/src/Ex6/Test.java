package Ex6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
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
        FlowPane root = new FlowPane();
        ButtonStartPause btn = new ButtonStartPause(40);
        root.getChildren().addAll(btn);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
