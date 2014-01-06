import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Path here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Path extends Actor
{
    /**
     * Act - do whatever the Path wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    GreenfootImage image;
    public Path()
    {
        image = new GreenfootImage(800,600); // 560
        setImage(image);
    }
    public void drawPath(int x,int y,int x1,int y1)
    {
        image.drawLine(x1,y1,x,y);
    }
    public void clearPath()
    {
        image.clear();
    }
}
