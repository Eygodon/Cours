package Ex2;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;


public class Ecouteurs implements EventHandler {

    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private String message;
    private Boolean stop;
    private Label label;
    /******************* CONSTRUCTORS *******************/
    public Ecouteurs (Boolean stop, Label lab)
    {
        super();
        this.stop = stop;
        this.label = lab;
    }

    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/

    @Override
    public void handle(Event event)
    {
        this.message = "je suis " + event.getSource().toString();
        System.out.format("%s | %s | %s | %s\n", this.message,
                event.getEventType().getName(), event.getSource().toString(), event.getTarget().toString());
        this.label.setText(this.message);
        if (this.stop)
            event.consume();
    }
}
