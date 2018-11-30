import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author Sai Harshith
 * @version (V 1.0 11/18/2018)
 */
public class Wish extends World implements LevelHandler
{
    
   
    public LevelHandler next;
    public CurrentLevel currlevel;
    int count=0;
    private shenronspeaks sp;
    private Gokuspeaks gp;
    private Piccolo p;
    private LivesIterator lifeIter;

    public Wish(CurrentLevel l)
    {    
        
        super(1200, 650, 1,false); 
        GreenfootImage bg = new GreenfootImage("dark.jpg");
        bg.scale(getWidth(),getHeight());
        setBackground(bg);
        this.currlevel = l;
        
        sp = new shenronspeaks();
        gp = new Gokuspeaks();
        p = new Piccolo();
        
        
        prepare();
    }
    
    public void act(){
    count++;
        if(count==25)
            addObject(sp,300,100);
        if(count==45)
            this.removeObject(sp);
        if(count==70)
            addObject(gp,850,450);
        if(count==100)
            removeObject(gp);
        if(count == 115)
            addObject(p, 750,550);
        if(count == 140)
            startNext();
    }
  
    private void prepare()
    {   
        
        
        
        
    }
    
    public void startWorld(LivesIterator li)
    {
        Greenfoot.setWorld(this);
        lifeIter = li;
    }
    
    public void setNextLevel(LevelHandler NextLevel)
    {
        this.next = NextLevel;
    }
    
    public void startNext(){
        this.next.startWorld(lifeIter);
    }
    
    public Wish getLevel(){
        return this;
    }
    
}
    
