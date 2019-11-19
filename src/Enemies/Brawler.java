package Enemies;

import java.awt.Point;

import javax.swing.ImageIcon;

import Game.Player;

public class Brawler extends Enemy
{
	private static final ImageIcon img = new ImageIcon("Resources/brawler.jpg");
    /**
     * Constructor for objects of class Brawler
     */
    public Brawler(int x, int y, Point[]inTargets,Player inP)
    {
        super(x,y,1,1,1,5, img, inTargets,inP);
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