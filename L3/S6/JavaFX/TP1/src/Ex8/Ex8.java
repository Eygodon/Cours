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
        BorderPane root = new BorderPane();
        TabGamers tabGamers = new TabGamers(3);
        Checkers checker = new Checkers();
        checker.setPiece(5, 2, 2);
        checker.setColorPiece(Color.TURQUOISE, 2, 2);
        root.setLeft(checker);
        root.setRight(tabGamers);
        Scene scene = new Scene(root);

        primaryStage.setTitle("TP1 Exo 8");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
