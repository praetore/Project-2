import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Point;
import java.util.List;
/**
 * Write a description of class Boot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boot extends Actor
{
    public boolean hasLoods = false;
    private int x,y;
    private int moveDelay = Haven.MOVEDELAY/10;
    private int[][] route;
    private WayPoint wayPointToFollow;

    public Boot()
    {
        getImage().scale((int) Haven.bloksizeX,(int) Haven.bloksizeY);
        // zet de route naar p1 tot p4
        setRoute(new int[][]{{8 ,(int)Haven.P1.getY() ,(int)Haven.P1.getX() },
                             {9 ,(int)Haven.P2.getY() ,(int)Haven.P2.getX() },
                             {10 ,(int)Haven.P3.getY(),(int)Haven.P3.getX() },
                             {11 ,(int)Haven.P4.getY(),(int)Haven.P4.getX() }});
    }
    
    /**
     * Act - do whatever the Boot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
        setBootX(this.getX());
        setBootY(this.getY());
        if(Greenfoot.mouseClicked(this))
        {
            onClick();
        }
        if(hasLoods)
        {   
            findClosestWaypoint();
            move();
        }
    }
    private void findClosestWaypoint() {
        List leafs = getWorld().getObjects(WayPoint.class);
        while(wayPointToFollow == null && leafs.size() > 0) {
        //if (wayPointToFollow == null && leafs.size() > 0) {
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
            //followPath(x, y, 2);
            moveToWayPoint();
            moveDelay = Haven.MOVEDELAY/10;
        } else moveDelay--;
    }

    private void setRoute(int[][] route) {
        this.route = route;
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
    public void onClick()
    {
        Haven.loods.setCurrent(this);
    }
    
    public void setBootX(int x){
        this.x = x/(int) Haven.bloksizeX;
    }

    public int getBootX() {
        return x;
    }

    public void setBootY(int y){
         this.y = y/(int) Haven.bloksizeY;
    }

    public int getBootY() {
         return y;
    }
}

