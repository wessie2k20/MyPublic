package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class MyMouseListener extends MouseAdapter{
	private MainController mainController;

	public MainController getMainController() {
		return mainController;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	
	public MyMouseListener(MainController mainController) {
		this.setMainController(mainController);
	}
	
    public void mouseEntered(MouseEvent e) {
    	if(e.getSource() instanceof JButton) {
    		((JButton)e.getSource()).setBackground(new Color(0,230,115));
    		((JButton)e.getSource()).setForeground(Color.black);
    	}
    }
 
    public void mouseExited(MouseEvent e) {
    	if(e.getSource() instanceof JButton) {
    		((JButton)e.getSource()).setBackground(Color.black);
    		((JButton)e.getSource()).setForeground(Color.white);
    	}
    }
    
    
    
	
}
