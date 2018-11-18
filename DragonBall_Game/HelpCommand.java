import greenfoot.*;

/**
 * Write a description of class HelpCommand here.
 * 
 * @author Sai Harshith 
 * @version (V 1.0 11/18/2018)
 */

public class HelpCommand implements ButtonCommand
{
    Receiver helpReceiver;
    
    public void setReceiver(Receiver newReceiver)
    {
        this.helpReceiver = newReceiver;
        
    }
    public void executeCommand()
    {
        helpReceiver.performAction();
        
    }
}