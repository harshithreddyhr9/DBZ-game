/**
 * Write a description of class LivesIterImpl here.
 * 
 * @author Chungchen Ran
 * @version v0.2 11/26/18
 */
public class LivesIterImpl implements LivesIterator
{
    private int livesRemaining;

    /**
     * Constructor for objects of class LivesIterImpl
     */
    public LivesIterImpl(int lives)
    {
        livesRemaining = lives;
    }
    
    /**
     * Go to the next number.
     */
    public void next()
    {
        livesRemaining--;
    }
    
    /**
     * Return the current number.
     */
    public int currentItem()
    {
        return livesRemaining;
    }
    
    /**
     * Check if the iterator is done.
     */
    public boolean isDone()
    {
        return (livesRemaining == 0);
    }
}
