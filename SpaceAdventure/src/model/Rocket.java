package model;

public class Rocket extends GameObject {

	private int speedUp, speedDown, speedSides;
	private boolean movingUp, movingDown, movingLeft, movingright;
	private boolean hit;
	private boolean shoot;

	public int getSpeedUp() {
		return speedUp;
	}

	public void setSpeedUp(int speedUp) {
		this.speedUp = speedUp;
	}

	public int getSpeedDown() {
		return speedDown;
	}

	public void setSpeedDown(int speedDown) {
		this.speedDown = speedDown;
	}

	public int getSpeedSides() {
		return speedSides;
	}

	public void setSpeedSides(int speedSides) {
		this.speedSides = speedSides;
	}
	
	public boolean isMovingUp() {
		return movingUp;
	}

	public void setMovingUp(boolean movingUp) {
		this.movingUp = movingUp;
	}

	public boolean isMovingDown() {
		return movingDown;
	}

	public void setMovingDown(boolean movingDown) {
		this.movingDown = movingDown;
	}

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}

	public boolean isMovingright() {
		return movingright;
	}

	public void setMovingright(boolean movingright) {
		this.movingright = movingright;
	}

	public boolean isHit() {
		return hit;
	}

	public void setHit(boolean hit) {
		this.hit = hit;
	}
	
	public boolean isShoot() {
		return shoot;
	}
	
	public void setShoot(boolean shoot) {
		this.shoot = shoot;
	}
	
	public Rocket() {
		this.setyPos(400);
		this.setxPos(400);
		this.setSpeedUp(3);
		this.setSpeedDown(2);
		this.setSpeedSides(3);
		this.setShoot(false);
//		this.setMoving(false);
		this.setWidth(90);
		this.setHeight(110);
	}
	
	public int moveUp() {
		if((this.getyPos()- this.getSpeedUp())>0) {
			this.setyPos(this.getyPos() - this.getSpeedUp());			
		}
		return this.getyPos();
	}
	
	public int moveDown() {
		if((this.getyPos()-this.getSpeedDown())<650) {
			this.setyPos(this.getyPos() + this.getSpeedDown());			
		}
		return this.getyPos();
	}
	
	public int moveLeft() {
		if(this.getxPos()- this.getSpeedSides()>0) {
			this.setxPos(this.getxPos() - this.getSpeedSides());			
		}
		return this.getxPos();
	}
	
	public int moveRight() {
		if(this.getxPos() - this.getSpeedSides()<930) {			
			this.setxPos(this.getxPos() + this.getSpeedSides());
		}
		return this.getxPos();
	}
	
	public void stopMovement() {
		this.setMovingUp(false);
		this.setMovingDown(false);
		this.setMovingright(false);
		this.setMovingLeft(false);
	}
	
	
	
	
}
