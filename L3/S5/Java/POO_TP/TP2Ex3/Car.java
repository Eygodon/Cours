package TP2Ex3;

public class Car extends Vehicle {

    private final static int MAX_SPEED = 8;


    public void accelerate (){
        for (int i = 0; i < 2; i++)
        {
            super.accelerate();
        }
    }

    @Override
    public void specialMove() {
        this.brake();
    }

    @Override
    public String getType() {
        String result;
        if (this.getState()) {
            result = "[C]";
        } else {
            result = "[*]";
        }
        return result;
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SPEED;
    }
}
