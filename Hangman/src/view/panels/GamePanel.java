package view.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import model.Word;

public class GamePanel extends JPanel {

	private HangManLabel hangManLabel;
	private WordPanel wordPanel;
	private LetterPanel letterPanel;

	public HangManLabel getHangManLabel() {
		return hangManLabel;
	}

	public void setHangManLabel(HangManLabel hangManLabel) {
		this.hangManLabel = hangManLabel;
	}

	public WordPanel getWordPanel() {
		return wordPanel;
	}

	public void setWordPanel(WordPanel wordPanel) {
		this.wordPanel = wordPanel;
	}

	public LetterPanel getLetterPanel() {
		return letterPanel;
	}

	public void setLetterPanel(LetterPanel letterPanel) {
		this.letterPanel = letterPanel;
	}

	public GamePanel() {
		this.setLayout(null);
		this.setBounds(0, 0, 1024, 768);
		this.setHangManLabel(new HangManLabel());
		this.add(this.getHangManLabel());
		this.setWordPanel(new WordPanel());
		this.add(this.getWordPanel());
		this.setLetterPanel(new LetterPanel());
		this.add(this.getLetterPanel());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.lightGray);
		g.setColor(Color.black);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString("Spielbildschirm!", 400, 120);
	}

	public void paintHangMan(int count) {
		this.getHangManLabel().setHangCount(count);

	}

	public void addActionListenerToLetterButtons(ActionListener al) {
		this.getLetterPanel().addActionListenersToButtons(al);
	}

	public void displayCreatedWord(Word word) {
		this.getWordPanel().displayCreatedWord(word);
		this.getHangManLabel().setHangCount(word.getHangManCount());
	}

	public void resetLetterButtons() {
		this.getLetterPanel().resetLetterButtons();

	}

}
