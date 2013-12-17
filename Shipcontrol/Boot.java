import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boot extends Actor
{
    /**
     * Act - do whatever the Boot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if (Greenfoot.isKeyDown("right")) {
            turn(6);
        }
        if (Greenfoot.isKeyDown("left")) {
            turn(-6);
        }
        move(1);
        checkCollision();
    }    
    
    public void checkCollision() {
        if (isTouching(Zandbank1.class)) {
            setLocation (50, 300);
        }
        if (isTouching(Zandbank2.class)) {
            setLocation (50, 300);
        }
        if (isTouching(Strand1.class)) {
            setLocation (50, 300);
        }
        if (isTouching(Strand2.class)) {
            setLocation (50, 300);
        }        
    }
}
