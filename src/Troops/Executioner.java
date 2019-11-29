package Troops;

import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * @author Carson Forsyth
 * @version 11/28/19
 */
public class Executioner extends Troop {
	private static final ImageIcon EXECUTIONER_IMG = new ImageIcon("Resources/Game Images/Troops/executioner.png");
	
	public Executioner(Point p) {
		super(p);
	}

	public Image getImage() {
		return EXECUTIONER_IMG.getImage();
	}
}
