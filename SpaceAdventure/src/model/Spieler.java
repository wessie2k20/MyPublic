package model;

public class Spieler {
	private int punkte, leben, maxLeben;

	public int getPunkte() {
		return punkte;
	}

	public void setPunkte(int punkte) {
		this.punkte = punkte;
	}

	public int getLeben() {
		return leben;
	}

	public void setLeben(int leben) {
		this.leben = leben;
	}

	public int getMaxLeben() {
		return maxLeben;
	}

	public void setMaxLeben(int maxLeben) {
		this.maxLeben = maxLeben;
	}
	
	public Spieler() {
		this.setPunkte(0);
		this.setMaxLeben(3);
		this.setLeben(this.getMaxLeben());
	}
	
}
