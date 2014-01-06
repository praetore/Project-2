import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Arrays;

/**
 * Write a description of class Boot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boot extends Actor
{    
    int[] pathx,pathy,pathx1,pathy1;
    boolean bezig = false;
    boolean gaan = false;
    int beginx,beginy;
    int i = 2;

    
    public Boot(int x, int y)
    {
        beginx = x;
        beginy = y;
        resetPath();
    }
    public void resetPath()
    {
        i = 1;
        gaan = false;
        Zee.p1.clearPath();
        pathx = new int[1];
        pathx[0] = beginx;
        pathy = new int[1];
        pathy[0] = beginy;
    }
    public void act() 
    {
        
        goPath();
        /*if(Greenfoot.isKeyDown("space"))
        {
            gaan = true;
        }*/
        if(gaan && !bezig)
        {
                i++;
            try
            {
                turnTowards(pathx[i],pathy[i]);
                //setLocation(pathx[i],pathy[i]);
                if(pathx[pathx.length-1] != this.getX())
                   ( move(int) Math.sqrt(Math.pow((double)(pathx[i]-pathx[i-1]),2)+Math.pow((double)(pathy[i]-pathy[i-1]),2)));


            }catch(Exception e){}
            if(i>=pathx.length)
            {
                beginx = this.getX();
                beginy = this.getY();
                resetPath();
            }
                
            
        }
    }    
    public void goPath()
    {
        
        try
        {
            if(Greenfoot.getMouseInfo().getButton() == 1)
            {
                bezig = true;
                MouseInfo info = Greenfoot.getMouseInfo();
                int x = info.getX();
                int y = info.getY();
                if(pathx[pathx.length-1] != this.getX())
                    Zee.p1.drawPath(x,y,pathx[pathx.length-1],pathy[pathy.length-1]);
                
                pathx1 = new int[pathx.length+1];
                for(int i =0;i<pathx.length;i++)
                    pathx1[i]=pathx[i];
                pathx1[pathx1.length-1] = x;
                
                pathy1 = new int[pathy.length+1];
                for(int i =0;i<pathy.length;i++)
                    pathy1[i]=pathy[i];
                pathy1[pathy1.length-1] = y;
               
                pathx = pathx1;
                pathy = pathy1;
                gaan = true;
            }
            else
            {
                bezig = false;
            }
        }catch(Exception e){}
    }
}
