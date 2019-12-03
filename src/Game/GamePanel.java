package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
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

import Enemies.Brawler;
import Enemies.Cavalry;
import Enemies.Dragon;
import Enemies.Enemy;
import Enemies.Knight;
import Enemies.Thief;

/**
 * @author Carson Forsyth
 * @version 11/29/19
 */
public class GamePanel extends JPanel {
	private static final ImageIcon START_IMG = new ImageIcon("Resources/Game Images/Menu Items/start.png");
	private static final ImageIcon GUARD_IMG = new ImageIcon("Resources/Game Images/Troops/guard.png");
	private static final ImageIcon ARCHER_IMG = new ImageIcon("Resources/Game Images/Troops/archer.png");
	private static final ImageIcon EXECUTIONER_IMG = new ImageIcon("Resources/Game Images/Troops/executioner.png");
	private static final ImageIcon CATAPULT_IMG = new ImageIcon("Resources/Game Images/Troops/catapult.png");
	private static final ImageIcon WIZARD_IMG = new ImageIcon("Resources/Game Images/Troops/wizard.png");
	
	private GameFieldPanel gfp;
	private ArrayList<Troop> troops;
	private JPanel toolBar, troopBar, infoBar;
	private JButton guard, archer, executioner, catapult, wizard, start;
	private JLabel moneyLabel, healthLabel, waveLabel;
	private Polygon[] noGoZones;
	private GameActions clickAction;
	private Player player;
	private int wave;

