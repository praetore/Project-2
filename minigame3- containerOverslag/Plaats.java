import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;

/**
 * Write a description of class Plaatsen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plaats extends Actor
{

    public List containers;
    private Container cont;
    public Actor select;
    /**
     * Act - do whatever the Plaatsen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */



    public void act() 
    {
      onclick();
    }

    private void onclick() {
        Haven haven = (Haven)this.getWorld();
        if (Greenfoot.mouseClicked(this)) {
            haven.kraan.moveTo(this);


            if (getX() == haven.haak.getX() && getY() == haven.haak.getY()) {
                haven.haak.setAtTarget(true);

            }

            if (haven.haak.getAtTarget()) {
              select = getOneIntersectingObject(Container.class);


            }



        }

    }



}




