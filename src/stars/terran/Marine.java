package stars.terran;

import stars.Behavior;

public class Marine extends Terran {
	private String name;
	private int hp;
	public static int attack = 5;

	public Marine(String name) {
		this.name = name;
		this.hp = 100;
	}

	public void attack(Behavior b) {
		System.out.println(this.getName()+"->"+b.getName());
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
