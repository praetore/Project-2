import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kraan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Kraan extends Actor
{
   public Container c1;
    public Actor target;

     public void moveTo(Actor actor) {
        target = actor;

    }
    
     public void act() {
        moveToTarget();
         Haven haven = (Haven)this.getWorld();
        if (haven.vrachtwagen.container != null) {

        target = null;
            try {
            c1.setOpgepakt(false);
            } catch (Exception e) {

            }
        }

    }



    public void moveToTarget() {

        if(target != null) {

            if(target.getX() < this.getX()) {
                move(-1);
            } else if(target.getX() > this.getX()) {
                move(1);
                
            
        }

        }

        
       
    }
}


