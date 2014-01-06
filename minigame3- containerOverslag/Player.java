import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Kraan kraan;
    Haak haak;
    private MouseInfo info;
    private Actor clicked;
    private Container currContainer;
    private final int COUNTDOWN = 1;
    private int timer = COUNTDOWN;
      Haven haven = (Haven)getWorld();
    public Player(Kraan kraan,Haak haak)
    {
        this.kraan = kraan;
        this.haak = haak;
    }
    public void act() 
    {
        info = Greenfoot.getMouseInfo();
        onClick();
        timer--;
       
    }    
    public void onClick()
    {
        if(info != null && timer <0)
        {
            if(info.getButton() == 1)
            {
                List objects = getWorld().getObjects(null);
                List intersects = new ArrayList();
                for(int i = 0;i<objects.size();i++)
                {
                    Actor object = (Actor)objects.get(i);
                    if((info.getX() > object.getX()-(Haven.afstandy/2) && info.getX() < object.getX()+(Haven.afstandy/2)) && (info.getY() > object.getY()-(Haven.afstandy/2) && info.getY() < object.getY()+(Haven.afstandy/2)) && object.getX() < 400)
                    {
                        if(object.getClass() == Vrachtwagen.class || object.getClass() == Container.class || object.getClass() == Plaats.class)
                        {
                            intersects.add(object);
                        }
                    }
                }
                try{
                    clicked = (Actor)intersects.get(intersects.size()-1);
                }catch(Exception e){}
            }
            timer = COUNTDOWN;
        }
        if(clicked != null)
        {
            if(kraan.getAtTarget() && haak.getAtTarget())
            {
                if(clicked.getClass() == Plaats.class)
                {
                    if(currContainer != null)
                    {   
                        Haven haven = (Haven)getWorld();
                        currContainer.setOpgepakt(false,null);
                        currContainer = null;
                        haven.makeBalance();
                    }
                }
                else if(clicked.getClass() == Container.class)
                {
                    if(currContainer == null)
                    {   
                        Haven haven = (Haven)getWorld();
                        currContainer = (Container)clicked;
                        Container con = new Container(currContainer.getWeight(),currContainer.getWeight());
                        getWorld().addObject(con,currContainer.getX(),currContainer.getY());
                        getWorld().removeObject(currContainer);
                        currContainer = con;
                        currContainer.setOpgepakt(true,haak);
                          
                        haven.haak.setSpeed(currContainer.getWeight() / 2);
                    }
                    else
                    {
                        Haven haven = (Haven)getWorld();
                        currContainer.setOpgepakt(false,null);
                        currContainer = null;
                        
                    }
                }
                
                kraan.setAtTarget(false);
                haak.setAtTarget(false);
                clicked = null;
            }
            else
            {
                kraan.goToTarget(clicked);
                haak.goToTarget(clicked);
            }
            
            
        }
    }
    
    public void setCurrNull() {
         currContainer = null;
    }
}