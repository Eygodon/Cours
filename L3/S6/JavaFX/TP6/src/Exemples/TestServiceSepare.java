

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

public class TestServiceSepare extends Application {

    private MenuItem calculateItem;
    private Button calculateButton;
    private Label message ; 
    private Scene scene;

    // Je crée mon service qui va lancer une nouvelle tache à chaque fois
    // Void = le call de ma tache ne retourne rien. 
    private Service<Void> calculateService = new Service<Void>(){
        @Override 
        // la méthode createTask chargée de créer la tache
        protected Task<Void> createTask(){
            return new Task<Void>(){
                @Override 
                // la méthode call qui contient le gros calcul lancé par l'évènement. 
                protected Void call() throws Exception {                       
                    final int maxIterations = 500000;
                    for (int iterations = 0; iterations < maxIterations; iterations ++) {
                        System.out.println(iterations);
                    }
                    // call retourne Void => je retourne null
                    return null ; 
                }
            };  
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
        // Je construit le bouton, et le laBMessage
        calculateButton = new Button();
        calculateButton.setText("Lancer le calcul !");
        calculateButton.setOnAction((ActionEvent event) -> doCalculate());        
        StackPane center = new StackPane();
        center.getChildren().add(calculateButton);        
        message = new Label ("->     ");
        // Je place dans le root qui est un BorderPane        
        final BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(center);
        root.setBottom(message); 
        scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // La procédure appelée par le EventHandler 
    private void doCalculate() {
        // Je demande à l'IHM de dire que je calcule et je désactive bouton et menu 
        final Cursor oldCursor = scene.getCursor();
        scene.setCursor(Cursor.WAIT);
        message.setText("Attendez, je calcule");
        calculateItem.setDisable(true);
        calculateButton.setDisable(true);
         
        // Je place un écouteur sur le changement d'état de mon Service 
        calculateService.stateProperty().addListener( (ObservableValue, oldValue, newValue) -> {
            switch (newValue) {
                case FAILED:
                case CANCELLED:
                case SUCCEEDED:
                    // je reactive bouton et menu 
                    // et je dis que j'ai fini.
                    scene.setCursor(oldCursor);
                    calculateItem.setDisable(false);
                    calculateButton.setDisable(false);
                    message.setText("-> J'ai fini "); 
                    // Je réinitialise le service. 
                    calculateService.reset();    
                    break;                    
            }
               
        });  
        
        //Je demande au service de lancer la tache. 
        calculateService.start(); 
    };

    public static void main(String[] args) {
        launch(args);
    }
}
