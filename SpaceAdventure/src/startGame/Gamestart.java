package startGame;

import javax.swing.SwingUtilities;

import controller.MainController;

public class Gamestart {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()-> new MainController());
	}
}
