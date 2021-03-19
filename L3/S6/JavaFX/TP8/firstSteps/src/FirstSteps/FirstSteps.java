package FirstSteps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Properties and binding illustration with FXML controller
 * A disk's position is bound to sliders
 */
public class FirstSteps extends Application {

    /*--------------------- Public methods -------------------------*/

    @Override
    public void start (Stage stage) {
        MyBorderPane2 myBorderPane2 = new MyBorderPane2();

        // Scene dimensions
        double width = 600.0, height = 600.0;

        Scene scene = new Scene(myBorderPane2, width, height);
        stage.setScene(scene);

        stage.setTitle("First steps in JavaFX with FXML");
        stage.show ();
    }


    public static void main (String args []) {
        launch (args);
    }
}
