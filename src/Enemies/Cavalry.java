package Enemies;

import java.awt.Point;

import javax.swing.ImageIcon;

import Game.Player;

public class Cavalry extends Enemy
{
	private static final ImageIcon img = new ImageIcon("Resources/cavalry.jpg");
    /**
     * Constructor for objects of class Cavalry
     */
    public Cavalry(int x, int y, Point[]inTargets,Player inP)
    {
        super(x,y,5,5,8,3, img, inTargets,inP);
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
