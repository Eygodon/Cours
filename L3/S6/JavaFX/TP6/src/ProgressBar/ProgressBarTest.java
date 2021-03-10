package ProgressBar;

import Ex2.ButtonAleaTask;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.Property;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ProgressBar;

public class ProgressBarTest extends Application {
    @Override
    public void start(Stage primaryStage) {
        ButtonAleaTask b0 = new ButtonAleaTask();
        b0.setOnAction((ActionEvent event) -> b0.go());
        Button bCancel = new Button("Cancel");
        bCancel.setOnAction((ActionEvent event) -> b0.cancel());
        bCancel.disableProperty().bind(Bindings.not(b0.disableProperty()));

        HBox hBox = new HBox();
        hBox.getChildren().addAll(b0, bCancel);

        HBox pbBox  = new HBox();
        pbBox.visibleProperty().bind(b0.disableProperty());
        ProgressBar pb = new ProgressBar();
        pb.progressProperty().bind(b0.getService().progressProperty());
        Label pbPercent = new Label();
        pbPercent.textProperty().bind(Bindings.concat(b0.getService().getProgress(), " %"));
        pbBox.getChildren().addAll(pb, pbPercent);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(hBox, pbBox);
        Scene scene = new Scene(vBox, 300, 400);

        primaryStage.setTitle("AleaCoin Ex1");
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
