import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    public Text(String text)
    {
        GreenfootImage img = new GreenfootImage(200, 200);
            
        img.setColor(new Color(0,0,0,0));
        img.fill();
        img.setColor(Color.WHITE);
        img.setFont(new Font("OptimusPrinceps", false, false , 25));
        
        img.drawString(text, 35, 50);
        setImage(img);
    }
    
    
    public void act() 
    {
        // Add your action code here.
    }    
}
