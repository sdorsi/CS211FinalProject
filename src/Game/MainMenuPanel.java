package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainMenuPanel extends JPanel {
	private int width, height;
	private JButton newGameButton, continueGameButton, creditsButton;
	
	/**
	 * @param width width of frame in pixels
	 * @param height height of frame in pixels
	 */
	public MainMenuPanel(int width, int height) {
		this.width = width;
		this.height = height;
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(null);
		
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(new NewGameListener());
		newGameButton.setBackground(Color.GRAY);
		newGameButton.setForeground(Color.WHITE);
		newGameButton.setFont(new Font("Serif", Font.PLAIN, 48));
		newGameButton.setHorizontalAlignment(SwingConstants.CENTER);
//		newGameButton.setBounds((this.width / 2) - (newGameButton.getPreferredSize().width / 2),
//								50,
//								newGameButton.getPreferredSize().width,
//								newGameButton.getPreferredSize().height);
		newGameButton.setBounds((this.width / 2) - (newGameButton.getPreferredSize().width / 2),
				150,
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
//		this.add(continueGameButton);
		
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
	}
	
	// listener for the new game button
	private class NewGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Driver.goToNewGame();
		}
	}
	
	// listener for the continue game button
	private class ContinueGameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Driver.goToContinueGame();
		}
	}
	
	// listener for the credits button
	private class CreditsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Driver.goToCredits();
		}
	}
}