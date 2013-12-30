import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Boot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boot extends Actor
{
   public  List containers;
   public  List<Integer> gewichtArray = new ArrayList<Integer>();
    public int rand;
    private double balance;
    /**
     * Act - do whatever the Boot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public double getBalance() {
        return balance;
    }

    public double getAngle() {
        return balance - 118;
    }

    public void act() 
    {


      //  System.out.println(rand);

    }




    public int getFirst() {
        return gewichtArray.get(0);
    }

    public void checkIntersectingObject() {
        containers = getIntersectingObjects(Container.class);

        for(Object o : containers) {
            Container c = (Container)o;
            // voor de volgorde van het pakken
            gewichtArray.add(c.getWeight());




        }
    }
}
