package stars;

import stars.protoss.*;
import stars.terran.*;
import stars.zerg.*;

public class StartGame {
	public static void repair(Behavior b) {
		b.repair();
	}
	public static void move(Behavior b) {
		b.move();
	}
	public static void attack(Behavior b1, Behavior b2) {
		b1.attack(b2);
	}
	public static void main(String[] args) {
		Protoss.upgrade();
		Zealot z1 = new Zealot("����1");
		Dragoon d1 = new Dragoon("���1");
		Tank t1 = new Tank("��ũ1");
		Marine m1 = new Marine("����1");
		move(z1);
		repair(z1);
		// ����->���
		attack(z1, d1);
		
	}
}
