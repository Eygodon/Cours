package Ex6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Scanner;

public class Big5x4 extends Application {
    @Override
    public void start (Stage primaryStage){

        GridPane root = new GridPane();

        for (int i = 0; i<5; i++){
            for (int j = 0; j<4; j++){
                Button button = new Button();
                button.setText("("+ i + ";" + j + ")");
                root.add(button, i, j);
            }
        }
        Button bigButton = new Button();
        Button smolButton = new Button();

        bigButton.setText("grand");
        smolButton.setText("petit");

        bigButton.setMaxWidth(Double.MAX_VALUE);
        bigButton.setMaxHeight(Double.MAX_VALUE);
        smolButton.setMaxWidth(Double.MAX_VALUE);
        smolButton.setMaxHeight(Double.MAX_VALUE);
        root.add(bigButton,0, 1,2,2);
        root.add(smolButton,0, 3,2,1);

        Scene scene = new Scene(root);

        root.setHgap(10);
        root.setVgap(5);

        primaryStage.setTitle("Tp1 Ex6");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
