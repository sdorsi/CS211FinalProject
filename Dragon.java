package CS211FINAL;

import java.awt.Point;
public class Dragon extends Enemy
{
    int lastTarget;
    public Dragon(int x, int y, Point[]inTargets,Player inP)
    {
        super(x,y,8,7,4,4,inTargets,inP);
        lastTarget=inTargets.length-1;
        ability();//flies straight to player
    }   
    
    public void ability()
    {
        setCurrTargetIndex(lastTarget);
    }

    @Override
    public String toString()
    {
        return "Dragon";
    }
}