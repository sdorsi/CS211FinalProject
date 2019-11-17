import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainMenuPanel extends JPanel {
	private int width, height;
	/* uncomment later for use
	private Timer t;
	private BufferedImage myImage;
	private Graphics myBuffer;
	*/
	private JButton newGameButton, continueGameButton, creditsButton;
	
	public MainMenuPanel(int width, int height) {
		this.width = width;
		this.height = height;
		
		/* uncomment later for use
		t = new Timer(0, new Listener());
		myImage = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
		myBuffer = myImage.getGraphics();
		*/
		
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(null);
		
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new NewGameListener());
		newGameButton.setBackground(Color.GRAY);
		newGameButton.setForeground(Color.WHITE);
		newGameButton.setFont(new Font("Serif", Font.PLAIN, 48));
		newGameButton.setHorizontalAlignment(SwingConstants.CENTER);
		newGameButton.setBounds((this.width / 2) - (newGameButton.getPreferredSize().width / 2),
								50,
								newGameButton.getPreferredSize().width,
								newGameButton.getPreferredSize().height);
		this.add(newGameButton);
		
		continueGameButton = new JButton("Continue Game");
		continueGameButton.addActionListener(new ContinueGameListener());
		continueGameButton.setBackground(Color.GRAY);
		continueGameButton.setForeground(Color.WHITE);
		continueGameButton.setFont(new Font("Serif", Font.PLAIN, 48));
		continueGameButton.setHorizontalAlignment(SwingConstants.CENTER);
		continueGameButton.setBounds((this.width / 2) - (continueGameButton.getPreferredSize().width / 2),
				150,
				continueGameButton.getPreferredSize().width,
				continueGameButton.getPreferredSize().height);
		this.add(continueGameButton);
		
		creditsButton = new JButton("Credits");
		creditsButton.addActionListener(new CreditsListener());
		creditsButton.setBackground(Color.GRAY);
		creditsButton.setForeground(Color.WHITE);
		creditsButton.setFont(new Font("Serif", Font.PLAIN, 48));
		creditsButton.setHorizontalAlignment(SwingConstants.CENTER);
		creditsButton.setBounds((this.width / 2) - (creditsButton.getPreferredSize().width / 2),
				250,
				creditsButton.getPreferredSize().width,
				creditsButton.getPreferredSize().height);
		this.add(creditsButton);
		
//		t.restart();
	}
	
	private class NewGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Driver.goToNewGame();
		}
	}
	
	private class ContinueGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Driver.goToContinueGame();
		}
	}
	
	private class CreditsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Driver.goToCredits();
		}
	}
	
	/* uncomment when images and other things that actually require graphics are used
	private class Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			repaint();
		}
	}
	
	public void paintComponent(Graphics g) {
		myBuffer.drawImage(myImage, 0, 0, this.getWidth(), this.getHeight(), null);
	}
	*/
}