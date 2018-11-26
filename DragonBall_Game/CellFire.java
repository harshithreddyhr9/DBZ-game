import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CellFire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CellFire extends Actor
{
    /**
     * Act - do whatever the CellFire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(20);
        if(isAtEdge())
            getWorld().removeObject(this);
    }    
}
