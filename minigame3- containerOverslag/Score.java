import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Menu
{
    /**
     * Act - do whatever the Score wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public int score;


    public Score() {
           GreenfootImage img = new GreenfootImage(50,50);

             String i = Integer.toString(score);
              img.drawString(i, 20, 20);
            this.setImage(img);
    }

    public void act() 
    {
        GreenfootImage img = new GreenfootImage(50,50);
       getScore();
       String i = Integer.toString(score);
        img.drawString(i, 20, 20);
        this.setImage(img);
    }

    public void increaseScore() {
        setScore(10);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }
}
