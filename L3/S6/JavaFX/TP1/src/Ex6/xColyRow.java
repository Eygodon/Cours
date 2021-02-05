package Ex6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.awt.*;
import java.util.Scanner;

public class xColyRow extends Application {
    @Override
    public void start (Stage primaryStage){
        Scanner scan = new Scanner(System.in);
        System.out.println("Indiquez le nombre de colonnes souhaitées :");
        int col = scan.nextInt();
        System.out.format("Nombre de colonnes : %d\n"+"Indiquez le nombre de lignes souhaitées :", col);
        int row = scan.nextInt();
        System.out.format("Nombre de lignes   : %d\n", row);
        GridPane root = new GridPane();

        for (int i = 0; i<col; i++){
            for (int j = 0; j<row; j++){
                Button button = new Button();
                button.setText("("+i+";"+j+")");
                root.add(button, i, j);
            }
        }
        Scene scene = new Scene(root);

        root.setHgap(10);
        root.setVgap(5);

        primaryStage.setTitle("Tp1 Ex6");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
