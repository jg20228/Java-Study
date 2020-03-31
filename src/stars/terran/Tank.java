package stars.terran;

import stars.Behavior;

public class Tank extends Terran {
	private String name;
	private int hp;
	public static int attack = 30;

	public Tank(String name) {
		this.name = name;
		this.hp = 100;
	}

	@Override
	public void attack(Behavior b) {
		System.out.println("원거리 공격");
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
