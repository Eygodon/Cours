package Vue;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class TabGamers extends TabPane {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private final List<Tab> onglets;

    /******************* CONSTRUCTORS *******************/
    public TabGamers()
    {
        super();
        onglets = new ArrayList<Tab>();

        for (int i = 0; i < 3; i++)
        {
            VBox vBox = new VBox();
            ToggleBox player = new ToggleBox();
            vBox.getChildren().add(player);
            Tab tab = new Tab();
            if (i == 0)
                tab.setText("Bambi");
            else
                tab.setText("Chasseur" + i);
            tab.setContent(vBox);
            onglets.add(tab);
        }
        onglets.forEach(tab -> this.getTabs().add(tab));
    }

    /********************* GETTERS **********************/
    public List<Tab> getOnglets(){
        return this.onglets;
    }


    /********************* SETTERS **********************/


    /********************* METHODS **********************/

}
