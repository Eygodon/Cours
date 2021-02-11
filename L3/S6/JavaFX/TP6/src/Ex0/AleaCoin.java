package Ex0;

import java.util.Random;

public class AleaCoin {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/
    private int piles;
    private int faces;

    public AleaCoin() {
        piles = 0;
        faces = 0;
    }

    /******************* CONSTRUCTORS *******************/


    /********************* GETTERS **********************/
    public int getFaces() {
        return this.faces;
    }

    public int getPiles() {
        return this.piles;
    }

    /********************* SETTERS **********************/


    /********************* METHODS **********************/
    public int startLaunch(int nbOfLaunch)
    {
        this.piles = 0;
        this.faces = 0;
        Random rnd = new Random();

        for (int i = 0; i < nbOfLaunch; i++)
        {
            if (rnd.nextBoolean())
                this.piles++;
            else
                this.faces++;
        }
        return this.piles;
    }

}
