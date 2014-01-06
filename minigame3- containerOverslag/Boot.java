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


       //System.out.println(balance);

    }




    public int getFirst(int i) {
        try {
            return gewichtArray.get(i);
        }     catch (Exception e) {
            System.out.println("fout");}
        return i;
    }


    public void checkIntersectingObject() {
         containers = getIntersectingObjects(Container.class);
        balance = 0;

        for(Object o : containers) {
            Container cont = (Container)o;
            // voor de volgorde van het pakken
            gewichtArray.add(cont.getWeight());

            // balans
            double extra = this.getY()-cont.getY();

            extra /= 20;
            balance += cont.getWeight()*extra;


        }
        System.out.println(balance);
        System.out.println(gewichtArray);
        
    }
}
