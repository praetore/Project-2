import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * Write a description of class Bewaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Bewaker extends Actor
{
    
    /**
     * Act - do whatever the Bewaker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x = 0;
    public void act() 
    {
        if(((Containeropslag)getWorld()).key[KeyEvent.VK_W])
        {
            x++;
            System.out.println(x);
        }
        
    }    
    
}
