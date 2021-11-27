package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import model.GameObject;
import utility.GraphicsLoader;

public class GameLabel extends JLabel {
	private BufferedImage bg1, bg2, rocket, gegner, gold, schuss;
	private BufferedImage[] explosion;
	private Image gifExplosion;
	private int yBg1, yBg2;
	private int yRocketPos, xRocketPos;
	private int expNumber;
	private int[] yGegnerPos, xGegnerPos;
	private int[] yGoldPos, xGoldPos;
	private String lebenString, punkteString;
	private boolean inMenu, shoot;
	private int schussY, schussX;

	public BufferedImage getBg1() {
		return bg1;
	}

	public void setBg1(BufferedImage bg1) {
		this.bg1 = bg1;
	}

	public BufferedImage getBg2() {
		return bg2;
	}

	public void setBg2(BufferedImage bg2) {
		this.bg2 = bg2;
	}

	public BufferedImage getRocket() {
		return rocket;
	}

	public void setRocket(BufferedImage rocket) {
		this.rocket = rocket;
	}

	public BufferedImage getGegner() {
		return gegner;
	}

	public void setGegner(BufferedImage gegner) {
		this.gegner = gegner;
	}

	public BufferedImage getGold() {
		return gold;
	}

	public void setGold(BufferedImage gold) {
		this.gold = gold;
	}

	public BufferedImage[] getExplosion() {
		return explosion;
	}

	public void setExplosion(BufferedImage[] explosion) {
		this.explosion = explosion;
	}

	public BufferedImage getSchuss() {
		return schuss;
	}

	public void setSchuss(BufferedImage schuss) {
		this.schuss = schuss;
	}

	public Image getGifExplosion() {
		return gifExplosion;
	}

	public void setGifExplosion(Image gifExplosion) {
		this.gifExplosion = gifExplosion;
	}

	public int getyBg1() {
		return yBg1;
	}

	public void setyBg1(int yBg1) {
		this.yBg1 = yBg1;
	}

	public int getyBg2() {
		return yBg2;
	}

	public void setyBg2(int yBg2) {
		this.yBg2 = yBg2;
	}

	public int getyRocketPos() {
		return yRocketPos;
	}

	public void setyRocketPos(int yRocketPos) {
		this.yRocketPos = yRocketPos;
	}

	public int getxRocketPos() {
		return xRocketPos;
	}

	public void setxRocketPos(int xRocketPos) {
		this.xRocketPos = xRocketPos;
	}

	public int[] getyGegnerPos() {
		return yGegnerPos;
	}

	public void setyGegnerPos(int[] ygegnerPos) {
		this.yGegnerPos = ygegnerPos;
	}

	public int[] getxGegnerPos() {
		return xGegnerPos;
	}

	public void setxGegnerPos(int[] xGegnerPos) {
		this.xGegnerPos = xGegnerPos;
	}

	public int[] getyGoldPos() {
		return yGoldPos;
	}

	public void setyGoldPos(int[] yGoldPos) {
		this.yGoldPos = yGoldPos;
	}

	public int[] getxGoldPos() {
		return xGoldPos;
	}

	public void setxGoldPos(int[] xGoldPos) {
		this.xGoldPos = xGoldPos;
	}

	public String getLebenString() {
		return lebenString;
	}

	public void setLebenString(String lebenString) {
		this.lebenString = lebenString;
	}

	public String getPunkteString() {
		return punkteString;
	}

	public void setPunkteString(String punkteString) {
		this.punkteString = punkteString;
	}

	public int getExpNumber() {
		return expNumber;
	}

	public void setExpNumber(int expNumber) {
		this.expNumber = expNumber;
	}

	public boolean isInMenu() {
		return inMenu;
	}

	public void setInMenu(boolean inMenu) {
		this.inMenu = inMenu;
	}

	public int getSchussY() {
		return schussY;
	}

	public void setSchussY(int schussY) {
		this.schussY = schussY;
	}

