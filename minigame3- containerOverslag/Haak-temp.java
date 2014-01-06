import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Haak extends Actor
{
    private int speed = 1;
    Kraan kraan;
    private boolean haveContainer = false;
    public boolean atTarget = false;
    public Container selected;
    public Haak(Kraan kraan)
    {
        this.kraan = kraan;
    }
    public void act()
    {
        setLocation(kraan.getX(),getY());
        
    }

/*
    private void setSpeed() {

        if (getHaveContainer()) {
            speed =  selected.getWeight() / 2;
        }

    }*/
    
    public void setSpeed(int i) {
        
        speed = i;

    }
    
    


    public void goToTarget(Actor target)
    {
        if(target != null)
        {
            try
            {
                Greenfoot.delay(speed);
                if(getY() < target.getY())
                {
                    setLocation(getX(),getY()+1 );
                }
                if(getY() > target.getY())
                {
                    setLocation(getX(),getY()-1);
                }
                if(getY() == target.getY())
                {
                    setAtTarget(true);
                }
                else
                {
                    setAtTarget(false);
                }
            }catch(Exception e){}
        }
    }
    public boolean getHaveContainer() {
        return haveContainer;
    }

    public void setHaveContainer(boolean haveContainer) {
        this.haveContainer = haveContainer;
    }

    public void setAtTarget(boolean atTarget) {
        this.atTarget = atTarget;
    }

    public boolean getAtTarget() {
        return atTarget;
    }

    public int getSpeed() {
        return speed;
    }
}
