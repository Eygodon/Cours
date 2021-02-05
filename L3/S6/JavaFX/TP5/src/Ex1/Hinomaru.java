/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/** 
 * 
* Cette application affiche un drapeau japonais dont on peut déplacer le cercle central.
* - Pour respecter les proportions du drapeau japonais, l'aspect ratio de la fenêtre 
* et le rayon du soleil sont gérées par des bindings 
* - deux sliders permettent (toujours avec des bindings) de déplacer le soleil. 
* 
* @author  Xavier Skapin Antoine Bergey
*/
public class Hinomaru extends Application {
    
    @Override
    public void start(Stage stage) {
        BorderPane borderPaneRoot = new BorderPane();
        Scene scene = new Scene(borderPaneRoot, 600, 400, Color.WHITE);    
        
        // Il faut respecter le ratio Largeur/Hauteur = 3/2 du drapeau japonais
        // Je lie la largeur min et max de la fenêtre à sa hauteur de la fenetre. 
        stage.minWidthProperty().bind(stage.heightProperty().multiply(1.5));
        stage.maxWidthProperty().bind(stage.heightProperty().multiply(1.5));
        // Remarques : 
        // * On doit travailler sur stage.minWidthProperty 
        //         widthProperty est une readOnlyDoubleProperty (=> dont on ne peut modifier la valeur) 
        //         scene n'a qu'une widthProperty (qui est aussi une readOnlyDoubleProperty) 
        // * Dans l'absolu, il faudrait retirer de stage.height la hauteur du bandeau de la fenêtre ; 
        
       
        
        // Center content    
        Pane pane = new Pane();    

        Circle circle = new Circle(borderPaneRoot.getWidth()/2, 
                borderPaneRoot.getHeight()/2, 125.0, Color.RED);    
        
        // le rayon du cercle doit faire 3/10 de la hauteur du drapeau
        // Je lie le rayon du cercle à la hauteur de la scene 
        circle.radiusProperty().bind(scene.heightProperty().multiply(3).divide(10));
        
        
        pane.getChildren().add(circle);
        borderPaneRoot.setCenter(pane);    

        // Bottom content
        // Slider : min = 0, max = 1, start value = 0.5
        Slider sliderX = new Slider(0, 1, 0.5);
        circle.centerXProperty().bind(sliderX.valueProperty().multiply(borderPaneRoot.widthProperty()));
        borderPaneRoot.setBottom(sliderX);

        // Right content
        // Slider : min = 0, max = 1, start value = 0.5
        Slider sliderY = new Slider(0, 1, 0.5);
        sliderY.setOrientation(Orientation.VERTICAL);

        // sliderY and circle's frame of reference head in oppposite direction:
        // Y's circle depends on (1 - sliderY)
        SimpleDoubleProperty propertyOne = new SimpleDoubleProperty(1.0);    
        circle.centerYProperty().bind(borderPaneRoot.heightProperty().multiply(propertyOne.subtract(sliderY.valueProperty())));

        borderPaneRoot.setRight(sliderY);

        // Stage attributes
        stage.setScene(scene);
        stage.setTitle("Taiyō ga ugoite iru ");
        
        
        stage.centerOnScreen();
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
