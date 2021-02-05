/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2Ex3;


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
            vehicle.setCurrentSpeed(0);
            vehicle.setCircuit(this);
        }
    }
    
    public void startRace ()
    {
        while(!this.isRaceOver())
        {
            this.raceLoop();
        }
            this.endRace();
    }
    
    public void raceLoop ()
    {
        this.count +=1;
        System.out.format("Tour n°%d\n", this.count);
        for (Vehicle v : vehicles)
        {
            v.accelerate();
            v.moveFw();
            randVehicle().specialMove();
        }
        this.print();
    }
    
    public void print ()
    {
        for (int i = 0; i < this.vehicles.size(); i++)
        {
            System.out.format("%d :%s%s\n",i,this.vehicles.get(i).getRoute(),this.vehicles.get(i).getType());
        }
    }
    
    public boolean isRaceOver()
    {
        boolean isOver = false;
        for (Vehicle v : vehicles)
        {
            if (v.getPos() >= this.length)
            {
                isOver = true;
                v.setWinner();
            }
        }
        return isOver;
    }

    public void endRace(){
        Vehicle winner = null;
        for (Vehicle v : vehicles)
        {
            if (v.getWinner())
                winner = v;
        }
        System.out.format("Race ended. Winner is %s",winner.toString());
    }
    
    public  Vehicle randVehicle()
    {
        return this.vehicles.get(Math.abs(rand.nextInt() % this.vehicles.size()));
    }
}
