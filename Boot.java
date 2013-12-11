import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class boot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Boot extends Actor

{
    private Loods loods;
    private Kade selectedKade;

    public Boot() {
        getImage().scale((int) Haven.bloksizeX,(int) Haven.bloksizeY);
    }

    /**
     * Act - do whatever the boot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act() {
    }

    public void move(Loods loods)
    {
        setLocation(loods.getLoodsX(),loods.getLoodsY());
    }

    public void setLoods(Loods loods) {
        this.loods = loods;
    }

    public void moveToNxtPoint() {
        int leafX = selectedKade.getX();
        int leafY = selectedKade.getY();

                /*
                 *  Uitwerking: http://sinepost.wordpress.com/2012/05/01/first-we-take-manhattan/
                 */
        int xDir = (int)Math.signum(leafX - getX());
        int yDir = (int)Math.signum(leafY - getY());

        if (xDir == 0) // Move in yDir
            setLocation(getX(), getY() + yDir);
        else if (yDir == 0) // Move in xDir
            setLocation(getX() + xDir, getY());
        else // A choice
        {
            double xDirDist = Math.hypot(leafX - (getX() + xDir), leafY - getY());
            double yDirDist = Math.hypot(leafX - getX(), leafY - (getY() + yDir));
            if (xDirDist < yDirDist)
                setLocation(getX() + xDir, getY());
            else
                setLocation(getX(), getY() + yDir);
        }
    }
}
