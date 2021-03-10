package Ex5;

import Ex3.BorderWithQuitLA;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Test extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderWithQuitLA root = new BorderWithQuitLA();
        MyButtonPanel panel = new MyButtonPanel(3, 5);
        root.setCenter(panel);
        BorderPane.setAlignment(panel, Pos.CENTER);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/


    /******************* CONSTRUCTORS *******************/


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
}
