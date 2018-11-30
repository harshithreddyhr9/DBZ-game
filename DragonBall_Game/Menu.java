import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;
/**
 * Write a description of class Menu here.
 * 
 * @author Sai Harshith
 * @version (V 1.0 11/18/2018)
 */
public class Menu extends World
{
    //private GreenfootSound backgroundMusic;
    private Play buttonPlay;
    private Help buttonHelp;
    private PlayCommand playCmd;
    private HelpCommand helpCmd;
    private String bgImageName;
    public String username = null;
    
    private LivesAggregate lifeAgg;
    private LivesIterator lifeIter;
    
    LevelHandler level1;
    LevelHandler level2;
    LevelHandler levelOneSplash;
    LevelHandler levelTwoSplash;
    LevelHandler wish;
    LevelHandler highScore;
    CurrentLevel l;
    int count=0;

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {           
        super(1200, 675, 1,false); 
        GreenfootImage bg = new GreenfootImage("dbb.jpg");
        bg.scale(getWidth(),getHeight());
        setBackground(bg);
        
        buttonPlay = new Play();
        buttonHelp = new Help();
        playCmd = new PlayCommand();
        helpCmd = new HelpCommand();
        
        lifeAgg = new LivesAggImpl(3);
        lifeIter = lifeAgg.createIterator();

        l = new CurrentLevel();
        levelOneSplash = new LevelOneSplash(l);
        level1 = new Level1(l);
        levelTwoSplash = new LevelTwoSplash(l);
        level2 = new Level2(l);
        wish = new Wish(l);
        highScore = new HighScore(l);
        /**
         * Appending levels one after the other using
         * Chain of Responsibilty.
         */
        levelOneSplash.setNextLevel(level1);
        level1.setNextLevel(levelTwoSplash);
        levelTwoSplash.setNextLevel(level2);
        level2.setNextLevel(wish);
        wish.setNextLevel(highScore);
        
        UserDetails user = UserDetails.getInstance();
        
        while(username == null)
        {
            username = JOptionPane.showInputDialog("Enter User Name");
        }
        user.setUserName(username);
        prepare();
    }
    
    public void act()
    {
        
    }
    
    /**
     * Place the buttons in the world
     */
    public void prepare()
    {
        
        addObject(buttonPlay, 740,432);
        addObject(buttonHelp, 740,502);
        
        
        
            
        buttonPlay.setCommand(playCmd);
        buttonHelp.setCommand(helpCmd);
        
        playCmd.setReceiver(

            new Receiver()
            {
                public void performAction()
                {
                    if(Greenfoot.mouseClicked(buttonPlay)){
                        level1.startWorld(lifeIter);
                    }
                }
            });

        helpCmd.setReceiver(
            new Receiver()
            {
                public void performAction()
                {
                    if(Greenfoot.mouseClicked(buttonHelp)){
                        HelpScreen help = buttonHelp.getHelp();
                        addObject(help, getWidth()/2, getHeight()/2);

                        addObject(new Back(help),
                            (help.getX() - help.getImage().getWidth()/2)+15,
                            (help.getY() - help.getImage().getHeight()/2)+15);

                    }
                }
            }
        );


    }
}
