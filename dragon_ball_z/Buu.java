import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buu extends Villian
{
    /**
     * Act - do whatever the Buu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(5);
        turnAtEdge();
        randomTurn();
        lookForGoku();
    }    
}
