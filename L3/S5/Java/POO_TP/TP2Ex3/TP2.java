/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TP2Ex3;

/**
 *
 * @author yberth01
 */
public class TP2 {


    public static void main(String[] args) {
        Skateboard s1 = new Skateboard();
        Skateboard s2 = new Skateboard();
        Car c1 = new Car();
        Car c2 = new Car();
        Tank t1 = new Tank();
        Circuit circuit = new Circuit(50);
        circuit.addVehicle(s1);
        circuit.addVehicle(s2);
        circuit.addVehicle(c1);
        circuit.addVehicle(c2);
        circuit.addVehicle(t1);
        circuit.init();
        circuit.startRace();


    }
    
}
