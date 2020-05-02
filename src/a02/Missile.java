package a02;

public class Missile {

	int x;
	int y;
	int angle;
	int speed;
	int who;

	Missile(int x, int y, int angle, int speed, int who) {// 미사일 좌표 입력
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.angle = angle;
		this.who = who;
	}

	public void move() {// 미사일 이동
		x += Math.cos(Math.toRadians(angle)) * speed;
		y += Math.sin(Math.toRadians(angle)) * speed;
	}
}
