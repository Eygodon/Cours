package Ex3;

import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class BorderPaneTest extends Application {

    @Override
    public void start (Stage primaryStage){
        Button button1 = new Button();
        Button button2 = new Button();
        Button button3 = new Button();
        Button button4 = new Button();
        Button button5 = new Button();

        button1.setText("Haut");
        button2.setText("Bas");
        button3.setText("Gauche");
        button4.setText("Droite");
        button5.setText("Centre");


        BorderPane root = new BorderPane();
        BorderPane.setAlignment(button1, Pos.CENTER);
        BorderPane.setAlignment(button3, Pos.BOTTOM_LEFT);
        BorderPane.setAlignment(button4, Pos.TOP_RIGHT);
        BorderPane.setAlignment(button5, Pos.TOP_LEFT);
        //On ne peut pas appeller set top par exemple deux fois sur deux nodes différents
        //root.setTop(button1);
        //root.setBottom(button2);
        root.setLeft(button3);
        root.setRight(button4);
        root.setCenter(button5);

        Scene scene = new Scene(root, 300, 300);

        // On indique le titre de la fenêtre principale
        primaryStage.setTitle("Exo3Border");
        // On met la scene dans la fenêtre principale
        primaryStage.setScene(scene);
        // On montre la fenêtre principale
        primaryStage.show();
    }
}

