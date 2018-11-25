/**
 * Write a description of class CurrentLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CurrentLevel  
{
    // instance variables - replace the example below with your own
    private String level;
    private int nball;
    public CurrentLevel()
    {
        this.level = "level1";
        this.nball = 0;
    }
    
    public String getLevel()
    {
        return this.level;
    }
    
    public void setLevel(String level)
    {
        this.level = level;
    }
    
    public int getNBall()
    {  
        return this.nball;
    }
    
    public void incrementNBall()
    {
        this.nball += 1;
    }
}
