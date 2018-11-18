import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private Background img0, img1;
    private Goku goku;
    private Freeza frieza;
   
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1345, 542, 1, false); 
        
        img0 = new Background();
        addObject( img0, getWidth()/2, getHeight()/2);
        
        img1 = new Background();
        addObject(img1, getWidth() + getWidth()/2, getHeight()/2);
        
        goku = new Goku();
        addObject(goku, 350, 190);
        
        frieza = new Freeza();
        addObject(frieza, 70, 190);
        
        
    }

    
    public void act()
    {
        
            img0.scroll();
            img1.scroll();
            //goku.scroll();
        
        
        
    }
    
}


