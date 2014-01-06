import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sound extends Menu
{
    private boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public boolean isPlaying = false;
    /**
     * Act - do whatever the Sound wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if (Greenfoot.mouseClicked(this)) {
           if (isPlaying) {
           Haven haven = (Haven)getWorld();
           haven.backgroundSound.stop();
           haven.vrachtwagen.containerSound.setVolume(0);
           setPlaying(false);
           this.setImage("mute.png");

           } else {
               Haven haven = (Haven)getWorld();
               haven.vrachtwagen.containerSound.setVolume(20);
               haven.backgroundSound.play();
               setPlaying(true);
               this.setImage("play.png");
           }
       }
    }    
}
