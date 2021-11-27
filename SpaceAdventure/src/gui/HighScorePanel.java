package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.util.Map;
import java.util.Set;

import javax.swing.*;

import controller.MainController;
import controller.MyMouseListener;

public class HighScorePanel extends JPanel {

	private class MyScoreLabel extends JLabel {
		private Map<Integer, String> highScores;
		
		public Map<Integer, String> getHighScores() {
			return highScores;
		}

		public void setHighScores(Map<Integer, String> highScores) {
			this.highScores = highScores;
		}

		private class MyMouseWheelListener extends MouseAdapter {
			private MyScoreLabel sl;

			public void mouseWheelMoved(MouseWheelEvent e) {
				if (e.getWheelRotation() > 0) {
					if((this.sl.getxPos() + 10) < 350) {
						this.sl.setxPos(this.sl.getxPos() + 10);						
					}
				}
				if (e.getWheelRotation() < 0) {
					if((this.sl.getxPos() + 10) > 50) {
						this.sl.setxPos(this.sl.getxPos() - 10);
					}
				}
			}

			public MyMouseWheelListener(MyScoreLabel sl) {
				this.sl = sl;
			}
		}

		private int xPos;
		private MyMouseWheelListener ml;
		
		public int getxPos() {
			return xPos;
		}

		public void setxPos(int xPos) {
			this.xPos = xPos;
		}
		
		public MyMouseWheelListener getMl() {
			return ml;
		}

		public void setMl(MyMouseWheelListener ml) {
			this.ml = ml;
		}

		public MyScoreLabel() {

			this.setBounds(0, 0, 1024, 500);
			this.setMl(new MyMouseWheelListener(this));
			this.addMouseWheelListener(getMl());
			this.setxPos(150);
			
			this.revalidate();
			this.repaint();
			this.setVisible(true);
		}

		@Override
		protected void paintComponent(Graphics g) {
			int hsPosIncrease = 30;
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g.setColor(Color.red);
			g.setFont(new Font("Arial", Font.BOLD, 50));
			g.drawString("HighScores", 350, 50);
			
			
			g.setFont(new Font("Arial", Font.BOLD, 25));
			Set<Integer> keys = this.getHighScores().keySet();
			if(keys.isEmpty()) {
				g.setColor(Color.red);
				g.drawString("HighScores leer", 350, 150);
			}else {
				for(Integer i : keys) {
					g.setColor(Color.white);
					String hs = i + " : " + this.getHighScores().get(i);
					hsPosIncrease += 30;
					g.drawString(hs, 400, this.getxPos() + hsPosIncrease);
				}				
			}
			
//			this.repaint();
		}
	}

	private JButton btnBack;
	private MyScoreLabel scoreLabel;
	
	
	public JButton getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	public MyScoreLabel getScoreLabel() {
		return scoreLabel;
	}

	public void setScoreLabel(MyScoreLabel scoreLabel) {
		this.scoreLabel = scoreLabel;
	}


	public HighScorePanel() {
		this.setBtnBack(new JButton("Zurueck"));
		this.setScoreLabel(new MyScoreLabel());

		this.setBounds(0, 0, 1024, 768);
		this.setLayout(null);
		this.setBackground(new Color(210, 210, 210, 120));

		this.getBtnBack().setBounds(150, 600, 725, 50);
		this.getBtnBack().setFont(new Font("Arial", Font.BOLD, 40));
		this.getBtnBack().setBackground(Color.black);
		this.getBtnBack().setForeground(Color.white);
		this.getBtnBack().setBorder(null);
		this.getBtnBack().setFocusPainted(false);

		this.add(this.getScoreLabel());
		this.add(this.getBtnBack());

		this.getScoreLabel().setVisible(true);
		this.getBtnBack().setVisible(true);

		this.revalidate();
		this.repaint();
		this.setVisible(true);
	}

	public void addMyMouseListener(MyMouseListener mouseAdapter) {
		this.getBtnBack().addMouseListener(mouseAdapter);
	}

	public void addActionListenerToButtons(MainController m) {
		this.getBtnBack().addActionListener(m::pressedBack);
	}

	public void setHighScores(Map<Integer, String> hs) {
		this.getScoreLabel().setHighScores(hs);		
	}

}
