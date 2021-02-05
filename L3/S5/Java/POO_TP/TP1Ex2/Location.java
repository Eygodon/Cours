package TP1Ex2;

public class Location {
    /********************* CONSTANTS ********************/

    public static final int MAX_SIZE_X = 10;
    public static final int MAX_SIZE_Y = 10;

    /********************* VARIABLES ********************/

    public int xPos;
    public int yPos;
    /******************* CONSTRUCTORS *******************/

    public Location(int x, int y)
    {
        if(x >= 0 && x < MAX_SIZE_X && y >= 0 && y < MAX_SIZE_Y)
        {
            this.xPos = x;
            this.yPos = y;
        }
    }

    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/

    public static Location[] allLocation ()
    {
        int count = 0;
        Location[] result = new Location[MAX_SIZE_X * MAX_SIZE_Y];
        for (int i = 0; i < MAX_SIZE_X; ++i)
        {
            for (int j = 0; j < MAX_SIZE_Y; j++)
            {
                result[count] = new Location(i, j);
                count += 1;
            }
        }
        return result;
    }

    @Override

    public String toString()
    {
        return String.format("[ x : %d y : %d]", this.xPos, this.yPos);
    }

}
