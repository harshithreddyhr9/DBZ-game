import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cell here.
 * 
 * @author (Sai Harshith) 
 * @version (V 1.0 11/18/2018)
 */
public class Cell extends Actor
{
    int count = 0;
    /**
     * Act - do whatever the Cell wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
             count++;
      if(count == 50){
    if (getY() == 235){
      setLocation(getX(), getY()+20);
      count =0;}// "if not at target y-coordinate, move toward target y-coordinate"
      else if (getY() > 235){
      setLocation(getX(), getY()-40);
      count =0;}// "if not at target y-coordinate, move toward target y-coordinate"
      else if (getY() < 235){
      setLocation(getX(), getY()+40);
      count =0;}
    }
    }    
}
