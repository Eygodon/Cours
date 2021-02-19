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
public class CompteurInnerClass1E extends Application {
    int compteur = 0 ; 
    Label lCompteur , lPlus1;
    Button bPlus5 ; 
    
    @Override
    public void start(Stage primaryStage) {
        lPlus1 = new Label("Plus 1");
        bPlus5 = new Button("Plus 5");
        lCompteur = new Label ("nb : 0");
        
        // Je crée un seul écouteur
        Ecouteur ePlus = new Ecouteur();
        
        // J'abonne cet écouteur à l'entree de la souris sur le label.
        lPlus1.addEventHandler(MouseEvent.MOUSE_ENTERED, ePlus); 
        // et à l'action sur le bouton. 
        bPlus5.addEventHandler(ActionEvent.ACTION,ePlus); 
        
        FlowPane root = new FlowPane(); 
        root.setHgap(5);
        root.getChildren().addAll(lPlus1,bPlus5,lCompteur);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Un seul écouteur pour les deux");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    // Ma classe écouteur 
    public class Ecouteur implements EventHandler{
        // J'incremente le compteur de clics et affiche le nouveau 
        // nombre. 
        @Override
        public void handle(Event event) {
            // Je teste si je suis sur le label
            if (event.getSource()== lPlus1)
                compteur++ ;
            else 
                compteur = compteur+5 ; 
            lCompteur.setText(" nb : "+compteur); 
        }
        
    }
}
