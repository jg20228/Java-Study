package ch05;

//�߻�Ŭ������ new �� �� ����. ������Ʈ�� �ƴϱ� ������!!
//�߻�Ŭ������ �߻� �޼��带 ���� �� �ִ�.
abstract class Food1 {
	abstract void eat();
}

class ���1 extends Food1 {
	private String name = "���";
	void eat() {
		System.out.println(name + "�� �Ծ����ϴ�.");
	}
}

class �Ұ��1 extends Food1 {
	private String name = "�Ұ��";
	void eat() {
		System.out.println(name + "�� �Ծ����ϴ�.");
	}
}

class ����1 extends Food1 {
	private String name = "����";
	void eat() {
		System.out.println(name + "�� �Ծ����ϴ�.");
	}
}

public class FoodEx01 {
	static void start(Food1 f) {
		f.eat();
	}
	public static void main(String[] args) {
		// ���� f1 = new ����();
		// ��� f2 = new ���();
		// �Ұ�� f3 = new �Ұ��();
		start(new ���1());
	}
}
