package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class CreditsPanel extends JPanel {
	private int width, height;
	private JTextArea credits;
	private JButton back;

	/**
	 * @param width width of the window in pixels
	 * @param height height of the window in pixels
	 */
	public CreditsPanel(int width, int height) {
		this.width = width;;
		this.height = height;
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(null);
		
		credits = new JTextArea();
		credits.setEditable(false);
		credits.setLineWrap(true);
		credits.setBackground(Color.GRAY);
		credits.setForeground(Color.WHITE);
		credits.setFont(new Font("Serif", Font.PLAIN, 20));
		credits.setText("\t\t       Credits\n" +
						"\n" +
						"\tCreated by:\t\tSimon D'Orsi\n" +
						"           \t\t\tCarson Forsyth\n" +
						"\n" +
						"\tCreated for CS 211-H01:\n" +
						"\tObject Oriented Programming\n" +
						"\tAt George Mason University\n" + 
						"\tFor Professor Tessema Mengistu");

		credits.setBounds(this.width / 10,
						  this.height / 10,
						  (int)(this.width * 0.8),
						  (int)(this.height * 0.6));
		this.add(credits);
		
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
	
	// listener for the back button
	private class BackListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Driver.goToMainMenu();
		}
	}
}