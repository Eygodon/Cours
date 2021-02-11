package Ex1;

import javafx.event.Event;
import javafx.event.EventHandler;

public class Ecouteurs implements EventHandler {

    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private String message;
    private Boolean stop;

    /******************* CONSTRUCTORS *******************/
    public Ecouteurs (String message, Boolean stop)
    {
        super();
        this.message = message;
        this.stop = stop;
    }

    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/

    @Override
    public void handle(Event event)
    {
        System.out.format("%s | %s | %s | %s\n", this.message,
                event.getEventType().getName(), event.getSource().toString(), event.getTarget().toString());
        if (this.stop)
            event.consume();
    }
}
