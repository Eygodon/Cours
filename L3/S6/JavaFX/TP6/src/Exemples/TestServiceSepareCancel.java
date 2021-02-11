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

public class TestServiceSepareCancel extends Application {

    private MenuItem calculateItem;
    private Button calculateButton;
    private Label message ; 
    private Scene scene;

    // Le service qui va creer et lancer la tache de calcul 
    // Void car le call de la tache ne retourne rien 
    private Service<Void> calculateService = new Service<Void>(){
        @Override 
        // La méthode qui crée la tache
        protected Task<Void> createTask(){
            return new Task<Void>(){
                @Override 
                // la méthoce call de la tache qui calcule. 
                protected Void call() throws Exception {                       
                    final int maxIterations = 500000;
                    for (int iterations = 0; iterations < maxIterations; iterations ++) {
                        // Je teste si on a demandé un cancel sur le service
                        if (isCancelled()) {
                            // et je termine si oui. 
                            System.out.println(" on m'a annulé"); 
                            break;
                        }
                        System.out.println(iterations);
                    }
                    return null ; 
                }
            };  
        }         
    };

    @Override
    public void start(Stage primaryStage) {
        // Je construit le menu 
        final MenuItem exitItem = new MenuItem("Annuler");
        // Un item demande l'annulation (de la tache) du service. 
        exitItem.setOnAction((ActionEvent t) -> calculateService.cancel());
        final Menu fileMenu = new Menu("Fichier");
        fileMenu.getItems().add(exitItem);
        calculateItem = new MenuItem("Calculer");
        calculateItem.setOnAction((ActionEvent t) -> doCalculate());
        final Menu actionMenu = new Menu("Action");
        actionMenu.getItems().add(calculateItem);
        final MenuBar menuBar = new MenuBar();
        menuBar.getMenus().setAll(fileMenu, actionMenu);
        // le bouton et meessage
        calculateButton = new Button();
        calculateButton.setText("Lancer le calcul !");
        calculateButton.setOnAction((ActionEvent event) -> doCalculate());        
        StackPane center = new StackPane();
        center.getChildren().add(calculateButton);
        message = new Label ("->     ");
        // Je place le tout dans le root qui est un BorderPane        
        final BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(center);
        root.setBottom(message); 
        scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // La méthode appelee par le handler qui lance le calcul
    private void doCalculate() {
        // Je dis que je calcule et desactive bouton et menu
        final Cursor oldCursor = scene.getCursor();
        scene.setCursor(Cursor.WAIT);
        message.setText("Attendez, je calcule");
        calculateItem.setDisable(true);
        calculateButton.setDisable(true);
        
        // J'abonne un écouteur sur els changements d'état du service 
        calculateService.stateProperty().addListener( (ObservableValue, oldValue, newValue) -> {
            switch (newValue) {
                case FAILED:
                case CANCELLED:
                case SUCCEEDED:
                    // je dis que j'ai fini et reactive bouton et menu
                    scene.setCursor(oldCursor);
                    calculateItem.setDisable(false);
                    calculateButton.setDisable(false);
                    message.setText("-> J'ai fini "); 
                    // Je n'oublie pas de reinitialiser le service
                    calculateService.reset();    
                    break;                    
            }           
        });  
        
        // Je démarre le service (qui crée et lance la tache)
        calculateService.start(); 
    };

    public static void main(String[] args) {
        launch(args);
    }
}
