import java.util.ArrayList;

/**
 * Write a description of class LivesIterImpl here.
 * 
 * @author Chungchen Ran
 * @version v0.1 11/22/18
 */
public class LivesIterImpl implements LivesIterator
{
    private ArrayList<String> livesRemaining;
    private int cursor;

    /**
     * Constructor for objects of class LivesIterImpl
     */
    public LivesIterImpl(ArrayList<String> lives)
    {
        livesRemaining = lives;
        cursor = lives.size() - 1;
    }

    /**
     * Return the first number.
     */
    public String first()
    {
        return livesRemaining.get(livesRemaining.size());
    }
    
    /**
     * Return the next number.
     */
    public String next()
    {
        cursor--;
        if (!isDone())
            return livesRemaining.get(cursor);
        else
            return "<end>";
    }
    
    /**
     * Return the current number.
     */
    public String currentItem()
    {
        return livesRemaining.get(cursor);
    }
    
    /**
     * Check if the iterator is done.
     */
    public boolean isDone()
    {
        return (cursor == 0);
    }
}
