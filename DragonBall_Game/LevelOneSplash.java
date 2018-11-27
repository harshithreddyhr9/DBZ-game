import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class LevelOneSplash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelOneSplash extends World implements LevelHandler
{

    
    public LevelHandler next;
    
    
    public LevelOneSplash(CurrentLevel l)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 542, 1, false);
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
            startNext();
    }
    
    
    public void startWorld()
    {
        Greenfoot.setWorld(this);
    }
    
    public void setNextLevel(LevelHandler NextLevel)
    {
        this.next = NextLevel;
    }
    
    public void startNext(){
        this.next.startWorld();
    }
    
   
}
