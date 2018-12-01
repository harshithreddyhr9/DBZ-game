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
    
    //private CurrentHealth currHealth;
    private HealthBar hbar;
    private LivesIterator lifeIter;
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
    public int min_y = 1320;
    public int max_y = 1330;
    public int min_x = 90;
    public int max_x = 500;
    private Health100 hbar100;
    public UserDetails user;
    
    public int ballsCollected = 0;
    public int ballsNeeded = 7;
    
    public Level2(CurrentLevel l)
    {    
        super(1240, 640, 1, false);
        hbar = new HealthBar();
        hbar100 = new Health100();
        img0 = new Background();    // first background image
        addObject(img0, getWidth()/2, getHeight()/2);   // place middle
        img1 = new Background();    // second background image
        addObject(img1, getWidth() + getWidth()/2, getHeight()/2);
        
        //currHealth = new CurrentHealth();
        //hbar = currHealth.getCurrentHealth(0);  // health bar, num of hits 0
        addObject(hbar100, 500, 30);
        life1 = new Life();         // life counter
        addObject(life1, 100, 30);
        life2 = new Life();
        addObject(life2, 150, 30);
        life3 = new Life();
        addObject(life3, 200, 30);
        
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
            this.next.startWorld(lifeIter);
            user.setT2();
        }
        
        paint(scrollPosition,scrollSpeed);
        
        displayHealthBar();
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
        addObject(goku,422,200);
        
        Buu buu = new Buu(goku);
        addObject(buu, 90,135);
        
        Frieza f = new Frieza(goku);
        addObject(f,90,335);
        
        Cell c = new Cell(goku);
        addObject(c,90,535);
         GamePoints gamepoint = new GamePoints();
         HealthBar hbar = new HealthBar();
        ((PointsSubject)goku).attach(gamepoint);
        ((PointsSubject)goku).attach(hbar);
        addObject(hbar, 300,27);
        addObject(gamepoint, 296, 27);
        goku.setNoBalls(3);
        user = UserDetails.getInstance();
    }
    
    private void addBall()
    {
        oneBall = whichball.returnBall(currlevel);
        ballPosY = (int)(Math.random()*((max_y-min_y)+1))+min_y;
        ballPosX = (int)(Math.random()*((max_x-min_x)+1))+min_x;
        addObject(oneBall,ballPosY,ballPosX);
    }
    
    
    public void startWorld(LivesIterator li){
            Greenfoot.setWorld(this);
            lifeIter = li;
            addBall();
    }
    
    public void startNext(){
        this.next.startWorld(lifeIter);
    }
    
    public void setNextLevel(LevelHandler NextLevel){
        this.next = NextLevel;
    }
    
    public void displayLives()
    {
        showText("Lives:", 40, 30);
        //Goku goku = getObjects(Goku.class).get(0);
        //if (goku.countLives() == 2)
        if (lifeIter.currentItem() == 2)
        {
            removeObject(life3);
        }
        //else if (goku.countLives() == 1)
        else if (lifeIter.currentItem() == 1)
        {
            removeObject(life3);
            removeObject(life2);
        }
        //else if (goku.countLives() == 0)
        else if (lifeIter.currentItem() == 0)
        {
            removeObject(life3);
            removeObject(life2);
            removeObject(life1);
            addObject(new GameOver(),600,300);
            Greenfoot.stop();
        }
    }
    
    public void displayHealthBar()
    {
        Goku goku = getObjects(Goku.class).get(0);
        //removeObject(hbar);
        //hbar = currHealth.getCurrentHealth(goku.getNumOfHits());
        //addObject(hbar, 500, 30);
        if (goku.getNumOfHits() == 4)
        {
            //goku.loseLife();
            if (!lifeIter.isDone())
            {
                lifeIter.next();
            }
            goku.resetHitCount();
            //if (goku.countLives() > 0)
            if (lifeIter.currentItem() > 0)
            {
                hbar100 = new Health100();
                addObject(hbar100, 500, 30);
            }
        }
    }
}
