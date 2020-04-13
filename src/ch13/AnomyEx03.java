package ch13;

//여기서는 익명 클래스 쓸 이유가 없다
class Car {
	void run() {
		System.out.println("자동차는 달린다");
	}
}

class Sonata extends Car {
}

class Granger extends Car {
}

public class AnomyEx03 {

	static void start(Car c) {
		c.run();
	}

	public static void main(String[] args) {
		start(new Sonata());
	}

}
