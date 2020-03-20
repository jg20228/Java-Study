package ch03;

//메서드(함수)는 클래스안에 작성할 수 있다.
//메서드(함수)는 메서드안에 작성할 수 없다.
public class MethodEx01 {

	public static void main(String[] args) {
		int num = Cal.add(5, 3);
		System.out.println("결과 : " + num);

		num = Cal.minus(5, 3);
		System.out.println("결과 : " + num);
		
		num = Cal.multi(5, 3);
		System.out.println("결과 : " + num);
		
		num = Cal.divide(5, 3);
		System.out.println("결과 : " + num);
	}

}
