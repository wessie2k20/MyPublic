package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class GameStartLabel extends JLabel{

	BufferedImage titel;

	public BufferedImage getTitel() {
		return titel;
	}

	public void setTitel(BufferedImage titel) {
		this.titel = titel;
	}
	
	public GameStartLabel() {		
		try {
			this.setTitel(ImageIO.read(this.getClass().getResource("/titel.png")));
		}catch(Exception e) {
			e.printStackTrace();
		}
		this.setLayout(null);
		this.setBounds(0, 0, 1024, 400);
		this.setVisible(true);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(this.getTitel(), 0, 0,1024, 400, null);
		
		
		this.repaint();		
	}
	
}
