package Game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Carson Forsyth
 * @version 11/17/19
 */
public class GameFieldPanel extends JPanel {
	private int width, height;
	private String map;
	private BufferedImage myImage;
	private Graphics myBuffer;
	private Timer t;
	
	public GameFieldPanel(int width, int height, String map) {
		this.width = width;
		this.height = height;
		this.map = map;
		myImage = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
		myBuffer = myImage.getGraphics();
		
		t = new Timer(0, new GameListener());
		t.start();
	}
	
	private class GameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			myBuffer.drawImage(new ImageIcon("Resources/Maps/" + map).getImage(), 0, 0, width, height, null);
			repaint();
		}
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(myImage, 0, 0, this.getWidth(), this.getHeight(), null);
	}
}