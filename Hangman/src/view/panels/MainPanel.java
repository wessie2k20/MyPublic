package view.panels;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Word;

public class MainPanel extends JPanel {
	private GameStartPanel startPanel;
	private GamePanel gamePanel;
	private WinPanel winPanel;
	private LoosePanel loosePanel;

	public GameStartPanel getStartPanel() {
		return startPanel;
	}

	public void setStartPanel(GameStartPanel startPanel) {
		this.startPanel = startPanel;
	}

	public GamePanel getGamePanel() {
		return gamePanel;
	}

	public void setGamePanel(GamePanel gamePanel) {
		this.gamePanel = gamePanel;
	}

	public WinPanel getWinPanel() {
		return winPanel;
	}

	public void setWinPanel(WinPanel winPanel) {
		this.winPanel = winPanel;
	}

	public LoosePanel getLoosePanel() {
		return loosePanel;
	}

	public void setLoosePanel(LoosePanel loosePanel) {
		this.loosePanel = loosePanel;
	}

	public MainPanel() {
		this.setLayout(null);
		this.setBounds(0, 0, 1024, 768);
		this.setGamePanel(new GamePanel());
		this.setStartPanel(new GameStartPanel());
		this.setWinPanel(new WinPanel());
		this.setLoosePanel(new LoosePanel());
		this.add(this.getStartPanel());
		this.add(this.getGamePanel());
		this.add(this.getLoosePanel());
		this.add(this.getWinPanel());
		this.changeGameState(true, false, false, false);
	}

	public void addActionListenerToStartPanel(ActionListener a) {
		this.getStartPanel().addActionListenerToStartButton(a);

	}

	public void startGame() {
		this.changeGameState(false, true, false, false);

	}

	private void changeGameState(boolean inStart, boolean inGame, boolean inWin, boolean inLoose) {
		this.getGamePanel().setVisible(inGame);
		this.getStartPanel().setVisible(inStart);
		this.getWinPanel().setVisible(inWin);
		this.getLoosePanel().setVisible(inLoose);

		this.revalidate();
		this.repaint();
	}

	public void addActionListenerToLetterButtons(ActionListener al) {
		this.getGamePanel().addActionListenerToLetterButtons(al);
	}

	public void paintHangMan(int count) {
		this.getGamePanel().paintHangMan(count);
	}

	public void displayCreatedWord(Word word) {
		this.getGamePanel().displayCreatedWord(word);
		this.getWinPanel().setWord(word.toString());
		this.getLoosePanel().setWord(word.toString());
	}

	public void showWin() {
		this.changeGameState(false, false, true, false);
	}

	public void showLoose() {
		this.changeGameState(false, false, false, true);
	}

	public void addActionListenerToPlayAgainButton(ActionListener al) {
		this.getWinPanel().addActionListenerToPlayAgainButton(al);
		this.getLoosePanel().addActionListenerToPlayAgainButton(al);
	}

	public void addActionListenerToBeendenButton(ActionListener al) {
		this.getWinPanel().addActionListenerToBeendenButton(al);
		this.getLoosePanel().addActionListenerToBeendenButton(al);
	}

	public void resetLetterButtons() {
		this.getGamePanel().resetLetterButtons();

	}

}
