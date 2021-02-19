package Ex10;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import javafx.scene.control.Label;
import java.util.ArrayList;

public class Combo extends Application {

    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/


    /******************* CONSTRUCTORS *******************/


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/

    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane left = new FlowPane();
        left.setOrientation(Orientation.VERTICAL);
        left.setVgap(10);
        javafx.scene.control.Label metric = new Label("Metric");
        ComboBox<String> comboMetric = new ComboBox<String>();
        comboMetric.getItems().addAll("meter", "centimetre", "millimetre");
        comboMetric.setPromptText("PlaceHolder");
        TextField inputMetric = new TextField();
        left.getChildren().addAll(metric, comboMetric, inputMetric);

        FlowPane root = new FlowPane();
        root.setOrientation(Orientation.HORIZONTAL);
        root.getChildren().addAll(left);

        Scene scene= new Scene(root, 400, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Ex10");
        primaryStage.show();
    }
}
