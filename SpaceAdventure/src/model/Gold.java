package model;

public class Gold extends GameObject{

	private int wert;
		
	public int getWert() {
		return wert;
	}

	public void setWert(int wert) {
		this.wert = wert;
	}

	
	public Gold() {
		this.setyPos(-200);
		this.setxPos(((int) (Math.random() * 749) + 1));
		this.setSpeed(((int) (Math.random() * 3) + 2));
		this.setWidth(50);
		this.setHeight(50);
		this.setWert(10);
	}
	
	public void moveGold() {
		if(this.getyPos() + this.getSpeed() < 768) {
			this.setyPos(this.getyPos()+this.getSpeed());
		}else {
			this.setyPos(-200);
			this.setxPos(((int) (Math.random() * 749) + 1));
			this.setSpeed(((int) (Math.random() * 3) + 2));
		}
	}

	public void resetGold() {
		this.setyPos(-200);
		this.setxPos(((int) (Math.random() * 749) + 1));
		this.setSpeed(((int) (Math.random() * 3) + 2));
//		this.setWert(((int) (Math.random() * 100) + 1));
	}
}
