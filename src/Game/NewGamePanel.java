package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author Carson Forsyth
 * @version 11/28/19
 */
public class NewGamePanel extends JPanel {
	private static final String[] mapList = {"map1.png", "map2.png"};
	private static final ImageIcon previousImg = new ImageIcon("Resources/Game Images/Menu Items/previous.png");
	private static final ImageIcon nextImg = new ImageIcon("Resources/Game Images/Menu Items/next.png");
	private static final ImageIcon startImg = new ImageIcon("Resources/Game Images/Menu Items/start.png");
	
	private int width, height, mapIndex;
	private JButton previous, next, start, back;
	private JLabel currentMap;

	public NewGamePanel(int width, int height) {
		this.width = width;
		this.height = height;
		this.mapIndex = 0;
		
		this.setLayout(null);
		
		this.previous = new JButton(previousImg);
		this.previous.setBounds(70, 250, 100, 100);
		this.previous.setContentAreaFilled(false);
		this.previous.setBorder(null);
		this.previous.addActionListener(new PreviousListener());
		this.add(this.previous);
		
		this.next = new JButton(nextImg);
		this.next.setBounds(730, 250, 100, 100);
		this.next.setContentAreaFilled(false);
		this.next.setBorder(null);
		this.next.addActionListener(new NextListener());
		this.add(this.next);
		
		this.start = new JButton(startImg);
		this.start.setBounds(400, 575, 100, 50);
		this.start.setContentAreaFilled(false);
		this.start.setBorder(null);
		this.start.addActionListener(new StartListener());
		this.add(this.start);
		
		ImageIcon scaled = new ImageIcon((new ImageIcon("Resources/Maps/" + mapList[this.mapIndex])).getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));
		this.currentMap = new JLabel(scaled);
		this.currentMap.setBounds(200, 50, 500, 500);
		this.add(this.currentMap);
		
		back = new JButton("Back");
		back.addActionListener(new BackListener());
		back.setBackground(Color.GRAY);
		back.setForeground(Color.WHITE);
		back.setFont(new Font("Serif", Font.PLAIN, 20));
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setBounds((int)(this.width * 0.01) + (back.getPreferredSize().width / 2),
					   (int)(this.height * 0.9) - (back.getPreferredSize().width / 2),
								back.getPreferredSize().width,
								back.getPreferredSize().height);
		this.add(back);
	}
	
	private class PreviousListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(mapIndex > 0) {
				mapIndex--;
				ImageIcon scaled = new ImageIcon((new ImageIcon("Resources/Maps/" + mapList[mapIndex])).getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));
				currentMap.setIcon(scaled);
			}
		}
	}
	
	private class NextListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(mapIndex < mapList.length - 1) {
				mapIndex++;
				ImageIcon scaled = new ImageIcon((new ImageIcon("Resources/Maps/" + mapList[mapIndex])).getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));
				currentMap.setIcon(scaled);
			}
		}
	}
	
	private class StartListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Driver.map = mapList[mapIndex].substring(0, 4);
			Driver.goToContinueGame();
		}
	}
	
	private class BackListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Driver.goToMainMenu();
		}
	}
}