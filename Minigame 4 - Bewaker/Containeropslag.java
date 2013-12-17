import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 * Write a description of class Containeropslag here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Containeropslag extends World implements KeyListener
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
    public Containeropslag()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(scherm[0], scherm[1], 1); 
        maakObjecten();
    }
    public void maakObjecten()
    {
        addObject(new Bewaker(),100,100);
    }
    public void keyPressed(KeyEvent e){
            int keyCode = e.getKeyCode();
            if(keyCode >0 )
            {
                System.out.println(KeyEvent.VK_W+" "+keyCode);
                key[keyCode] = true;
            }
    }
    public void keyReleased(KeyEvent e){
            int keyCode = e.getKeyCode();
            if(keyCode >0 && keyCode <key.length)
            {
                key[keyCode] = false;
            }
    }

    public void keyTyped(KeyEvent e) {
    }
    
}
