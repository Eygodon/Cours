package Ex2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
        b2.addEventHandler(ActionEvent.ACTION, new Ecouteurs( true, labMessage));
        b2.addEventHandler(ActionEvent.ACTION, new Ecouteurs(true, labMessage));
        b2.setOnAction(new Ecouteurs( false, labMessage));
        b1.setOnAction(new Ecouteurs(false,labMessage));
        circle.addEventHandler(MouseEvent.MOUSE_CLICKED, new Ecouteurs(true, labMessage));
        root.addEventHandler(MouseEvent.MOUSE_CLICKED, new Ecouteurs(false,  labMessage));


        Scene scene = new Scene(root);

        primaryStage.setTitle("Ex1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
/*
    Question 1)
    Deux setOnAction override le précédent.
    Question 3)
    Root et circle ne peuvent pas réagir à un Action.any, ni receveoir un ecouteur via SetOnAction.
    Question 4)
    javafx.scene.input.Mouse_event
 */