package ch05;

abstract class Animal {
	abstract public String getNAME();
}

class Mouse extends Animal{
	final String NAME = "쥐";
	@Override
	public String getNAME() {
		return NAME;
	}
}

class Dog extends Animal {
	final String NAME = "강아지";
	public String getNAME() {
		return this.NAME;
	}
}

class Cat extends Animal {
	final String NAME = "고양이";
	public String getNAME() {
		return this.NAME;
	}
}

class Bird extends Animal {
	final String NAME = "새";
	public String getNAME() {
		return this.NAME;
	}
}

public class AnimalEx01 {

	static void attack(Animal u1, Animal u2) {

		System.out.println(u2.getNAME() + "가 " + u1.getNAME() + "에게 공격당했습니다.");

	}

	public static void main(String[] args) {
		Dog d1 = new Dog();
		Cat c1 = new Cat();
		Bird b1 = new Bird();

		System.out.println(d1.NAME + " 탄생");
		System.out.println(c1.NAME + " 탄생");
		System.out.println(b1.NAME + " 탄생");

		attack(b1, c1);
	}

}
