package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Timer;
import java.util.TimerTask;

import controller.MainController;
import controller.MovemetDirection;

public class MainModel {

	private class MyRocketMovementTimerTask extends TimerTask {
		private MainModel mainModel;
		private int oneUp;

		public MainModel getMainModel() {
			return mainModel;
		}

		public void setMainModel(MainModel mainModel) {
			this.mainModel = mainModel;
		}

		public int getOneUp() {
			return oneUp;
		}

		public void setOneUp(int oneUp) {
			this.oneUp = oneUp;
		}

		public MyRocketMovementTimerTask(MainModel mainModel) {
			this.setMainModel(mainModel);
			this.setOneUp(0);
		}

		@Override
		public void run() {
			if (!this.getMainModel().isInMenu() && !this.getMainModel().isGameOver()
					&& this.getMainModel().isGameStart() && !this.getMainModel().isHsMenu()) {
				// Raketen Movement
				if (this.getMainModel().getRocket().isMovingUp()) {
					this.getMainModel().getRocket().moveUp();
				}
				if (this.getMainModel().getRocket().isMovingLeft()) {
					this.getMainModel().getRocket().moveLeft();
				}
				if (this.getMainModel().getRocket().isMovingright()) {
					this.getMainModel().getRocket().moveRight();
				}
				if (this.getMainModel().getRocket().isMovingDown()) {
					this.getMainModel().getRocket().moveDown();
				}
				// Shoot
				if (this.getMainModel().getRocket().isShoot()) {
					this.getMainModel().shoot();
				}
				// Gegner Movement
				this.getMainModel().moveGegner();

				for (Gold gold : this.getMainModel().getGold()) {
					gold.moveGold();
				}
				if (this.getMainModel().checkKollisionGegner()) {
					this.getMainModel().getMainController().updateRocketHit(0);
					this.getMainModel().getMyTimer().updateExpNumberInTimerTask(0);
				}
				this.getMainModel().checkKollisionGold();
				this.getMainModel().checkKollisionSchuss();
				if (this.getMainModel().getSpieler().getPunkte() != 0) {
					if (this.getMainModel().getSpieler().getPunkte() % 100 == 0
							&& this.getOneUp() != this.getMainModel().getSpieler().getPunkte()) {
						this.getMainModel().doOneUp();
						this.setOneUp(this.getMainModel().getSpieler().getPunkte());
					}
				}
			}
			this.getMainModel().getMainController().update(this.getMainModel());

		}

	}

	private Rocket rocket;
	private Spieler spieler;
	private Schuss schuss;
	private MainController mainController;
	private Timer timer;
	private MyTimer myTimer;
	private MyRocketMovementTimerTask timerTask;
	private Gegner[] gegner;
	private Gold[] gold;
	private boolean inMenu, gameOver, gameStart, hsMenu;
	private HighScore highScore;

	public Rocket getRocket() {
		return rocket;
	}

	public void setRocket(Rocket rocket) {
		this.rocket = rocket;
	}

	public Spieler getSpieler() {
		return spieler;
	}

	public void setSpieler(Spieler spieler) {
		this.spieler = spieler;
	}

