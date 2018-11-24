import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author Sai Harshith
 * @version (V 1.0 11/18/2018)
 */
public class Level1 extends World implements LevelHandler
{
    
    private static final String bgImageName = "bg2.png";    
    private static final double scrollSpeed = 5;
    private static final int picWidth = (new GreenfootImage(bgImageName)).getWidth();
    private GreenfootImage bgImage, bg;
    private int scrollPosition = 0;
    public LevelHandler next;
    public CurrentLevel currlevel;
    

    public DragonBall oneBall;
    public int ballPos = 600;


    
    public Level1(CurrentLevel l)
    {    
        
        super(1240, 542, 1, false);
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
        paint(scrollPosition,scrollSpeed);

        
    }
  
    private void paint(int position,double scrollSpeed)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(bg, position, 0);
        bg.drawImage(bgImage, position + picWidth, 0);
        ballPos -= (int) scrollSpeed;
        oneBall.setLocation(ballPos,135);
    } 
    
    private void prepare()
    {   
        Goku goku = new Goku(this);
        addObject(goku,422,135);
        
        Buu buu = new Buu(goku);
        addObject(buu, 90,105);
        
        Frieza f = new Frieza(goku);
        addObject(f,90,235);
        
        Cell c = new Cell(goku);
        addObject(c,90,435);
        
        oneBall = new One();
        addObject(oneBall,600,135);
        
    }
    
    public void startWorld()
    {
        Greenfoot.setWorld(this);
    }
    
    public void setNextLevel(LevelHandler NextLevel)
    {
        this.next = NextLevel;
    }
    
    public void startNext(){
        this.next.startWorld();
    }
    
    public Level1 getLevel()
    {
        return this;
    }
}
    
