import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;

/**
 * Write a description of class Loods here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Loods extends Actor
{
    private static final int MOVEDELAY = 0;

    private int x,y;
    private int moveDelay = MOVEDELAY;
    private int[][] route;
    private WayPoint wayPointToFollow;

    public Loods()
    {
        getImage().scale((int) Haven.bloksizeX,(int) Haven.bloksizeY);
        setRoute(new int[][]{{4 ,15 ,1 },{10,18 ,6 },{12,18,18}});
    }

    /**
     * Act - do whatever the Loods wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        findClosestWaypoint();
        move();
    }

    private void findClosestWaypoint() {
        List leafs = getWorld().getObjects(WayPoint.class);
        if (wayPointToFollow == null && leafs.size() > 0) {
            int range = 0;
            List closestLeafs = getObjectsInRange(range, WayPoint.class);
            while (closestLeafs.isEmpty()) {
                range++;
                closestLeafs = getObjectsInRange(range,WayPoint.class);
            }
            while (closestLeafs.size() > 1) {
                closestLeafs.remove(0);
            }
            for (Object leaf : closestLeafs) {
                wayPointToFollow = (WayPoint) leaf;
            }
        }
    }

    private void move() {
        if (moveDelay == 0) {
            moveToWayPoint();

            moveDelay = MOVEDELAY;
        } else moveDelay--;
    }

    private void moveToWayPoint() {
        if (wayPointToFollow != null) {
            try {
                int leafX = wayPointToFollow.getX();
                int leafY = wayPointToFollow.getY();

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
                        setLocation(getX() + xDir*4, getY());
                    else
                        setLocation(getX(), getY() + yDir*4);
                }
            } catch (IllegalStateException E) {
                wayPointToFollow = null;
            }
        }
    }

    private void setRoute(int[][] route) {
        this.route = route;
    }

    private void followPath(int x, int y, int path)
    {
        if(x<route[path-1][0] && y<route[path-1][1])
            x++;
        else if(x==route[path-1][0] && y<route[path-1][1])
            y++;
        else if(x>route[path-1][2] && y==route[path-1][1])
            x--;
        setLocation((int) (x * Haven.bloksizeX + Haven.bloksizeX / 2), (int) (y * Haven.bloksizeY + Haven.bloksizeY / 2));
    }

    public void setLoodsX(int x){
        this.x = x/(int) Haven.bloksizeX;
    }

    public int getLoodsX() {
        return x;
    }

    public void setLoodsY(int y){
         this.y = y/(int) Haven.bloksizeY;
    }

    public int getLoodsY() {
         return y;
    }
}

