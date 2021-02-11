package Ex2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class TestActionEvent extends Application {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    BorderPane root;
    Circle circle;
    Button b1, b2;
    Label labMessage;

    /******************* CONSTRUCTORS *******************/


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/

    @Override
    public void start(Stage primaryStage) throws Exception {

        root = new BorderPane();
        circle = new Circle(50);
        b1 = new Button("b1");
        b2 = new Button("b2");
        labMessage = new Label("Mon message");
        root.setCenter(circle);
        root.setTop(labMessage);
        root.setLeft(b1);
        root.setRight(b2);

        b2.addEventHandler(ActionEvent.ACTION, new Ecouteurs("Boutton action 4", false));
        b2.addEventHandler(ActionEvent.ACTION, new Ecouteurs("Handler B2", false));
        b2.setOnAction(new Ecouteurs("On Action b2", false));

        Scene scene = new Scene(root);

        primaryStage.setTitle("Ex1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
