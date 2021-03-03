package Ex5;

import javafx.scene.control.Button;

public class MyButton extends Button {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/

    private int line;
    private int column;

    /******************* CONSTRUCTORS *******************/

    public MyButton (int line, int column)
    {
        super(String.valueOf(line) + String.valueOf(column));
        this.line = line;
        this.column = column;
    }

    /********************* GETTERS **********************/

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    /********************* SETTERS **********************/

    public void setLine(int line) {
        this.line = line;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    /********************* METHODS **********************/
}
