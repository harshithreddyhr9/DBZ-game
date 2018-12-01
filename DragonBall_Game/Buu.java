import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buu here.
 * 
 * @author (Sai Harshith) 
 * @version (V 1.0 11/18/2018)
 */
public class Buu extends Actor
{
    
    Timer gettime = new Timer();
    int count=0;
    private World w = getWorld(); 
    Goku goku;
    GreenfootSound fireball = new GreenfootSound("buu.wav");
    
    /**
     * Act - do whatever the Buu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Buu(Goku goku){
        this.goku = goku;
    }
    public void act() 
    {
        
        int diff = this.goku.getY()-this.getY(); 
        if(-75<diff && diff<75)
        attackGoku();
      
    }
    
    public void attackGoku(){
        if(gettime.TimeElapsed() > 1000){
            fireball.play();
            World world = getWorld();
            BuuFire bf = new BuuFire();
            
            world.addObject(bf, this.getX()+this.getImage().getWidth()/2, this.getY());
            gettime.fire();
            

    
}
}
}

