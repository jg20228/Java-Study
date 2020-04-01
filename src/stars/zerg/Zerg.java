package stars.zerg;

import stars.Behavior;

public abstract class Zerg implements Behavior{
	public void move() {
		System.out.println("이동");
	}
	public void repair() {
		System.out.println("자연 치료");
	}
	public abstract void attack(Behavior b);
	
	public static void upgrade() {
		Hydra.attack++;
		Ultra.attack++;
	}
	
}
