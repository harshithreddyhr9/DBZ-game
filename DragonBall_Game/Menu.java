import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        
        
        super(1200, 650, 1,false); 
        GreenfootImage bg = new GreenfootImage("dbb.jpg");
        bg.scale(getWidth(),getHeight());
        setBackground(bg);
        
        buttonPlay = new Play();
        buttonHelp = new Help();
        playCmd = new PlayCommand();
        helpCmd = new HelpCommand();
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
                        Greenfoot.setWorld(new Level1());
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
                            help.getX() - help.getImage().getWidth()/2,
                            help.getY() - help.getImage().getHeight()/2);

                    }
                }
            }
        );


    }
}
