import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World implements LevelHandler
{

    private static final String bgImageName = "newbg.png";    
    private static final double scrollSpeed = 7;
    private static final int picWidth = (new GreenfootImage(bgImageName)).getWidth();
    private GreenfootImage bgImage, bg;
    private int scrollPosition = 0;
    
    public LevelHandler next;
    public CurrentLevel currlevel;

    
    public Level2(CurrentLevel l)
    {    
        
        super(1440, 542, 1, false);
        setBackground(bgImageName);
        
        bgImage = new GreenfootImage(getBackground());
        bg = new GreenfootImage(picWidth, getHeight());
        bg.drawImage(bgImage, 0, 0);
        this.currlevel = l;
        prepare();
    }
       public void act()
    {
                scrollPosition -= scrollSpeed;
        while(scrollSpeed > 0 && scrollPosition < -picWidth) scrollPosition += picWidth;
        while(scrollSpeed < 0 && scrollPosition > 0) scrollPosition -= picWidth;
        paint(scrollPosition);
        
    }
  
    private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(bg, position, 0);
        bg.drawImage(bgImage, position + picWidth, 0);
    } 
    
    private void prepare()
    {   
        Goku goku = new Goku();
        addObject(goku,422,135);
        
        Buu buu = new Buu(goku);
        addObject(buu, 90,105);
        
        Frieza f = new Frieza(goku);
        addObject(f,90,235);
        
        Cell c = new Cell(goku);
        addObject(c,90,435);
        
        
    }
    
    
    public void startWorld()
    {
        if(this.currlevel.getLevel().equals("level1"))
            Greenfoot.setWorld(this);
    }
    
    public void setNextLevel(LevelHandler NextLevel)
    {
        this.next = NextLevel;
    }
}
