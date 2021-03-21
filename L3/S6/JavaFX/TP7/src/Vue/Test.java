package Vue;

import Modele.JeuDesChasseurs;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application {

    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/


    /******************* CONSTRUCTORS *******************/


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/
    /********************* METHODS **********************/
    @Override
    public void start(Stage primaryStage) throws Exception {
        JeuDesChasseurs j = new JeuDesChasseurs(10);
        PanneauVue root = new PanneauVue(j);
        root.activateTab(1);
        root.activateTabChoicePersonnage(0, false);
        root.affichePlateau();
        root.resetCase(0,0);
        root.ajouteBambi(2,2);
        root.ajouteChasseur(2,2,1);


        Scene scene = new Scene(root);

        primaryStage.setTitle("Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
