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
    Boot bootPC = new Boot();
    Vrachtwagen vrachtwagen = new Vrachtwagen(200,360);
    Vrachtwagen vrachtwagenPC = new Vrachtwagen(600,360);
    Plaats plaats = new Plaats();
    Kraan kraan = new Kraan();
    Kraan kraanPC = new Kraan();
     Balans balans = new Balans();
    Balans balansPC = new Balans();
    Sound sound = new Sound();
    Pauze pauze = new Pauze();
     
    Haak haak = new Haak(kraan);
    Haak haakPC = new Haak(kraanPC);
     Player player = new Player(kraan,haak);
    VolgendeContainer label = new VolgendeContainer();
    Score score = new Score();
    private Boot bootie;
    public  int containerNummer = 0;
    public static int afstandx = 50;
    public static int afstandy = 20;
    public static int beginx = 100;
    public static int beginy = 130;
    public static int aantalx = 5;
    public static int aantaly = 5;
    public static int aantalz = 3;
    public static int pcbeginx = 500;
    public static int pcbeginy = 130;
    public GreenfootSound backgroundSound = new GreenfootSound("background.mp3");

    public Boot getBoot() {
        return bootie;
    }

    public Haven() {
        super(800, 600, 1);

        backgroundSound.playLoop();

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

    addObject(sound,750,560);
    addObject(balans,50,50);
    addObject(vrachtwagen,200,360);
    addObject(vrachtwagenPC,600,360);
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
    
    /* player
     * hier wordt de boot van de speler gevult met containers
     * op x = beginx+afstandx*n
     * en y = beginy+afstandy*i
     * beginx en beginy zijn de locatie van de meest linksboven container
     * afstandx is de afstand die zit tussen de containers horizontaal
     * afstandy is de afstand die zit tussen de containers verticaal
     */
  /*  for(int i=0;i<aantaly;i++)
    {
        for(int n=0;n<aantalx;n++)
        {
            addObject(new Plaats(), beginx+afstandx*n,beginy+afstandy*i);
        }
    } */
    for(int a=0;a<aantalz;a++)
    {
        for(int i=0;i<aantaly;i++)
        {
            for(int n=0;n<aantalx;n++)
            {
                addObject(new Container(), beginx+afstandx*n,beginy+afstandy*i);
            }
        }
    }
        
     /* computer
      * voor uitleg zie player
      */
    
    for(int a=0;a<aantalz;a++)
    {
        for(int i=0;i<aantaly;i++)
        {
            for(int n=0;n<aantalx;n++)
            {
                addObject(new Container(), pcbeginx+afstandx*n,pcbeginy+afstandy*i);
            }
        }
    }
     
     
     
     
     
     
     /*
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

*/


    addObject( haak,170,170);
    addObject( haakPC,570,170);
    addObject(kraan,170,130);
    addObject(kraanPC,570,130);
    addObject(pauze,380,560);
    addObject(label,50,540);
    boot.checkIntersectingObject();
     bootPC.checkIntersectingObject();
    getNext(containerNummer);
    
    label.image.drawString("volgende: " + first, 150,50);

    makeBalance();
   addObject(score,100,550);
   addObject(player,100,650);
  addObject(new Computer(kraanPC,haakPC,vrachtwagenPC),100,650);
}

public void getNext(int i) {

        makeBalance();
        // volgende container
        first = boot.getFirst(i);
        System.out.println(first);
        label.setImage(first);
    }

    public int getFirst() {
        return first;
    }

    public void makeBalance() {
        // balans
        balans.setRotation(0);
        boot.gewichtArray.clear();
        boot.checkIntersectingObject();
        balans.setDraai((int)boot.getBalance());
        checkBalance();
        System.out.println("balanceeeeee");
    }

    public void checkBalance() {
      double b =  boot.getBalance();
      if (b > 50 || b < -50) {
          System.out.println("GAME OVER");
         // addObject(new GameOver(),400,300);
          Greenfoot.stop();
      }
    }

    public void geefGewicht(int i) {
      if (i == first) {
          score.increaseScore(10);
      } else {
          score.increaseScore(-10);
      }
    }

}

