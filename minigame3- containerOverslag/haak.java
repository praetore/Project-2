import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Haak extends Actor
{
    private int speed;
    public Container container;
    public Container selected;
    private boolean haveContainer = false;
    public boolean atTarget = false;


    public void act() 
    {
        volgKraan();
        setSpeed();
        checkForContainer();
    }

    private void checkForContainer() {
        try {
        if (selected != null) {
        if (getY() == selected.getY() && getX() == selected.getX()) {
            setHaveContainer(true);

        }

        if (getY() != selected.getY() || getX() != selected.getX()) {
            setHaveContainer(false);
        }
        }
        } catch (Exception e){}

    }


    private void setSpeed() {

        if (getHaveContainer()) {
            speed =  selected.getWeight() / 2;
        }

    }

    private void volgKraan() {
        Haven haven = (Haven)this.getWorld();
        int x = haven.kraan.getX();

        try {
            int y = haven.kraan.target.getY();

            if (y < getY()) {
                setLocation(x,getY()-1);

            }
            if (y > getY()) {
                setLocation(x, getY() + 1);
            }

        } catch(Exception e) {}
        setLocation(x,getY());
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
