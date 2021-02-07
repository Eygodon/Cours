package Ex8;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.control.Label;

public class Checkers extends GridPane {
    /********************* CONSTANTS ********************/
    private final int CELL_SIZE = 20;
    private final int GRID_SIZE = 11;

    /********************* VARIABLES ********************/
    private Label[][] labels;
    RowConstraints rc = new RowConstraints(CELL_SIZE);
    ColumnConstraints cc = new ColumnConstraints(CELL_SIZE);

    /******************* CONSTRUCTORS *******************/
    public Checkers() {
        super();
        this.setHgap(2);
        this.setVgap(2);
        this.labels = new Label[GRID_SIZE][GRID_SIZE];
        this.labels[0][0] = new Label(" ");
        BackgroundFill bgFill = new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY);
        Background bg = new Background(bgFill);
        for (int i = 0; i < GRID_SIZE; i++)
        {
            this.getRowConstraints().add(rc);
            this.getColumnConstraints().add(cc);
        }
        for (int i = 1; i < GRID_SIZE; i++)
        {
            for (int j = 1; j < GRID_SIZE; j++)
            {
                if (i == 1)
                {
                    labels[j][0] = new Label(String.valueOf((char) (j + 64)));
                    this.add(labels[j][0],j, 0);
                }
                if (j == 1)
                {
                    labels[0][i] = new Label(String.valueOf(i));
                    this.add(labels[0][i], 0, i);

                }
                labels[i][j] = new Label("");
                labels[i][j].setBackground(bg);
                labels[i][j].setTextAlignment(TextAlignment.CENTER);
                labels[i][j].setAlignment(Pos.CENTER);
                GridPane.setMargin(labels[i][j], new Insets(1,1,1,1));
                labels[i][j].setMaxWidth(Double.MAX_VALUE);
                labels[i][j].setMaxHeight(Double.MAX_VALUE);
                this.add(labels[i][j], i, j);
            }
        }

        this.setStyle("-fx-border-width: 2; -fx-border-color: red; -fx-border-radius: 2px");
    }

    /********************* GETTERS **********************/
    public Integer getPiece (int x, int y)
    {
        if (x <= 10 && y <= 10  && x > 0 && y > 0 && !(labels[x][y].getText().equals(" ")))
            return Integer.valueOf(labels[x][y].getText());
        else
            return null;
    }

    /********************* SETTERS **********************/
    public void setPiece (Integer p, int x, int y)
    {
        if (x < 10 && y < 10  && x >= 0 && y >= 0) {
            labels[x][y].setText(String.valueOf(p));
        }
        else
            System.out.println("Votre déplacement est hors du damier");
    }

    public void setColorPiece(Color c, int x, int y){
        if (getPiece(x, y) != null){
            labels[x][y].setBackground(new Background(new BackgroundFill(c, CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }


    /********************* METHODS **********************/
}
