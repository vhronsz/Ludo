package model;

import java.util.Random;

public class Roll {
	public float x;
	public float y;
	public int value;
	
	public Roll(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public void random_Dice() {
		Random rand = new Random();
		this.value = rand.nextInt(6)+1;
	}
	
}
