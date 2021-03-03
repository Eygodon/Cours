package Ex3;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class BorderWithQuitCLA extends BorderPane {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private Button quit;

    /******************* CONSTRUCTORS *******************/
    public BorderWithQuitCLA(){
        super();
        this.quit = new Button("Quit");
        this.quit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        this.setBottom(quit);
        BorderPane.setAlignment(quit, Pos.BOTTOM_RIGHT);
    }

    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
}