package sbs;

interface Animal {
	void sound();
}

class Tiger implements Animal {
	@Override
	public void sound() {
		System.out.println("어흥");
	}
}

class Dog implements Animal{
	//부모가 가진 함수를 재정의 하는 것을 오버라이딩이라고 함.
	//부모가 가진 함수를 재정의 하지 않아도 오버라이딩!!
	public void sound(){
		System.out.println("멍멍");
	}
}

class Cat implements Animal{
	public void sound(){
		System.out.println("야옹");
	}
}

class Fish implements Animal{
	public void sound(){
		System.out.println("뻐끔뻐끔");
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
