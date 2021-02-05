package TP1Ex2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class World {
    /********************* CONSTANTS ********************/


    /********************* VARIABLES ********************/

    private Map<Robot, Location> robots = new HashMap<>();
    private Location[] freeLocation;
    private static Location[] allLocation;
    private static Random rand = new Random();

    /******************* CONSTRUCTORS *******************/

    public World ()
    {
        this.freeLocation = Location.allLocation();
        this.allLocation = Location.allLocation();
    }

    /********************* GETTERS **********************/


    /********************* SETTERS **********************/


    /********************* METHODS **********************/

    public static  Location pickRandomLocation()
    {
        int index = rand.nextInt(allLocation.length -1);
        return allLocation[index];
    }

    public Robot pickRandomRobot(){
        Object[] robotsArray = robots.keySet().toArray();
        return (Robot)robotsArray[rand.nextInt(robotsArray.length)];
    }

    public Location locate(Robot r)
    {
        return robots.get(r);
    }

    public boolean hasRobotAtLoc (Location l)
    {
        return robots.containsValue(l);
    }

    public void killRobot (Robot r)
    {
        Location l = this.locate(r);
        robots.remove(r);
        Location[] temp = freeLocation.clone();
        temp[freeLocation.length] = l;
        freeLocation = temp;
    }

    public Robot robotFromPos (Location l)
    {
        for (Map.Entry<Robot, Location> entry : robots.entrySet()){
            if (l.equals(entry.getValue())){
                return entry.getKey();
            }
        }
        return null;
    }

    public void addRobot (String name)
    {
        Location l = pickRandomLocation();
        if (this.hasRobotAtLoc(l))
        {
            this.killRobot(this.robotFromPos(l));
        }
        this.robots.put(new Robot(name), l);
    }

    public void moveRobot()
    {
        Robot r = pickRandomRobot();
        Location l = pickRandomLocation();
        Location currentLoc = locate(r);
        if (this.hasRobotAtLoc(l))
        {
            this.killRobot(this.robotFromPos(l));
        }
        this.robots.remove(r, currentLoc);
        this.robots.put(r, l);
    }

    public void display()
    {
        for (Map.Entry<Robot, Location> entry : robots.entrySet())
        {
            Robot r = entry.getKey();
            Location l = entry.getValue();
            System.out.print(r.toString());
            System.out.println("  -  " + l.toString());
        }
    }
}
