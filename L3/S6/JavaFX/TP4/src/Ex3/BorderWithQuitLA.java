package Ex3;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class BorderWithQuitLA extends BorderPane {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private Button quit;

    /******************* CONSTRUCTORS *******************/
    public BorderWithQuitLA() {
        super();
        this.quit = new Button("Quit");
        this.quit.setOnAction( event -> {
            Platform.exit();
                }
        );
        this.setBottom(quit);
        BorderPane.setAlignment(quit, Pos.BOTTOM_RIGHT);
    }

/********************* GETTERS **********************/


/********************* SETTERS **********************/


/********************* METHODS **********************/
}