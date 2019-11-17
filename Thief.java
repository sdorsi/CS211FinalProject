package CS211FINAL;

import java.awt.Point;

public class Thief extends Enemy
{
    /**
     * Constructor for objects of class Thief
     */
    public Thief(int x, int y, Point[]inTargets,Player inP)
    {
        super(x,y,2,2,6,8,inTargets,inP);
    }   
    
    public void ability()
    {
        
    }
    
    @Override
    public String toString()
    {
        return "Thief";
    }
}
