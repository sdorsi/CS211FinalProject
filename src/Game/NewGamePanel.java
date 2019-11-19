package Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Carson Forsyth
 * @version 11/18/19
 */
public class NewGamePanel extends JPanel {
	private static final int numMaps = 1;
	private static final String[] mapList = {"map1.png"};
	private static final String[] mapDataList = {"map1Data.txt"};
	private static final ImageIcon previousImg = new ImageIcon("Resources/Game Images/previous.png");
	private static final ImageIcon nextImg = new ImageIcon("Resources/Game Images/next.png");
	
	private int width, height, mapIndex;
	private JButton previous, next;
	private JLabel currentMap;

	public NewGamePanel(int width, int height) {
		this.width = width;
		this.height = height;
		this.mapIndex = 0;
		
		this.setLayout(null);
		
		this.previous = new JButton(new ImageIcon("Resources/Game Images/previous.png"));
		this.previous.setBounds(20, 250, 100, 100);
		this.previous.addActionListener(new PreviousListener());
		this.add(previous);
		
		this.next = new JButton(new ImageIcon("Resources/Game Images/next.png"));
		this.next.setBounds(580, 250, 100, 100);
		this.next.addActionListener(new NextListener());
		this.add(next);
		
		this.currentMap = new JLabel(new ImageIcon("Resources/Maps/map1.png"));
		this.currentMap.setBounds(150, 100, 400, 400);
		this.add(this.currentMap);
	}
	
	private class PreviousListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(mapIndex > 0) {
				mapIndex--;
				currentMap.setIcon(new ImageIcon("Resources/Maps/map" + mapIndex + ".png"));
			}
		}
	}
	
	private class NextListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(mapIndex < mapList.length - 1) {
				mapIndex++;
				currentMap.setIcon(new ImageIcon("Resources/Maps/map" + mapIndex + ".png"));
			}
		}
	}
}