package ch01;

public class OperEx02 {

	public static void main(String[] args) {
		int sum = 0; // 0
		int distance = 100;
		int move = 20;

		sum = sum + move;
		System.out.println(sum);
		sum = sum + move;
		System.out.println(sum);
		sum = sum + move;
		System.out.println(sum);
		sum = sum + move;
		System.out.println(sum);
		sum = sum + move; //누적
		System.out.println("움직인 거리 : " + sum);
		System.out.println("도착지 : " + distance);
		// 문자+숫자는 결합이 된다.(문자로 casting, 묵시적형변환)
	}

}
