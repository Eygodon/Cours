package Ex5;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import javax.swing.*;
import java.awt.*;

public class MenuBarTest extends Application {

    @Override
    public void start(Stage primaryStage){
        MenuBar menuBar = new MenuBar();
        Menu fichier = new Menu();
        Menu afficher = new Menu();
        MenuItem nouveau = new MenuItem();
        MenuItem ouvrir = new MenuItem();
        MenuItem pleinEcran = new MenuItem();
        Menu couleur = new Menu();
        MenuItem bleu = new MenuItem();
        MenuItem rouge = new MenuItem();

        menuBar.getMenus().addAll(fichier, afficher);
        fichier.getItems().addAll(nouveau, ouvrir);
        afficher.getItems().addAll(pleinEcran, couleur);
        couleur.getItems().addAll(bleu, rouge);

        menuBar.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(2))));
        fichier.setText("Fichier");
        afficher.setText("Afficher");
        afficher.setText("Afficher");
        nouveau.setText("Nouveau");
        ouvrir.setText("Ouvrir");
        pleinEcran.setText("Plein Ecran");
        couleur.setText("Couleurs");
        bleu.setText("Bleu");
        rouge.setText("Rouge");


        //BorderPane root = new BorderPane();
        VBox root = new VBox();
        root.getChildren().addAll(menuBar);
        //root.setRight(menuBar);
        root.setAlignment(Pos.BOTTOM_LEFT);

        Scene scene = new Scene(root, 500, 300);

        primaryStage.setTitle("TP1, Ex5");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
