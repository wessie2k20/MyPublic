package view.panels;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class WinPanel extends JPanel {

	private JButton playAgainBtn;
	private JButton beendenBtn;
	private String word = "";

	public JButton getPlayAgainBtn() {
		return playAgainBtn;
	}

	public void setPlayAgainBtn(JButton playAgainBtn) {
		this.playAgainBtn = playAgainBtn;
	}

	public JButton getBeendenBtn() {
		return beendenBtn;
	}

	public void setBeendenBtn(JButton beendenBtn) {
		this.beendenBtn = beendenBtn;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public WinPanel() {
		this.setBounds(0, 0, 1024, 768);
		this.setLayout(null);
		this.setPlayAgainBtn(new JButton("Neues Spiel"));
		this.getPlayAgainBtn().setBounds(350, 500, 130, 35);

		this.setBeendenBtn(new JButton("Spiel beenden"));
		this.getBeendenBtn().setBounds(550, 500, 130, 35);

		this.add(this.getPlayAgainBtn());
		this.add(this.getBeendenBtn());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Font font = new Font("Arial", Font.BOLD, 40);
		g.setFont(font);
		g.drawString("Das gesuchte Wort war: ", 250, 150);
		g.drawString(this.getWord(), 250, 200);
		g.drawString("Herzlichen Glückwunsch!", 250, 300);
		g.drawString("Wort erraten!", 250, 400);
	}

	public void addActionListenerToPlayAgainButton(ActionListener al) {
		this.getPlayAgainBtn().addActionListener(al);
	}

	public void addActionListenerToBeendenButton(ActionListener al) {
		this.getBeendenBtn().addActionListener(al);
	}
}
