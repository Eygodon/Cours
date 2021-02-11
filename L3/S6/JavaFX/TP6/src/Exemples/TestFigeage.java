package Exemples;

import javafx.application.Application;
import javafx.application.Platform; 
import javafx.event.ActionEvent;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TestFigeage extends Application {

    private MenuItem calculateItem;
    private Button calculateButton;
    private Label message ; 
    private Scene scene;

    @Override
    public void start(Stage primaryStage) {
        // Construction du Menu 
        final MenuItem exitItem = new MenuItem("Quitter");
        exitItem.setOnAction((ActionEvent t) -> Platform.exit());
        final Menu fileMenu = new Menu("Fichier");
        fileMenu.getItems().add(exitItem);
        calculateItem = new MenuItem("Calculer");
        calculateItem.setOnAction((ActionEvent t) -> doCalculate());
        final Menu actionMenu = new Menu("Action");
        actionMenu.getItems().add(calculateItem);
        final MenuBar menuBar = new MenuBar();
        menuBar.getMenus().setAll(fileMenu, actionMenu);
        // Construction du Bouton 
        calculateButton = new Button();
        calculateButton.setText("Lancer le calcul !");
        calculateButton.setOnAction((ActionEvent event) -> doCalculate());
        StackPane center = new StackPane();
        center.getChildren().add(calculateButton);
        // Du label affichant le message 
        message = new Label ("->   "); 
        
        final BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(center);
        root.setBottom(message);
        scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // La méthode appelée dans le eventHandler 
    private void doCalculate() {
        final Cursor oldCursor = scene.getCursor();
        // Je demande à l'IHM d'afficher que je calcule et de désactiver MEnu et bouton 
        scene.setCursor(Cursor.WAIT);
        calculateItem.setDisable(true);
        calculateButton.setDisable(true);
        message.setText("-> Attendez, je calcule"); 
        // Je lance le calcul 
        final int maxIterations = 1000000;
        for (int iterations = 0; iterations < maxIterations; iterations ++) {
            System.out.println(iterations);
        }
        // Je demande à l'IHM d'afficher que je finis, et je réactive menu et bouton 
        scene.setCursor(oldCursor);
        calculateItem.setDisable(false);
        calculateButton.setDisable(false);
        message.setText("-> J'ai fini"); 
    }

    public static void main(String[] args) {
        launch(args);
    }
}
