import java.util.ArrayList;

/**
 * Write a description of class LivesAggImpl here.
 * 
 * @author Chungchen Ran
 * @version v0.1 11/22/18
 */
public class LivesAggImpl implements LivesAggregate
{
    private ArrayList<String> livesRemaining = new ArrayList<String>();

    /**
     * Set the number of lives remaining.
     */
    public void setLives(int lives)
    {
        for (int i = 0; i <= lives; i++)
        {
            livesRemaining.add(Integer.toString(i));
        }
    }

    /**
     * Return the lives Iterator with the number of lives remaining.
     */
    public LivesIterator createIterator()
    {
        return new LivesIterImpl(livesRemaining);
    }
}
