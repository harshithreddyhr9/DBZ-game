// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;
import java.awt.Color;

/**
 * 
 */
public class CrabWorld extends World
{
    /* WARNING: This file is auto-generated and any changes to it will be overwritten*/
    private int livesRemaining;
    private int wormsEaten;

    /**
     * Initialize the World
     */
    public CrabWorld()
    {
        super(560 , 400 , 1);
        livesRemaining = 3;
        wormsEaten = 0;
        prepare ( );
        showLivesAndScore ( );
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Crab crab = new Crab ( );
        addObject ( crab , 265 , 192 );
        Worm worm = new Worm ( );
        addObject ( worm , 529 , 111 );
        Worm worm2 = new Worm ( );
        addObject ( worm2 , 512 , 277 );
        Worm worm3 = new Worm ( );
        addObject ( worm3 , 397 , 322 );
        Worm worm4 = new Worm ( );
        addObject ( worm4 , 425 , 148 );
        Worm worm5 = new Worm ( );
        addObject ( worm5 , 292 , 68 );
        Worm worm6 = new Worm ( );
        addObject ( worm6 , 154 , 106 );
        Worm worm7 = new Worm ( );
        addObject ( worm7 , 292 , 331 );
        Worm worm8 = new Worm ( );
        addObject ( worm8 , 164 , 357 );
        Worm worm9 = new Worm ( );
        addObject ( worm9 , 112 , 260 );
        Worm worm10 = new Worm ( );
        addObject ( worm10 , 87 , 38 );
        Lobster lobster = new Lobster ( );
        addObject ( lobster , 102 , 107 );
        Lobster lobster2 = new Lobster ( );
        addObject ( lobster2 , 432 , 81 );
        Lobster lobster3 = new Lobster ( );
        addObject ( lobster3 , 471 , 382 );
    }

    /**
     * Reset the Lobsters Positions when Crab loses a life
     */
    private void resetLobsterPositions()
    {
        Lobster lobster1 = getObjects ( Lobster . class ) . get ( 0 );
        Lobster lobster2 = getObjects ( Lobster . class ) . get ( 1 );
        Lobster lobster3 = getObjects ( Lobster . class ) . get ( 2 );
        lobster1 . setLocation ( 102 , 107 );
        lobster2 . setLocation ( 432 , 81 );
        lobster3 . setLocation ( 471 , 382 );
    }

    /**
     * Display the Crab's lives and current score
     */
    private void showLivesAndScore()
    {
        showText ( "Lives: " + livesRemaining , 50 , 20 );
        showText ( "Worms: " + wormsEaten , 150 , 20 );
    }

    /**
     * Crab loses a life when touched by a Lobster
     */
    public void loseLife()
    {
        livesRemaining = livesRemaining - 1;
        showLivesAndScore ( );
        if (livesRemaining != 0) {
            resetLobsterPositions ( );
            Crab crab = new Crab ( );
            addObject ( crab , 265 , 192 );
        }
        else {
            Greenfoot . stop ( );
        }
    }

    /**
     * Score increments when Crab touches a Worm
     */
    public void addWorm()
    {
        wormsEaten = wormsEaten + 1;
        showLivesAndScore ( );
    }
}
