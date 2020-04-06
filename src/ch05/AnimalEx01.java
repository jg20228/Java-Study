package ch05;

abstract class Animal {
	abstract public String getNAME();
}

class Mouse extends Animal{
	final String NAME = "��";
	@Override
	public String getNAME() {
		return NAME;
	}
}

class Dog extends Animal {
	final String NAME = "������";
	public String getNAME() {
		return this.NAME;
	}
}

class Cat extends Animal {
	final String NAME = "�����";
	public String getNAME() {
		return this.NAME;
	}
}

class Bird extends Animal {
	final String NAME = "��";
	public String getNAME() {
		return this.NAME;
	}
}

public class AnimalEx01 {

	static void attack(Animal u1, Animal u2) {

		System.out.println(u2.getNAME() + "�� " + u1.getNAME() + "���� ���ݴ��߽��ϴ�.");

	}

	public static void main(String[] args) {
		Dog d1 = new Dog();
		Cat c1 = new Cat();
		Bird b1 = new Bird();

		System.out.println(d1.NAME + " ź��");
		System.out.println(c1.NAME + " ź��");
		System.out.println(b1.NAME + " ź��");

		attack(b1, c1);
	}

}
