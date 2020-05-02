package a01;

import lombok.Data;

@Data
public class Player {
	private Player() {
	}

	private int playerX;
	private int playerY;
	private int playerHP;
	private int moveSpeed;
	private int power;
	private int width = 100;
	private int height = 100;
	private double angle;

	public Player(int x, int y, double angle,int hp, int moveSpeed, int power) {
		this.playerX = x;
		this.playerY = y;
		this.playerHP = hp;
		this.moveSpeed = moveSpeed;
		this.power = power;
	}
}
