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
        count++;
        //int diff = this.goku.getY()-this.getY(); 
        if(count%20==0)
        attackGoku();
      
    } 
    public void attackGoku(){
        if(gettime.TimeElapsed() > 100){
            World world = getWorld();
            FriezaFire ff = new FriezaFire();
            world.addObject(ff, this.getX()+this.getImage().getWidth()/2, this.getY());
            gettime.fire();
            

    
}
}   
}
