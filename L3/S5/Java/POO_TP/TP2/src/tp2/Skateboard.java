/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

/**
 *
 * @author yberth01
 */
public class Skateboard extends Vehicle {

    private final static int MAX_SPEED = 4;
    
    @Override
    public void specialMove() {
        this.accelerate();
    }

    @Override
    public String getType() {
        if(this.getState())
        {
            return "[S]";
        }
        else
        {
            return "[*]";
        }
    }

    @Override
    public int getMaxSpeed() 
    {
        return this.MAX_SPEED;
    }
    
    
}
