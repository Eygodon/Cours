package Ex3;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.awt.*;

public class PaneTest extends Application {

    @Override
    public void start (Stage primaryStage){
        Button button1 = new Button();
        Button button2 = new Button();
        Button button3 = new Button();
        Button button4 = new Button();
        Button button5 = new Button();
        Button button6 = new Button();

        button1.setText("Un");
        button2.setText("Deux");
        button3.setText("Trois");
        button4.setText("Quatre");
        button5.setText("Cinq");
        button6.setText("Six");

        FlowPane root = new FlowPane();
        root.getChildren().addAll(button1, button2, button3, button4, button5, button6);
        root.setOrientation(Orientation.VERTICAL);
        root.setVgap(12);
        root.setHgap(6);
        root.setAlignment(Pos.BASELINE_CENTER);

        //Lorsqu'on redimensionne la fenêtre les boutons sautent une ligne
        Scene scene = new Scene(root, 30, 30);

        // On indique le titre de la fenêtre principale
        primaryStage.setTitle("Exo3Flow");
        // On met la scene dans la fenêtre principale
        primaryStage.setScene(scene);
        // On montre la fenêtre principale
        primaryStage.show();
    }
}

