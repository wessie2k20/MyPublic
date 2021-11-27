package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

import controller.MainController;
import controller.MyMouseListener;

public class GameStartPanel extends JPanel{
	private GameStartLabel label;
	private JButton btnstart;
	private boolean inMenu;
	public GameStartLabel getLabel() {
		return label;
	}

	public void setLabel(GameStartLabel label) {
		this.label = label;
	}

	public JButton getBtnstart() {
		return btnstart;
	}

	public void setBtnstart(JButton btnstart) {
		this.btnstart = btnstart;
	}

	public boolean isInMenu() {
		return inMenu;
	}

	public void setInMenu(boolean inMenu) {
		this.setVisible(inMenu);
		this.inMenu = inMenu;
	}

	public GameStartPanel() {
		this.setLabel(new GameStartLabel());
		this.setBtnstart(new JButton("Start"));
		this.getBtnstart().setBounds(150, 450, 725, 50);
		this.getBtnstart().setFont(new Font("Arial", Font.BOLD, 40));
		this.getBtnstart().setBackground(Color.black);
		this.getBtnstart().setForeground(Color.white);
		this.getBtnstart().setBorder(null);
		this.getBtnstart().setFocusPainted(false);
		
		this.setLayout(null);
		this.setBounds(0, 0, 1024, 768);
		
		this.setBackground(Color.black);
		this.add(this.getLabel());
		this.add(this.getBtnstart());
		this.setVisible(true);	
	}

	public void addMyMouseListener(MyMouseListener mouseAdapter) {
		this.getBtnstart().addMouseListener(mouseAdapter);		
	}

	public void addActionListenerToButtons(MainController m) {
		this.getBtnstart().addActionListener(m::pressedGameStart);		 
	}
	
	
}
