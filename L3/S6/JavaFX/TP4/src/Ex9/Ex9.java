package Ex9;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Ex9 extends Application {

    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private SecondeFenetre autreS;
    private Label lSecondOuvert;
    private TextField tfPrincipal;
    private Button button;

    /******************* CONSTRUCTORS *******************/


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
    public static void main (String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.lSecondOuvert = new Label("");
        this.tfPrincipal = new TextField();
        this.button = new Button("Envoi");
        this.autreS = new SecondeFenetre();

        HBox root = new HBox();
        root.getChildren().addAll(lSecondOuvert, tfPrincipal, button);
        Scene mainScene = new Scene(root, 200, 200);

        this.button.setOnAction(event ->
                autreS.afficheMessage(tfPrincipal.getText())
        );
        this.autreS.setOnTextChanged(event ->
                tfPrincipal.setText(((TextField)event.getSource()).getText())
        );
        this.autreS.addEventHandler(WindowEvent.WINDOW_HIDING, event ->
                this.lSecondOuvert.setText("Fenetre 2 fermée")
        );
        this.autreS.addEventHandler(WindowEvent.WINDOW_SHOWING, event ->
                this.lSecondOuvert.setText("Fenetre 2 ouverte")
        );
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Main");
        primaryStage.show();


        autreS.show();

    }
}
