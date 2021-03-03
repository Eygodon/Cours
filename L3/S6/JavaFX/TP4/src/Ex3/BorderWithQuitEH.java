package Ex3;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class BorderWithQuitEH extends BorderPane implements EventHandler{
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private Button quit;

    /******************* CONSTRUCTORS *******************/
    public BorderWithQuitEH(){
        super();
        this.quit = new Button("Quit");
        this.setBottom(quit);
        BorderPane.setAlignment(quit, Pos.BOTTOM_RIGHT);
    }

    @Override
    public void handle(Event event) {
        Platform.exit();
    }

    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
}