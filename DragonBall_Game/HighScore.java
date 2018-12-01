import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.net.*;
import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;
/**
 * Write a description of class HighScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class HighScore extends World implements LevelHandler
{

    public LevelHandler next;
    public UserDetails user;
    private LivesIterator lifeIter;
    
    public HighScore(CurrentLevel l)
    {    
        // Create a new world with 1200x650 cells with a cell size of 1x1 pixels.
        super(1200, 650, 1);
    }
    
    public void act()
    {
        //do nothing as its a static screen;
    }
    
    public void prepare()
    {
       user = UserDetails.getInstance();
       String name = user.getUserName();
       String score = user.getScore();
       try{
           sendData(name,score.replace("s",""));
       }catch(Exception e){
           //do nothing
       }
       addObject(new Text("Scoreboard"),600,100);
       addObject(new DisplayHighScore(user.getUserName(),0),600,300);
       addObject(new DisplayHighScore(user.getScore(),1),800,300);
    }
    
    
    public void sendData(String username,String score) throws Exception
    {
       StringBuffer buf = new StringBuffer();
       buf.append("{\"username\":\"");buf.append(username);buf.append("\",");
       buf.append("\"score\":\"");buf.append(score);buf.append("\"}");
       String json_str = buf.toString();
       
       URL url = new URL("http://18.216.182.74:5000/scoreboard");
       URLConnection con = url.openConnection();
       HttpURLConnection http = (HttpURLConnection)con;
       http.setRequestMethod("POST"); // PUT is another valid option
       http.setDoOutput(true);
       
       byte[] out = json_str.getBytes(StandardCharsets.UTF_8);
       int length = out.length;
		
       http.setFixedLengthStreamingMode(length);
       http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
       http.connect();
       
       OutputStream os = http.getOutputStream();
       os.write(out);
       os.close();
    }
    
    public void startWorld(LivesIterator li)
    {
        Greenfoot.setWorld(this);
        lifeIter = li;
        prepare();
    }
    
    public void setNextLevel(LevelHandler NextLevel)
    {
        this.next = NextLevel;
    }
    
    public void startNext(){
        this.next.startWorld(lifeIter);
    }
}