	public GamePanel(int width, int height, String map) {
 		this.clickAction = GameActions.NONE;
		this.troops = new ArrayList<Troop>();
		this.wave = 0;
		switch(map) {
		case "map1":
			this.noGoZones = MapBounds.map1;
			break;
		case "map2":
			this.noGoZones = MapBounds.map2;
			break;
		}
		player = new Player(100, 200);
		
		map += ".png";
		this.setLayout(null);
		
		gfp = new GameFieldPanel(700, 700, map);
		gfp.setBackground(Color.DARK_GRAY);
		gfp.addMouseListener(new MouseActionListener());
		gfp.setBounds(0, 0, 700, 700);
		this.add(gfp);
		
		toolBar = new JPanel();
		toolBar.setLayout(new BorderLayout());
		toolBar.setBounds(700, 0, 200, 700);

		infoBar = new JPanel();
		infoBar.setBackground(Color.DARK_GRAY);
		infoBar.setLayout(new GridLayout(2, 2));
		moneyLabel = new JLabel("Money: " + player.getMoney());
		moneyLabel.setForeground(Color.WHITE);
		moneyLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		infoBar.add(moneyLabel);
		healthLabel = new JLabel("Health: " + player.getLife());
		healthLabel.setForeground(Color.WHITE);
		healthLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		infoBar.add(healthLabel);
		waveLabel = new JLabel("Wave: " + (this.wave + 1));
		waveLabel.setForeground(Color.WHITE);
		waveLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		infoBar.add(waveLabel);
		start = new JButton(START_IMG);
		start.addActionListener(new StartListener());
		infoBar.add(start);
		toolBar.add(infoBar, BorderLayout.NORTH);
		
		troopBar = new JPanel();
		troopBar.setBackground(Color.DARK_GRAY);
		troopBar.setLayout(new GridLayout(3, 2));
		
		ImageIcon scaledGuard = new ImageIcon(GUARD_IMG.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		guard = new JButton(scaledGuard);
		guard.addActionListener(new GuardListener());
		troopBar.add(guard);
		ImageIcon scaledArcher = new ImageIcon(ARCHER_IMG.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		archer = new JButton(scaledArcher);
		archer.addActionListener(new ArcherListener());
		troopBar.add(archer);
		ImageIcon scaledExecutioner = new ImageIcon(EXECUTIONER_IMG.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		executioner = new JButton(scaledExecutioner);
		executioner.addActionListener(new ExecutionerListener());
		troopBar.add(executioner);
		ImageIcon scaledCatapult = new ImageIcon(CATAPULT_IMG.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		catapult = new JButton(scaledCatapult);
		catapult.addActionListener(new CatapultListener());
		troopBar.add(catapult);
		ImageIcon scaledWizard = new ImageIcon(WIZARD_IMG.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
		wizard = new JButton(scaledWizard);
		wizard.addActionListener(new WizardListener());
		troopBar.add(wizard);
		
		toolBar.add(troopBar, BorderLayout.CENTER);
		
		this.add(this.toolBar);
	}
	
	private void updateMoneyLabel() {
		moneyLabel.setText("Money: " + player.getMoney());
	}
	private void updateHealthLabel() {
		healthLabel.setText("Health: " + player.getLife());
	}
	private void updateWaveLabel() {
		waveLabel.setText("Wave: " + (this.wave));
	}
	
	private class StartListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			start.setEnabled(false);
			wave++;
			updateWaveLabel();
			gfp.resetEnemySpawnIndex();
			gfp.restartEnemySpawnTimer();
			gfp.restartMainGameTimer();
		}
	}
	
	private class GuardListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(player.canBuyGuard())
				clickAction = GameActions.GUARD_SELECTED;
		}
	}
	private class ArcherListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(player.canBuyArcher())
				clickAction = GameActions.ARCHER_SELECTED;
		}
	}
	private class ExecutionerListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(player.canBuyExecutioner())
				clickAction = GameActions.EXECUTIONER_SELECTED;
		}
	}
	private class CatapultListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(player.canBuyCatapult())
				clickAction = GameActions.CATAPULT_SELECTED;
		}
	}
	private class WizardListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(player.canBuyWizard())
				clickAction = GameActions.WIZARD_SELECTED;
		}
	}
	
	private class MouseActionListener implements MouseListener {
		public void mouseClicked(MouseEvent me) {
			Point point = me.getPoint();
			if(isValidPlacementLocation(point)) {
				if(clickAction == GameActions.GUARD_SELECTED) {
					Troop g = new Troop(new Point(point.x - (Troop.getWidth() / 2), point.y - (Troop.getHeight() / 2)), 1);
					troops.add(g);
					player.setMoney(player.getMoney() - Player.GUARD_COST);
					updateMoneyLabel();
					clickAction = GameActions.NONE;
				}
				else if(clickAction == GameActions.ARCHER_SELECTED) {
					Troop a = new Troop(new Point(point.x - (Troop.getWidth() / 2), point.y - (Troop.getHeight() / 2)), 2);
					troops.add(a);
					player.setMoney(player.getMoney() - Player.ARCHER_COST);
					updateMoneyLabel();
					clickAction = GameActions.NONE;
				}
				else if(clickAction == GameActions.EXECUTIONER_SELECTED) {
					Troop e = new Troop(new Point(point.x - (Troop.getWidth() / 2), point.y - (Troop.getHeight() / 2)), 3);
					troops.add(e);
					player.setMoney(player.getMoney() - Player.EXECUTION_COST);
					updateMoneyLabel();
					clickAction = GameActions.NONE;
				}
				else if(clickAction == GameActions.CATAPULT_SELECTED) {
					Troop c = new Troop(new Point(point.x - (Troop.getWidth() / 2), point.y - (Troop.getHeight() / 2)), 4);
					troops.add(c);
					player.setMoney(player.getMoney() - Player.CATAPULT_COST);
					updateMoneyLabel();
					clickAction = GameActions.NONE;
				}
				else if(clickAction == GameActions.WIZARD_SELECTED) {
					Troop w = new Troop(new Point(point.x - (Troop.getWidth() / 2), point.y - (Troop.getHeight() / 2)), 5);
					troops.add(w);
					player.setMoney(player.getMoney() - Player.WIZARD_COST);
					updateMoneyLabel();
					clickAction = GameActions.NONE;
				}
			}
		}

		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}
	
	private boolean isValidPlacementLocation(Point player) {
		for(Polygon poly : this.noGoZones) {
			if(poly.intersects(new Rectangle(player.x - (Troop.getWidth() / 2), player.y - (Troop.getHeight() / 2), Troop.getWidth(), Troop.getWidth()))) {
				return false;
			}
		}
		return true;
	}
	
	/*
	public void save() {
		 creates the data file that can be used to save a game in the format:
		 <amount of money>
		 <base health>
		 <current wave>
		 <troop1 type (space) troop1 x location (space) troop1 y location>
		 <troop2 type (space) troop2 x location (space) troop2 y location>
		 <troop3 type (space) troop3 x location (space) troop3 y location>
		 ...
		 <troopN type (space) troopN x location (space) troopN y location>
		String data = "";
		data += player.getMoney() + "\n";
		data += player.getLife() + "\n";
		data += this.wave + "\n";
		for(Troop t : this.troops) {
			data += t.getName + " " + t.getX() + " " + t.getY();
		}
	}
	*/
	
	private class GameFieldPanel extends JPanel {
		private int width, height, enemySpawnIndex;
		private String map;
		private BufferedImage myImage;
		private Graphics myBuffer;
		private Timer mainGameTimer, enemySpawnTimer;
		private ArrayList<Enemy> enemies;
		private Point[] path;
		
		public GameFieldPanel(int width, int height, String map) {
			this.width = width;
			this.height = height;
			this.map = map;
			switch(this.map) {
			case "map1.png":
				path = MapPaths.map1;
				break;
			case "map2.png":
				path = MapPaths.map2;
				break;
			default:
				path = new Point[0];
				break;
			}
			this.enemySpawnIndex = 0;
			this.enemies = new ArrayList<Enemy>();
			
			myImage = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
			myBuffer = myImage.getGraphics();
			mainGameTimer = new Timer(0, new mainGameListener());
			enemySpawnTimer = new Timer(1000, new EnemySpawnListener());
			myBuffer.drawImage(new ImageIcon("Resources/Maps/" + map).getImage(), 0, 0, width, height, null);
		}
		
		public void resetEnemySpawnIndex() {
			this.enemySpawnIndex = 0;
		}
		
		public void restartEnemySpawnTimer() {
			this.enemySpawnTimer.restart();
		}
		
		public void restartMainGameTimer() {
			this.mainGameTimer.restart();
		}
		
		private boolean isWaveOver() {
			if(this.enemySpawnIndex >= Waves.waves[wave - 1].length && this.enemies.isEmpty())
				return true;
			return false;
		}
		
		private class mainGameListener implements ActionListener {
			public void actionPerformed(ActionEvent ae) {
				myBuffer.drawImage(new ImageIcon("Resources/Maps/" + map).getImage(), 0, 0, width, height, null);
				
				Enemy target=null;
	            for(Troop a : troops)
	            {
	                for(int i = 0; i < enemies.size(); i++)
	                {
	                    //if enemy in range, then attack
	                    if(a.getRadius()>Math.abs(enemies.get(i).getX()-a.getX())&&a.getRadius()>Math.abs(enemies.get(i).getY()-a.getY())&&target==null&&enemies.get(i).alive())
	                    {                    
	                        target=enemies.get(i);
	                    }

	                    //implements thief ability
	                    if(enemies.get(i) instanceof Thief)
	                    {
	                        player.setMoney(((Thief)enemies.get(i)).stealFromPlayer(player.getMoney()));
	                    }
	                }

	                if(target!=null&&a.getRadius()>Math.abs(target.getX()-a.getX())&&a.getRadius()>Math.abs(target.getY()-a.getY()))
	                {
	                    if(a.getDelay()<0)
	                    {
	                        a.setDelay(a.getInitDelay());
	                        target.setLife(target.getLife()-a.getDamage());
	                    }
	                    else
	                    if(target.alive())
	                    {
	                        a.setDelay(a.getDelay()-1);
	                    }
	                    else
	                    {
	                        target=null;
	                    }
	                }
	            }
	            
	            for(int i = 0; i < enemies.size(); i++) {
	            	if(!enemies.get(i).alive()) {
	            		if(enemies.get(i) instanceof Brawler)
	            			player.setMoney(player.getMoney() + 1);
	            		else if(enemies.get(i) instanceof Knight)
	            			player.setMoney(player.getMoney() + 3);
	            		else if(enemies.get(i) instanceof Thief)
	            			player.setMoney(player.getMoney() + 5);
	            		else if(enemies.get(i) instanceof Cavalry)
	            			player.setMoney(player.getMoney() + 10);
	            		else if(enemies.get(i) instanceof Dragon)
	            			player.setMoney(player.getMoney() + 30);
	            		enemies.remove(i);
	            		i--;
	            	}
	            }
				for(Troop t : troops) {
					t.draw(myBuffer);
				}
				for(Enemy e : enemies) {
					e.draw(myBuffer);
				}
				
				updateMoneyLabel();
				updateHealthLabel();
				
				repaint();
				
				if(isWaveOver()) {
					start.setEnabled(true);
				}
				
				if(!player.isAlive()) {
					mainGameTimer.stop();
					enemySpawnTimer.stop();
					myBuffer.setColor(Color.DARK_GRAY);
					myBuffer.fillRect(200, 200, 500, 250);
					myBuffer.setColor(Color.WHITE);
					myBuffer.setFont(new Font("Comic Sans", Font.BOLD, 36));
					myBuffer.drawString("Game Over", 350, 320);
					repaint();
				}
			}
		}
		
		private class EnemySpawnListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(enemySpawnIndex < Waves.waves[wave - 1].length) {
					switch(Waves.waves[wave - 1][enemySpawnIndex++]) {
					case BRAWLER:
						Brawler b = new Brawler(path[0].x, path[0].y, path, player);
						b.start();
						enemies.add(b);
						break;
					case KNIGHT:
						Knight k = new Knight(path[0].x, path[0].y, path, player);
						k.start();
						enemies.add(k);
						break;
					case THIEF:
						Thief t = new Thief(path[0].x, path[0].y, path, player);
						t.start();
						enemies.add(t);
						break;
					case CAVALRY:
						Cavalry c = new Cavalry(path[0].x, path[0].y, path, player);
						c.start();
						enemies.add(c);
						break;
					case DRAGON:
						Dragon d = new Dragon(path[0].x, path[0].y, path, player);
						d.start();
						enemies.add(d);
						break;
					}
				}
				else {
					enemySpawnTimer.stop();
				}
			}
		}
		
		public void paintComponent(Graphics g) {
			g.drawImage(myImage, 0, 0, this.getWidth(), this.getHeight(), null);
		}
	}
}