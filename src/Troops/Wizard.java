package Troops;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * @author Carson Forsyth
 * @version 11/28/19
 */
public class Wizard extends Troop {
	private static final ImageIcon WIZARD_IMG = new ImageIcon("Resources/Game Images/Troops/wizard.png");
	
	public Wizard(Point p) {
		super(p);
	}

	public Image getImage() {
		return WIZARD_IMG.getImage();
	}
}