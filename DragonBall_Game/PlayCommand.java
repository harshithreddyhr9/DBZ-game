
/**
 * Write a description of class PlayCommand here.
 * 
 * @author Sai Harshith
 * @version (V 1.0 11/18/2018)
 */

public class PlayCommand implements ButtonCommand
{
    Receiver playReceiver;
    
    public void setReceiver(Receiver newRec)
    {
        this.playReceiver = newRec;
        
    }
    public void executeCommand()
    {
        playReceiver.performAction();
        
    }
}