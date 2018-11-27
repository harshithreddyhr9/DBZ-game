import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World implements LevelHandler
{
    private Background img0, img1;
    
    private Life life1, life2, life3;
    
    private static final String bgImageName = "newbg.png";    
    private static final double scrollSpeed = 7;
    private static final int picWidth = (new GreenfootImage(bgImageName)).getWidth();
    private GreenfootImage bgImage, bg;
    private int scrollPosition = 0;
    
    public LevelHandler next;
    public CurrentLevel currlevel;
    public WhichBall whichball;
    public DragonBall oneBall;
    public int ballPosX;
    public int ballPosY;
    public int min_y = 1300;
    public int max_y = 1350;
    public int min_x = 50;
    public int max_x = 500;
    
    public int ballsCollected = 0;
    public int ballsNeeded = 7;
    
    public Level2(CurrentLevel l)
    {    
        super(1240, 640, 1, false);
        
        img0 = new Background();    // first background image
        addObject(img0, getWidth()/2, getHeight()/2);   // place middle
        img1 = new Background();    // second background image
        addObject(img1, getWidth() + getWidth()/2, getHeight()/2);
        
        life1 = new Life();
        addObject(life1, 150, 30);
        life2 = new Life();
        addObject(life2, 200, 30);
        life3 = new Life();
        addObject(life3, 250, 30);
        
        //setBackground(bgImageName);
        setBackground(bgImageName);
        whichball = new WhichBall();
        //bgImage = new GreenfootImage(getBackground());
        //bg = new GreenfootImage(picWidth, getHeight());
        //bg.drawImage(bgImage, 0, 0);
        this.currlevel = l;
        prepare();
    }
    
    public void act(){
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
        
        displayLives();
        
        img0.scroll();
        img1.scroll();
    }
  
    private void paint(int position,double scrollSpeed)
    {
        //GreenfootImage bg = getBackground();
        //bg.drawImage(bg, position, 0);
        //bg.drawImage(bgImage, position + picWidth, 0);
        ballPosY -= (int) scrollSpeed;
        if(ballPosY <= 0)
        {
            addBall();
        }
        else
        {
            oneBall.setLocation(ballPosY,ballPosX);
        }
        oneBall.setLocation(ballPosY,ballPosX);
    } 
    
    private void prepare()
    {   
        Goku goku = new Goku(currlevel,this);
        addObject(goku,422,155);
        
        Buu buu = new Buu(goku);
        addObject(buu, 90,135);
        
        Frieza f = new Frieza(goku);
        addObject(f,90,335);
        
        Cell c = new Cell(goku);
        addObject(c,90,535);
        
    }
    
    private void addBall()
    {
        oneBall = whichball.returnBall(currlevel);
        ballPosY = (int)(Math.random()*((max_y-min_y)+1))+min_y;
        ballPosX = (int)(Math.random()*((max_x-min_x)+1))+min_x;
        addObject(oneBall,ballPosY,ballPosX);
    }
    
    
    public void startWorld(){
            Greenfoot.setWorld(this);
            addBall();
    }
    
    public void startNext(){
        this.next.startWorld();
    }
    
    public void setNextLevel(LevelHandler NextLevel){
        this.next = NextLevel;
    }
    
    public void displayLives()
    {
        showText("Lives:", 90, 30);
        Goku goku = getObjects(Goku.class).get(0);
        if (goku.countLives() == 2)
        {
            removeObject(life3);
        }
        else if (goku.countLives() == 1)
        {
            removeObject(life2);
        }
        else if (goku.countLives() == 0)
        {
            removeObject(life1);
            Greenfoot.stop();
        }
    }
}
