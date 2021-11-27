package view.panels;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JLabel;

import model.Word;

public class WordPanel extends JLabel {
	private char[] word;
	private boolean[] guessedLetters;
//	private int hangCount;

	private Graphics2D graphic;
	private Line2D.Double letterLine;

	public char[] getWord() {
		return word;
	}

	public void setWord(char[] word) {
		this.word = word;
	}

	public boolean[] getGuessedLetters() {
		return guessedLetters;
	}

	public void setGuessedLetters(boolean[] guessedLetters) {
		this.guessedLetters = guessedLetters;
	}

	public Graphics2D getGraphic() {
		return graphic;
	}

	public void setGraphic(Graphics2D graphic) {
		this.graphic = graphic;
	}

	public Line2D.Double getLetterLine() {
		return letterLine;
	}

	public void setLetterLine(Line2D.Double letterLine) {
		this.letterLine = letterLine;
	}



	public WordPanel() {
		this.setLetterLine(new Line2D.Double(0, 0, 0, 0));
		this.setLayout(null);
		this.setBounds(260, 200, 500, 200);
		this.setBackground(Color.white);
		this.setOpaque(true);
//		this.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Font font = new Font("Arial", Font.BOLD, 30);
		g2.setStroke(new BasicStroke(10));
		for (int i = 0, x = 10; i < this.getWord().length; i++, x += 50) {
			this.getLetterLine().setLine(x, 150, x + 30, 150);
			g2.draw(this.getLetterLine());
			if (this.getGuessedLetters()[i] == true) {
				g2.setFont(font);
				g2.drawString("" + this.getWord()[i], x + 4, 140);
			}
		}
	}

	public void displayCreatedWord(Word word) {
		this.setWord(word.getWord());
		this.setGuessedLetters(word.getGuessedLetters());
		this.repaint();
	}
}
