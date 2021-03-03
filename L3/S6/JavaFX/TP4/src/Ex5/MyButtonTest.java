package Ex5;

import Ex3.BorderWithQuitLA;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.paint.Paint;

public class MyButtonTest extends Scene {

    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    BorderWithQuitLA monRoot;

    /******************* CONSTRUCTORS *******************/
    public MyButtonTest(int x, int y) {
        super(new BorderWithQuitLA(), x, y);
        monRoot = (BorderWithQuitLA) this.getRoot();
    }

    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
}
