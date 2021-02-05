/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author yberth01
 */
public class Circuit {
    
    private final int length;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private int count = 0;
    private final Random rand = new Random();
    
    public Circuit(int length)
    {
        this.length = length;
    }
    
    public void addVehicle (Vehicle toAdd)
    {
        this.vehicles.add(toAdd);
    }
    
    public void init ()
    {
        for( Vehicle vehicle : vehicles)
        {
            vehicle.setPos(0);
        }
    }
    
    public void startRace ()
    {
        while(!this.isRaceOver())
        {
            this.raceLoop();
        }
    }
    
    public void raceLoop ()
    {
        
    }
    
    public void print ()
    {
        
    }
    
    public boolean isRaceOver()
    {
        return true;
    }
    
    public Vehicle randVehicle()
    {
        return this.vehicles.get(Math.abs(rand.nextInt() % this.vehicles.size()));
    }
}
