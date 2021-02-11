package Exemples;



import javafx.application.Application;
import javafx.application.Platform; 
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

public class TestTaskSepare extends Application {

    private MenuItem calculateItem;
    private Button calculateButton;
    private Label message ; 
    private Scene scene;

    // Je déclare la tache, Void = pas de valeur de retour.  
    private Task<Void> calculateTask = new Task<Void>(){
                // La méthode call contient le calcul lancé dans un thread séparé par la tache
                protected Void call() throws Exception {                       
                    final int maxIterations = 500000;
                    for (int iterations = 0; iterations < maxIterations; iterations ++) {
                        System.out.println(iterations);
                    }
                    // type de retour Void => je retourne null.
                    return null ; 
                }
            };  

   
       
    @Override
    public void start(Stage primaryStage) {
        // Construction du menu
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
        // Construction du bouton, et du labelMessage
        calculateButton = new Button();
        calculateButton.setText("Lancer le calcul !");
        calculateButton.setOnAction((ActionEvent event) -> doCalculate());        
        StackPane center = new StackPane();
        center.getChildren().add(calculateButton);       
        message = new Label ("->     ");        
        // Placement dans le root qui est un BorderPane
        final BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(center);
        root.setBottom(message); 
        scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // la routine appelée par le EventHandler du bouton
    private void doCalculate() {
        final Cursor oldCursor = scene.getCursor();
        // Je demande à l'IHM d'avertir que je calcule et je desactive bouton et menu
        scene.setCursor(Cursor.WAIT);
        message.setText("Attendez, je calcule");
        calculateItem.setDisable(true);
        calculateButton.setDisable(true);
        // Je positionne un écouteur sur la fin de la tache 
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
        // Je cree un thread pour lancer la tache. 
        Thread th = new Thread(calculateTask);
        th.start();
        
    };

    public static void main(String[] args) {
        launch(args);
    }
}
