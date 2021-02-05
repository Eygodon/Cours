package TP2Ex3;

public class Tank extends Vehicle {
    private  final static int MAX_SPEED = 2;
    private boolean canAttack = true;

    @Override
    public void specialMove() {
        Vehicle target = this.getCircuit().randVehicle();
        if (this.canAttack)
        {
            this.stop();
            if (target.getClass().getSimpleName().equals("Tank"))
            {
                target.stop();
            }
            else
            {
                target.shutDown();
            }
            this.canAttack = false;
        }


    }

    @Override
    public String getType() {
        if(this.getState())
        {
            return "[T]";
        }
        else
        {
            return "[*]";
        }
    }

    @Override
    public int getMaxSpeed() {
        return this.MAX_SPEED;
    }



}
