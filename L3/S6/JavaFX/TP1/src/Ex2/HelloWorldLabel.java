/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class HelloWorldLabel extends Application {
    
    // start est appelée automatiquement pour lancer l'application, 
    // elle a en parametre la fenetre principale. 
    @Override
    public void start(Stage primaryStage) {
        // On crée l'étiquette  
        //Label monLabel = new Label();
        Button monButton = new Button();
        Label monLabel2 = new Label();
        Circle monCircle = new Circle(150, 100, 40, Color.RED);
        Line monLine = new Line();
        //monLabel.setText("Hello World");
        monButton.setText("OeilGauche");
        monLabel2.setText("OeilDroit");
        BorderStroke bs = new BorderStroke(Color.PURPLE, BorderStrokeStyle.DASHED, new CornerRadii(7), new BorderWidths(5,5,5,5));

        // root, qui sera la racine de la fenêtre est un Pane (panneau sans 
        // gestionnaire de placement)
        Pane root = new Pane();
        // on place l'étiquette monLabel à l'intérieur de root
        root.getChildren().addAll(monButton, monLabel2, monCircle, monLine);

        //on positionne les labels
        //monLabel.setLayoutX(100);
        monButton.setLayoutY(20);
        monLabel2.setLayoutY(20);
        monLabel2.setLayoutX(200);
        monLine.setLayoutX(100);
        monLine.setLayoutY(150);
        monLine.setStartX(100);
        monButton.setBorder(new Border(bs));
        monButton.setPadding(new Insets(10, 20, 50, 30));
        monLabel2.setStyle(" -fx-border-width : 5px ; -fx-border-color : red");


        /* ######## Event Handler ######## */

        monButton.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                monLine.setLayoutY(monLine.getLayoutY() + 5);
            }
        });

        // On crée la scène (la zone intérieure de la fenètre)
        // elle a le Pane root comme intérieur, et on dit qu'elle fait 300 x 250 pixels.  
        Scene scene = new Scene(root, 300, 300);//sans dimensions, la fenêtre s'ajuste aux éléments
        
        // On indique le titre de la fenêtre principale 
        primaryStage.setTitle("Hello World!");
        // On met la scene dans la fenêtre principale
        primaryStage.setScene(scene);
        // On montre la fenêtre principale
        primaryStage.show();
    }

    /**
     * Fonction main par défaut 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // lance l'application 
        launch(args);
      
    }
    
}

