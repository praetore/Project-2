import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Haven here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Haven extends World
{
    int first;
    Boot boot = new Boot();
    Haak haak = new Haak();
    Boot bootPC = new Boot();
    Vrachtwagen vrachtwagen = new Vrachtwagen();
    Vrachtwagen vrachtwagenPC = new Vrachtwagen();
    Plaats plaats = new Plaats();
    Kraan kraan = new Kraan();
    Kraan kraanPC = new Kraan();
    VolgendeContainer label = new VolgendeContainer();
    Score score = new Score();
    private Boot bootie;
    /**
     * Constructor for objects of class Haven.
     * 
     */

    public Boot getBoot() {
        return bootie;
    }

    public Haven() {
        super(800, 600, 1);


        setPaintOrder(Kraan.class, Haak.class, Container.class, Plaats.class);

            for (int x = 0; x <= getWidth(); x = x + 50) {
              for (int y = 0; y <= getHeight(); y = y + 50) {
                  if ( y < 250)
                  {
                      addObject (new Water(), x , y);
                  }
                  
                  if ( y >= 250 && y <= 500)
                    {
                       addObject (new Kade(), x , y);
                    }
                   
                   
            }
    }


    addObject(new Balans(),50,50);
    addObject(vrachtwagen,200,360);
    addObject(boot,190,170);
    addObject(bootPC,590,170);
    //addObject(new Stapels(),160,450);
    //addObject(new Stapels(),160,490);
    //addObject(new Stapels(),160,530);
    
   // addObject(new Stapels(),360,450);
    //addObject(new Stapels(),360,490);
    //addObject(new Stapels(),360,530);
    
   // addObject(new Stapels(),560,450);
   // addObject(new Stapels(),560,490);
   // addObject(new Stapels(),560,530);
    // start x 100 tot 350
    // start y 130 - 230
    // image 1 heeft weight 1 enz..

        addObject(new Container(1, 1), 100,130);
        addObject( new Plaats() ,100,130);
        addObject(new Container(3, 3), 150,130);
        addObject(new Plaats(),150,130);
        addObject(new Container(5, 5), 200,130);
        addObject(new Plaats(),200,130);
        addObject(new Container(2, 2), 250,130);
        addObject(new Plaats(),250,130);
        addObject(new Container(4, 4), 300,130);
        addObject(new Plaats(),300,130);

        addObject(new Container(6, 6), 100,150);
        addObject(new Plaats(),100,150);
        addObject(new Container(7, 7), 150,150);
        addObject(new Plaats(),150,150);
        addObject(new Container(8, 8), 200,150);
        addObject(new Plaats(),200,150);
        addObject(new Container(6, 6), 250,150);
        addObject(new Plaats(),250,150);
        addObject(new Container(4, 4), 300,150);
        addObject(new Plaats(),300,150);

        addObject(new Container(4, 4), 300,170);
        addObject(new Plaats(),300,170);
        addObject(new Container(5, 5), 100,170);
        addObject(new Plaats(),100,170);
        addObject(new Container(2, 2), 150,170);
        addObject(new Plaats(),150,170);
        addObject(new Container(1, 1), 200,170);
        addObject(new Plaats(),200,170);
        addObject(new Container(7, 7), 250,170);
        addObject(new Plaats(),250,170);

        addObject(new Container(8, 8), 300,190);
        addObject(new Plaats(),300,190);
        addObject(new Container(2, 2), 100,190);
        addObject(new Plaats(),100,190);
        addObject(new Container(3, 3), 150,190);
        addObject(new Plaats(),150,190);
        addObject(new Container(6, 6), 200,190);
        addObject(new Plaats(),200,190);
        addObject(new Container(7, 7), 250,190);
        addObject(new Plaats(),250,190);

        addObject(new Container(3, 3), 300,210);
        addObject(new Plaats(),3000,210);
        addObject(new Container(3, 3), 100,210);
        addObject(new Plaats(),100,210);
        addObject(new Container(6, 6), 150,210);
        addObject(new Plaats(),150,210);
        addObject(new Container(7, 7), 200,210);
        addObject(new Plaats(),200,210);
        addObject(new Container(8, 8), 250,210);
        addObject(new Plaats(),250,210);

        // PCBOOT

        addObject(new Container(1, 1), 500,130);
        addObject(new Container(3, 3), 550,130);
        addObject(new Container(5, 5), 600,130);
        addObject(new Container(2, 2), 650,130);
        addObject(new Container(4, 4), 700,130);

        addObject(new Container(6, 6), 500,150);
        addObject(new Container(7, 7), 550,150);
        addObject(new Container(8, 8), 600,150);
        addObject(new Container(6, 6), 650,150);
        addObject(new Container(4, 4), 700,150);

        addObject(new Container(4, 4), 700,170);
        addObject(new Container(5, 5), 500,170);
        addObject(new Container(2, 2), 550,170);
        addObject(new Container(1, 1), 600,170);
        addObject(new Container(7, 7), 650,170);

        addObject(new Container(8, 8), 700,190);
        addObject(new Container(2, 2), 500,190);
        addObject(new Container(3, 3), 550,190);
        addObject(new Container(6, 6), 600,190);
        addObject(new Container(7, 7), 650,190);

        addObject(new Container(3, 3), 700,210);
        addObject(new Container(3, 3), 500,210);
        addObject(new Container(6, 6), 550,210);
        addObject(new Container(7, 7), 600,210);
        addObject(new Container(8, 8), 650,210);




    addObject( haak,170,170);
    addObject(kraan,170,130);
    addObject(kraanPC,570,130);

    addObject(label,50,500);
    boot.checkIntersectingObject();
    first = boot.getFirst();

    System.out.println(boot.gewichtArray);

   addObject(score,100,550);
}
}

