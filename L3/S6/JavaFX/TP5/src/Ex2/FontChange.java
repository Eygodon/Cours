package Ex2;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringExpression;
import javafx.beans.value.ChangeListener;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FontChange extends Application {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private Label lab;
    private BorderPane root;
    private SliderBetter tailleFonte;
    /******************* CONSTRUCTORS *******************/


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
    @Override
    public void start (Stage primaryStage){
        lab = new Label("Deus Vult");
        tailleFonte = new SliderBetter("tailleFonte", 0, 50, 20);
        root = new BorderPane();
        lab.styleProperty().bind(Bindings.concat("-fx-font-size:", tailleFonte.valueProp()));
        Scene scene = new Scene(root, 500, 500);
        root.setCenter(lab);
        root.setBottom(tailleFonte);

        primaryStage.setTitle("Ex2.4");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
