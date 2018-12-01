import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cell here.
 * 
 * @author (Sai Harshith) 
 * @version (V 1.0 11/18/2018)
 */
public class Cell extends Actor
{
    Timer gettime = new Timer();
    int count=0;
    Goku goku;
    GreenfootSound fireball = new GreenfootSound("cell.wav");
    /**
     * Act - do whatever the Cell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Cell(Goku goku){
        this.goku =goku;
    }
    public void act() 
    {
        
        count ++;
        int diff = this.goku.getY()-this.getY(); 
        if(-100<diff && diff<100)
        attackGoku();
      
    } 
    public void attackGoku(){
        fireball.play();
        if(gettime.TimeElapsed() > 1000){
            World world = getWorld();
            CellFire cf = new CellFire();
            world.addObject(cf, this.getX()+this.getImage().getWidth()/2, this.getY());
            gettime.fire();
            

    
}
}
}
