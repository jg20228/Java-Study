package a02;

public class Missile {

	int x;
	int y;
	int angle;
	int speed;
	int who;

	Missile(int x, int y, int angle, int speed, int who) {// �̻��� ��ǥ �Է�
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.angle = angle;
		this.who = who;
	}

	public void move() {// �̻��� �̵�
		x += Math.cos(Math.toRadians(angle)) * speed;
		y += Math.sin(Math.toRadians(angle)) * speed;
	}
}
