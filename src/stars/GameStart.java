package stars;

import java.io.ObjectInputStream.GetField;

//다크템플러 Dark Templer, 리버 River

//오버로딩
abstract class Protoss {
	abstract public String getNAME();
	//abstract public String setNAME(); final이라서 변경불가 

	abstract public int getHp();
	abstract public void setHp(int hp);
	
	abstract public int getAttack();
	abstract public void setAttack(int attack);

}

class Zealot extends Protoss {
	private final String NAME;
	private int hp;
	static int attack = 10;

	public Zealot(String name) {
		this.NAME = name;
		this.hp = 100;
	}

	public String getNAME() {
		return NAME;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	@Override
	public void setAttack(int attack) {
		this.attack = attack;
	}

}

class Dragoon extends Protoss {
	private final String NAME;
	private int hp;
	static int attack = 15;

	public Dragoon(String name) {
		this.NAME = name;
		this.hp = 100;
	}

	public String getNAME() {
		return NAME;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	@Override
	public void setAttack(int attack) {
		this.attack = attack;
		
	}

}

class DarkTempler extends Protoss {
	private final String NAME;
	private int hp;
	static int attack = 50;

	public DarkTempler(String name) {
		this.NAME = name;
		this.hp = 100;
	}

	public String getNAME() {
		return NAME;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	@Override
	public void setAttack(int attack) {
		this.attack = attack;
		
	}

}

class River extends Protoss {
	private final String NAME;
	private int hp;
	static int attack = 70;

	public River(String name) {
		this.NAME = name;
		this.hp = 100;
	}

	public String getNAME() {
		return NAME;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	@Override
	public void setAttack(int attack) {
		this.attack = attack;
		
	}

}

public class GameStart {

	// 공격
	static void attack(Protoss u1, Protoss u2) {
		u2.setHp(u2.getHp()-u1.getAttack());
		System.out.println(u2.getNAME() + "이 공격당하고 있습니다.");
		System.out.println(u2.getNAME() + "의 체력은 " + u2.getHp() + "입니다.");
	}

	public static void main(String[] args) {
		// 공격력 업그레이드하기
		Zealot.attack++;
		// 질럿 생성하기
		Zealot z1 = new Zealot("1번질럿");
		System.out.println(z1.getAttack());
		Zealot z2 = new Zealot("2번질럿");
		System.out.println(z2.getAttack());
		Dragoon d1 = new Dragoon("1번드라군");
		Dragoon d2 = new Dragoon("2번드라군");
		DarkTempler dk1 = new DarkTempler("1번다크템플러");
		DarkTempler dk2 = new DarkTempler("2번다크템플러");
		River r1 = new River("1번리버");
		River r2 = new River("2번리버");
		System.out.println(Dragoon.attack);

		// 질럿 공격하기
		attack(z1, z2);
		attack(dk1, r1);
	}

}
