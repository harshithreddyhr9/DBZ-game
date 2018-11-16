import lang.stride.*;
import java.util.*;
import greenfoot.*;
import java.awt.Color;

/**
 * 
 */
public class DragonBallWorld extends World
{

    /**
     * 
     */
    public DragonBallWorld()
    {
        super(1260, 750, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Goku goku =  new  Goku();
        addObject(goku, 90, 650);
        Henchmen gohan = new Gohan();
        addObject(gohan, 60, 300);
        Henchmen vegeta = new Vegeta();
        addObject(vegeta, 60, 450);
        Dragonball star =  new  onestar();
        addObject(star,500, 600);
        Dragonball star2 =  new  twostar();
        addObject(star2, 612, 677);
        Dragonball star3 =  new  threestar();
        addObject(star3, 397, 322);
        Dragonball star4 =  new  fourstar();
        addObject(star4, 425, 148);
        Dragonball star5 =  new  fivestar();
        addObject(star5, 292, 68);
        Dragonball star6 =  new  sixstar();
        addObject(star6, 154, 106);
        Dragonball star7 =  new  sevenstar();
        addObject(star7, 292, 331);
        Villian buu =  new  Buu();
        addObject(buu, 702, 707);
        Villian freeza =  new  Freeza();
        addObject(freeza, 432, 81);
        Villian cell =  new  Cell();
        addObject(cell, 900, 450);
    }
}
