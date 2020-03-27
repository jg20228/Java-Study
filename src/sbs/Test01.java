package sbs;

interface Animal {
	void sound();
}

class Tiger implements Animal {
	@Override
	public void sound() {
		System.out.println("����");
	}
}

class Dog implements Animal{
	//�θ� ���� �Լ��� ������ �ϴ� ���� �������̵��̶�� ��.
	//�θ� ���� �Լ��� ������ ���� �ʾƵ� �������̵�!!
	public void sound(){
		System.out.println("�۸�");
	}
}

class Cat implements Animal{
	public void sound(){
		System.out.println("�߿�");
	}
}

class Fish implements Animal{
	public void sound(){
		System.out.println("��������");
	}
}

public class Test01 {
	
	public static void start(Animal a){
		a.sound();
	}
	
	public static void main(String[] args) {
		start(new Fish());
		start(new Cat());
		start(new Dog());
		start(new Tiger());
//		Animal f = new Fish();
//		f.sound();
//		
//		Animal c = new Cat();
//		c.sound();
//		
//		Animal d = new Dog();
//		d.sound();
	}
}
