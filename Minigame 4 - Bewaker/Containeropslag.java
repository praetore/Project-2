import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Containeropslag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Containeropslag extends World
{

    /**
     * Constructor for objects of class Containeropslag.
     * 
     */
    public static boolean[] key = new boolean[70000];
    public static final int MOVEDELAY = 10;
    public static final int[] scherm = {800,600};
    public static final double bloksizeX = scherm[0]/20; //getWidth()/10;
    public static final double bloksizeY = scherm[1]/20; //getHeight()/10;
    public static final double aantalX = scherm[0]/ bloksizeX;
    public static final double aantalY = scherm[1]/ bloksizeY;
    public static Bewaker bewaker = new Bewaker();
    public static Fog fog = new Fog();
    public Containeropslag()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(scherm[0], scherm[1], 1); 
        maak(400,200);
        maak(200,200);
        maakObjecten();

    }

    public void maakObjecten()
    {
        addObject(fog,scherm[0]/2,scherm[1]/2);
        addObject(bewaker,100,100);
    }

    public void maak(int x,int y)
    {
        addObject(new Container(),x,y);
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
}
