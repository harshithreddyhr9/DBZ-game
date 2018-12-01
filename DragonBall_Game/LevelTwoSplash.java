import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelTwoSplash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelTwoSplash extends World implements LevelHandler
{
    
    private static final String bgImageName = "levelTwoSplash.png"; 
    public LevelHandler next;
    private LivesIterator lifeIter;
    
    public LevelTwoSplash(CurrentLevel l)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1240, 640, 1); 
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("space"))
            startNext();
    }
    
    public void startWorld(LivesIterator li)
    {
        Greenfoot.setWorld(this);
        lifeIter = li;
    }
    
    public void setNextLevel(LevelHandler NextLevel)
    {
        this.next = NextLevel;
    }
    
    public void startNext(){
        this.next.startWorld(lifeIter);
    }
    
}
