/**
 * Write a description of class LivesAggImpl here.
 * 
 * @author Chungchen Ran
 * @version v0.2 11/26/18
 */
public class LivesAggImpl implements LivesAggregate
{
    private int livesRemaining;
    
    /**
     * Constructor for LivesAggImpl
     */
    public LivesAggImpl(int lives)
    {
        livesRemaining = lives;
    }

    /**
     * Return the lives Iterator with the number of lives remaining.
     */
    public LivesIterator createIterator()
    {
        return new LivesIterImpl(livesRemaining);
    }
}
