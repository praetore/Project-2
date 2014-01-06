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
    private Haak haak;



    public Container(int weight, int image) {
        this.weight = weight;
        this.image = image;

        setImage(image + ".png");
    }
    public Container() {
        int randomnr= Greenfoot.getRandomNumber(7)+1;
        this.weight = randomnr;
        this.image = randomnr;

        setImage(image + ".png");
    }
    public void act() {
        if(opgepakt)
        {
             Haven haven = (Haven)getWorld();
            setLocation(haak.getX(),haak.getY());
           // haven.haak.setSpeed(weight/2);
        }
    }

    public void setOpgepakt(boolean value, Haak haak) {
        opgepakt = value;
        this.haak = haak;
    }

    public boolean getOpgepakt() {
        return opgepakt;
    }

    public int getWeight() {
        return weight;
    }

}
