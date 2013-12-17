import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WayPoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WayPoint extends Actor
{
    private int wayPointNo;

    public WayPoint() {
        getImage().scale((int) Haven.bloksizeX,(int) Haven.bloksizeY);
    }

    public WayPoint(int wayPointNo) {
        this.wayPointNo = wayPointNo;
        getImage().scale((int) Haven.bloksizeX,(int) Haven.bloksizeY);
    }

    /**
     * Act - do whatever the WayPoint wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkShipRequest();
    }

    private void checkShipRequest() {
        Vrachtschip boot = (Vrachtschip) getOneIntersectingObject(Vrachtschip.class);
        if (boot != null && wayPointNo == 0) {
            boot.moveToFirstPoint();
        }
    }
}
