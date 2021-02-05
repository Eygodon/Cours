package TP1Ex1;

public class Wheel
{
    /********************* CONSTANTS *********************/

    private static final String DEFAULT_BRAND = "Michelin";
    private static final int DEFAULT_SIZE = 20;
    private static final double DEFAULT_PRESSURE = 3;

    /********************* VARIABLES *********************/

    private double pressure;
    private final String brand;
    private final int size;

    /******************* CONSTRUCTORS *******************/

    public Wheel()
    {
        this.brand = DEFAULT_BRAND;
        this.pressure = DEFAULT_PRESSURE;
        this.size = DEFAULT_SIZE;

    }

    public Wheel(String brand, int size)
    {

        this.size = size;
        this.pressure = DEFAULT_PRESSURE;
        this.brand = brand;
    }

    /********************* GETTERS *********************/

    /********************* METHODS *********************/

    public void inflate ()
    {
        this.pressure += 0.1;
    }

    public void deflate ()
    {
        this.pressure -= 0.1;
    }

    public void print()
    {
        System.out.format("Wheel : [%s - %d\" - %.1f bar]\n",brand, size, pressure);
    }

    @Override

     public String toString(){
         return String.format("Wheel : [%s - %d\" - %.1f bar]\n",brand, size, pressure);

    }
}
