package Ex2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Curves extends Application {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private Pane circlePane;
    private Circle circle;
    private SliderBetter A, B, X;
    private VBox sliderBox;
    private int sizeX, sizeY;

    /******************* CONSTRUCTORS *******************/


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
    @Override
    public void start (Stage primaryStage){
        sizeX = 300;
        sizeY = 400;
        circlePane = new Pane();
        circle = new Circle(3, Color.BLACK);
        sliderBox = new VBox();

        A = new SliderBetter("A", 0, 2, 0);
        B = new SliderBetter("B", 0, 100, 0);
        X = new SliderBetter("X", 0, sizeX , 0);

        circle.layoutXProperty().bind(X.valueProp());
        circle.layoutYProperty().bind(A.valueProp()
                                .multiply(X.valueProp()
                                .multiply(X.valueProp())
                                )
                                .add(B.valueProp())
        );

        circlePane.getChildren().add(circle);
        sliderBox.getChildren().addAll(A, B, X);

        BorderPane root = new BorderPane();

        root.setCenter(circlePane);
        root.setBottom(sliderBox);

        Scene scene = new Scene(root, sizeX*2, sizeY*2);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ex2.3");
        primaryStage.show();
    }
}
