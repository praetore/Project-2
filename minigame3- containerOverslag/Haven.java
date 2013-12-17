import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Haven here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Haven extends World
{
    Boot boot = new Boot();
    Boot bootPC = new Boot();
    Vrachtwagen vrachtwagen = new Vrachtwagen();
    Vrachtwagen vrachtwagenPC = new Vrachtwagen();
    Kraan kraan = new Kraan();
    Kraan kraanPC = new Kraan();
    /**
     * Constructor for objects of class Haven.
     * 
     */
    public Haven()
    {
        super(800, 600, 1);
            for (int x = 0; x <= getWidth(); x = x + 50) {
              for (int y = 0; y <= getHeight(); y = y + 50) {
                  if ( y < 300)
                  {
                      addObject (new Water(), x , y);
                  }
                  
                  if ( y >= 300 && y <= 600)
                    {
                       addObject (new Kade(), x , y);
                    }
                   
                   
            }
    }



    addObject(vrachtwagen,200,500);
    addObject(boot,450,175);

    for (int x = 100; x < 500; x = x +50) {
        for (int y = 100; y < 280; y = y + 30)  {
             addObject(new Container(), x,y);
        }
    }
    addObject(new haak(),170,170);
    addObject(kraan,170,270);
    addObject(kraanPC,570,270);

    
}
}

