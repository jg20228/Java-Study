package array03;

import java.util.Scanner;

public class ArrayEx07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("6자리 숫자를 입력하세요");
		int num = sc.nextInt();// 6자리 수 입력

		String strNum = num + "";
		// System.out.println(strNum.charAt(2));
		// System.out.println(strNum.length());
		boolean flag = false;
		for (int i = 0; i < strNum.length(); i++) {
			if (strNum.charAt(i) == '3' && flag == false) {
				flag = true;
				System.out.println(strNum.charAt(i)+"이 존재합니다");
			} else if (i + 1 == strNum.length() && flag == false) {
				System.out.println("X");
			}
		}
		/*
		int count = 0;
		for (int i = 0; i < strNum.length(); i++) {
			if (strNum.charAt(i) == '3') count++;
		}
		if(count>0) System.out.println(count+"회 발견");
		else System.out.println("존재하지 않습니다.");*/
	}

}
