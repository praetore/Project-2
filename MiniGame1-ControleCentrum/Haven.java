import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Point;
/**
 * Write a description of class Haven here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Haven extends World
{

    /**
     * Constructor for objects of class Haven.
     * 
     */
    public static final int MOVEDELAY = 10;
    public static final int[] scherm = {800,600};
    public static final double bloksizeX = scherm[0]/20; //getWidth()/10;
    public static final double bloksizeY = scherm[1]/20; //getHeight()/10;
    public static final double aantalX = scherm[0]/ bloksizeX;
    public static final double aantalY = scherm[1]/ bloksizeY;
    
    public static final Point P1 = new Point(1,17);
    public static final Point P2 = new Point(1,19);
    public static final Point P3 = new Point(17,17);
    public static final Point P4 = new Point(17,19);
    public static Loods loods = new Loods();
   
    public Haven()
    {    
        super(scherm[0], scherm[1], 1); 
        for (int x=0;x< aantalX;x++)
            for(int y=0;y< aantalY;y++)
                addObject(new Zee(),(int)(x* bloksizeX + bloksizeX /2),(int)(y* bloksizeY + bloksizeY /2));
        for (int x=0;x<scherm[0]/bloksizeX;x++)
            if (x < 8 || x > 11) {
                for(int y=10;y<13;y++)
                    addObject(new Wal(),(int)(x* bloksizeX + bloksizeX /2),(int)(y* bloksizeY + bloksizeY /2));
            }

        for (int x = 0; x < 4; x++) {
            addObject(new WayPoint(),(int)((x+8)* bloksizeX + bloksizeX /2),(int)(9* bloksizeY + bloksizeY /2));
            addObject(new WayPoint(),(int)((x+8)* bloksizeX + bloksizeX /2),(int)(13* bloksizeY + bloksizeY /2));
        }
        addObject(new Parkeerplaats(),(int)(P1.getX()* bloksizeX + bloksizeX /2),(int)(P1.getY()* bloksizeY + bloksizeY /2));
        addObject(new Parkeerplaats(),(int)(P2.getX()* bloksizeX + bloksizeX /2),(int)(P2.getY()* bloksizeY + bloksizeY /2));
        addObject(new Parkeerplaats(),(int)(P3.getX()* bloksizeX + bloksizeX /2),(int)(P3.getY()* bloksizeY + bloksizeY /2));
        addObject(new Parkeerplaats(),(int)(P4.getX()* bloksizeX + bloksizeX /2),(int)(P4.getY()* bloksizeY + bloksizeY /2));
        
                
        addObject(loods,(int)(1* bloksizeX + bloksizeX /2),(int)(14* bloksizeY + bloksizeY /2));
        addObject(new Boot(),(int)(1* bloksizeX + bloksizeX /2),(int)(1* bloksizeY + bloksizeY /2));
        
        /*
        for(double x=0;x<aantalX;x++)
            for(double y=0; y<aantalY/8*3;y++)
                addObject(new Water(),(int)(x*bloksizeX+bloksizeX/2),(int)(y*bloksizeY+bloksizeY/2));

        addObject(new Boot.java(bloksizeX*4,bloksizeY*2),(int)(bloksizeX*2+bloksizeX*4/2),(int)(bloksizeY*1+bloksizeY*2/2)  );
        for(double x=0;x<aantalX;x++)
            for(double y=aantalY/8*3; y<aantalY/8*6;y++)
                addObject(new Dijk(),(int)(x*bloksizeX+bloksizeX/2),(int)(y*bloksizeY+bloksizeY/2));
        for(double x=0;x<aantalX;x++)
            for(double y=aantalY/8*7; y<aantalY/8*8;y++)
                addObject(new Gras(),(int)(x*bloksizeX+bloksizeX/2),(int)(y*bloksizeY+bloksizeY/2));
        for(double x=0;x<aantalX;x++)
            for(double y=aantalY/8*6; y<aantalY/8*7;y++)
                addObject(new Rails(),(int)(x*bloksizeX+bloksizeX/2),(int)(y*bloksizeY+bloksizeY/2));
        for(double x=aantalX/8*2;x<aantalX/8*6;x++)
            for(double y=aantalY/8*1; y<((aantalY/8)*3);y++)
                addObject(new Container(),(int)(x*bloksizeX+bloksizeX/2),(int)(y*bloksizeY+bloksizeY/2));
                
        addObject(new Kraan(),(int)(5*bloksizeX+bloksizeX/2),(int)(5*bloksizeY+bloksizeY/2));
        */
    }
    public double getBloksizeX()
    {
        return bloksizeX;
    }
    public double getBloksizeY()
    {
        return bloksizeY;
    }
}
