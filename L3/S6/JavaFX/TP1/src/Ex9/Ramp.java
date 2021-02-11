package Ex9;

import Ex4.HboxTest;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.util.Scanner;

public class Ramp  extends Application {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/


    /******************* CONSTRUCTORS *******************/


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/

    @Override
    public void start (Stage primaryStage)
    {
        HBox root = new HBox();
        Integer inset = 0;
        System.out.println("Saisir le nombre de cases voulues :");
        Scanner sc = new Scanner(System.in);
        int tiles = sc.nextInt();

        for (int i = 0; i < tiles; i++)
        {
            VBox tile = new VBox();
            Label label = new Label("10");
            tile.getChildren().add(label);
            root.getChildren().add(tile);
            inset += i;
            HBox.setMargin(tile, new Insets(0,0,inset,0));
        }
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Ex9");
        primaryStage.show();
    }
}
