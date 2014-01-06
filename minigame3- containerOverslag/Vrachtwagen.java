import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vrachtwagen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Vrachtwagen extends Actor
{

    /**
     * Act - do whatever the Vrachtwagen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Container currContainer;
    private int aantalVrachtwagens = 1;
    public Kraan kraan;
    private int vrachtwagenSpeed = 1;
    int x,y;
    public Vrachtwagen(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    public Actor getIntersect(Class cl)
    {
        return getOneIntersectingObject(cl);
    }
    public void move(Container con)
    {
        currContainer = con;
    }
    public void act()
    {
        if(currContainer != null)
        {
            if(x<400)
            {
                setLocation(getX()-1,getY());
            }
            else
            {
                setLocation(getX()+1,getY());
            }
            currContainer.setLocation(getX(),getY());
        }
        if(getX() <=1 || getX() >= getWorld().getWidth()-1)
        {
            Haven haven = (Haven)getWorld();
            getWorld().removeObject(currContainer);
            currContainer = null;
            haven.score.increaseScore();
            setLocation(x,y);
        }
        Container con = (Container)getIntersect(Container.class);
        if(con!= null)
        {
            con.setOpgepakt(false,null);
            this.move(con);
        }
    }
}


