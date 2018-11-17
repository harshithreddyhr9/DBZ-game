import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class AppMain extends World
{

    /**
     * Constructor for objects of class AppMain.
     */
    LevelHandler level1;
    LevelHandler level2;
    CurrentLevel l;
    public AppMain()
    {
        super(800,800, 1);
        l = new CurrentLevel();
        level1 = new CrabWorld(l);
        level2 = new LevelTwo(l);
        
        /**
         * Appending levels one after the other using
         * Chain of Responsibilty.
         */
        level1.setNextLevel(level2);
        
        level1.startWorld();
    }
   
}
