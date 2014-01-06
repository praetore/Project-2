import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kraan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Kraan extends Actor
{
    public boolean atTarget = false;
    public void goToTarget(Actor target)
    {
        if(target != null)
        {
            try{
                if(getX() < target.getX())
                {
                    setLocation(getX()+1,getY());
                }
                if(getX() > target.getX())
                {
                    setLocation(getX()-1,getY());
                }
                if(getX() == target.getX())
                {
                    setAtTarget(true);
                }
                else
                {
                    setAtTarget(false);
                }
            }catch(Exception e){}
        }
    }
    public void setAtTarget(boolean atTarget) {
        this.atTarget = atTarget;
    }

    public boolean getAtTarget() {
        return atTarget;
    }
}


