/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.util.Arrays;

/**
 *
 * @author yberth01
 */
public abstract class Vehicle {
    private int pos;
    private int currentSpeed;
    private  int maxSpeed;
    private boolean isWorking;
    
   public Vehicle ()
   {
       this.isWorking = true;
   }
   
   public void accelerate()
   {
       if(this.currentSpeed < this.maxSpeed)
           this.currentSpeed += 1;
   }
   
   public void brake()
   {
       if (this.currentSpeed > 0)
           this.currentSpeed -= 1;
   }
    
   public void toStart ()
   {
       this.pos = 0;
       this.currentSpeed = 0;
   }
    
   public void stop ()
   {
       this.currentSpeed = 0;
   }
   
   public void shutDown ()
   {
       this.isWorking = false;
   }
   
   public void moveFw ()
   {
       if(this.isWorking)
       this.pos += this.currentSpeed;
   }
   
   public abstract void specialMove();
   
   public String getRoute()
   {
       char[] arr = new char[this.pos];
       Arrays.fill(arr, '-');
       return String.valueOf(arr);
   }
   
   public abstract String getType ();
   
   public int getPos ()
   {
       return this.currentSpeed;
   }
   
   public boolean getState ()
   {
       return this.isWorking;
   }
   
   public abstract int getMaxSpeed(); 
   
   public void setPos (int newPos)
   {
        this.pos = newPos;
   }
   
}
