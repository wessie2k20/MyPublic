package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class HighScore implements Serializable{

	private static final long serialVersionUID = -686594846457199242L;
	
	private Map<Integer, String> highScore;

	public Map<Integer, String> getHighScore() {
		return highScore;
	}

	public void setHighScore(Map<Integer, String> highScore) {
		this.highScore = highScore;
	}
	
	public HighScore() {
		this.setHighScore(new HashMap< Integer,String>());	
	}
	
	public void addHighScore( Integer score, String name) {
		this.getHighScore().put(score, name);
	}
	
	
	
}
