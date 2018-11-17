import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class LevelTwo extends World implements LevelHandler
{

    LevelHandler next;
    CurrentLevel level;
    /**
     * Constructor for objects of class LevelTwo.
     */
    public LevelTwo(CurrentLevel l)
    {
        super(800, 800, 1);
        this.level = l;
        prepare();
    }
    
    public void startWorld()
    {
        //do nothing for now
    }
    
    private void prepare()
    {
        Crab crab =  new Crab();
        addObject(crab, 265, 192);
        Worm worm =  new Worm();
        addObject(worm, 529, 111);
        Worm worm2 =  new Worm();
        addObject(worm2, 512, 277);
        Worm worm3 =  new Worm();
        addObject(worm3, 397, 322);
        Worm worm4 =  new Worm();
        addObject(worm4, 425, 148);
        Worm worm5 =  new Worm();
        addObject(worm5, 292, 68);
        Worm worm6 =  new Worm();
        addObject(worm6, 154, 106);
        Worm worm7 =  new Worm();
        addObject(worm7, 292, 331);
        Worm worm8 =  new Worm();
        addObject(worm8, 164, 357);
        Worm worm9 =  new Worm();
        addObject(worm9, 112, 260);
        Worm worm10 =  new Worm();
        addObject(worm10, 87, 38);
        Lobster lobster =  new Lobster();
        addObject(lobster, 102, 107);
        Lobster lobster2 =  new Lobster();
        addObject(lobster2, 432, 81);
        Lobster lobster3 =  new Lobster();
        addObject(lobster3, 471, 382); 
    }
    
    public void setNextLevel(LevelHandler NextLevel)
    {
        this.next = NextLevel;
    }
}
