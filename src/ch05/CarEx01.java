package ch05;

class Car {
	void run() {
		System.out.println("�⺻ ������");
	}
	public Car() {
		System.out.println("�� ������");
	}
}

class Sonata extends Car {
	// �������̵� - ���� �� �θ� ����ִ� �޼ҵ带 ����(��ȿȭ)
	// �������ε� - ���� �� ���õǰ� �� �ڿ� �ڽ� Ŭ������ ������ Ÿ�� ������
	
	void run() {
		System.out.println("�ҳ�Ÿ���� ������");

	}
	
	public Sonata() {
		System.out.println("�ҳ�Ÿ ������");
	
	}
}

public class CarEx01 {

	public static void main(String[] args) {
		Car s1 = new Sonata();
	}
}
