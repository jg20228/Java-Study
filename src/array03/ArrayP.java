package array03;

import java.util.Scanner;

public class ArrayP {

	public static void main(String[] args) {

		char arr[] = { '��', '��', '��', '��', '��' };
		char rra[] = { '0', '0', '0', '0', '0' };

		for (int i = 0; i < arr.length; i++) {
			int j = arr.length - i - 1;
			rra[i] = arr[arr.length - i - 1];
			System.out.print(rra[i]);
		}
		System.out.println();

		// ���� 1,000,000,000 = 10��
		// ���� �Է� �ް� ex) 1,000 �� ����ϱ�
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int count = 0;
		for (int i = 10; i <= a; i = i * 10) {
			count++;
			if ((count - 3) == 0) {
				count = 0;
				System.out.println("�޸�");
			}

		}

	}

}
