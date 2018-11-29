/**
 * Write a description of class UserDetails here.
 * 
 * @author (Shabari Girish Ganapathy) 
 * @version (a version number or a date)
 */
import java.util.*;

public class UserDetails  
{
    private static UserDetails obj; 
    private static String userName;
    private static long t1;
    private static long t2;
    // private constructor to force use of 
    // getInstance() to create Singleton object 
    private UserDetails() {} 
  
    public static UserDetails getInstance() 
    { 
        if (obj==null) 
            obj = new UserDetails(); 
        return obj; 
    }
    
    public static void setUserName(String name)
    {
        userName = name;
    }
    
    public static String getUserName()
    {
        return userName;
    }
    
    public static void setT1()
    {
        Date d = new Date();
        t1 = d.getTime();
    }
    
    public static void setT2()
    {
        Date d = new Date();
        t2 = d.getTime();
    }
    
    public static String getScore()
    {
        return Integer.toString((int)(t2-t1)/1000)+"s";
    }
}
