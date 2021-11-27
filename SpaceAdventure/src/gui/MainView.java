package gui;

import java.awt.Color;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.MainController;
import controller.MyMouseListener;

public class MainView extends JFrame {
	private MainPanel mainPanel;
	private boolean inMenu, gameOver, shooting, gameStart, hsMenu, saveDialogShow;

	public MainPanel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(MainPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	public boolean isInMenu() {
		return inMenu;
	}

	public void setInMenu(boolean inMenu) {
		this.getMainPanel().getPausePanel().setVisible(inMenu);
		this.getMainPanel().updateInMenuInLabel(inMenu);
		this.requestFocus();
		this.inMenu = inMenu;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.getMainPanel().getGoPanel().setVisible(gameOver);
		this.getMainPanel().updateInMenuInLabel(gameOver);
		this.requestFocus();
		this.gameOver = gameOver;
	}

	public boolean isShooting() {
		return shooting;
	}

	public void setShooting(boolean shooting) {
		this.getMainPanel().getLabel().setShoot(shooting);
		this.shooting = shooting;
	}

	public boolean isGameStart() {
		return gameStart;
	}

	public void setGameStart(boolean gameStart) {
		this.getMainPanel().getGsPanel().setVisible(!gameStart);
		this.getMainPanel().updateInMenuInLabel(gameStart);
		this.gameStart = gameStart;
	}

	public boolean isHsMenu() {
		return hsMenu;
	}

	public void setHsMenu(boolean hsMenu) {
		this.getMainPanel().getHsPanel().setVisible(hsMenu);
		this.hsMenu = hsMenu;
	}

	public boolean isSaveDialogShow() {
		return saveDialogShow;
	}

	public void setSaveDialogShow(boolean saveDialogShow) {
		this.saveDialogShow = saveDialogShow;
	}

	public MainView() {
		this.frameInit();
		this.setTitle("Space Attack");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(400, 200, 1024, 768);
		this.setLayout(null);
		this.setResizable(false);
		this.setMainPanel(new MainPanel());
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		this.setContentPane(this.getMainPanel());
		this.setVisible(true);
	}

	public void backGroundMovement() {
		int yBg1 = this.getMainPanel().getLabel().getyBg1();
		if (yBg1 < 768) {
			this.getMainPanel().getLabel().setyBg1(yBg1 += 2);
		} else {
			this.getMainPanel().getLabel().setyBg1(-768);
		}
		int yBg2 = this.getMainPanel().getLabel().getyBg2();
		if (yBg2 < 768) {
			this.getMainPanel().getLabel().setyBg2(yBg2 += 2);
		} else {
			this.getMainPanel().getLabel().setyBg2(-768);
		}
	}

	public void moveRocket(int xPos, int yPos) {
		this.getMainPanel().getLabel().setxRocketPos(xPos);
		this.getMainPanel().getLabel().setyRocketPos(yPos);
	}

	public void moveGegner(int[] gegnerYPos, int[] gegnerXPos) {
		this.getMainPanel().getLabel().updateGegnerPos(gegnerYPos, gegnerXPos);

	}

	public void moveSchuss(int yPos, int xPos) {
		this.getMainPanel().getLabel().setSchussY(yPos);
		this.getMainPanel().getLabel().setSchussX(xPos);
	}

	public void moveGold(int[] goldYPos, int[] goldXPos) {
		this.getMainPanel().getLabel().updateGoldPos(goldYPos, goldXPos);
	}

	public void updateLeben(int leben) {
		this.getMainPanel().getLabel().setLebenString("Leben: " + leben);
	}

	public void updatePunkte(int punkte) {
		this.getMainPanel().getLabel().setPunkteString("Punkte: " + punkte);
	}

	public void updateExpNumber(int number) {
		this.getMainPanel().getLabel().setExpNumber(number);
	}

	public int getExpNumber() {
		return this.getMainPanel().getLabel().getExpNumber();
	}

	public void updateHighScores(Map<Integer, String> hs) {
		this.getMainPanel().getHsPanel().setHighScores(hs);
	}

	public void addMyMouseListener(MyMouseListener mouseAdapter) {
		this.getMainPanel().getPausePanel().addMyMouseListener(mouseAdapter);
		this.getMainPanel().getGoPanel().addMyMouseListener(mouseAdapter);
		this.getMainPanel().getGsPanel().addMyMouseListener(mouseAdapter);
		this.getMainPanel().getHsPanel().addMyMouseListener(mouseAdapter);

	}

	public void addActionListenerToButtons(MainController m) {
		this.getMainPanel().getPausePanel().addActionListenerToButtons(m);
		this.getMainPanel().getGoPanel().addActionListenerToButtons(m);
		this.getMainPanel().getGsPanel().addActionListenerToButtons(m);
		this.getMainPanel().getHsPanel().addActionListenerToButtons(m);
	}

	public String doGameOver() {
		int auswahl = -1;
		if (!this.isSaveDialogShow()) {
			auswahl = JOptionPane.showConfirmDialog(this, "HighScore speichern?");
		}
		String name = "";
		if (auswahl == 0) {
			name = JOptionPane.showInputDialog(this, "Namen eintragen");
		}
		this.setSaveDialogShow(true);
//		System.out.println("Name: " + name);
		return name;
	}

}
