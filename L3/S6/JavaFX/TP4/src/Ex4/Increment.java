package Ex4;

import Ex3.BorderWithQuitCLA;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;



public class Increment extends Application {
    /********************* CONSTANTS ********************/
    private final Button increase = new Button("+5");
    private final Button reduce = new Button("-5");

    /********************* VARIABLES ********************/

    private Label label = new Label();
    private Pane pc = new Pane();
    private int radius = 10;
    private Circle circle = new Circle();

    /******************* CONSTRUCTORS *******************/


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
    @Override
    public void start(Stage primaryStage) throws Exception {
        label.setText(String.valueOf(radius));
        circle.setRadius(radius);

        increase.setOnAction(event ->
                {
                    radius += 5;
                    label.setText(String.valueOf(radius));
                    circle.setRadius(radius);
                }
        );

        reduce.setOnAction(event ->
                {
                    radius -= 5;
                    label.setText(String.valueOf(radius));
                    circle.setRadius(radius);
                }
        );

        HBox box = new HBox();
        box.setSpacing(20);
        box.setAlignment(Pos.CENTER);
        box.getChildren().addAll(increase, label, reduce);


        circle.setLayoutX(200);
        circle.setLayoutY(175);
        pc.getChildren().add(circle);
        pc.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            circle.setLayoutX(event.getX());
            circle.setLayoutY(event.getY());
        });
        //mousedragged, mouse moved, mouse released , getx, gety, setlayoutx/y
        BorderWithQuitCLA root = new BorderWithQuitCLA();

        Scene scene = new Scene(root, 400, 400);
        root.setTop(box);
        root.setCenter(pc);

        primaryStage.setTitle("Ex4");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}