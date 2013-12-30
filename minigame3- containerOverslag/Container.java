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
    private Kraan kraan;
    public int weight;
    private int image;



    public Container(int weight, int image) {
        this.weight = weight;
        this.image = image;

        setImage(image + ".png");
    }

    public void act() {

        checkOnclick();
        checkOpgepakt();




    }




    private void checkOnclick() {
        Haven haven = (Haven)this.getWorld();

        if (Greenfoot.mouseClicked(this)) {


            haven.kraan.moveTo(this);

            if (haven.haak.selected != null) {
                haven.haak.setHaveContainer(false);
                haven.haak.selected.setOpgepakt(false);
                haven.haak.selected = null;

            }


            if (haven.haak.selected == null) {
                World world = getWorld();
                int x = getX();
                int y = getY();
                world.removeObject(this);
                world.addObject(this, x, y);
                haven.haak.setHaveContainer(true);
                haven.haak.selected = this;
                haven.haak.selected.setOpgepakt(true);
            }





        }
    }




    public void checkOpgepakt() {
        try {
            if (getOpgepakt()) {
                Haven haven = (Haven)this.getWorld();
                int x = haven.kraan.target.getX();
                int y = haven.kraan.target.getY();

                if (getY() < y) {
                    setLocation(getX(),getY()+1);
                    Greenfoot.delay(haven.haak.getSpeed());
                }

                if (getY() > y) {

                    setLocation(getX(),getY()-1);
                    Greenfoot.delay(haven.haak.getSpeed());
                }

                if (getX() < x) {
                    setLocation(getX()+1,getY());
                    Greenfoot.delay(haven.haak.getSpeed());
                }

                if (getX() > x) {

                    setLocation(getX()-1,getY());
                    Greenfoot.delay(haven.haak.getSpeed());
                }
            }
        } catch(Exception e) {

        }
    }



    public void setOpgepakt(boolean value) {
        opgepakt = value;
    }

    public boolean getOpgepakt() {
        return opgepakt;
    }

    public int getWeight() {
        return weight;
    }

}
