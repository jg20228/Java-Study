package array03;

import java.util.Scanner;

/*
 * 숫자 1000000000를 입력받고 (10억)
 * 3자리 마다 콤마를 찍어서 출력!!
 * 1,000,000,000
 */

public class ArrayEx05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String tempNum = num + ""; // 결합연산자 (숫자가 문자로 변함)
		String tempNum2[] = tempNum.split("");

		// ----------------------------------------//
		int len = tempNum2.length; // len = 4

		for (int i = 0; i < len; i++) {
			if ((len - i) % 3 == 0 && i != 0) {
				System.out.print(",");
			}
			System.out.print(tempNum2[i]);
		}
		System.out.println();
		// ----------------------------------------//
		String array[] = new String[100];
		int count = 0;
		int count2 = 0;
		for (int i = tempNum2.length - 1; i >= 0; i--) {
			array[count2] = tempNum2[i];
			count++;
			count2++;
			if (count % 3 == 0 && i != 0) {
				array[count2] = ",";
				count2++;
			}

		}
		for (int i = count2 - 1; i >= 0; i--) {
			System.out.print(array[i]);
		}
		System.out.println();
		// ----------------------------------------//

		// 자릿수 계산을 위한 변수
		int p = (tempNum2.length % 3);
		// 첫째자리 앞에 ,이 붙으면 안됨
		for (int i = 0; i < tempNum2.length; i++) {
			if (i == 0)
				tempNum2[i] = "" + tempNum2[i];
			else if (i % 3 == p)
				tempNum2[i] = "," + tempNum2[i];
			System.out.print(tempNum2[i]);
		}

	}

}
