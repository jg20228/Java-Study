package animal;

interface Animal {
	// ��Ģ 2�� ����
	void run();
	void sound();
	
}

class Dog implements Animal {

	@Override
	public void run() {
		System.out.println("������ �޸���");
	}

	@Override
	public void sound() {
		System.out.println("�۸�");
	}

}

class Bird implements Animal{

	void fly() {
		System.out.println("���� ����");		

	}

	@Override
	public void run() {
		System.out.println("���� �޸���");		
	}

	@Override
	public void sound() {
		System.out.println("±±");
		
	}
}

public class AnimalEx02 {

	static void start(Animal a) {
		a.run();
		a.sound();
		if(a instanceof Bird) {
			//fly �޼��带 �������̶�� �� Ȯ��
			//�ٿ�ĳ�����ؼ� fly����
			//����ͷ� �ϴ°� ���� �̰Ŵ� ������
			((Bird) a).fly();
		}
	}
	
	public static void main(String[] args) {
		start(new Dog());
		start(new Bird());
		
		
	}

}
