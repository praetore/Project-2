import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Startmenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Startmenu extends World
{
    private boolean sound = true;
    
    public void setSound() {
        if (getSound()) {
            sound = false;
        } else {
            sound = true;
        }
    }
    
    public boolean getSound() {
        return sound;
    }
    
    /**
     * Constructor for objects of class Startmenu.
     * 
     */
    public Startmenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        Play play = new Play();
        addObject (play, 400,300);
        Help help = new Help();
         addObject (help, 400,400);
        Credits credits = new Credits();
         addObject (credits, 400,500);
         Titel titel = new Titel();
         addObject (titel, 440,120);
         Sound sound = new Sound();
         addObject (sound, 60, 540);
    }
}
