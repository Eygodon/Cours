package Ex2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Mult extends Application {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private SliderBetter sliderX;
    private SliderBetter sliderY;
    private SliderBetter sliderRes;

    /******************* CONSTRUCTORS *******************/


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
    @Override
    public void start (Stage primaryStage){
        sliderX   = new SliderBetter("X", 0, 100, 0);
        sliderY   = new SliderBetter("Y", 0, 100, 0);
        sliderRes = new SliderBetter("X*Y", 0, 10000, 0);
        sliderRes.valueProp().bind(sliderX.valueProp().multiply(sliderY.valueProp()));

        VBox root = new VBox();
        root.getChildren().addAll(sliderX, sliderY, sliderRes);

        Scene scene = new Scene(root);

        primaryStage.setTitle("Ex1.2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
