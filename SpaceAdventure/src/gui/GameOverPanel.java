package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import controller.MainController;
import controller.MyMouseListener;

public class GameOverPanel extends JPanel{

	private JButton btnNewGame;
		
	public JButton getBtnNewGame() {
		return btnNewGame;
	}

	public void setBtnNewGame(JButton btnNewGame) {
		this.btnNewGame = btnNewGame;
	}

	public GameOverPanel() {
		initialize();
	}

	private void initialize() {
		this.setBounds(0,0,1024,768);
		this.setLayout(null);
		this.setBackground(new Color(210, 210, 210, 120));
		this.setBtnNewGame(new JButton("New Game"));
		this.getBtnNewGame().setBounds(150, 150, 725, 50);
		this.getBtnNewGame().setFont(new Font("Arial", Font.BOLD, 40));
		this.getBtnNewGame().setBackground(Color.black);
		this.getBtnNewGame().setForeground(Color.white);
		this.getBtnNewGame().setBorder(null);
		this.getBtnNewGame().setFocusPainted(false);
		this.add(this.getBtnNewGame());
		
	}
	
	public void addActionListenerToButtons(MainController m) {
		this.getBtnNewGame().addActionListener(m::pressedNewGame);	
	}
	public void addMouseListenerToButtons(MainController m) {
		this.getBtnNewGame().addActionListener(m::pressedNewGame);	
	}
	public void addMyMouseListener(MyMouseListener mouseAdapter) {
		this.getBtnNewGame().addMouseListener(mouseAdapter);
	}
}
