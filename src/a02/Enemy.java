package a02;

public class Enemy {
	int x;
	int y;
	int speed;

	public Enemy(int x, int y, int enemy_Speed) {
		this.x = x;
		this.y = y;
		this.speed = enemy_Speed;
	}

	public void move() {
		x -= speed;
	}
}
