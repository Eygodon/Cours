package Ex9;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class SecondeFenetre extends Stage {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private TextField tfSecondaire;
    private Scene scene;
    private Pane root;

    /******************* CONSTRUCTORS *******************/
    public SecondeFenetre(){
        super();
        this.tfSecondaire = new TextField();
        this.root = new Pane();
        this.root.getChildren().add(tfSecondaire);
        this.scene = new Scene(root, 200, 200);
        this.setScene(scene);
        this.setTitle("Second");
    }

    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
    public void afficheMessage(String m){
        this.tfSecondaire.setText(m);
    }
    public void setOnTextChanged(EventHandler<KeyEvent> eh){
     tfSecondaire.setOnKeyReleased(eh);
    }
}
