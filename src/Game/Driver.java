package Game;

import javax.swing.JFrame;

/**
 * @author Carson Forsyth
 * @version 11/28/19
 */
public class Driver {
	private static final int WIDTH = 900;
	private static final int HEIGHT = 700;
	private static JFrame frame;
	public static String map = "";
	
	public static void main(String[] args) {
		frame = new JFrame("CS 211 Final Project");
		frame.setSize(Driver.WIDTH, Driver.HEIGHT);
		frame.setLocation(200, 50);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new MainMenuPanel(Driver.WIDTH, Driver.HEIGHT));
		frame.setVisible(true);
	}
	
	public static void goToNewGame() {
		frame.getContentPane().removeAll();
		frame.setContentPane(new NewGamePanel(Driver.WIDTH, Driver.HEIGHT));
		frame.setVisible(true);
	}
	
	public static void goToContinueGame() {
		frame.getContentPane().removeAll();
		frame.setContentPane(new GamePanel(Driver.WIDTH, Driver.HEIGHT, map));
		frame.setVisible(true);
	}
	
	public static void goToCredits() {
		frame.getContentPane().removeAll();
		frame.setContentPane(new CreditsPanel(Driver.WIDTH, Driver.HEIGHT));
		frame.setVisible(true);
	}
	
	public static void goToMainMenu() {
		frame.getContentPane().removeAll();
		frame.setContentPane(new MainMenuPanel(Driver.WIDTH, Driver.HEIGHT));
		frame.setVisible(true);
	}
}