import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Container1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Container extends Actor
{
    private boolean opgepakt = false;
    private boolean selected;
    private Kraan kraan;

    public void act() {
      checkOnclick();
      checkOpgepakt();
    }

    private void checkOnclick() {
        Haven haven = (Haven)this.getWorld();
        if (Greenfoot.mouseClicked(this)) {
            if (!getOpgepakt()) {
            haven.kraan.moveTo(this);
             setOpgepakt(true);
            }
        }
    }

    private void checkOpgepakt() {
        try {
            if (getOpgepakt()) {
                Haven haven = (Haven)this.getWorld();
                int x = haven.kraan.getX();
                int y = haven.kraan.target.getY();

                if (getY() < y) {
                    setLocation(x,getY()+1);
                }

                if (getY() > y) {
                    setLocation(x,getY()-1);
                }
            }
        } catch(Exception e) {
            setOpgepakt(false);
        }
    }

    public void setOpgepakt(boolean value) {
        opgepakt = value;
    }

    public boolean getOpgepakt() {
        return opgepakt;
    }

    public boolean isSelected() {
        return selected;
    }
}
