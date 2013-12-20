import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Fog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fog extends Actor
{
    /**
     * Act - do whatever the Fog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage image;
    private final int ROTATIONWIDTH = 20;
    public Fog()
    {
        image = new GreenfootImage(Containeropslag.scherm[0],Containeropslag.scherm[1]);
        setImage(image);
    }
    public void act()
    {
        image.fill();
        int breedte = 1;
        Bewaker bewaker = Containeropslag.bewaker;
        //double distance = Math.hypot((int)(Containeropslag.bloksizeX*x),(int)(Containeropslag.bloksizeY*y));
        for(int s=-ROTATIONWIDTH;s<=ROTATIONWIDTH;s++)
        {
            for(int n =0;n<100;n++)
            {
                int tempx = bewaker.getX();
                int tempy = bewaker.getY();
                double distance = n;
                
                tempx += Math.cos(Math.toRadians((bewaker.getRotation()+s)%360)) * (int)distance;
                tempy -= Math.sin(Math.toRadians((bewaker.getRotation()+s)%360)) * (int)distance;
                try
                {
                    image.setColorAt(tempx,tempy,new Color(0,0,0,1));
                }catch(Exception e){}
            }
        }
        
    }
}
