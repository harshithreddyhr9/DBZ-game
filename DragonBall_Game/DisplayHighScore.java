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
    
        public String text;
        public String scoreboard;
        public DisplayHighScore(String text,int index)
        {
            this.text = text;
            try{
                this.scoreboard = getScoreBoard();
            }catch(Exception E){
                //do nothing
            }
            finally{
                prepare(index);
            }
        }
        
        public void prepare(int index)
        {
            GreenfootImage img = new GreenfootImage(300, 300);
            
            img.setColor(new Color(0,0,0,0));
            img.fill();
            img.setColor(Color.WHITE);
            img.setFont(new Font("OptimusPrinceps", false, false , 25));
            
            img.drawString(text, 35, 50);
            if(!this.scoreboard.equals("No Connection")){  
                String arr[] = this.scoreboard.split(";");
                int y = 100;
                for(String s : arr){
                    String temp[] = s.split(":");
                    img.drawString(temp[index],35,y);
                    y += 35;
                    //System.out.println(s);
                }
            }else{
                img.drawString(this.scoreboard,35,100);
            }
            setImage(img);
        }
    
        public String getScoreBoard() throws Exception
        {
         URL url = new URL("http://18.216.182.74:5000/scoreboard");
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
