    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    import java.net.*;
    import java.io.*;
    /**
     * Write a description of class DisplayHighScore here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class DisplayHighScore extends Actor
    {
    
        public String username;
        public String scoreboard;
        public DisplayHighScore(String username)
        {
            this.username = username;
            
            try{
                this.scoreboard = getScoreBoard();
            }catch(Exception E){
                //do nothing
            }
            finally{
                prepare();
            }
        }
        
        public void prepare()
        {
            GreenfootImage img = new GreenfootImage(800, 400);
            img.setColor(new Color(0,0,0,0));
            img.fill();
            img.setColor(Color.WHITE);
            img.setFont(new Font("OptimusPrinceps", false, false , 25));
            img.drawString(this.username, 35, 35);
            img.drawString(this.scoreboard,225,35);
            setImage(img);
        }
    
        public String getScoreBoard() throws Exception
        {
         URL url = new URL("http://127.0.0.1:5000/scoreboard");
         String line = "";
         BufferedReader reader = null;
         try {
             reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
             line= reader.readLine();
             reader.close();
         }catch(Exception e){
             line = "No Connection";
         }finally{
         }
         
         return line;
        }
    
        public void act() 
        {
            // Add your action code here.
        }
    
}
