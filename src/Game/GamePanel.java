package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import Enemies.Enemy;
import Troops.Archer;
import Troops.Catapult;
import Troops.Executioner;
import Troops.Guard;
import Troops.Troop;
import Troops.Wizard;

/**
 * @author Carson Forsyth
 * @version 11/28/19
 */
public class GamePanel extends JPanel {
	private static final ImageIcon START_IMG = new ImageIcon("Resources/Game Images/Menu Items/start.png");
	private static final ImageIcon GUARD_IMG = new ImageIcon("Resources/Game Images/Troops/guard.png");
	private static final ImageIcon ARCHER_IMG = new ImageIcon("Resources/Game Images/Troops/archer.png");
	private static final ImageIcon EXECUTIONER_IMG = new ImageIcon("Resources/Game Images/Troops/executioner.png");
	private static final ImageIcon CATAPULT_IMG = new ImageIcon("Resources/Game Images/Troops/catapult.png");
	private static final ImageIcon WIZARD_IMG = new ImageIcon("Resources/Game Images/Troops/wizard.png");
	
	private GameFieldPanel gfp;
	private JPanel toolBar, troopBar, infoBar;
	private JButton start;
	
	private Polygon[] noGoZones;
	private ArrayList<Troop> troops;
	private JButton guard, archer, executioner, catapult, wizard;
	private ArrayList<Enemy> enemies;
	private int money, health, wave;
	private GameActions clickAction;

	public GamePanel(int width, int height, String map) {
 		this.clickAction = GameActions.NONE;
 		this.enemies = new ArrayList<Enemy>();
		this.troops = new ArrayList<Troop>();
		switch(map) {
		case "map1":
			this.noGoZones = MapBounds.map1;
			break;
		case "map2":
			this.noGoZones = MapBounds.map2;
			break;
		}
		
		map += ".png";
		this.setLayout(null);
		
		gfp = new GameFieldPanel(700, 700, map);
		gfp.setBackground(Color.blue);
		gfp.addMouseListener(new MouseActionListener());
		gfp.setBounds(0, 0, 700, 700);
		this.add(gfp);
		
		toolBar = new JPanel();
		toolBar.setLayout(new BorderLayout());
		toolBar.setBounds(700, 0, 200, 700);

		infoBar = new JPanel();
		infoBar.setBackground(Color.green);
		infoBar.setLayout(new GridLayout(2, 2));
		JLabel money = new JLabel("Money");
		money.setFont(new Font("Arial", Font.PLAIN, 24));
		infoBar.add(money);
		JLabel health = new JLabel("Health");
		health.setFont(new Font("Arial", Font.PLAIN, 24));
		infoBar.add(health);
		JLabel wave = new JLabel("Wave");
		wave.setFont(new Font("Arial", Font.PLAIN, 24));
		infoBar.add(wave);
		start = new JButton(START_IMG);
		start.addActionListener(new StartListener());
		infoBar.add(start);
		toolBar.add(infoBar, BorderLayout.NORTH);
		
		troopBar = new JPanel();
		troopBar.setBackground(Color.orange);
		troopBar.setLayout(new GridLayout(3, 2));
		
		guard = new JButton(GUARD_IMG);
		guard.addActionListener(new GuardListener());
		troopBar.add(guard);
		archer = new JButton(ARCHER_IMG);
		archer.addActionListener(new ArcherListener());
		troopBar.add(archer);
		executioner = new JButton(EXECUTIONER_IMG);
		executioner.addActionListener(new ExecutionerListener());
		troopBar.add(executioner);
		catapult = new JButton(CATAPULT_IMG);
		catapult.addActionListener(new CatapultListener());
		troopBar.add(catapult);
		wizard = new JButton(WIZARD_IMG);
		wizard.addActionListener(new WizardListener());
		troopBar.add(wizard);
		
		toolBar.add(troopBar, BorderLayout.CENTER);
		
		this.add(this.toolBar);
	}
	
	private class StartListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	private class GuardListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			clickAction = GameActions.GUARD_SELECTED;
		}
	}
	
	private class ArcherListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			clickAction = GameActions.ARCHER_SELECTED;
		}
	}
	
	private class ExecutionerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			clickAction = GameActions.EXECUTIONER_SELECTED;
		}
	}
	
	private class CatapultListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			clickAction = GameActions.CATAPULT_SELECTED;
		}
	}
	
	private class WizardListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			clickAction = GameActions.WIZARD_SELECTED;
		}
	}
	
	private class MouseActionListener implements MouseListener {
		public void mouseClicked(MouseEvent me) {
			Point p = me.getPoint();
			if(isValidPlacementLocation(p)) {
				if(clickAction == GameActions.GUARD_SELECTED) {
					Guard g = new Guard(new Point(p.x - (Troop.getWidth() / 2), p.y - (Troop.getHeight() / 2)));
					troops.add(g);
					clickAction = GameActions.NONE;
				}
				else if(clickAction == GameActions.ARCHER_SELECTED) {
					Archer a = new Archer(new Point(p.x - (Troop.getWidth() / 2), p.y - (Troop.getHeight() / 2)));
					troops.add(a);
					clickAction = GameActions.NONE;
				}
				else if(clickAction == GameActions.EXECUTIONER_SELECTED) {
					Executioner e = new Executioner(new Point(p.x - (Troop.getWidth() / 2), p.y - (Troop.getHeight() / 2)));
					troops.add(e);
					clickAction = GameActions.NONE;
				}
				else if(clickAction == GameActions.CATAPULT_SELECTED) {
					Catapult c = new Catapult(new Point(p.x - (Troop.getWidth() / 2), p.y - (Troop.getHeight() / 2)));
					troops.add(c);
					clickAction = GameActions.NONE;
				}
				else if(clickAction == GameActions.WIZARD_SELECTED) {
					Wizard w = new Wizard(new Point(p.x - (Troop.getWidth() / 2), p.y - (Troop.getHeight() / 2)));
					troops.add(w);
					clickAction = GameActions.NONE;
				}
			}
		}

		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	
	private boolean isValidPlacementLocation(Point p) {
		for(Polygon poly : this.noGoZones) {
			if(poly.intersects(new Rectangle(p.x - (Troop.getWidth() / 2), p.y - (Troop.getHeight() / 2), Troop.getWidth(), Troop.getWidth()))) {
				return false;
			}
		}
		return true;
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

	
	
	
	
	
	
	
	private class GameFieldPanel extends JPanel {
		private int width, height;
		private String map;
		private BufferedImage myImage;
		private Graphics myBuffer;
		private Timer t;
		
		public GameFieldPanel(int width, int height, String map) {
			this.width = width;
			this.height = height;
			this.map = map;
			troops = new ArrayList<Troop>();
			myImage = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
			myBuffer = myImage.getGraphics();
			t = new Timer(0, new GameListener());
			t.start();
		}
		
		private class GameListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				myBuffer.drawImage(new ImageIcon("Resources/Maps/" + map).getImage(), 0, 0, width, height, null);
				for(Troop t : troops) {
					t.draw(myBuffer);
				}
				repaint();
			}
		}
		
		public void paintComponent(Graphics g) {
			g.drawImage(myImage, 0, 0, this.getWidth(), this.getHeight(), null);
		}
	}
}