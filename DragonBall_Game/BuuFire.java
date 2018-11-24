import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BuuFire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BuuFire extends Actor
{
    /**
     * Act - do whatever the BuuFire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(30);
        if(isAtEdge())
            getWorld().removeObject(this);
    }    
}
