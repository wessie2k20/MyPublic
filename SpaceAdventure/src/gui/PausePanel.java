package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import controller.MainController;
import controller.MyMouseListener;

public class PausePanel extends JPanel {
	private JButton btnResume, btnShop, btnExit, btnSettings, btnHighScore;
	
	public JButton getBtnResume() {
		return btnResume;
	}

	public void setBtnResume(JButton btnResume) {
		this.btnResume = btnResume;
	}

	public JButton getBtnShop() {
		return btnShop;
	}

	public void setBtnShop(JButton btnShop) {
		this.btnShop = btnShop;
	}

	public JButton getBtnExit() {
		return btnExit;
	}

	public void setBtnExit(JButton btn_Exit) {
		this.btnExit = btn_Exit;
	}

	public JButton getBtnSettings() {
		return btnSettings;
	}

	public void setBtnSettings(JButton btnSettings) {
		this.btnSettings = btnSettings;
	}

	public JButton getBtnHighScore() {
		return btnHighScore;
	}

	public void setBtnHighScore(JButton btnHighScore) {
		this.btnHighScore = btnHighScore;
	}

	public PausePanel() {
		initialize();
	}

	private void initialize() {
		
		this.setLayout(null);		
		this.setBounds(0, 0, 1024, 768);
		
//		this.setPreferredSize(new Dimension(800, 600));
//		this.setBounds(0,0, (int)this.getParent().getSize().getWidth(), (int)this.getParent().getSize().getHeight());
		
		this.setBackground(new Color(210, 210, 210, 120));
		this.setOpaque(true);
//		this.setBackground(Color.lightGray);
		this.setBtnResume(new JButton("Resume"));
		this.getBtnResume().setBounds(150, 50, 725, 50);
		this.getBtnResume().setFont(new Font("Arial", Font.BOLD, 40));
		this.getBtnResume().setBackground(Color.black);
		this.getBtnResume().setForeground(Color.white);
		this.getBtnResume().setBorder(null);
		this.getBtnResume().setFocusPainted(false);
		this.add(this.getBtnResume());
		
		this.setBtnHighScore(new JButton("High Score"));
		this.getBtnHighScore().setBounds(150, 150, 725, 50);
		this.getBtnHighScore().setFont(new Font("Arial", Font.BOLD, 40));
		this.getBtnHighScore().setBackground(Color.black);
		this.getBtnHighScore().setForeground(Color.white);
		this.getBtnHighScore().setBorder(null);
		this.getBtnHighScore().setFocusPainted(false);
		this.add(this.getBtnHighScore());
		
		this.setBtnExit(new JButton("Exit"));
		this.getBtnExit().setBounds(150, 250, 725, 50);
		this.getBtnExit().setFont(new Font("Arial", Font.BOLD, 40));
		this.getBtnExit().setBackground(Color.black);
		this.getBtnExit().setForeground(Color.white);
		this.getBtnExit().setBorder(null);
		this.getBtnExit().setFocusPainted(false);
		this.add(this.getBtnExit());
		
	}

	public void addMyMouseListener(MyMouseListener mouseAdapter) {
		this.getBtnResume().addMouseListener(mouseAdapter);
		this.getBtnExit().addMouseListener(mouseAdapter);
		this.getBtnHighScore().addMouseListener(mouseAdapter);
//		this.getBtnSettings().addMouseListener(mouseAdapter);
//		this.getBtnShop().addMouseListener(mouseAdapter);
	}
	
	public void addActionListenerToButtons(MainController m) {
		this.getBtnResume().addActionListener(m::pressedResume);
		this.getBtnExit().addActionListener(m::pressedExit);
		this.getBtnHighScore().addActionListener(m::pressedHighScore);
//		this.getBtnSettings().addActionListener(m::pressedSettings);
//		this.getBtnShop().addActionListener(m::pressedShop);
	}
	
}
