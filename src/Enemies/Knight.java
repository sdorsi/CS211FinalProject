package Enemies;

import java.awt.Point;

import javax.swing.ImageIcon;

import Game.Player;

public class Knight extends Enemy
{
	private static final ImageIcon img = new ImageIcon("Resources/Game Images/Enemies/knight.png");
    /**
     * Constructor for objects of class Knight
     */
    public Knight(int x, int y, Point[]inTargets,Player inP)
    {
        super(x,y,3,3,3,6, inTargets,inP, img);
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
