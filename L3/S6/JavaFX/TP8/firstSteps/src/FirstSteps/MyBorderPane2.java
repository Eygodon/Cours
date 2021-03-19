package FirstSteps;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

/**
 * This class loads the FXML data describing the scene contents
 */
public class MyBorderPane2 extends BorderPane {

    /*--------------------- Public methods -------------------------*/

    /**
     * Constructor
     */
    public MyBorderPane2() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MyBorderPane2.class.getResource("MyBorderPane2.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        }
        catch(IOException ioe) {
            System.err.println("MyBorderPane2 constructor error");
            ioe.printStackTrace();
        }
    }
}
