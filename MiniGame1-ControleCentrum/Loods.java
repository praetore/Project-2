import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
/**
 * Write a description of class Loods here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Loods extends Actor
{
    private int aantalMensen = 4;   // het aantal mensen dat in de loodsboot zitten 
    private int[] route;
    private int moveDelay = Haven.MOVEDELAY;    // movement delay zodat het niet elke act gebeurt
    private int x,y;                            // x en y  van de loodsboot
    private GreenfootImage image = new GreenfootImage("ambulance.png"); // het plaatje van de loodsboot
    private Boot boot; // de boot class wordt later gebruikt om methodes aan te roepen
    private WayPoint wayPointToFollow;
    public Loods()
    {
        /* 
         * het plaatje wordt eerst op maat gemaakt 
         * daarna wordt de font ingesteld en daarna de kleur
         * vervolgens wordt het aantal mensen op het plaatje gezet
         */
        getImage().scale((int) Haven.bloksizeX,(int) Haven.bloksizeY);
        getImage().setFont(new Font("Verdana", Font.BOLD, 24));
        getImage().setColor(Color.BLUE);
        getImage().drawString(""+aantalMensen,(int)(Haven.bloksizeX/4*2),(int)(Haven.bloksizeY/4*3));
        
    }
    /*
     * stel de huidige boot in als boot en zet de route naar de boot toe in
     */
    public void setCurrent(Boot _boot)
    {
        boot = _boot;
        this.route = new int[]{8 ,(int)boot.getBootX() ,(int)boot.getBootY()};
    }
    /* 
     * stel de loods x en y in
     * kijk daarna of de boot bestaat 
     * en kijk dan of de loods op de boot staat zo ja dan laat hij de boot bewegen en laad hij een mens uit 
     * vervolgens wordt de boot wegggehaald uit het geheugen
     * 
     * zo nee beweeg de loods naar de boot
     */
    public void act()
    {
        setLoodsX(this.getX());
        setLoodsY(this.getY());
        if(boot != null)
        {
            if(boot.getBootX() == getLoodsX() && boot.getBootY() == getLoodsY())
            {
                boot.hasLoods = true; 
                decreaseAantal();
                boot = null;
            }
            else{
                findClosestWaypoint();
                move();
            }
        }
        
    }
    /* 
     * deze methode laat de loodsboot bewegen volgens de ingestelde route
     * dit geld ook voor de followPath methode
     */
    public void move()
    {
        
        if (moveDelay == 0) {
            setLoodsX(this.getX());
            setLoodsY(this.getY());
            //followPath(x, y);
            if(y<10)
                moveToWayPoint(boot);
            else
                moveToWayPoint(wayPointToFollow);
            moveDelay = Haven.MOVEDELAY/10;
        } else moveDelay--;
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
    private void findNextWayPoint()
    {
        if(getOneObjectAtOffset(0,-((int) (4 * Haven.bloksizeY + Haven.bloksizeY / 2)),WayPoint.class) != null)
        {
            wayPointToFollow = (WayPoint) getOneObjectAtOffset(0,-((int) (4 * Haven.bloksizeY + Haven.bloksizeY / 2)),WayPoint.class);
        }
    }
    private void moveToWayPoint(Actor target) {
        if (target != null) {
            try {
                int leafX = target.getX();
                int leafY = target.getY();
                if(target.getClass() == WayPoint.class && this.getX() == leafX && this.getY() == leafY)
                {
                    findNextWayPoint();
                }
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
    private void followPath(int x, int y)
    {
        if(x<route[0] && y>route[2])
            x++;
        else if(x==route[0] && y>route[2])
            y--;
        else if(x>route[1] && y==route[2])
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
    // dit haalt de aantalmensen omlaag
    public void decreaseAantal()
    {
        aantalMensen--;
        repaint();
    }
    // dit haalt de aantal mensen omhoog
    public void increaseAantal()
    {
        aantalMensen++;
        repaint();
    }
    // dit tekent de loodsboot opnieuw 
    public void repaint()
    {
        getImage().clear();
        image.scale((int) Haven.bloksizeX,(int) Haven.bloksizeY);
        getImage().drawImage(image,0,0);
        getImage().drawString(""+aantalMensen,(int)(Haven.bloksizeX/4)-5,(int)(Haven.bloksizeY/4*3));
    }
}

