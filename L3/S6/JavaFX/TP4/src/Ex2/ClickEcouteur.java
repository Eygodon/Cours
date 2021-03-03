package Ex2;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class ClickEcouteur implements EventHandler<MouseEvent> {

    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    Label label;

    /******************* CONSTRUCTORS *******************/
    public ClickEcouteur (Label label)
    {
        this.label = label;
    }

    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
    @Override
    public void handle (MouseEvent event) {
        label.setText("posX = " + event.getX() + "posY = " + event.getY());
    }
}