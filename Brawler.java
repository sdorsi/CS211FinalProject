package CS211FINAL;

import java.awt.Point;
public class Brawler extends Enemy
{
    /**
     * Constructor for objects of class Brawler
     */
    public Brawler(int x, int y, Point[]inTargets,Player inP)
    {
        super(x,y,1,1,1,5,inTargets,inP);
    }   
    
    public void ability()
    {
        
    }
    
    @Override
    public String toString()
    {
        return "Brawler";
    }

}