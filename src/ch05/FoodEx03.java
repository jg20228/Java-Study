package ch05;

abstract class Į {
	abstract void kill();

	abstract void cook();

	abstract void repair();
}

//�߻�Ŭ������ ������� �뵵�� ��� �����ϴ�.
abstract class �丮������ extends Į {
	void kill() {}

	void repair() {}
}

class ������ extends �丮������ {
	void cook() {
		System.out.println("�丮�ϱ�");
	}

}

public class FoodEx03 {

	public static void main(String[] args) {

	}

}
