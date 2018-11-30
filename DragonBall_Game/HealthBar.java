import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author Chungchen Ran
 * @version 11/27/18
 */
public class HealthBar extends Actor implements PointsObserver
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public void act() 
    {
        // Add your action code here.
    }   
    
    
      public void updatePoints(int points, int hits){
	    Health0 hbar0 = new Health0();	
	    Health25 hbar25 = new Health25();
	    Health50 hbar50 = new Health50();
	    Health75 hbar75 = new Health75();
	    Health100 hbar100 = new Health100();
             switch(hits)
             {   
            case 0 : {getWorld().addObject(hbar100,500, 30);
                break;}
            
            case 1 : {
                getWorld().addObject(hbar75,500, 30);
                break;}
            case 2 : {getWorld().addObject(hbar50,500, 30);
                break;}
            case 3 : {getWorld().addObject(hbar25,500, 30);
             break;}
            case 4 : {getWorld().addObject(hbar0,500, 30);
                break;}
            default : getWorld().addObject(hbar100,500, 30);     
}
}
}
