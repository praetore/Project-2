import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Haven here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Haven extends World
{
    public static final int[] scherm = {800,600};
    public static final double bloksizeX = scherm[0]/20; //getWidth()/10;
    public static final double bloksizeY = scherm[1]/20; //getHeight()/10;
    public static final double aantalX = scherm[0]/ bloksizeX;
    public static final double aantalY = scherm[1]/ bloksizeY;

    /**
     * Constructor for objects of class Haven.
     */
    public Haven()
    {
        super(scherm[0], scherm[1], 1);
        populate();
    }

    @Override
    public void act() {
        spawnShip();
    }


    /**
     * Een nieuwe schip spawnt vanaf de bovenkant en wacht totdat hij geloodsd kan worden.
     */
    private void spawnShip() {
        int spawnChance = 40;

        if (Greenfoot.getRandomNumber(spawnChance) == 1) {
            int randomX = Greenfoot.getRandomNumber(getWidth());
            addObject(new Vrachtschip(), randomX, 0);
        }
    }

    /**
     * Loading world objects
     */
    private void populate() {
        for (int x=0;x< aantalX;x++)
            for(int y=0;y< aantalY;y++)
                addObject(new Zee(),(int)(x* bloksizeX + bloksizeX /2),(int)(y* bloksizeY + bloksizeY /2));
        for (int x=0;x<scherm[0]/bloksizeX;x++)
            if (x < 8 || x > 11) {
                for(int y=10;y<13;y++)
                    addObject(new Wal(),(int)(x* bloksizeX + bloksizeX /2),(int)(y* bloksizeY + bloksizeY /2));
            }

        for (int x = 0; x < 4; x++) {
            addObject(new WayPoint(x+1),(int)((x+8)* bloksizeX + bloksizeX /2),(int)(9* bloksizeY + bloksizeY /2));
            addObject(new WayPoint(x+1),(int)((x+8)* bloksizeX + bloksizeX /2),(int)(13* bloksizeY + bloksizeY /2));
        }


        addObject(new Loodsboot(),(int)(1* bloksizeX + bloksizeX /2),(int)(1* bloksizeY + bloksizeY /2));
        addObject(new Vrachtschip(),(int)(1* bloksizeX + bloksizeX /2),(int)(1* bloksizeY + bloksizeY /2));
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
