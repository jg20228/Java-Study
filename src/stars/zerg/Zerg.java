package stars.zerg;

import stars.Behavior;

public abstract class Zerg implements Behavior{
	public void move() {
		System.out.println("�̵�");
	}
	public void repair() {
		System.out.println("�ڿ� ġ��");
	}
	public abstract void attack(Behavior b);
	
	public static void upgrade() {
		Hydra.attack++;
		Ultra.attack++;
	}
	
}
