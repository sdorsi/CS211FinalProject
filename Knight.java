package CS211FINAL;

import java.awt.Point;

public class Knight extends Enemy
{
    /**
     * Constructor for objects of class Knight
     */
    public Knight(int x, int y, Point[]inTargets,Player inP)
    {
        super(x,y,3,3,3,6,inTargets,inP);
    }   
    
    public void ability()
    {
        
    }
    
    @Override
    public String toString()
    {
        return "Knight";
    }
}
