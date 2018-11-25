/**
 * Write a description of class WhichBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WhichBall  
{
    // instance variables - replace the example below with your own
    private DragonBall one;
    private DragonBall two;
    private DragonBall three;
    private DragonBall four;
    private DragonBall five;
    private DragonBall six;
    private DragonBall seven;
    
    public WhichBall()
    {
        one = new One();
        two = new Two();
        three = new Three();
        four = new Four();
        five = new Five();
        six = new Six();
        seven = new Seven();
    }
    
    public DragonBall returnBall(CurrentLevel l)
    {
        switch(l.getNBall())
        {
            case 0 : return one;
            case 1 : return two;
            case 2 : return three; 
            case 3 : return four;
            case 4 : return five;
            case 5 : return six;
            case 6 : return seven;
            default : return one;
        }
    }
}
