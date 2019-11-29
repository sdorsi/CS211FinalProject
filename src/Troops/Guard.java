package Troops;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * @author Carson Forsyth
 * @version 11/28/19
 */
public class Guard extends Troop {
	private static final ImageIcon GUARD_IMG = new ImageIcon("Resources/Game Images/Troops/guard.png");
	
	public Guard(Point p) {
		super(p);
	}

	public Image getImage() {
		return GUARD_IMG.getImage();
	}
}
