package Enemies;

import java.awt.Point;

import javax.swing.ImageIcon;

import Game.Player;

public class Dragon extends Enemy
{
	private static final ImageIcon img = new ImageIcon("Resources/dragon.jpg");
    int lastTarget;
    public Dragon(int x, int y, Point[]inTargets,Player inP)
    {
        super(x,y,8,7,4,4, img, inTargets,inP);
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