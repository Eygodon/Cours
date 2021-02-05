package TP1Ex2;

public class Main {
    public static void main(String[] args)
    {
        World mainWorld = new World();
        mainWorld.addRobot("Arouf");
        mainWorld.addRobot("Shrek");

        mainWorld.display();

        mainWorld.moveRobot();
        mainWorld.display();

        mainWorld.moveRobot();
        mainWorld.display();

        mainWorld.moveRobot();
        mainWorld.display();

        mainWorld.moveRobot();
        mainWorld.display();
    }
}
