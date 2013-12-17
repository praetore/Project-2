import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.awt.*;
import java.util.List;

/**
 * Write a description of class boot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Vrachtschip extends Actor
{
    private List<Point> route;
    private boolean hasCargo;
    private Point currentWayPoint;
    private int unloadDelay;

    public Vrachtschip() {
        getImage().scale((int) Haven.bloksizeX, (int) Haven.bloksizeY);
        unloadDelay = 30;
    }

    /**
     * Act - do whatever the boot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act() {
        currentWayPoint = getNextWayPoint();
        moveToPoint(currentWayPoint);
        unloadCargo();
    }

    private Point getNextWayPoint() {
        Point currentLocation = new Point(getX(), getY());
        if (currentLocation.getY() < route.get(0).getY()) return route.get(0);
        if (!hasCargo && isTouching(Kade.class)) return new Point(Greenfoot.getRandomNumber(getWorld().getWidth()), 0);
        if (hasCargo && isTouching(Kade.class)) {
            unloadDelay--;
            return currentLocation;
        } else {
            for (int x = route.size()-1; x > 1; x--) {
                if (currentLocation.getY() < route.get(x).getY() &&
                        currentLocation.getY() > route.get(x-1).getY()) {
                    return route.get(x);
                }
            }
        }
        return null;
    }

    private void moveToPoint(Point point) {
        int pointX = (int) point.getX();
        int pointY = (int) point.getY();

                /*
                 *  Uitwerking: http://sinepost.wordpress.com/2012/05/01/first-we-take-manhattan/
                 */
        int xDir = (int)Math.signum(pointX - getX());
        int yDir = (int)Math.signum(pointY - getY());

        if (xDir == 0) // Move in yDir
            setLocation(getX(), getY() + yDir);
        else if (yDir == 0) // Move in xDir
            setLocation(getX() + xDir, getY());
        else // A choice
        {
            double xDirDist = Math.hypot(pointX - (getX() + xDir), pointY - getY());
            double yDirDist = Math.hypot(pointX - getX(), pointY - (getY() + yDir));
            if (xDirDist < yDirDist)
                setLocation(getX() + xDir, getY());
            else
                setLocation(getX(), getY() + yDir);
        }
    }

    private void unloadCargo() {
        //To change body of created methods use File | Settings | File Templates.
    }

    public void setRoute(List<Point> route) {
        this.route = route;
    }
}
