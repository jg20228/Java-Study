package array03;

import java.util.Scanner;

public class Gugudan2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�������� �����մϴ�.");
		boolean confirm = true;
		
		while (confirm) {
			System.out.println("���ڸ� �Է��ϼ��� 2~9");
			int num = sc.nextInt();

			for (int i = 1; i <= 9; i++) {
				System.out.println(num + "*" + i + "=" + (i * num));
			} // end of for
			System.out.println("��� �����ұ��? y or n");
			String check = sc.next();
			if (check.equals("n")) {
				confirm=false;//break; // ���� ����� �ݺ����� ���������� ���
			}
		} // end of while
		System.out.println("������ ���α׷� ����");
	}// end of main

}// end of class
