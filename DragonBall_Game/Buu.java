import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buu here.
 * 
 * @author (Sai Harshith) 
 * @version (V 1.0 11/18/2018)
 */
public class Buu extends Actor
{
    int count = 0;
    /**
     * Act - do whatever the Buu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
      count++;
      if(count == 50){
    if (getY() == 105){
      setLocation(getX(), getY()+20);
      count =0;}// "if not at target y-coordinate, move toward target y-coordinate"
      else if (getY() > 105){
      setLocation(getX(), getY()-40);
      count =0;}// "if not at target y-coordinate, move toward target y-coordinate"
      else if (getY() < 105){
      setLocation(getX(), getY()+40);
      count =0;}
    }
    }    
}
