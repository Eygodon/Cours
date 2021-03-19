package Ex8;

import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class TabGamers  extends TabPane {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/

    private final List<Tab> onglets;
    /******************* CONSTRUCTORS *******************/

    public TabGamers(Integer nbJoueurs){
        super();
        onglets = new ArrayList<>();
        
        for (int i = 0 ; i < nbJoueurs ; i++)
        {
            VBox vbox = new VBox();
            Direction dir = new Direction();
            GamerPane player = new GamerPane();
            vbox.getChildren().addAll(player, dir);

            Tab tab = new Tab("Joueur"+ String.valueOf(i));
            tab.setContent(vbox);
            onglets.add(tab);
        }

        onglets.forEach(tab -> this.getTabs().add(tab));
    }

    /********************* GETTERS **********************/



    /********************* SETTERS **********************/
    public void setOngletLabel(int PlayerId, String text)
    {
        this.onglets.get(PlayerId).setText(text);
        this.getTabs().get(PlayerId).setText(text);
    }

    /********************* METHODS **********************/
    public void deletePlayer (int playerID)
    {
        this.onglets.remove(playerID);
        this.getTabs().remove(playerID);
    }

    public void addPlayer (String text)
    {
        VBox vbox = new VBox();
        Direction dir = new Direction();
        GamerPane player = new GamerPane();
        vbox.getChildren().addAll(player, dir);

        Tab newPlayer = new Tab(text);
        newPlayer.setContent(vbox);
        this.onglets.add(newPlayer);
        this.getTabs().add(newPlayer);
    }

}
