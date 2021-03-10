package Ex2;

import Ex2.ButtonAleaTask;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EssaiTask extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        ButtonAleaTask b0 = new ButtonAleaTask();
        b0.setOnAction((ActionEvent event) -> b0.go());
        ButtonAleaTask b1 = new ButtonAleaTask();
        b1.setOnAction((ActionEvent event) -> b1.go());
        ButtonAleaTask b2 = new ButtonAleaTask();
        b2.setOnAction((ActionEvent event) -> b2.go());
        ButtonAleaTask b3 = new ButtonAleaTask();
        b3.setOnAction((ActionEvent event) -> b3.go());
        ButtonAleaTask b4 = new ButtonAleaTask();
        b4.setOnAction((ActionEvent event) -> b4.go());

        VBox vBox = new VBox();
        vBox.getChildren().addAll(b0, b1, b2, b3, b4);
        Scene scene = new Scene(vBox, 300, 400);

        primaryStage.setTitle("AleaCoin Ex1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
