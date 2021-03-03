package Ex3;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class BorderWithQuit extends BorderPane {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    Button quit;

    /******************* CONSTRUCTORS *******************/
    public BorderWithQuit(){
        super();
        this.quit = new Button("Quit");
        this.quit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        BorderPane.setAlignment(quit, Pos.BOTTOM_RIGHT);
    }

    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
}
