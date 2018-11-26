import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Level1 here.
 * 
 * @author Sai Harshith
 * @version (V 1.0 11/18/2018)
 */
public class Level1 extends World implements LevelHandler
{
    private Background img0, img1;
    
    private static final String bgImageName = "bg2.png";    
    private static final double scrollSpeed = 5;
    private static final int picWidth = (new GreenfootImage(bgImageName)).getWidth();
    private GreenfootImage bgImage, bg;
    private int scrollPosition = 0;
    public LevelHandler next;
    public CurrentLevel currlevel;
    public WhichBall whichball;

    public DragonBall oneBall;
    public int ballPosX;
    public int ballPosY;
    public int min_y = 1250;
    public int max_y = 1300;
    public int min_x = 50;
    public int max_x = 500;
    public int ballsCollected = 0;
    public int ballsNeeded = 4;
    
    public Level1(CurrentLevel l)
    {    
        
        super(1240, 542, 1, false);
        
        img0 = new Background();    // first background image
        addObject(img0, getWidth()/2, getHeight()/2);   // place middle
        img1 = new Background();    // second background image
        addObject(img1, getWidth() + getWidth()/2, getHeight()/2);
        
        //setBackground(bgImageName);
        whichball = new WhichBall();
        //bgImage = new GreenfootImage(getBackground());
        //bg = new GreenfootImage(picWidth, getHeight());
        //bg.drawImage(bgImage, 0, 0);
        this.currlevel = l;
        prepare();
    }
    
       public void act()
    {
        scrollPosition -= scrollSpeed;

        while(scrollSpeed > 0 && scrollPosition < -picWidth) scrollPosition += picWidth;
        while(scrollSpeed < 0 && scrollPosition > 0) scrollPosition -= picWidth;
        
        if(currlevel.getNBall() != ballsCollected && currlevel.getNBall() != ballsNeeded)
        {
            ballsCollected = currlevel.getNBall();
            addBall();
        }
        
        if(currlevel.getNBall() == ballsNeeded)
        {
            this.next.startWorld();
        }
        paint(scrollPosition,scrollSpeed);
        
        img0.scroll();  // moves image slowly
        img1.scroll();  // moves image slowly
    }
  
    private void paint(int position,double scrollSpeed)
    {
        //GreenfootImage bg = getBackground();
        //bg.drawImage(bg, position, 0);
        //bg.drawImage(bgImage, position + picWidth, 0);
        ballPosY -= (int) scrollSpeed;
        oneBall.setLocation(ballPosY,ballPosX);
    } 
    
    private void prepare()
    {   
        Goku goku = new Goku(currlevel,this);
        addObject(goku,422,135);
        
        Buu buu = new Buu(goku);
        addObject(buu, 90,75);
        
        Frieza f = new Frieza(goku);
        addObject(f,90,235);
        
        Cell c = new Cell(goku);
        addObject(c,90,435);
        
       
    }
    
    private void addBall()
    {
        oneBall = whichball.returnBall(currlevel);
        ballPosY = (int)(Math.random()*((max_y-min_y)+1))+min_y;
        ballPosX = (int)(Math.random()*((max_x-min_x)+1))+min_x;
        addObject(oneBall,ballPosY,ballPosX);
    }
    
    public void startWorld()
    {
        Greenfoot.setWorld(this);
        addBall();
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
    
