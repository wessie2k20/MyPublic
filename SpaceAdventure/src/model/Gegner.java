package model;

public class Gegner extends GameObject {

	
	public Gegner() {
		this.setyPos(-200);
		this.setxPos(((int) (Math.random() * 950) + 1));
		this.setSpeed(((int) (Math.random() * 3) + 2));
		this.setHeight(70);
		this.setWidth(70);
	}
	
	public void moveGegner() {
		if(this.getyPos() + this.getSpeed() < 800) {
			this.setyPos(this.getyPos()+this.getSpeed());
		}else {
			this.setyPos(-200);
			this.setxPos(((int) (Math.random() * 950) + 1));
			this.setSpeed(((int) (Math.random() * 3) + 2));
		}
	}
	public void resetGegner() {
		this.setyPos(-200);
		this.setxPos(((int) (Math.random() * 950) + 1));
		this.setSpeed(((int) (Math.random() * 3) + 2));
	}
}
