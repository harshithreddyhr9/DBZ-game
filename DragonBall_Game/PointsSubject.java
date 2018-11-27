/**
 * Write a description of class PointsSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface PointsSubject  
{
    void attach(PointsObserver obj);
    void notifyObservers();

    
}

