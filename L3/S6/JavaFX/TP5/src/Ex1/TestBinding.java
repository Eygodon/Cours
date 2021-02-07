package Ex1;

import Ex2.SliderBetter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class TestBinding extends Application {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    TextField A, B, C, D, E;
    Button resetti, DtoE;
    SliderBetter slider;
    /******************* CONSTRUCTORS *******************/


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
    @Override

    public void start (Stage primaryStage){
        VBox root = new VBox();
        A = new TextField("");
        B = new TextField("");
        C = new TextField("");
        D = new TextField("D chef ou futur chef");
        E = new TextField("c'est E ici");
        resetti = new Button("Reset E");
        DtoE = new Button("D -> E");
        slider = new SliderBetter("monSlider", 0, 50, 25);

        A.textProperty().bindBidirectional(B.textProperty());
        A.textProperty().bindBidirectional(C.textProperty());

        resetti.setOnAction( e -> {E.textProperty().setValue("Ici c'est E");});
        DtoE.setOnAction(e -> {E.textProperty().bind(D.textProperty());});

        root.getChildren().addAll(A, B, C, D, E, resetti, DtoE, slider);

        Scene scene = new Scene(root,500,600, Color.LIGHTBLUE);

        primaryStage.setScene(scene);
        primaryStage.setTitle("TP5 Ex1");
        primaryStage.show();
    }
}
