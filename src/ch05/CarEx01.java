package ch05;

class Car {
	void run() {
		System.out.println("기본 움직임");
	}
}

class Sonata extends Car {
	// 오버라이드 - 실행 시 부모가 들고있는 메소드를 무시(무효화)
	// 동적바인딩 - 실행 시 무시되고 난 뒤에 자식 클래스를 밑으로 타고 내려감
	void run() {
		System.out.println("소나타만의 움직임");

	}
}

public class CarEx01 {

	public static void main(String[] args) {
		Car s1 = new Sonata();
		s1.run();
	}
}
