    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    import java.net.*;
    import java.io.*;
    import java.util.*;
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
            GreenfootImage img = new GreenfootImage(300, 500);
            
            img.setColor(new Color(0,0,0,0));
            img.fill();
            img.setColor(Color.WHITE);
            img.setFont(new Font("OptimusPrinceps", false, false , 25));
            
            if(!this.scoreboard.equals("No Connection")){  
                String arr[] = this.scoreboard.split(";");
                arr = sortScoreBoard(arr);
                int y = 50;
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

        public String [] sortScoreBoard(String [] arr)
        {
            Arrays.sort(arr, new Comparator<String>() {
                public int compare(String str1, String str2) {
                    //String substr1 = str1.substring(str1.length()-3,str1.length()-1);
                    //String substr2 = str2.substring(str1.length()-3,str1.length()-1);
                    String substr1[] = str1.split(":");
                    String substr2[] = str2.split(":");
                    return -(Integer.valueOf(substr2[1].replace("s","")).compareTo(Integer.valueOf(substr1[1].replace("s",""))));
                }
            });

            return arr;
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
