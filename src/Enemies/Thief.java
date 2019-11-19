package Enemies;

import java.awt.Point;

import javax.swing.ImageIcon;

import Game.Player;

public class Thief extends Enemy
{
	private static final ImageIcon img = new ImageIcon("Resources/thief.jpg");
    /**
     * Constructor for objects of class Thief
     */
    public Thief(int x, int y, Point[]inTargets, Player inP)
    {
        super(x,y,2,2,6,8, img, inTargets,inP);
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
