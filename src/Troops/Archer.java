package Troops;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * @author Carson Forsyth
 * @version 11/28/19
 */
public class Archer extends Troop{
	private static final ImageIcon ARCHER_IMG = new ImageIcon("Resources/Game Images/Troops/archer.png");
	
	public Archer(Point p) {
		super(p);
	}

	public Image getImage() {
		return ARCHER_IMG.getImage();
	}
}
