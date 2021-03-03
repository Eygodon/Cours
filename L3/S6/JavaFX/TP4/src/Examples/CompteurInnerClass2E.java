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
public class CompteurInnerClass2E extends Application {
    int compteur = 0 ; 
    Label lCompteur ; 
    @Override
    public void start(Stage primaryStage) {
        Label lPlus1 = new Label("Plus 1");
        Button bPlus5 = new Button("Plus 5");
        lCompteur = new Label ("nb : 0");
        
        // Je crée deux écouteurs, 
        // Un pour le label
        Ecouteur ePlus1 = new Ecouteur(1); 
        // un pour le bouton
        Ecouteur ePlus5 = new Ecouteur(5);
        
        // J'abonne un écouteur à l'entree de la souris sur le label.
        lPlus1.addEventHandler(MouseEvent.MOUSE_ENTERED, ePlus1); 
        // J'abonne l'autre écouteur à l'action sur le bouton. 
        bPlus5.addEventHandler(ActionEvent.ACTION,ePlus5); 
        
        FlowPane root = new FlowPane(); 
        root.setHgap(5);
        root.getChildren().addAll(lPlus1,bPlus5,lCompteur);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Deux écouteurs différents");
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
        int increment ; 
        public Ecouteur(int increment){
             this.increment = increment ; 
        }

        // J'incremente le compteur de clics et affiche le nouveau 
        // nombre. 
        @Override
        public void handle(Event event) {
            compteur = compteur+increment ; 
            lCompteur.setText(" nb : "+compteur); 
        }
        
    }
}
