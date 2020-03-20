package ch03;

//메서드(함수)는 클래스안에 작성할 수 있다.
//메서드(함수)는 메서드안에 작성할 수 없다.
public class MethodEx01 {

	static int add(int n1, int n2) {
		int result = n1 + n2;
		// System.out.println("result : " + result);
		return result; // return 가장 마지막에!!
	}
	//minus(매개변수는 int형 두개) (return은 int형)
	static int minus(int n1, int n2) {
		int result = n1 - n2;
		return result;
	}
	static int multi(int n1, int n2) {
		int result = n1 * n2;
		return result;
	}
	static int divide(int n1, int n2) {
		int result = n1 / n2;
		return result;
	}

	public static void main(String[] args) {
		int num = MethodEx01.add(5, 3);
		System.out.println("결과 : " + num);

		num = MethodEx01.minus(5, 3);
		System.out.println("결과 : " + num);
		
		num = MethodEx01.multi(5, 3);
		System.out.println("결과 : " + num);
		
		num = MethodEx01.divide(5, 3);
		System.out.println("결과 : " + num);
	}

}
