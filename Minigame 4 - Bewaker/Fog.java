import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fog extends Actor
{
    /**
     * Act - do whatever the Fog wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage image;
    public Fog()
    {
        image = new GreenfootImage(Containeropslag.scherm[0],Containeropslag.scherm[1]);
        image.fill();
        setImage(image);
    }
}
