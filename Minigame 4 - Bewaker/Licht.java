import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Licht here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Licht extends Actor
{
    /**
     * Act - do whatever the Licht wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int x,y;
    public Licht(int x,int y)
    {
        this.x = x;
        this.y = y;
    }   
    public void act() 
    {
        Bewaker bewaker = Containeropslag.bewaker;
        Fog fog = Containeropslag.fog;
        int tempx = bewaker.getX();
        int tempy = bewaker.getY();
        double distance = Math.hypot((int)(Containeropslag.bloksizeX*x),(int)(Containeropslag.bloksizeY*y));
        tempx += Math.cos(Math.toRadians(bewaker.getRotation())) * (int)distance;
        tempy -= Math.sin(Math.toRadians(bewaker.getRotation())) * (int)distance;
        try
        {
            fog.getImage().setColorAt(tempx,tempy,new Color(0,0,0,1));
        }catch(Exception e){}
    }
}
