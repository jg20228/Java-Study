package array03;

import java.util.Random;
import java.util.Scanner;

public class BaseBallA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		System.out.println("�߱�����");
		System.out.println("1~4 �Է�");
		int score = 0;
		while (true) {
			int input = 0;// �Է°�
			int r = 0;// 0~4 ��������
			int r2 = 0;// 0~4 Ȩ������

			int runner = 0;// ����
			int ball = 0;// ��
			int strike = 0;// ��Ʈ����ũ
			int out = 0;// �ƿ�
			while (true) {
				r = ran.nextInt(5);
				r2 = ran.nextInt(5);
				System.out.println("HINT = r:" + r +" r2:" + r2);
				input = sc.nextInt();
				if (r == r2) {// Ȩ��
					System.out.println("Ȩ��! ���� : " + (runner + 1) + "ȹ��");
					score = score + runner + 1;
					runner = 0;
					ball = 0;
					strike = 0;
				}
				if (input == r) {// ��Ÿ
					runner++;
					if (runner == 4) {
						runner = runner - 1;
						System.out.println("���� ȹ��");
					} else {
						System.out.print("��Ÿ! ");
						System.out.println("���� :" + runner);
					}
					ball = 0;
					strike = 0;
					
				} else if (r == 0) {// ��
					ball++;
					if (ball == 4) {// 4��
						System.out.println("4��!");
						ball = 0;
						runner++;
					} else {// 4���� �ƴҶ�
						System.out.println("�� count: " + ball);
					}

				} else {// ��Ʈ����ũ
					strike++;
					if (strike == 3) {
						out++;
						strike = 0;
						System.out.println("�ƿ� count: " + out);
					}
				}

			} // end of while
		} // end of while

	}

}
