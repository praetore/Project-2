import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.lang.System;

/**
 * Write a description of class Sound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sound extends Actor
{
    private GreenfootSound ship = new GreenfootSound("Ship sound.mp3");
    private GreenfootImage play = new GreenfootImage("play.png");
    private GreenfootImage mute = new GreenfootImage("mute.png");
    /**
     * Act - do whatever the Sound wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Startmenu start = (Startmenu) getWorld();
        if(Greenfoot.mouseClicked(this)){
            start.setSound();
        }
        doSound();
    }
    
    public void doSound() {
        Startmenu start = (Startmenu) getWorld();
        if(start.getSound()){
            ship.play();
            setImage(play);
        } else {
            ship.stop();
            setImage(mute);
        }
    }
}
