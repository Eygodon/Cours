package Exemples;



import javafx.application.Application;
import javafx.application.Platform; 
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
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

public class TestTaskSepareMessage extends Application {

    private MenuItem calculateItem;
    private Button calculateButton;
    private Label message ; 
    private Label messageAvancement ; 
    private Scene scene;

    
    // Je déclare la tache dont la méthode call ne retourne rien 
    private Task<Void> calculateTask = new Task<Void>(){
        // la méthode call qui contient le calcul. 
        protected Void call() throws Exception {                       
            final int maxIterations = 500000;
            for (int iterations = 0; iterations < maxIterations; iterations ++) {
                System.out.println(iterations);
                if (iterations %10000 == 0)
                    // de temps en temps je mets à jour le messageProperty
                    updateMessage(" "+ (iterations));
            }
            return null ; 
        }
    };  


       
    @Override
    public void start(Stage primaryStage) {
        // Je construit le menu
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
        // Je construit le bouton
        calculateButton = new Button();
        calculateButton.setText("Lancer le calcul !");
        calculateButton.setOnAction((ActionEvent event) -> doCalculate());        
        StackPane center = new StackPane();
        center.getChildren().add(calculateButton);
        
        // Je construit les Labels message
        message = new Label ("->     ");
        messageAvancement = new Label (); 
        // Je "binde" le message d'avancement sur la propriété de la tache
        messageAvancement.textProperty().bind(Bindings.concat("avancement :",calculateTask.messageProperty())); 
        
        // Je place le tout dans le root 
        final BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(center);
        root.setBottom(message); 
        root.setLeft(messageAvancement);
        scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // La méthode appelée par le EventHandler 
    private void doCalculate() {
        // Je dis que je calcule et desactive menu et bouton 
        final Cursor oldCursor = scene.getCursor();
        scene.setCursor(Cursor.WAIT);
        message.setText("Attendez, je calcule");
        calculateItem.setDisable(true);
        calculateButton.setDisable(true);
         
        // J'ajoute un écouteur pour traiter la fin de la tache 
        calculateTask.stateProperty().addListener( (ObservableValue, oldValue, newValue) -> {
            switch (newValue) {
                case FAILED:
                case CANCELLED:
                case SUCCEEDED:
                    scene.setCursor(oldCursor);
                    calculateItem.setDisable(false);
                    calculateButton.setDisable(false);
                    message.setText("-> J'ai fini "); 
                    break;                    
            }
        });  

        // Je lance la tache dans un thread
        Thread th = new Thread(calculateTask);
        th.start();
        
    };

    public static void main(String[] args) {
        launch(args);
    }
}
