package Ex8;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.awt.*;
import javafx.scene.control.Label;

public class Ex8 extends Application {

    /********************* METHODS **********************/
    @Override
    public void start (Stage primaryStage){
        Checkers root =new Checkers();
        root.setPiece(5, 8, 2);
        root.getPiece(8,2);
        root.setColorPiece(Color.TURQUOISE, 8,2);
        Scene scene = new Scene(root);

        primaryStage.setTitle("TP1 Exo 8");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
