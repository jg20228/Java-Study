package array03;

import java.util.Random;
import java.util.Scanner;

public class CardGame {

	public static void main(String[] args) {

		Random ran = new Random();
		Scanner sc = new Scanner(System.in);

		while (true) {
			int r = ran.nextInt(100); // ����
			int input = 0; // �Է°�
			int count = 0;
			int min = 0;
			int max = 99;
			System.out.println("���� �����Ͽ����ϴ�. ���߾� ������");
			try {
				while (true) {
					count++;
					System.out.println(min + "-" + max);
					System.out.print(count + ">>");
					input = sc.nextInt();
					if (input == r) {
						count = 0;
						min = 0;
						max = 99;
						System.out.println("�¾ҽ��ϴ�.");
						break;
					} else if (input > r && input <= max) {
						max = input - 1;
						System.out.println("�� �۰�");
					} else if (input < r && input >= min) {
						min = input + 1;
						System.out.println("�� ũ��");
					} else
						System.out.println("�߸� �Է��ϼ̽��ϴ�.");

				} // end of while
			} catch (Exception e) {
				System.out.println("���ڸ� �Է��ϼ���");
			}
			System.out.println("�ٽ��Ͻðڽ��ϱ�?(y/n)>>");
			String text = sc.next();
			if (text.equals("n")) {
				System.out.println("�ߴ�");
				break;
			}

		} // end of while
	}

}
