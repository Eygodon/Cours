/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

/**
 * Une application pour illustrer le binding de haut niveau. 
 * 2 labels (lNomJumeau1, et lNomJumeau2) recuperent leur texte auprès 
 *     d'un TextField
 * 2 labels ages sont calculés automatiquements à partir de la soustraction d'un
 *     entier présent dans un autre label
 * @author bergey
 */
public class LaFamille extends Application {
    
    Label lNomJumeau1, lNomJumeau2,  lAgeJumeau1, lAgeJumeau2; 
    TextField tfNomPere, tfAnneeJumeau1, tfAnneeJumeau2 ; 
    
    
    
    
    @Override
    public void start(Stage primaryStage) { 
     
        // le champ où l'on saisit le nom de famille du père
        tfNomPere = new TextField ("Bergey"); 
        
        //  les noms de famille des jumeaux   
        lNomJumeau1 = new Label(""); 
        lNomJumeau2 = new Label(""); 
        // que l'on lie unidirectionnellement auprès du nom du père
        lNomJumeau1.textProperty().bind(tfNomPere.textProperty());      
        lNomJumeau2.textProperty().bind(tfNomPere.textProperty());  
       
        // Les années de naissance des jumeaux. 
        tfAnneeJumeau1 = new TextField(); 
        tfAnneeJumeau2 = new TextField();
        // On les "binde" bidirectionnellement. 2 jumeaux sont nés la même année
        tfAnneeJumeau2.textProperty().bindBidirectional(tfAnneeJumeau1.textProperty()); 

        
        // les labels dans lesquels on va mettre l'age  des jumeaux.  
        lAgeJumeau1 = new Label(); 
        lAgeJumeau2 = new Label(); 
                
        
        // Je vais stocker l'année (comme Number) de naissance ici
        IntegerProperty dateNaissance =  new SimpleIntegerProperty();  
        dateNaissance.setValue(1954);
        
        // Je lie l'annee de naissance bidirectionnellement avec 
        // le TextField tfAnneeJumeau1,
        // Il faut utiliser un convertisseur Nombre<->String 
        Bindings.bindBidirectional (tfAnneeJumeau1.textProperty(),dateNaissance, new NumberStringConverter("####"));
 
        // Je lie le texte des lAgeJumeaux à l'année de naissance
        //   - avec un calcul de  (-(dateNaissance-2020))
        //   - un convert pour pouvoir le lier à une Propriété texte 
        lAgeJumeau1.textProperty().bind(Bindings.convert(Bindings.negate(dateNaissance.subtract(2020))));
        lAgeJumeau2.textProperty().bind(Bindings.convert(Bindings.negate(dateNaissance.subtract(2020))));
        
        
        ////////////////////////////
        // Construction de l'interface 
        // Vous savez faire maintenant plus joli que cela 
        BorderPane root = new BorderPane  ();
        
        VBox vbPere = new VBox();
        vbPere.setPadding(new Insets(5));        
        vbPere.getChildren().addAll(new Label(" nom père"), tfNomPere); 
        vbPere.setStyle("-fx-border-color: blue;");
        
        VBox vbCentre = new VBox (); 
        vbCentre.setAlignment(Pos.CENTER);
        Label lAnneeNais = new Label("Annee naissance"); 
        lAnneeNais.setPadding(new Insets(5));
        vbCentre.getChildren().addAll(new Label("Jumeaux"), new Label("nom"), 
        lAnneeNais, new Label("Age"));
        
        VBox vbJumeau1 = new VBox(); 
        vbJumeau1.setPadding(new Insets(5));
        vbJumeau1.setAlignment(Pos.CENTER);
        vbJumeau1.getChildren().addAll(new Label("Bernard"),lNomJumeau1,
                tfAnneeJumeau1, lAgeJumeau1);
        vbJumeau1.setStyle("-fx-border-color: red;");
        
        VBox vbJumeau2 = new VBox();     
        vbJumeau2.setPadding(new Insets(5));
        vbJumeau2.setAlignment(Pos.CENTER);
        vbJumeau2.getChildren().addAll(new Label("Jean-Pierre"),lNomJumeau2,
                tfAnneeJumeau2, lAgeJumeau2);
        vbJumeau2.setStyle("-fx-border-color: red;");
        
        
        root.setTop(vbPere); 
        root.setLeft(vbJumeau1); 
        root.setCenter(vbCentre);
        root.setRight(vbJumeau2) ; 
        
        Scene scene = new Scene(root );
        
        primaryStage.setTitle("jumeaux : changez le nom et l'année");
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
