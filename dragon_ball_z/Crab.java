// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;
import java.awt.Color;
import java.util.List;
import java.util.Set;

/**
 * This class defines a crab. Crabs live on the beach. They like sand worms (very yummy, especially the green ones).
 */
public class Crab extends Actor implements LifeSubject
{
    /* WARNING: This file is auto-generated and any changes to it will be overwritten*/
    private int wormsEaten;
    private int remainingLives;
    /* John Ran*/
    private ArrayList<LifeObserver> observers = new ArrayList < LifeObserver > ( );

    /* John Ran*/

    /**
     * Initialise the crab
     */
    public Crab()
    {
        wormsEaten = 0;
        remainingLives = 3;
    }

    /**
     * Act - do whatever the crab wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkKeyPress ( );
        lookForWorm ( );
    }

    /**
     * Check whether a control key on the keyboard has been pressed. If it has, react accordingly.
     */
    public void checkKeyPress()
    {
        if (Greenfoot . isKeyDown ( "up" )) {
            turn ( - 25 );
        }
        if (Greenfoot . isKeyDown ( "down" )) {
            turn ( 25 );
        }
        if (Greenfoot . isKeyDown ( "right" )) {
            move ( 3 );
        }
        if (Greenfoot . isKeyDown ( "left" )) {
            move ( - 3 );
        }
    }

    /**
     * Check whether we have stumbled upon a worm. If we have, eat it. If not, do nothing. If we have eaten eight worms, we win.
     */
    public void lookForWorm()
    {
        if (isTouching ( Worm . class )) {
            removeTouching ( Worm . class );
            wormsEaten = wormsEaten + 1;
            /* getWorld().showText("Worms: " + wormsEaten, 100, 30);*/
            getWorld ( ) . showText ( "Worms: " + wormsEaten , 160 , 20 );
            /* John Ran*/
            Greenfoot . playSound ( "slurp.wav" );
        }
    }

    /**
     * Crab loses a life when touched by a Lobster Added by John Ran
     */
    public void loseLife()
    {
        remainingLives = remainingLives - 1;
        getWorld ( ) . showText ( "Lives: " + remainingLives , 50 , 20 );
        if (remainingLives != 0) {
            this . setLocation ( 265 , 192 );
        }
        notifyObservers ( );
    }

    /**
     * Return the number of lives Crab has left. Added by John Ran
     */
    public int getLives()
    {
        return remainingLives;
    }

    /**
     * Return the number of Worms eaten by Crab. Added by John Ran
     */
    public int getNumWorms()
    {
        return wormsEaten;
    }

    /**
     * Attach an observer to the ArrayList John Ran added this here for Observer Pattern
     */
    public void attach(LifeObserver obj)
    {
        observers . add ( obj );
    }

    /**
     * Detach an observer from the ArrayList John Ran added this here for Observer Pattern
     */
    public void detach(LifeObserver obj)
    {
        observers . remove ( obj );
    }

    /**
     * Notify all observers of change in number of lives John Ran added this here for Observer Pattern
     */
    public void notifyObservers()
    {
        for (final LifeObserver obj : observers) {
            obj . update ( );
        }
    }
}
