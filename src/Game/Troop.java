package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

/**
 * Protects the player's main base
 * 
 * @author Simon D'Orsi
 */
public class Troop
{
	private static final Image GUARD_IMG = new ImageIcon("Resources/Game Images/Troops/guard.png").getImage();
	private static final Image ARCHER_IMG = new ImageIcon("Resources/Game Images/Troops/archer.png").getImage();
	private static final Image EXECUTIONER_IMG = new ImageIcon("Resources/Game Images/Troops/executioner.png").getImage();
	private static final Image CATAPULT_IMG = new ImageIcon("Resources/Game Images/Troops/catapult.png").getImage();
	private static final Image WIZARD_IMG = new ImageIcon("Resources/Game Images/Troops/wizard.png").getImage();
	private static final int WIDTH = 40;
	private static final int HEIGHT = 40;
	
	/*
    public static Troop guard=new Troop(0,0,1,60,120, 1);
    public static Troop archer=new Troop(0,0,1,200,200, 2);
    public static Troop executioner = new Troop(0,0,1,60,120, 3);
    public static Troop catapult = new Troop(0,0,1,60,120, 4);
    public static Troop wizard = new Troop(0,0,1,60,120, 5);
	*/
    private int x,y,damage,radius,delay,initDelay, type;
    
    public Troop(Point p, int type) {
    	this(p.x, p.y, getDamageFromType(type), getRadiusFromType(type), getDelayFromType(type), type);
    }
    
    public int getType() {
    	return this.type;
    }
    
    /**
     * @param int x-location
     * @param int y-location
     * @param int damage
     * @param int radius of range
     * @param int delay for damage
     */
    private Troop(int inX,int inY,int inD,int inR,int inDelay, int type)
    {
        x=inX;
        y=inY;
        damage=inD;
        radius=inR;
        delay=-1;
        initDelay=inDelay;
        this.type = type;
    }
    
    private static int getDamageFromType(int type) {
    	switch(type) {
    	case 1:
    		return 1;
    	case 2:
    		return 2;
    	case 3:
    		return 4;
    	case 4:
    		return 4;
    	case 5:
    		return 5;
    	}
    	return -1;
    }
    
    private static int getRadiusFromType(int type) {
    	switch(type) {
    	case 1:
    		return 75;
    	case 2:
    		return 100;
    	case 3:
    		return 30;
    	case 4:
    		return 150;
    	case 5:
    		return 100;
    	}
    	return -1;
    }
    
    private static int getDelayFromType(int type) {
    	switch(type) {
    	case 1:
    		return 300;
    	case 2:
    		return 300;
    	case 3:
    		return 600;
    	case 4:
    		return 600;
    	case 5:
    		return 400;
    	}
    	return -1;
    }
    
    public static int getWidth() {
    	return WIDTH;
    }
    
    public static int getHeight() {
    	return HEIGHT;
    }
    
    public void setDelay(int i)
    {
        delay=i;
    }
    
    public int getDelay()
    {
        return delay;
    }
    
    public int getInitDelay()
    {
        return initDelay;
    }
    
    public int getRadius()
    {
        return radius;
    }
    
    public int getX()
    {
        return x;
    }
    
    public int getY()
    {
        return y;
    }
    
    public void setX(int inX)
    {
        x=inX;
    }
    
    public void setY(int inY)
    {
        y=inY;
    }
    
    public int getDamage()
    {
        return damage;
    }

    public void draw(Graphics g) {
    	switch(this.type) {
    	case 1:
    		g.drawImage(GUARD_IMG, x, y, WIDTH, HEIGHT, null);
    		break;
    	case 2:
    		g.drawImage(ARCHER_IMG, x, y, WIDTH, HEIGHT, null);
    		break;
    	case 3:
    		g.drawImage(EXECUTIONER_IMG, x, y, WIDTH, HEIGHT, null);
    		break;
    	case 4:
    		g.drawImage(CATAPULT_IMG, x, y, WIDTH, HEIGHT, null);
    		break;
    	case 5:
    		g.drawImage(WIZARD_IMG, x, y, WIDTH, HEIGHT, null);
    		break;
    	default:
    		System.out.println("default");
    		break;
    	}
    	
    	g.setColor(Color.WHITE);
    	g.drawRect(this.x + (WIDTH / 2) - this.radius, this.y + (HEIGHT / 2) - this.radius, this.radius * 2, this.radius * 2);
    }
}
