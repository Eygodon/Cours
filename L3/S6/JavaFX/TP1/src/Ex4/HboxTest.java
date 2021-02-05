package Ex4;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class HboxTest extends Application {

    @Override
    public void start (Stage primaryStage){
        Button button1 = new Button();
        Button button2 = new Button();
        Button button3 = new Button();
        /*Button button4 = new Button();
        Button button5 = new Button();
        Button button6 = new Button();*/
        Region ressort = new Region();

        //les boutons gardent leur hauteur
        button1.setText("Un");
        button2.setText("Deux");
        button2.setMaxWidth(Double.MAX_VALUE);
        //button2.setFont(Font.font(100));
        button3.setText("Trois");
        /*button3.setPadding(new Insets(40));
        button4.setText("Quatre");
        button5.setText("Cinq");
        button6.setText("Six");*/


        HBox root = new HBox();
        root.getChildren().addAll(button1, ressort, button2, button3);
        HBox.setHgrow(ressort, Priority.ALWAYS);
        HBox.setHgrow(button2, Priority.ALWAYS);
        //root.getChildren().addAll(button1, button2, button3, button4, button5, button6);
        //Lorsque la fenêtre est trop étroite, les boutons sont réduits et leur texte affiché avec des points
        Scene scene = new Scene(root, 500, 50);
        root.setAlignment(Pos.TOP_CENTER);
        /*root.setSpacing(20);
        root.setAlignment(Pos.CENTER);
        HBox.setMargin(button1, new Insets(50));
        HBox.setMargin(button6, new Insets(50));
        HBox.setMargin(button2, new Insets(0,0,20,0));
        HBox.setMargin(button3, new Insets(0,0,40,0));
        HBox.setMargin(button4, new Insets(0,0,60,0));
        HBox.setMargin(button5, new Insets(0,0,80,0));*/
        primaryStage.setTitle("Tp1, Ex4");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
