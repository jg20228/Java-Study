package stars.zerg;

import stars.Behavior;

public class Ultra extends Zerg{
	private String name;
	private int hp;
	public static int attack =50;
	
	public Ultra(String name) {
		this.name = name;
		this.hp = 100;
	}
	public void attack(Behavior unit) {
		System.out.println("근거리 공격");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}
}
