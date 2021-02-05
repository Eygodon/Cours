package TP1Ex2;

public class Robot {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/

    private String name;

    /******************* CONSTRUCTORS *******************/

    public Robot (String name)
    {
        this.name = name;
    }

    /******************** GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/
    @Override

    public String toString ()
    {
        return ("Robot :" + this.name + "\n");
    }
}
