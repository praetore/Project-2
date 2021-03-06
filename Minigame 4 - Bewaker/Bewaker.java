import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
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
    private final int TURNSPEED = 2;
    private final int SPEED = 1;
    private final int OBJECTDISTANCE = 10;
    private double x,y;
    private int rotation = 0;
    private boolean first = true;
    public Bewaker()
    {
    }
    public void act() 
    {
        if(first)
        {
            //getWorld().addObject(new Licht(2,1),0,0);
            //getWorld().addObject(new Licht(3,1),0,0);
           
            x = this.getX();
            y = this.getY();
            first = false;
        }
        
        
        if(Greenfoot.isKeyDown("w"))
        {
            x += Math.cos(Math.toRadians(rotation)) * SPEED;
            y -= Math.sin(Math.toRadians(rotation)) * SPEED;
        }
        if(Greenfoot.isKeyDown("s"))
        {
            x -= Math.cos(Math.toRadians(rotation)) * SPEED;
            y += Math.sin(Math.toRadians(rotation)) * SPEED;
        }
        if(Greenfoot.isKeyDown("a"))
        {
            turn(-TURNSPEED);
            rotation = (rotation+TURNSPEED)%360;
        }
        if(Greenfoot.isKeyDown("d"))
        {
            turn(TURNSPEED);
            rotation = (rotation-TURNSPEED)%360;
        }
        Container con = (Container)getOneObjectAtOffset((int)(x-this.getX()-OBJECTDISTANCE),(int)(y-this.getY()+OBJECTDISTANCE),Container.class);
        Container con1 = (Container)getOneObjectAtOffset((int)(x-this.getX()+OBJECTDISTANCE),(int)(y-this.getY()-OBJECTDISTANCE),Container.class);
        Container con2 = (Container)getOneObjectAtOffset((int)(x-this.getX()),(int)(y-this.getY()),Container.class);
       
        if(con!= null || con1 != null || con2 != null)
        {
            x = x -(x-this.getX());
            y = y - (y-this.getY());
        }
        
        setLocation((int)x,(int)y);
    }  
    public int getRotation()
    {
        return rotation;
    }    
}
