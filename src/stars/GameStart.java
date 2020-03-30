package stars;

import java.io.ObjectInputStream.GetField;

//��ũ���÷� Dark Templer, ���� River

//�����ε�
abstract class Protoss {
	abstract public String getNAME();
	//abstract public String setNAME(); final�̶� ����Ұ� 

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

	// ����
	static void attack(Protoss u1, Protoss u2) {
		u2.setHp(u2.getHp()-u1.getAttack());
		System.out.println(u2.getNAME() + "�� ���ݴ��ϰ� �ֽ��ϴ�.");
		System.out.println(u2.getNAME() + "�� ü���� " + u2.getHp() + "�Դϴ�.");
	}

	public static void main(String[] args) {
		// ���ݷ� ���׷��̵��ϱ�
		Zealot.attack++;
		// ���� �����ϱ�
		Zealot z1 = new Zealot("1������");
		System.out.println(z1.getAttack());
		Zealot z2 = new Zealot("2������");
		System.out.println(z2.getAttack());
		Dragoon d1 = new Dragoon("1�����");
		Dragoon d2 = new Dragoon("2�����");
		DarkTempler dk1 = new DarkTempler("1����ũ���÷�");
		DarkTempler dk2 = new DarkTempler("2����ũ���÷�");
		River r1 = new River("1������");
		River r2 = new River("2������");
		System.out.println(Dragoon.attack);

		// ���� �����ϱ�
		attack(z1, z2);
		attack(dk1, r1);
	}

}
