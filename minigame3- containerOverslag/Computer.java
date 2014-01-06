import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Computer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Computer extends Actor
{
    private Kraan kraan;
    private Haak haak;
    private Vrachtwagen vrachtwagen;
    private MouseInfo info;
    private Actor clicked;
    Actor target;
    private Container currContainer;
    public Computer(Kraan kraan,Haak haak, Vrachtwagen vrachtwagen)
    {
        this.kraan = kraan;
        this.haak = haak;
        this.vrachtwagen = vrachtwagen;
    }
    
    long pauseTime = 0;   
    public boolean running()  
    {  
        long time = System.currentTimeMillis();  
        return time > pauseTime;  
    }  
    public void pause(long delay)  
    {  
        long time = System.currentTimeMillis();  
        pauseTime = time+delay;  
    } 
    
    public void act() 
    {
        info = Greenfoot.getMouseInfo();
        Greenfoot.delay(1);
        onClick();
    }    
    public void onClick()
    { 
        nextContainer();
        if (running()) {
        if(currContainer!= null)
        {
            if(!currContainer.getOpgepakt())
            {
                target = currContainer;
                if(!kraan.getAtTarget() || !haak.getAtTarget())
                {
                    kraan.goToTarget(target);
                    haak.goToTarget(target);
                    
                }
                else
                {
                    Container con = new Container(currContainer.getWeight(),currContainer.getWeight());
                    getWorld().addObject(con,currContainer.getX(),currContainer.getY());
                    getWorld().removeObject(currContainer);
                    currContainer = con;
                    currContainer.setOpgepakt(true,haak);
                    target = null;
                    kraan.setAtTarget(false);
                    haak.setAtTarget(false);
                    pause(2000);
                }
            }
            else
            {
                target = vrachtwagen;
                if(!kraan.getAtTarget() || !haak.getAtTarget())
                {
                    kraan.goToTarget(target);
                    haak.goToTarget(target);
                }
                else
                {
                    currContainer.setOpgepakt(false,null);
                    target = null;
                    currContainer = null;
                    kraan.setAtTarget(false);
                    haak.setAtTarget(false);
                    
                }
            }
        }
    }
        
    }
    public void nextContainer()
    {
        List objects = getWorld().getObjects(Container.class);
        List intersects = new ArrayList();
        for(int i = 0;i<objects.size();i++)
        {
            Container object = (Container) objects.get(i);
            if(object.getX() > 400)
            {
                intersects.add(object);
            }
        }
        if(intersects.size() >0)
        {
            currContainer = (Container)intersects.get(intersects.size()-1);
        }
    } 
}
