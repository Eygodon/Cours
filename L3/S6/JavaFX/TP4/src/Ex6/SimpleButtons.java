package Ex6;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SimpleButtons  extends Application {

    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/


    /******************* CONSTRUCTORS *******************/


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane root = new FlowPane();

        Image play = new Image(getClass().getResourceAsStream("Icon/TP_04_play.png"));
        Image pause = new Image(getClass().getResourceAsStream("Icon/TP_04_pause.png"));
        ImageView iconPlay = new ImageView(play);
        ImageView iconPause = new ImageView(pause);

        Button btnPlay = new Button("Play",iconPlay);
        Button btnPause = new Button("Pause",iconPause);

        FlowPane btnsPane = new FlowPane();

        btnsPane.getChildren().addAll(btnPlay, btnPause);
        btnsPane.setOrientation(Orientation.VERTICAL);
        btnsPane.setBorder(new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(4))));
        btnsPane.setPrefWrapLength(230);
        btnsPane.setVgap(5);
        Button quit = new Button("Quit");
        quit.setOnAction(event -> Platform.exit());
        /*root.setOrientation(Orientation.HORIZONTAL);
        root.hgapProperty().setValue(3);
        Pour Q1
         */
        root.setOrientation(Orientation.VERTICAL);
        root.getChildren().addAll(btnsPane, quit);
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("WHOA");
        primaryStage.show();
    }
}