	public MainController getMainController() {
		return mainController;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public MyTimer getMyTimer() {
		return myTimer;
	}

	public void setMyTimer(MyTimer myTimer) {
		this.myTimer = myTimer;
	}

	public MyRocketMovementTimerTask getTimerTask() {
		return timerTask;
	}

	public void setTimerTask(MyRocketMovementTimerTask timerTask) {
		this.timerTask = timerTask;
	}

	public Gegner[] getGegner() {
		return gegner;
	}

	public void setGegner(Gegner[] gegner) {
		this.gegner = gegner;
	}

	public Gold[] getGold() {
		return gold;
	}

	public void setGold(Gold[] gold) {
		this.gold = gold;
	}

	public boolean isInMenu() {
		return inMenu;
	}

	public void setInMenu(boolean inMenu) {
		this.inMenu = inMenu;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public Schuss getSchuss() {
		return schuss;
	}

	public void setSchuss(Schuss schuss) {
		this.schuss = schuss;
	}

	public boolean isGameStart() {
		return gameStart;
	}

	public void setGameStart(boolean gameStart) {
		this.gameStart = gameStart;
	}

	public boolean isHsMenu() {
		return this.hsMenu;
	}

	public void setHsMenu(boolean hsMenu) {
		this.hsMenu = hsMenu;
	}

	public HighScore getHighScore() {
		return highScore;
	}

	public void setHighScore(HighScore highScore) {
		this.highScore = highScore;
	}

	public MainModel(MainController mainController) {
		this.setMainController(mainController);
		this.setGameStart(false);
		this.setHsMenu(false);
		this.initialize();
	}

	private void initialize() {
		this.setRocket(new Rocket());
		this.setTimer(new Timer());
		this.setSpieler(new Spieler());
		this.setSchuss(new Schuss());
		this.loadHighScore();

		this.setGameOver(false);
		this.setGegner(new Gegner[5]);
		this.createGegner();

		this.setGold(new Gold[5]);
		for (int i = 0; i < this.getGold().length; i++) {
			this.getGold()[i] = new Gold();
		}
		this.setMyTimer(new MyTimer(this));
		this.getMainController().update(this);
		this.setTimerTask(new MyRocketMovementTimerTask(this));
		this.getTimer().scheduleAtFixedRate(getTimerTask(), 0, 10);

	}

	public void moveRocketLeft(boolean move) {
		this.getRocket().setMovingLeft(move);
	}

	public void moveRocketUp(boolean move) {
		this.getRocket().setMovingUp(move);
	}

	public void moveRocketDown(boolean move) {
		this.getRocket().setMovingDown(move);
	}

	public void moveRocketRight(boolean move) {
		this.getRocket().setMovingright(move);
	}

	public boolean checkKollisionGegner() {
		for (Gegner g : this.getGegner()) {
			if (g.getBounds().intersects(this.getRocket().getBounds())) {

				if (this.getSpieler().getLeben() - 1 >= 0) {
					this.getSpieler().setLeben(this.getSpieler().getLeben() - 1);
				}
				if (this.getSpieler().getLeben() == 0) {
					this.setGameOver(true);
				}
				this.createGegner(g);

				return true;
			}
		}
		return false;
	}

	public boolean checkKollisionGold() {
		for (Gold g : this.getGold()) {
			if(g.getBounds().intersects(this.getRocket().getBounds())) {
				this.getSpieler().setPunkte(this.getSpieler().getPunkte() + g.getWert());
				this.getSpieler().setPunkte(this.getSpieler().getPunkte() + g.getWert());
				g.resetGold();
				return true;
			}
		}
		return false;
	}

	public boolean checkLoose() {
		return this.getSpieler().getLeben() == 0;
	}

	public boolean checkKollisionSchuss() {
		for (Gegner g : this.getGegner()) {
			if(g.getBounds().intersects(this.getSchuss().getBounds())) {
				g.resetGegner();
				this.getRocket().setShoot(false);
				return true;
			}
		}
		return false;
	}

	public void newGame() {
		this.setRocket(new Rocket());
		this.setTimer(new Timer());
		this.setSpieler(new Spieler());
		this.setGameOver(false);
		this.createGegner();
		this.setGold(new Gold[5]);
		for (int i = 0; i < this.getGold().length; i++) {
			this.getGold()[i] = new Gold();
		}
		this.getMainController().updateRocketHit(-1);
		this.getMainController().update(this);
	}

	public int shoot() {
		if (this.getSchuss().getyPos() - this.getSchuss().getSpeed() > -50) {
			this.getSchuss().setyPos(this.getSchuss().getyPos() - this.getSchuss().getSpeed());
		} else {
			this.getSchuss().setyPos(-600);
			this.getRocket().setShoot(false);
		}
		return this.getSchuss().getyPos();
	}

	public void doOneUp() {
		this.getSpieler().setLeben(this.getSpieler().getLeben() + 1);
	}

	public boolean saveHighScore(String name) {
		if (!name.equalsIgnoreCase("")) {
			this.getHighScore().addHighScore(this.getSpieler().getPunkte(), name);
		}
		File f = new File("config/HighScore.ser");
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try (FileOutputStream fos = new FileOutputStream("config/HighScore.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(this.getHighScore());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public void loadHighScore() {
		File f = new File("config");
		if (!f.exists()) {
			f.mkdir();
		}
		File f1 = new File("config/HighScore.ser");
		if (f1.exists()) {
			try (FileInputStream fis = new FileInputStream("config/HighScore.ser");
					ObjectInputStream ois = new ObjectInputStream(fis)) {
				this.setHighScore((HighScore) ois.readObject());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			this.setHighScore(new HighScore());
		}
	}

	private void createGegner(Gegner g) {
		int i = 0, x = 0;
		while (i < this.getGegner().length) {
			g.resetGegner();
			while (x < i) {
				if (this.getGegner()[x].getxPos() <= g.getxPos() + 60
						&& this.getGegner()[x].getxPos() >= g.getxPos() - 60 && g != this.getGegner()[x]) {
					g.resetGegner();
					x = 0;
				} else {
					x++;
				}
			}
			i++;
			x = 0;
		}
	}

	private void createGegner() {
		int i = 0, x = 0;
		while (i < this.getGegner().length) {
			this.getGegner()[i] = new Gegner();
			while (x < i) {
				if (this.getGegner()[x].getxPos() <= this.getGegner()[i].getxPos() + 60
						&& this.getGegner()[x].getxPos() >= this.getGegner()[i].getxPos() - 60) {
					this.getGegner()[i].resetGegner();
					x = 0;
				} else {
					x++;
				}
			}
			i++;
			x = 0;
		}
	}

	private void moveGegner() {
		for (Gegner g : this.getGegner()) {
			if (g.getyPos() + g.getSpeed() < 800) {
				g.setyPos(g.getyPos() + g.getSpeed());
			} else {
				this.createGegner(g);
			}
		}
	}

}
