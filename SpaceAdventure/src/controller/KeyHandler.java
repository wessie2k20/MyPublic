package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter{
	private MainController mainController;
	
    public MainController getMainController() {
		return mainController;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}
	public KeyHandler(MainController mainController) {
		this.setMainController(mainController);
	}
	public void keyPressed(KeyEvent e) {
    	if(e.getKeyCode()==37) {
    		this.getMainController().getMainModel().moveRocketLeft(true);
    	} 
    	if(e.getKeyCode()== 38 ) {
    		this.getMainController().getMainModel().moveRocketUp(true);
    	}
    	if(e.getKeyCode()== 39 ) {
    		this.getMainController().getMainModel().moveRocketRight(true);
    	}
    	if(e.getKeyCode()== 40 ) {
    		this.getMainController().getMainModel().moveRocketDown(true);
    	}
    	if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
    		if(!getMainController().getMainModel().isInMenu()&& !this.getMainController().getMainModel().isGameOver() && !this.getMainController().getMainModel().isHsMenu()) {
    			this.getMainController().getMainModel().setInMenu(true);    			
    		}else {
    			this.getMainController().getMainModel().setInMenu(false);    	
    		}
    	}
    	if(e.getKeyCode() == KeyEvent.VK_SPACE) {
    		if(!this.getMainController().getMainModel().getRocket().isShoot()) {
    			this.getMainController().getMainModel().getRocket().setShoot(true);
    			this.getMainController().getMainModel().getSchuss().setyPos(this.getMainController().getMainModel().getRocket().getyPos());
    			this.getMainController().getMainModel().getSchuss().setxPos(this.getMainController().getMainModel().getRocket().getxPos());
    			this.getMainController().shoot();
    		}
    	}
    }

    public void keyReleased(KeyEvent e) {
    	if(e.getKeyCode()==37) {
    		this.getMainController().getMainModel().moveRocketLeft(false);
    	} 
    	if(e.getKeyCode()== 38 ) {
    		this.getMainController().getMainModel().moveRocketUp(false);
    	}
    	if(e.getKeyCode()== 39 ) {
    		this.getMainController().getMainModel().moveRocketRight(false);
    	}
    	if(e.getKeyCode()== 40 ) {
    		this.getMainController().getMainModel().moveRocketDown(false);

    	}
    }
	
	
}
