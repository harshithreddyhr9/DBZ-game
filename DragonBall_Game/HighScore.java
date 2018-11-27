import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HighScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class HighScore extends World implements LevelHandler
{

    public LevelHandler next;
    public UserDetails user;
    public HighScore(CurrentLevel l)
    {    
        // Create a new world with 1200x650 cells with a cell size of 1x1 pixels.
        super(1200, 650, 1);
        
    }
    
    public void act()
    {
        user = UserDetails.getInstance();
        String name = user.getUserName();
        addObject(new DisplayHighScore(name+" : "+user.getScore()),200,200);
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
