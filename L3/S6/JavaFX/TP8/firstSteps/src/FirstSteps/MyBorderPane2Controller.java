package FirstSteps;

import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Controller for MyBorderPane2.fxml's contents
 * The FXML loader is called in the MyBorderPane2 class.
 */
public class MyBorderPane2Controller {

    /*--------------------- Private members -------------------------*/

    /** Random generator */
    Random random = new Random();

    // To manipulate a Node defined in the FXML file named using the
    // "fx:id" field, we have to declare a class member with the same name.
    // The relationship between the node and the class member is made
    // with the leading @FXML annotation.
    @FXML
    Circle circle;

    /*--------------------- Public methods -------------------------*/

    /**
     * initialize() is called by the FXML loader when this class is created
     * @warn Do not forget the @FXML annotation
     */
    @FXML
    public void initialize() {
        circle.setFill(Color.BLACK);
    }


    /**
     * Randomly change the circle's color each time a slider is clicked on
     * @see MyBorderPane2.fxml
     */
    @FXML
    public void changeCircleColor() {
        float r = this.random.nextFloat();
        float g = this.random.nextFloat();
        float b = this.random.nextFloat();

        Color randomColor = Color.color(r, g, b);
        circle.setFill(randomColor);
    }
}

