package TP1Ex1;



import java.awt.*;

public class Bike
{
    /********************* CONSTANTS *********************/

    private static final Color DEFAULT_COLOR = Color.BLACK;
    private static final String DEFAULT_BRAND = "Renault";
    private static final Integer DEFAULT_SIZE = 25;
    private static final Integer MAX_SPEED = 60;
    private static final Integer MIN_SPEED = 0;

    /********************* VARIABLES *********************/

    private final String brand;
    private Color color;
    private Integer speed;
    private final Integer size;
    private final Wheel[] wheels = new Wheel[2];

    /******************* CONSTRUCTORS *******************/

    public Bike ()
    {
        this.brand = DEFAULT_BRAND;
        this.color = DEFAULT_COLOR;
        this.size =DEFAULT_SIZE;
        this.speed = 0;
        this.wheels[0] = new Wheel();
        this.wheels[1] = new Wheel();
    }

    public Bike (String brand, Color color, Integer size)
    {
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.speed = 0;
        this.wheels[0] = new Wheel("Renault", size+1);
        this.wheels[1] = new Wheel("Renault", size-1);
    }

  public Bike (Bike b){
          brand = b.brand;
          color = b.color;
          size = b.size;
          speed = b.speed;
          wheels[0] = new Wheel();
          wheels[1] = new Wheel();
  }

    /********************* GETTERS *********************/

    public Wheel[] getWheels()
    {
        return wheels;
    }

    public Wheel getFrontWheel()
    {
        return wheels[0];
    }

    public Wheel getRearWheel()
    {
        return wheels[1];
    }

    /********************* METHODS *********************/
    public void accelerate ()
    {
        if (this.speed < MAX_SPEED)
        this.speed += 1;
    }

    public void brake ()
    {
        if (this.speed > MIN_SPEED)
        this.speed -= 1;
    }

    public void repaint()
    {
        this.color = DEFAULT_COLOR;
    }

    public void print ()
    {
        System.out.format("Bike : [%s - %d\" - %s - (%dkm/h)]\n", brand, size, color, speed);
        System.out.format(" - Front ");
        this.wheels[0].print();
        System.out.format(" - Rear ");
        this.wheels[1].print();
    }

    public void deleteWheel (int index)
    {
        this.wheels[index] = null;
    }

    public void replaceWheel (String wBrand, int wSize, int index)
    {
        if (wSize >= this.size - 2|| wSize <= this.size + 2)
        {
            this.deleteWheel(index);
            this.wheels[index] = new Wheel(wBrand, wSize);
        }
    }

    public void switchWheels ()
    {
        Wheel temp = this.wheels[0];
        this.wheels[0] = this.wheels[1];
        this.wheels[1] = temp;
    }

    public int numberOfWheels ()
    {
        int count = 0;
        for (Wheel wheel : this.wheels){
            if (wheel != null){
                count += 1;
            }
        }
        return count;
    }

}
