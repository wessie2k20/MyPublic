package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private GameLabel label;
	private PausePanel pausePanel;
	private JDesktopPane lPane;
	private GameOverPanel goPanel;
	private GameStartPanel gsPanel;
	private HighScorePanel hsPanel;
	
	public GameLabel getLabel() {
		return label;
	}

	public void setLabel(GameLabel label) {
		this.label = label;
	}
	
	public PausePanel getPausePanel() {
		return pausePanel;
	}

	public void setPausePanel(PausePanel pausePanel) {
		this.pausePanel = pausePanel;
	}

	public JDesktopPane getlPane() {
		return lPane;
	}

	public void setlPane(JDesktopPane lPane) {
		this.lPane = lPane;
	}
	
	public GameOverPanel getGoPanel() {
		return goPanel;
	}

	public void setGoPanel(GameOverPanel goPanel) {
		this.goPanel = goPanel;
	}

	public GameStartPanel getGsPanel() {
		return gsPanel;
	}
	
	public void setGsPanel(GameStartPanel gsPanel) {
		this.gsPanel = gsPanel;
	}

	public HighScorePanel getHsPanel() {
		return hsPanel;
	}

	public void setHsPanel(HighScorePanel hsPanel) {
		this.hsPanel = hsPanel;
	}

	public void updateInMenuInLabel(boolean menu) {
		this.getLabel().setInMenu(menu);
	}

	public MainPanel() {
		this.setLayout(new BorderLayout());
//		this.setBackground(Color.yellow);
		
		this.setlPane(new JDesktopPane());
		this.add(this.getlPane());
		
//		this.getlPane().setBackground(Color.green);
		
		this.setLabel(new GameLabel());
		this.setPausePanel(new PausePanel());
		this.setGoPanel(new GameOverPanel());
		this.setGsPanel(new GameStartPanel());
		this.setHsPanel(new HighScorePanel());
		

		this.setLayout(null);
		this.getlPane().setBounds(0, 0, 1024, 768);
		this.getlPane().setLayout(null);
		
		this.getlPane().add(this.getLabel());
		this.getlPane().add(this.getPausePanel());
		this.getlPane().add(this.getGoPanel());
		this.getlPane().add(this.getGsPanel());
		this.getlPane().add(this.getHsPanel());


		this.getlPane().setLayer(this.getLabel(), 0);
		this.getlPane().setLayer(this.getPausePanel(), 1);
		this.getlPane().setLayer(this.getGoPanel(), 2);
		this.getlPane().setLayer(this.getGsPanel(), 3);
		this.getlPane().setLayer(this.getHsPanel(), 4);
		
		this.revalidate();
		this.repaint();
		
	}
}