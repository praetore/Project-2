import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;

/**
 * Write a description of class Kraan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Kraan extends Actor
{
    private Container container;

    public void act() {
        moveToContainer();
        grab();
    }

    private void moveToContainer() {
        Container target = null;
        List containers = getWorld().getObjects(Container.class);
        for (Object i : containers) {
            Container container = (Container) i;
            if (container.isSelected()) {
                target = container;
            }
        }

        if(target != null) {
            if(target.getX() < this.getX()) {
                move(-1);
            } else if(target.getX() > this.getX()) {
                move(1);
            }
        }
    }

    private void grab() {
        if (container != null) {
            container.setOpgepakt(false);
        }
    }

    private boolean hasContainer() {
        boolean hasContainer;
        if (container == null) hasContainer = false;
        else hasContainer = true;
        return hasContainer;
    }
}


