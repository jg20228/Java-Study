package array03;

import java.util.Scanner;

public class ArrayEx07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("6�ڸ� ���ڸ� �Է��ϼ���");
		int num = sc.nextInt();// 6�ڸ� �� �Է�

		String strNum = num + "";
		// System.out.println(strNum.charAt(2));
		// System.out.println(strNum.length());
		boolean flag = false;
		for (int i = 0; i < strNum.length(); i++) {
			if (strNum.charAt(i) == '3' && flag == false) {
				flag = true;
				System.out.println(strNum.charAt(i)+"�� �����մϴ�");
			} else if (i + 1 == strNum.length() && flag == false) {
				System.out.println("X");
			}
		}
		/*
		int count = 0;
		for (int i = 0; i < strNum.length(); i++) {
			if (strNum.charAt(i) == '3') count++;
		}
		if(count>0) System.out.println(count+"ȸ �߰�");
		else System.out.println("�������� �ʽ��ϴ�.");*/
	}

}
