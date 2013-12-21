import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Computer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Computer extends Actor
{
    private final int TURNSPEED = 2;
    private final int SPEED = 1;
    private final int OBJECTDISTANCE = 10;
    private double x,y;
    private int rotation = 0;
    private boolean first = true;
    private int keuze = 0;
    private boolean timerover = true;
    private int timer = 0;
    private int time;
    Random rand = new Random();
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
        if(timerover)
        {
            time = rand.nextInt(20)+20;
            keuze = rand.nextInt(4);
            timerover = false;
        }
        
        if(keuze == 0)
        {
            x += Math.cos(Math.toRadians(rotation)) * SPEED;
            y -= Math.sin(Math.toRadians(rotation)) * SPEED;
        }
        /*else if(keuze == 1)
        {
            x -= Math.cos(Math.toRadians(rotation)) * SPEED;
            y += Math.sin(Math.toRadians(rotation)) * SPEED;
        }*/
        else if(keuze == 2)
        {
            turn(-TURNSPEED);
            rotation = (rotation+TURNSPEED)%360;
        }
        else if(keuze == 3)
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
        timer++;
        if(timer == time)
        {
            timerover = true;
            timer = 0;
        }
    }  
    public int getRotation()
    {
        return rotation;
    }    
}

