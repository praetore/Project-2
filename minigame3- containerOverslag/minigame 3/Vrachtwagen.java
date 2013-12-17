import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vrachtwagen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Vrachtwagen extends Actor
{
   
    /**
     * Act - do whatever the Vrachtwagen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int aantalVrachtwagens = 1;
    public Kraan kraan;
   public Container container;
   private int vrachtwagenSpeed = 1;
    public void act() 
    {
        checkClicked();
        checkCollision();
        drive();
        createNew();
            }

    private void createNew() {
        //voor aanmaken nieuwe vrachtwagens.
        if (getAantalVrachtwagens() == 0) {
            setAantalVrachtwagens(1);
            this.setLocation(200,500);

        }
    }
    //checken of de vrachtwagen als target wordt ingesteld
    private void checkClicked() {
        if (Greenfoot.mouseClicked(this)) {
            Haven haven = (Haven)this.getWorld();
            haven.kraan.moveTo(this);

        }
    }
    //collision check met container
    private void checkCollision() {
        Container container = (Container) getOneIntersectingObject(Container.class);
        if (container != null) {

            loadContainer(container);
        }
    }

    private void loadContainer(Container container) {

        this.container = container;
    }

    private void drive() {


        if (container != null) {

            setLocation(getX()-vrachtwagenSpeed, getY());
            container.setLocation(getX(),getY());

        }
        //deleten van vrachtwagens en containers op de vrachtwagen
        if (getX() == 0) {
            getWorld().removeObject(this.getOneIntersectingObject(Container.class));
            container = null;
           setAantalVrachtwagens(0);




            }




}
    //getter en setter van het aantal vrachtwagens in het spel
    public int getAantalVrachtwagens() {
        return aantalVrachtwagens;
    }

    public void setAantalVrachtwagens(int aantalVrachtwagens) {
        this.aantalVrachtwagens = aantalVrachtwagens;
    }
}



