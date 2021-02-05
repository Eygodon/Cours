/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2Ex3;

import java.util.Arrays;


public abstract class Vehicle {
    private int pos;
    private int currentSpeed;
    private boolean isWorking;
    private boolean isWinner;
    private Circuit circuit;

   public Vehicle ()
   {
       this.isWorking = true;
       this.isWinner = false;
   }
   

   
   public String getRoute()
   {
       char[] arr = new char[this.pos];
       Arrays.fill(arr, '-');
       return String.valueOf(arr);
   }
   
   public abstract String getType ();
   
   public int getPos ()
   {
       return this.pos;
   }
   
   public boolean getState ()
   {
       return this.isWorking;
   }
   
   public abstract int getMaxSpeed(); 

   public int getCurrentSpeed() {return  this.currentSpeed;}

   public boolean getWinner()
    {
        return this.isWinner;
    }

    public Circuit getCircuit()
    {
        return this.circuit;
    }

   public void setPos (int newPos)
   {
        this.pos = newPos;
   }

   public void setWinner()
   {
       this.isWinner = true;
   }

   public void setCurrentSpeed(int i)
   {
       this.currentSpeed = i;
   }

   public void setCircuit(Circuit circuit)
   {
       this.circuit = circuit;
   }

    public void accelerate()
    {
        if(this.currentSpeed < this.getMaxSpeed())
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

   @Override
    public String toString()
   {
       return this.getClass().getSimpleName();
   }
}
