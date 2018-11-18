import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ButtonPlay here.
 * 
 * @author Sai Harshith 
 * @version (V 1.0 11/18/2018)
 */
public class Play extends Button implements ButtonInvoker
{
    /**
     * Act - do whatever the ButtonStart wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     ButtonCommand newButtonCommand;
    
    public void act() 
    {
        super.act();
        // Add your action code here.
    }
    
    public void click()
    {
        newButtonCommand.executeCommand();
        
    }
    public void setCommand(ButtonCommand newCmd)
    {
        this.newButtonCommand = newCmd;
    }
}
