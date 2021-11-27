package view.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LetterPanel extends JPanel {
	private List<JButton> letterButtons;

	public List<JButton> getLetterButtons() {
		return letterButtons;
	}

	public void setLetterButtons(List<JButton> letterButtons) {
		this.letterButtons = letterButtons;
	}

	public LetterPanel() {
		this.setBounds(240, 525, 500, 200);
		this.setBackground(Color.LIGHT_GRAY);
		this.setLetterButtons(List.of(new JButton("A"), new JButton("B"), new JButton("C"), new JButton("D"),
				new JButton("E"), new JButton("F"), new JButton("G"), new JButton("H"), new JButton("I"),
				new JButton("J"), new JButton("K"), new JButton("L"), new JButton("M"), new JButton("N"),
				new JButton("O"), new JButton("P"), new JButton("Q"), new JButton("R"), new JButton("S"),
				new JButton("T"), new JButton("U"), new JButton("V"), new JButton("W"), new JButton("X"),
				new JButton("Y"), new JButton("Z")));
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
		Dimension dimension = new Dimension(50, 30);
		this.getLetterButtons().forEach(b -> {
			b.setPreferredSize(dimension);
			this.add(b);
		});
	}

	public void addActionListenersToButtons(ActionListener al) {
		this.getLetterButtons().forEach(b -> b.addActionListener(al));
	}

	public void resetLetterButtons() {
		this.getLetterButtons().forEach(b->b.setEnabled(true));	
	}

}
