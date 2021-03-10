package Ex5;

import Ex3.BorderWithQuitLA;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;

import java.util.Scanner;

public class MyButtonTest extends Scene {

    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private BorderWithQuitLA monRoot;

    /******************* CONSTRUCTORS *******************/
    public MyButtonTest(int x, int y) {
        super(new BorderWithQuitLA(), x, y);
        monRoot = (BorderWithQuitLA)getRoot();
        System.out.println("line :");
        Scanner sc = new Scanner(System.in);
        Integer line = sc.nextInt();
        System.out.println("column :");
        Integer column = sc.nextInt();
        MyButton btn = new MyButton(line, column);
        Label lab = new Label("?");

        btn.setOnAction(event -> lab.setText(String.valueOf(btn.getLine()+ btn.getColumn())));

        monRoot.setTop(btn);
        monRoot.setCenter(lab);

        BorderWithQuitLA.setAlignment(btn, Pos.CENTER);
        BorderWithQuitLA.setAlignment(lab, Pos.CENTER);
    }

    /********************* GETTERS **********************/
    public BorderWithQuitLA getMonRoot() {
        return this.monRoot;
    }

    /********************* SETTERS **********************/


    /********************* METHODS **********************/
}
