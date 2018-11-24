import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goku here.
 * 
 * @author (Sai Harshith) 
 * @version (V 1.0 11/18/2018)
 */
public class Goku extends Actor

{
    /**
     * Act - do whatever the Goku wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int ballscollected;
    private LivesAggregate lifeAgg;
    private LivesIterator lifeIter;

    /**
     * Initialise the Goku
     */
    public Goku()
    {
        ballscollected = 0;
        lifeAgg = new LivesAggImpl(3);
        lifeIter = lifeAgg.createIterator();    // set up lives iterator
    }
    public void act() 
    {
        checkKeyPress();
        lookForBalls();
    }    
    
    public void checkKeyPress()
    {
        if (Greenfoot.isKeyDown("up")){
             if(this.getY()-this.getImage().getHeight()/2 > 0)
                this.setLocation(this.getX(), this.getY() - 5);
        }
        if(Greenfoot.isKeyDown("down")){
            if(this.getY()+this.getImage().getHeight()/2 < getWorld().getHeight())
                this.setLocation(this.getX(), this.getY() + 5);
        }
    }

    public void lookForBalls()
    {
        
<<<<<<< HEAD
    }
    
    public Goku getGokuObject(){
        return this;
=======
    }  
    
    public void loseLife()
    {
        if (!lifeIter.isDone())
        {
            getWorld().showText("Lives: " + lifeIter.currentItem(), 100, 30);
            lifeIter.next();
        }
>>>>>>> 1d2e3655f204760b4864f62b46f4bcf64b6c4957
    }
}
