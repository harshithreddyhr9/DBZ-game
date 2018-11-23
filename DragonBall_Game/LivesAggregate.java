import greenfoot.*;
/**
 * Write a description of class LivesAggregate here.
 * 
 * @author Chungchen Ran
 * @version v0.2 11/22/18
 */
public interface LivesAggregate
{
    LivesIterator createIterator();
    void setLives(int lives);
}
