import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button to close a window.
 * 
 * @author Sai Harshith
 * @version (V 1.0 11/18/2018)
 */
public class Back extends Button
{
    private Actor actor;
  
    public Back(Actor a)
    {
        actor = a;
    }
    
    /**
     * Act - do whatever the Back wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        this.click();
    }    
    
    /**
     * Close the window to see the menu again.
     */
    public void click()
    {
        if(Greenfoot.mouseClicked(this)){
            getWorld().removeObject(actor);
            getWorld().removeObject(this);
        }
    }
}
