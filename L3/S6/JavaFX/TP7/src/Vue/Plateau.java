package Vue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;


public class Plateau extends GridPane {
    /********************* CONSTANTS ********************/
    private final RowConstraints RC = new RowConstraints(20);
    private final ColumnConstraints CC = new ColumnConstraints((10));

    /********************* VARIABLES ********************/
    private Label [][] labels;

    /******************* CONSTRUCTORS *******************/
    public Plateau (int size)
    {
        super();
        this.setHgap(2);
        this.setVgap(2);
        this.labels = new Label[size][size];

        BackgroundFill bgFill = new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY);
        Background bg = new Background(bgFill);

        for (int i = 0 ; i < size ; i++)
        {
            this.getRowConstraints().add(RC);
            this.getColumnConstraints().add(CC);
            for (int j = 0; j < size; j++)
            {
                labels[i][j] = new Label("");
                labels[i][j].setBackground(bg);
                labels[i][j].setTextAlignment(TextAlignment.CENTER);
                labels[i][j].setAlignment(Pos.CENTER);
                GridPane.setMargin(labels[i][j], new Insets(1, 1, 1, 1));
                labels[i][j].setMaxWidth(Double.MAX_VALUE);
                labels[i][j].setMaxHeight(Double.MAX_VALUE);
                this.add(labels[i][j], i, j);
            }
        }
        this.setStyle("-fx-border-width: 2; -fx-border-color: red; -fx-border-radius: 2px");
    }


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
}
