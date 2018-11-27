import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background2 extends Actor
{
    /**
     * Act - do whatever the Background2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    public void scroll()
    {
        if (getX() < -getImage().getWidth()/2)  // move leftmost image to right side
        {
            setLocation(getX() + getWorld().getWidth()*2, getY());
        }
        setLocation(getX()-10, getY());
    }
}
