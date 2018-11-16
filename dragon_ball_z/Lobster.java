// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;
import java.awt.Color;

/**
 * A lobster. Lobsters live on the beach. They like to eat crabs. (Well, in our game they do...) Version: 2 The lobster walks around randomly. If it runs into a crab it eats it. In this version, we have added a sound effect, and the game stops when a lobster eats the crab.
 */
public class Lobster extends Actor implements LifeObserver
{
    /* WARNING: This file is auto-generated and any changes to it will be overwritten*/
    private CrabWorld world;
    /* John Ran*/
    private int posX;
    private int posY;

    /* John Ran added parameters*/

    /**
     * Initialize the Lobster, John Ran
     */
    public Lobster(int x, int y)
    {
        this . world = ( CrabWorld ) getWorld ( );
        posX = x;
        posY = y;
    }

    /**
     * Do whatever lobsters do.
     */
    public void act()
    {
        move ( 5 );
        turnAtEdge ( );
        randomTurn ( );
        lookForCrab ( );
    }

    /**
     * Check whether we are at the edge of the world. If we are, turn a bit. If not, do nothing.
     */
    public void turnAtEdge()
    {
        if (isAtEdge ( )) {
            turn ( 17 );
        }
    }

    /**
     * Randomly decide to turn from the current direction, or not. If we turn turn a bit left or right by a random degree.
     */
    public void randomTurn()
    {
        if (Greenfoot . getRandomNumber ( 100 ) > 90) {
            turn ( Greenfoot . getRandomNumber ( 90 ) - 45 );
        }
    }

    /**
     * Try to pinch a crab. That is: check whether we have stumbled upon a crab. If we have, remove the crab from the game, and stop the program running.
     */
    public void lookForCrab()
    {
        if (isTouching ( Crab . class )) {
            /* removeTouching(Crab.class);*/
            Crab crab = getWorld ( ) . getObjects ( Crab . class ) . get ( 0 );
            /* John Ran*/
            Greenfoot . playSound ( "au.wav" );
            crab . loseLife ( );
            /* John Ran*/
            if (crab . getLives ( ) == 0) {
                removeTouching ( Crab . class );
                /* John Ran*/
                Greenfoot . stop ( );
            }
        }
    }

    /**
     * Update the observer's state when the subject state changes. John Ran added this here for Observer Pattern
     */
    public void update()
    {
        Crab crab = getWorld ( ) . getObjects ( Crab . class ) . get ( 0 );
        /* John Ran*/
        if (crab . getLives ( ) != 0) {
            this . setLocation ( posX , posY );
        }
    }
}
