package Ex1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.Label;

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

        root.getChildren().forEach(child ->{
            child.addEventHandler(ActionEvent.ACTION, new Ecouteurs("Handler " + child.toString(), false));
            child.addEventFilter(ActionEvent.ACTION, new Ecouteurs("Filter " + child.toString(), false));
        });

        root.addEventHandler(ActionEvent.ACTION, new Ecouteurs("Handler root", false));
        root.addEventFilter(ActionEvent.ACTION, new Ecouteurs("Filter root", false));

        Scene scene = new Scene(root);

        scene.addEventHandler(ActionEvent.ACTION, new Ecouteurs("Handler scene", false));
        scene.addEventFilter(ActionEvent.ACTION, new Ecouteurs("Filter scene", false));

        primaryStage.setTitle("Ex1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
