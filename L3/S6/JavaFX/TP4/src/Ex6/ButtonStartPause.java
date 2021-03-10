package Ex6;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ButtonStartPause extends Button {
    /********************* CONSTANTS ********************/

    /********************* VARIABLES ********************/


    /******************* CONSTRUCTORS *******************/
    public ButtonStartPause(int size){
        super("");
        ImageView play = new ImageView(new Image(getClass().getResourceAsStream("Icon/TP_04_play.png")));
        play.setFitHeight(size);
        play.setPreserveRatio(true);
        ImageView pause = new ImageView(new Image(getClass().getResourceAsStream("Icon/TP_04_pause.png")));
        pause.setFitHeight(size);
        pause.setPreserveRatio(true);
        this.setGraphic(play);
        this.setOnAction(event ->
                this.setGraphic(pause)
        );
    }


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
}
