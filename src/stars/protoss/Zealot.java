package stars.protoss;

import stars.Behavior;

public class Zealot extends Protoss {
	private String name;
	private int hp;
	private int sh;
	public static int attack = 10;

	public Zealot(String name) {
		this.name = name;
		this.hp = 100;
		this.sh = 100;
	}
	public void attack(Behavior b1) {
		b1.setHp(b1.getHp()-this.getAttack());
		System.out.println("공격자 : "+this.getName()+" 공격력 "+this.getAttack()
		+" 피격자 : "+b1.getName()+" HP= "+b1.getHp());
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
