package animal;

interface Animal {
	// 규칙 2개 생성
	void run();
	void sound();
}
class Dog implements Animal {
	public void run() {
		System.out.println("강아지 달린다");
	}
	public void sound() {
		System.out.println("멍멍");
	}
}

class Bird implements Animal{
	void fly() {
		System.out.println("새는 난다");		
	}
	public void run() {
		System.out.println("새는 달린다");		
	}
	public void sound() {
		System.out.println("짹짹");
	}
}

public class AnimalEx02 {

	static void start(Animal a) {
		a.run();
		a.sound();
		if(a instanceof Bird) {
			//fly 메서드를 가진놈이라는 걸 확신
			//다운캐스팅해서 fly실행
			//어댑터로 하는게 좋고 이거는 위험함
			((Bird) a).fly();
		}
	}
	
	public static void main(String[] args) {
		start(new Dog());
		start(new Bird());
	}
}
