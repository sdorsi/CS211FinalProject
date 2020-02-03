package Enemies;

import java.awt.Point;

import javax.swing.ImageIcon;

import Game.Player;

public class Thief extends Enemy
{
	private static final ImageIcon img = new ImageIcon("Resources/Game Images/Enemies/thief.png");

    private int targetX,targetY;
    private boolean hasStolen,steal;
    
    /**
     * Constructor for objects of class Thief
     */
    public Thief(int x, int y, Point[]inTargets,Player inP)
    {
        super(x,y,5,2,10,8, inTargets,inP, img);
        hasStolen=false;
        steal=false;
        targetX=(int)inTargets[inTargets.length-1].getX();
        targetY=(int)inTargets[inTargets.length-1].getY();
    }   

    public void ability()
    {
        //steals money from player
        if(!steal && attacking)
        {
            steal=true;
        }
    }

    public int stealFromPlayer(int money)
    {
        if(!hasStolen&&steal)
        {
            hasStolen=true;
            return money-10;
        }
        return money;
    }
    
    @Override
    public String toString()
    {
        return "Thief";
    }
}