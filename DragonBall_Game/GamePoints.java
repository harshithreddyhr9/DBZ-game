import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class GamePoints extends Actor implements PointsObserver
{

    /**
     * Act - do whatever the GamePoints wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
    
    public void updatePoints(int points){
     getWorld().showText("Balls: " + points, 296, 27);   
}
}
