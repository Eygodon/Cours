package Ex1;

import Ex0.AleaCoin;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class ButtonAleaNul extends Button {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private ActionEvent event;
    private AleaCoin coin;
    /******************* CONSTRUCTORS *******************/

    public ButtonAleaNul() {
        super("Tirer 100 000 000 lancers");
        this.coin = new AleaCoin();
        this.event = new ActionEvent();
        this.setOnAction(event -> {
            this.setDisable(true);
            this.textProperty().set("Je calcule");
            this.coin.startLaunch(100000000);
            int faces = this.coin.getFaces();
            int piles = this.coin.getPiles();
            this.textProperty().set(String.valueOf(faces) + " faces/" + String.valueOf(piles) + " piles");
            this.setDisable(false);
        });
    }

    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
}
