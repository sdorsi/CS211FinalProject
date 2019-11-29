package Troops;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

/**
 * @author Carson Forsyth
 * @version 11/18/19
 */
public abstract class Troop {
	private static final int WIDTH = 40;
	private static final int HEIGHT = 40;
	private int x, y;
	
	public Troop(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public static int getWidth() {
		return WIDTH;
	}
	
	public static int getHeight() {
		return HEIGHT;
	}
	
	public void draw(Graphics g) {
		g.drawImage(getImage(), this.x, this.y, WIDTH, HEIGHT, null);
	}
	
	public abstract Image getImage();
}