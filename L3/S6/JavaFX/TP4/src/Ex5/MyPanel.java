package Ex5;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class MyPanel extends GridPane {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private MyButton[][] myButtons ;

    /******************* CONSTRUCTORS *******************/
    public MyPanel(int nlines, int ncolumns){
        super();
        myButtons = new MyButton[nlines][ncolumns];
        for (int i = 0; i < ncolumns; i++){
            for (int j = 0 ; j < nlines ; j++){
                MyButton button = new MyButton(i, j);
                this.add(button, i, j);
                myButtons[j][i] = button;
            }
        }
    }

    /********************* GETTERS **********************/

    /********************* SETTERS **********************/


    /********************* METHODS **********************/
    MyButton getButton (int line , int column){
        return myButtons[line][column];
    }
}
