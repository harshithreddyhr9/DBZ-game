import lang.stride.*;
import java.util.*;
import greenfoot.*;
import java.awt.Color;
import java.util.List;
import java.util.Set;

/**
 * This class defines a crab. Crabs live on the beach. They like sand worms 
 * (very yummy, especially the green ones).
 */
public class Crab extends Actor implements PointsSubject

{
    private int wormsEaten;
    //private PointsObserver gm;
    private ArrayList<PointsObserver> observers ;

    /**
     * Initialise the crab
     */
    public Crab()
    {
        observers = new ArrayList<PointsObserver>();
        wormsEaten = 0;
    }

    /**
     * Act - do whatever the crab wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment. 
     */
    public void act()
    {
        checkKeyPress();
        lookForWorm();
    }

    /**
     * Check whether a control key on the keyboard has been pressed.
     * If it has, react accordingly.
     */
    public void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("up")) {
            turn(-25);
        }
        if (Greenfoot.isKeyDown("down")) {
            turn(25);
        }
        if (Greenfoot.isKeyDown("right")) {
            move(3);
        }
        if (Greenfoot.isKeyDown("left")) {
            move(-3);
        }
    }

    /**
     * Check whether we have stumbled upon a worm.
     * If we have, eat it. If not, do nothing. If we have eaten eight worms, we win.
     */
    public void lookForWorm()
    {
        if (isTouching(Worm.class)) {
            removeTouching(Worm.class);
            wormsEaten = wormsEaten + 1;
            notifyObservers();
            
            Greenfoot.playSound("slurp.wav");
        }
    }
    
    public void attach(PointsObserver obj){
        System.out.println("hello");
        System.out.println(obj);
        System.out.println(observers);
        observers.add(obj);
       System.out.println(observers);
    }
    
    public void notifyObservers(){
        		for (int i=0; i<observers.size(); i++)
		{
			PointsObserver observer = observers.get(i) ;
			observer.updatePoints(wormsEaten) ;
		}
    }
    
}
