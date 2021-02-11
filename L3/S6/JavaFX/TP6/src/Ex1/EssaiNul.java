package Ex1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EssaiNul extends Application {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/


    /******************* CONSTRUCTORS *******************/


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
    @Override
    public void start (Stage primaryStage)
    {
        Pane root = new Pane();
        for (int i = 0; i<10; i++)
        {
            ButtonAleaNul button = new ButtonAleaNul();
            root.getChildren().add(button);
            button.setLayoutX(100*i);
        }

        Scene scene = new Scene(root, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Ex1");
        primaryStage.show();
    }
}
