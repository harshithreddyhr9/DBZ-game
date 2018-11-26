/**
 * Write a description of class timer here.
 * 
 * @author (Sai Harshith) 
 * @version (a version number or a date)
 */
public class Timer  
{
    private long timeoflastfire = System.currentTimeMillis();
    
    public void fire()
    {
        timeoflastfire = System.currentTimeMillis();
    }
    
    
    public int TimeElapsed()
    {
        return (int) (System.currentTimeMillis() - timeoflastfire);
    }
}
