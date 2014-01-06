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
    private final int VIEWDISTANCE =150;
    
    private double distanceding = 0.6;
    
    boolean up = false;
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
        
        double tempx = bewaker.getX();
        double tempy = bewaker.getY();
        for(double s=-ROTATIONWIDTH;s<=ROTATIONWIDTH;s+=distanceding)
        {
            /*
            for(int n =0;n<VIEWDISTANCE;n++)
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
            }*/
            double cos = Math.cos(Math.toRadians((bewaker.getRotation()+s)%360));
            double sin = Math.sin(Math.toRadians((bewaker.getRotation()+s)%360));
          
            for(double n =0;n<VIEWDISTANCE;n+=0.1)
            {
                double distance = n;
                int x = (int)(tempx + cos * distance);
                int y = (int)(tempy - sin * distance);
                if(x >=0 && x < Containeropslag.scherm[0] && y >=0 && y < Containeropslag.scherm[1])
                {
                    int rand = Greenfoot.getRandomNumber(10);
                    if(rand <10)
                    {
                        image.setColorAt(x,y,new Color(0,0,0,(int)(255*distance/VIEWDISTANCE)));
                    }
                }
            }
        }
        
        
    }
}
