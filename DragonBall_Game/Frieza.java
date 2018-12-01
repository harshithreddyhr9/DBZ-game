import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Frieza here.
 * 
 * @author (Sai Harshith) 
 * @version (V 1.0 11/18/2018)
 */
public class Frieza extends Actor
{
    Timer gettime = new Timer();
    GreenfootSound fireball = new GreenfootSound("friezaaaa.wav");

    int count = 0;
    Goku goku;
    /**
     * Act - do whatever the Frieza wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Frieza(Goku goku){
        this.goku =goku;
    }
    public void act() 
    {
        int diff = this.goku.getY()-this.getY(); 
        if(-100<diff && diff<100)
        attackGoku();
      
    } 
    public void attackGoku(){
        if(gettime.TimeElapsed() > 1000){
            fireball.play();
            World world = getWorld();
            FriezaFire ff = new FriezaFire();
            world.addObject(ff, this.getX()+this.getImage().getWidth()/2, this.getY());
            gettime.fire();
            //Greenfoot.playSound("friezadeathball.wav");   //plays multiple times, causing loud noise

    
}
}   
}