	public int getSchussX() {
		return schussX;
	}

	public void setSchussX(int schussX) {
		this.schussX = schussX;
	}

	public boolean isShoot() {
		return shoot;
	}

	public void setShoot(boolean shoot) {
		this.shoot = shoot;
	}


	public GameLabel() {
		this.setyBg1(0);
		this.setyBg2(-768);
		this.setyRocketPos(200);
		this.setxRocketPos(200);
		this.setyGegnerPos(new int[5]);
		this.setxGegnerPos(new int[5]);
		this.setyGoldPos(new int[5]);
		this.setxGoldPos(new int[5]);
		this.setExpNumber(-1);
		this.setExplosion(new BufferedImage[16]);
		this.setLebenString("Leben: ");
		this.setPunkteString("Punkte: ");
		this.loadImages();
				
		this.setBounds(0, 0, 1024, 768);
		this.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.drawImage(this.getBg1(), 0, this.getyBg1(), 1024, 775, null);
		g.drawImage(this.getBg2(), 0, this.getyBg2(), 1024, 775, null);
		g.drawImage(this.getRocket(), this.getxRocketPos(), this.getyRocketPos(), 90, 110, null);
		for (int i = 0; i < this.getyGegnerPos().length; i++) {
			g.drawImage(this.getGegner(), this.getxGegnerPos()[i], this.getyGegnerPos()[i], 100, 100, null);
		}
		for (int i = 0; i < this.getyGoldPos().length; i++) {
			g.drawImage(this.getGold(), this.getxGoldPos()[i], this.getyGoldPos()[i], 50, 50, null);
			
		}
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 25));
		g.drawString(this.getLebenString(), 10, 30);
		g.drawString(this.getPunkteString(), 10, 60);

		if (this.getExpNumber() != -1) {
			g.drawImage(this.getExplosion()[this.getExpNumber()], this.getxRocketPos(), this.getyRocketPos(), 100, 130,
					null);
		}
		if (!this.isInMenu()) {
			if (this.getExpNumber() == 0 || this.getExpNumber() == 5 || this.getExpNumber() == 10) {
				g.setColor(new Color(250, 0, 0, 50));
				g.fillRect(0, 0, 1024, 768);
			}
		}
		if (this.isShoot()) {
			g.drawImage(this.getSchuss(), this.getSchussX(), this.getSchussY(), 30, 30, null);
		}
		this.repaint();
	}

	public void updateGegnerPos(int[] gegnerYPos, int[] gegnerXPos) {
		this.setyGegnerPos(gegnerYPos);
		this.setxGegnerPos(gegnerXPos);
	}

	public void updateGoldPos(int[] goldYPos, int[] goldXPos) {
		this.setyGoldPos(goldYPos);
		this.setxGoldPos(goldXPos);
	}

	private void loadImages(){
		this.setBg1(GraphicsLoader.loadGraphics("bg2.png"));
		this.setBg2(GraphicsLoader.loadGraphics("bg2.png"));
		this.setRocket(GraphicsLoader.loadGraphics("rkt.png"));
		this.setGegner(GraphicsLoader.loadGraphics("gegner.png"));
		this.setGold(GraphicsLoader.loadGraphics("stern.png"));
		this.setSchuss(GraphicsLoader.loadGraphics("schuss2.png"));
		for (int i = 0; i < this.getExplosion().length; i++) {
			if (i < 10) {
				this.getExplosion()[i] = GraphicsLoader.loadGraphics("exp0" + i + ".png");
			} else {
				this.getExplosion()[i] = GraphicsLoader.loadGraphics("exp" + i + ".png");
			}
		}
		this.setGifExplosion(GraphicsLoader.loadGraphics("exp.gif"));
	}
	
	/*
	 * In Progress
	 */
	public void renderGameObjects(List<GameObject> gameObjects) {
		Graphics g = this.getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	}
}
