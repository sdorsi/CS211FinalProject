package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Enemies.Enemy;

/**
 * @author Carson Forsyth
 * @version 11/17/19
 */
public class GamePanel extends JPanel {
	private static final ImageIcon START_IMG = new ImageIcon("Resources/Game Images/Menu Items/start.png");
	
	private int width, height;
	private BufferedImage myImage;
	private Graphics myBuffer;
	private Timer t;
	private GameFieldPanel gfp;
	private JPanel toolBar, troopBar, infoBar;
	private JButton start;
	
//	private ArrayList<Troop> troops;
	private ArrayList<Enemy> enemies;
	private int money, health, wave;
	private String map;

	public GamePanel(int width, int height, String map) {
		this.width = width;
		this.height = height;
		this.map = map;
		myImage = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
		myBuffer = myImage.getGraphics();
		t = new Timer(0, new MainGameListener());
		this.setLayout(new BorderLayout());
		
		gfp = new GameFieldPanel(this.width, this.height, map);
		gfp.setBackground(Color.blue);
		this.add(gfp, BorderLayout.CENTER);
		
		toolBar = new JPanel();
		toolBar.setLayout(new BorderLayout());
		toolBar.setBackground(Color.yellow);

		infoBar = new JPanel();
		infoBar.setBackground(Color.green);
		infoBar.setLayout(new GridLayout(2, 2));
		infoBar.add(new JLabel("Money"));
		infoBar.add(new JLabel("Health"));
		infoBar.add(new JLabel("Wave"));
		start = new JButton(START_IMG);
		start.addActionListener(new StartListener());
		infoBar.add(start);
		toolBar.add(infoBar, BorderLayout.NORTH);
		
		troopBar = new JPanel();
		troopBar.setBackground(Color.orange);
		troopBar.setLayout(new GridLayout(3, 2));
		troopBar.add(new JLabel("Guard"));
		troopBar.add(new JLabel("Archer"));
		troopBar.add(new JLabel("Axe Dude"));
		troopBar.add(new JLabel("Catapult"));
		troopBar.add(new JLabel("Wizard"));
		toolBar.add(troopBar, BorderLayout.CENTER);
		
		this.add(this.toolBar, BorderLayout.EAST);
	}
	
	// dynamic movement and redrawing of the game field
	private class MainGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for(Enemy en : enemies) {
				en.draw(myBuffer);
			}
			
			repaint();
		}
	}
	
	private class StartListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	// used to draw the images to the screen
	public void paintComponent(Graphics g) {
		g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
	}
	
	public void save() {
		/*
		 creates the data file that can be used to save a game in the format:
		 <amount of money>
		 <base health>
		 <current wave>
		 <troop1 type (space) troop1 x location (space) troop1 y location>
		 <troop2 type (space) troop2 x location (space) troop2 y location>
		 <troop3 type (space) troop3 x location (space) troop3 y location>
		 ...
		 <troopN type (space) troopN x location (space) troopN y location>
		*/
		String data = "";
		data += this.money + "\n";
		data += this.health + "\n";
		data += this.wave + "\n";
		/*
		for(Troop t : this.troops) {
			data += t.getName + " " + t.getX() + " " + t.getY();
		}
		*/
	}
}