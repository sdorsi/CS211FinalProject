package Troops;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * @author Carson Forsyth
 * @version 11/28/19
 */
public class Catapult extends Troop {
	private static final ImageIcon CATAPULT_IMG = new ImageIcon("Resources/Game Images/Troops/catapult.png");
	
	public Catapult(Point p) {
		super(p);
	}

	public Image getImage() {
		return CATAPULT_IMG.getImage();
	}
}
