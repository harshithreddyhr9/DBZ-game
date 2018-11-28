/**
 * Write a description of class CurrentHealth here.
 * 
 * @author Chungchen Ran
 * @version 11/27/18
 */
public class CurrentHealth  
{
    private HealthBar hbar0, hbar25, hbar50, hbar75, hbar100;

    /**
     * Constructor for objects of class CurrentHealth
     */
    public CurrentHealth()
    {
        hbar0 = new Health0();
        hbar25 = new Health25();
        hbar50 = new Health50();
        hbar75 = new Health75();
        hbar100 = new Health100();
    }
    
    public HealthBar getCurrentHealth(int numOfHits)
    {
        switch (numOfHits)
        {
            case 0 : return hbar100;
            case 1 : return hbar75;
            case 2 : return hbar50;
            case 3 : return hbar25;
            case 4 : return hbar0;
            default : return hbar100;
        }
    }
}
