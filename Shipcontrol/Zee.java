import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zee extends World
{
    
    public static Path p1 = new Path();
    
    /**
     * Constructor for objects of class Zee.
     * 
     */
    public Zee()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        
        Boot boot = new Boot (this.getWidth(),this.getHeight()/2);
        addObject(boot,this.getWidth()/2,this.getHeight()/2);
        addObject(p1,this.getWidth()/2,this.getHeight()/2);
        
        /* Strand1 strand1 = new Strand1();
        addObject (strand1, 717, 132);
        Strand2 strand2 = new Strand2();
        addObject (strand2, 725, 476);
        
        Zandbank1 zandbank1 = new Zandbank1();
        addObject (zandbank1, 515, 145);
        Zandbank2 zandbank2 = new Zandbank2();
        addObject (zandbank2, 540, 470); */
    }
}
