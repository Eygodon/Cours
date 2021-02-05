package Ex7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;

public class Q1 extends Application {

    @Override
    public void start (Stage primaryStage){

        Label north = new Label("NORTH");
        north.setAlignment(Pos.CENTER);
        north.setFont(new Font("Sergoe UI",15));
        north.setMaxWidth(Double.MAX_VALUE);
        north.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, BorderStrokeStyle.NONE, BorderStrokeStyle.NONE,BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE ,
                new CornerRadii(0),new BorderWidths(1), Insets.EMPTY)));

        Label south = new Label("SOUTH");
        south.setAlignment(Pos.CENTER);
        south.setFont(new Font("Sergoe UI", 15));
        south.setMaxWidth(Double.MAX_VALUE);
        south.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, BorderStrokeStyle.SOLID, BorderStrokeStyle.NONE,BorderStrokeStyle.NONE, BorderStrokeStyle.NONE ,
                new CornerRadii(0),new BorderWidths(1), Insets.EMPTY)));


        Label w = new Label("W");
        Label e = new Label("E");
        Label s = new Label("S");
        Label t = new Label("T");
        w.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        e.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        s.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        t.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));


        VBox westBox = new VBox();
        westBox.getChildren().addAll(w, e, s, t);
        westBox.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID,BorderStrokeStyle.NONE, BorderStrokeStyle.NONE ,
                new CornerRadii(0),new BorderWidths(1), Insets.EMPTY)));
        westBox.setMaxWidth(Double.MAX_VALUE);
        westBox.setAlignment(Pos.CENTER);

        Label ee = new Label("E");
        Label ae = new Label("A");
        Label se = new Label("S");
        Label te = new Label("T");

        ee.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        ae.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        se.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));
        te.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(1))));


        VBox eastBox = new VBox();
        eastBox.getChildren().addAll(ee, ae, se, te);
        eastBox.setBorder(new Border(new BorderStroke(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK, BorderStrokeStyle.NONE, BorderStrokeStyle.NONE,BorderStrokeStyle.NONE, BorderStrokeStyle.SOLID ,
                new CornerRadii(0),new BorderWidths(1), Insets.EMPTY)));
        eastBox.setMaxWidth(Double.MAX_VALUE);
        eastBox.setAlignment(Pos.CENTER);

        Label center = new Label("CENTER");
        center.setAlignment(Pos.CENTER);
        center.setFont(new Font("Sergoe UI", 15));
        center.setMaxWidth(Double.MAX_VALUE);

        BorderPane root = new BorderPane();
        root.setTop(north);
        root.setBottom(south);
        root.setLeft(westBox);
        root.setRight(eastBox);
        root.setCenter(center);
        Scene scene = new Scene(root, 400, 150);

        primaryStage.setTitle("Tp1 Ex7");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
