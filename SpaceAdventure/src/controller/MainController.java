package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import gui.MainView;
import model.MainModel;

public class MainController {
	
	private class MyTimerTaskSwing extends javax.swing.Timer{

		public MyTimerTaskSwing(int delay, ActionListener listener) {
			super(delay, listener);
			
		}
		
	}
	
	private class MyTimerTask extends TimerTask {

		private MainController mc;

		private MyTimerTask(MainController mainController) {
			this.mc = mainController;
		}

		@Override
		public void run() {
			if (!this.mc.getMainModel().isInMenu() && !this.mc.getMainModel().isGameOver()
					&& this.mc.getMainModel().isGameStart() && !this.mc.getMainModel().isHsMenu()) {
				this.mc.getMainView().backGroundMovement();
			}
		}

	}

	private MainView mainView;
	private MainModel mainModel;
	private Timer backgroundTimer;
	private MyTimerTask timerTask;
	private KeyHandler keyHandler;
	private MyMouseListener mouseAdapter;
	private boolean highScoreDone;
	public MainView getMainView() {
		return mainView;
	}

	public void setMainView(MainView mainView) {
		this.mainView = mainView;
	}

	public MainModel getMainModel() {
		return mainModel;
	}

	public void setMainModel(MainModel mainModel) {
		this.mainModel = mainModel;
	}

	public Timer getBackgroundTimer() {
		return backgroundTimer;
	}

	public void setBackgroundTimer(Timer backgroundTimer) {
		this.backgroundTimer = backgroundTimer;
	}

	public MyTimerTask getTimerTask() {
		return timerTask;
	}

	public void setTimerTask(MyTimerTask timerTask) {
		this.timerTask = timerTask;
	}

	public KeyHandler getKeyHandler() {
		return keyHandler;
	}

	public void setKeyHandler(KeyHandler keyHandler) {
		this.keyHandler = keyHandler;
	}

	public MyMouseListener getMouseAdapter() {
		return mouseAdapter;
	}

	public void setMouseAdapter(MyMouseListener mouseAdapter) {
		this.mouseAdapter = mouseAdapter;
	}

	public boolean isHighScoreDone() {
		return highScoreDone;
	}

	public void setHighScoreDone(boolean highScoreDone) {
		this.highScoreDone = highScoreDone;
	}

	public MainController() {
		this.setMainView(new MainView());
		this.setMainModel(new MainModel(this));
		this.setBackgroundTimer(new Timer());
		this.setTimerTask(new MyTimerTask(this));
		this.setKeyHandler(new KeyHandler(this));
		this.setMouseAdapter(new MyMouseListener(this));
		this.getMainView().addKeyListener(this.getKeyHandler());
		this.getMainView().addMyMouseListener(this.getMouseAdapter());
		this.getMainView().addActionListenerToButtons(this);
		this.runBackgroundTimer();
//		try {
//			AudioInputStream ais = AudioSystem.getAudioInputStream(this.getClass().getResource("/Backgroundspaceattak.wav"));
//			Clip clip = AudioSystem.getClip();
//			clip.open(ais);
//			clip.loop(Clip.LOOP_CONTINUOUSLY);
//		} catch (UnsupportedAudioFileException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (LineUnavailableException e) {
//			e.printStackTrace();
//		}
	}

	public void runBackgroundTimer() {
		this.getBackgroundTimer().scheduleAtFixedRate(this.getTimerTask(), 0, 9);
	}

	public void update(MainModel m) {
		this.getMainView().moveRocket(m.getRocket().getxPos(), m.getRocket().getyPos());
		int[] gegnerXPos = new int[m.getGegner().length];
		int[] gegnerYPos = new int[m.getGegner().length];
		for (int i = 0; i < m.getGegner().length; i++) {
			gegnerYPos[i] = m.getGegner()[i].getyPos();
			gegnerXPos[i] = m.getGegner()[i].getxPos();
		}
		this.getMainView().moveGegner(gegnerYPos, gegnerXPos);

		int[] goldXPos = new int[m.getGold().length];
		int[] goldYPos = new int[m.getGold().length];
		for (int i = 0; i < m.getGold().length; i++) {
			goldYPos[i] = m.getGold()[i].getyPos();
			goldXPos[i] = m.getGold()[i].getxPos();
		}
		this.getMainView().updateLeben(m.getSpieler().getLeben());
		this.getMainView().updatePunkte(m.getSpieler().getPunkte());
		this.getMainView().moveGold(goldYPos, goldXPos);
		this.getMainView().setInMenu(m.isInMenu());
		this.getMainView().setGameOver(m.isGameOver());
		this.getMainView().setGameStart(m.isGameStart());
		this.getMainView().setHsMenu(m.isHsMenu());
		this.getMainView().setShooting(m.getRocket().isShoot());
		this.getMainView().moveSchuss(m.getSchuss().getyPos(), m.getSchuss().getxPos() + 25);
		this.getMainView().updateHighScores(m.getHighScore().getHighScore());
		if (m.isInMenu() || m.isGameOver()) {
			this.getMainView().updateExpNumber(-1);
		}
		if (m.isGameOver()&& !this.isHighScoreDone()) {
			this.setHighScoreDone(m.saveHighScore(this.getMainView().doGameOver()));
		} 
	}

	public void updateRocketHit(int expNumber) {
		this.getMainView().updateExpNumber(expNumber);
	}

	public int getExpNumberFromView() {
		return this.getMainView().getExpNumber();
	}

	public void pressedResume(ActionEvent e) {
		this.getMainModel().setInMenu(false);
	}

	public void pressedExit(ActionEvent e) {
		int auswahl = JOptionPane.showConfirmDialog(getMainView(), "Beenden?");
		if (auswahl == 0) {
			System.exit(0);
		}
	}

	public void pressedSettings(ActionEvent e) {

	}

	public void pressedShop(ActionEvent e) {

	}

	public void pressedNewGame(ActionEvent e) {
		this.getMainModel().newGame();
		this.getMainView().setSaveDialogShow(false);
		this.setHighScoreDone(false);
	}

	public void pressedGameStart(ActionEvent e) {
		this.getMainModel().setGameStart(true);
	}

	public void pressedHighScore(ActionEvent e) {
		this.getMainModel().setHsMenu(true);
		this.getMainModel().setInMenu(false);
	}

	public void pressedBack(ActionEvent e) {
		this.getMainModel().setHsMenu(false);
	}

	public void shoot() {
		this.getMainModel().shoot();
	}

}
