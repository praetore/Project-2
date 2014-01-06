import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pauze here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pauze extends Menu
{
    /**
     * Act - do whatever the Pauze wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public boolean isPlaying = false;

    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            if (isPlaying) {
                Haven haven = (Haven)getWorld();
               Greenfoot.stop();
                setPlaying(false);

            } else {
                Haven haven = (Haven)getWorld();


                Greenfoot.delay(0);
                setPlaying(true);
            }
        }
    }

    public Pauze() {
        getImage().scale(50,50);
    }
}
