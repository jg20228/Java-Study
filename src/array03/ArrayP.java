package array03;

import java.util.Scanner;

public class ArrayP {

	public static void main(String[] args) {

		char arr[] = { '가', '나', '다', '라', '마' };
		char rra[] = { '0', '0', '0', '0', '0' };

		for (int i = 0; i < arr.length; i++) {
			int j = arr.length - i - 1;
			rra[i] = arr[arr.length - i - 1];
			System.out.print(rra[i]);
		}
		System.out.println();

		// 숫자 1,000,000,000 = 10억
		// 숫자 입력 받고 ex) 1,000 로 출력하기
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		int count = 0;
		char[] arrWord = new char[a.length()];
		char[] arrWord2 = new char[a.length() + a.length() / 3];

		//for (int i = arrWord.length; i >= 0; i--) {
		//	arrWord[i] = (a.charAt(i));
		//}

		System.out.print(arrWord[0]);
		System.out.println();
		if (count - 3  == 0) {
			count=0;
			System.out.print(",");

		}

	}

}
