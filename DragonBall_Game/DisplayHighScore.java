import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DisplayHighScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DisplayHighScore extends Actor
{
    /**
     * Act - do whatever the DisplayHighScore wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public DisplayHighScore(String username)
    {
        GreenfootImage img = new GreenfootImage(400, 400);
        img.setColor(new Color(0,0,0,0));
        img.fill();
        img.setColor(Color.WHITE);
        img.setFont(new Font("OptimusPrinceps", false, false , 25));
        img.drawString(username, 35, 35);
        setImage(img);
    }
    
    public void act() 
    {
        // Add your action code here.
    }
    
}
