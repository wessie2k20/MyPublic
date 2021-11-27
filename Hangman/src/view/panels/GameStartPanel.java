package view.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameStartPanel extends JPanel {
	private JButton startButton;
	private BufferedImage img;

	public JButton getStartButton() {
		return startButton;
	}

	public void setStartButton(JButton startButton) {
		this.startButton = startButton;
	}


	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public GameStartPanel() {
		this.setOpaque(true);
		this.setLayout(null);
		this.setBounds(0, 0, 1024, 768);
		this.setStartButton(new JButton("Start Game"));
		this.getStartButton().setBounds(425, 450, 150, 30);
		this.add(this.getStartButton());
		try {
			this.setImg(ImageIO.read(this.getClass().getResource("/hangman.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(this.getImg(), 200, 200, 600, 300, null);
		g.setColor(Color.black);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString("HANGMAN!", 420, 120);
	}

	public void addActionListenerToStartButton(ActionListener a) {
		this.getStartButton().addActionListener(a);
	}


}
