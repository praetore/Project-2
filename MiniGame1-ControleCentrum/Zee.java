import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zee extends Actor
{
    /*
     * dit tekent de zee
     */
    public Zee()
    {
        getImage().scale((int) Haven.bloksizeX,(int) Haven.bloksizeY);
        getImage().drawRect(0,0,(int) Haven.bloksizeX,(int) Haven.bloksizeY);
    }
    public void act() 
    {
        // Add your action code here.
    }    
}
