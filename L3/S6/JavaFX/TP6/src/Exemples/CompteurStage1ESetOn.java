/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cleexempleecouteurs;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author bergey
 */
public class CompteurStage1ESetOn extends Application implements EventHandler {
    int compteur = 0 ; 
    Label lCompteur , lPlus1;
    Button bPlus5 ; 
    
    // Mon application est elle même  un EventHandler, 
    // J'écris la méthode handle
    @Override
    public void handle(Event event) {
        // Je teste si je suis sur le label
        if (event.getSource()== lPlus1)
            compteur++ ;
        else 
            compteur = compteur+5 ; 
        lCompteur.setText(" nb : "+compteur); 
    }
        
    @Override
    public void start(Stage primaryStage) {
        lPlus1 = new Label("Plus 1");
        bPlus5 = new Button("Plus 5");
        lCompteur = new Label ("nb : 0");
        
    
        
        // J'abonne l'application (qui est un écouteur) à l'entree de la souris sur le label.
        lPlus1.setOnMouseEntered(this);
                //MOUSE_ENTERED, this); 
        // et à l'action sur le bouton. 
        bPlus5.setOnAction(this); 
        
        FlowPane root = new FlowPane(); 
        root.setHgap(5);
        root.getChildren().addAll(lPlus1,bPlus5,lCompteur);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("avec setOn ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}
