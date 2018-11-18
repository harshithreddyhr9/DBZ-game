import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goku here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goku extends Scroller
{
    /**
     * Act - do whatever the Goku wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int ballscollected;

    /**
     * Initialise the Goku
     */
    public Goku()
    {
        ballscollected = 0;
    }
    public void act() 
    {
        checkKeyPress();
        lookForBalls();
    }    
    
    public void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY()-5);
        }
        if(Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY()+5);
        }
    }

    public void lookForBalls()
    {
        
    }
}
