import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author Chungchen Ran
 * @version 11/25/18
 */
public class Background extends Actor
{
    /**
     * Act - do whatever the Background wants to do. This method is called whenever
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
