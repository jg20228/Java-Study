package stars.protoss;

import stars.Behavior;

public class Dragoon extends Protoss {
	private String name;
	private int hp;
	private int sh;
	public static int attack = 15;

	public Dragoon(String name) {
		this.name = name;
		this.hp = 100;
		this.sh = 100;
	}

	@Override
	public void attack(Behavior b1) {
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

	public int getSh() {
		return sh;
	}

	public void setSh(int sh) {
		this.sh = sh;
	}

	public int getAttack() {
		return attack;
	}
}
