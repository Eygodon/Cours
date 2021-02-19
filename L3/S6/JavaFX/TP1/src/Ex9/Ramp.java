package Ex9;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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
        int insetBot = 0;
        int insetTop = 0;
        System.out.println("Saisir le nombre à atteindre :");
        Scanner sc = new Scanner(System.in);
        int tiles = sc.nextInt();

        for (int i = 0; i <= tiles; i++)
        {
            VBox tile = new VBox();
            tile.setAlignment(Pos.BOTTOM_LEFT);
            BorderStroke bs = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1));
            tile.setMaxWidth(Double.MAX_VALUE);
            tile.setMaxHeight(Double.MAX_VALUE);
            HBox.setHgrow(tile, Priority.ALWAYS);
            tile.setBackground(new Background(new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY)));
            tile.setBorder(new Border(bs));
            Label labelUn = new Label(String.valueOf(i/10));
            Label labelZero = new Label(String.valueOf(i%10));
            tile.getChildren().add(labelUn);
            tile.getChildren().add(labelZero);
            root.getChildren().add(tile);
            insetBot = (i*2);
            insetTop = (tiles - i) * 2;
            HBox.setMargin(tile, new Insets(insetTop,0,insetBot,0));
        }
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Ex9");
        primaryStage.show();
    }
}
