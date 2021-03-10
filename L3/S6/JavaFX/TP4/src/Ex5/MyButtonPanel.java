package Ex5;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class MyButtonPanel extends MyPanel{
    /******************* CONSTRUCTORS
     * @param nlines
     * @param ncolumns*******************/
    public MyButtonPanel(int nlines, int ncolumns) {

        super(nlines, ncolumns);



        for (int i = 0; i < nlines; i++ )
        {
            for (int j = 0; j < ncolumns; j++)
            {
                MyButton btn = getButton(i, j);
                Alert myPopUp = new Alert(Alert.AlertType.INFORMATION);
                myPopUp.setTitle("Info Button");
                myPopUp.setContentText("Line : " + String.valueOf(btn.getLine()) + "Column : "
                    + String.valueOf(btn.getColumn()));
                btn.setOnAction(event ->
                        myPopUp.show()
                );
            }
        }

    }
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/


    /******************* CONSTRUCTORS *******************/


    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
}
