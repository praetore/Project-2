import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VolgendeContainer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VolgendeContainer extends Menu
{
    Haven haven = (Haven)this.getWorld();
    GreenfootImage image = new GreenfootImage(300,100);
    public int nummer;
    /**
     * Act - do whatever the VolgendeContainer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */



    public VolgendeContainer() {


        this.setImage(image);
    }

    public void setImage(int i) {
       image.clear();
       
       setImage(i + ".png");
       



    }

    public void act() 
    {

    }    
}
