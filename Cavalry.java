package CS211FINAL;

import java.awt.Point;

public class Cavalry extends Enemy
{
    /**
     * Constructor for objects of class Cavalry
     */
    public Cavalry(int x, int y, Point[]inTargets,Player inP)
    {
        super(x,y,5,5,8,3,inTargets,inP);
    }   
    
    public void ability()
    {
        
    }
    
    @Override
    public String toString()
    {
        return "Cavalry";
    }
}
