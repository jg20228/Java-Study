package array03;

import java.util.Random;
import java.util.Scanner;

/*
 * ����ڰ� 1���� 4������ �� �� �ϳ��� �Է�!! 
 * Random�Լ��� 0���� 4���� ���� �߻� 
 * ���ڰ� ������ ��Ÿ 
 * ���ڰ� �ٸ��� ��Ʈ����ũ
 * 0�� ������ �� 
 * 3�ƿ� ���α׷� ����
 */

public class BaseBall {
	// https://blog.naver.com/codingspecialist/221277589049
	public static void main(String[] args) {
		Random r = new Random();
		int score = 0; // ����
		int base_state = 0; // ����
		int ballCount = 0; // �� ī��Ʈ
		int strikeCount = 0; // ��Ʈ����ũ ī��Ʈ
		int outCount = 0; // �ƿ� ī��Ʈ
		Scanner sc = new Scanner(System.in);
		int ran = r.nextInt(5);
		int input = 0;
		System.out.println("1~4 �Է�");
		while (outCount != 3) {
			ran = r.nextInt(5);
			input = sc.nextInt();

			if (input == ran) {
				//���� ������ ��Ÿ
				System.out.println("��Ÿ!");
				base_state++;
				ballCount = 0;
				strikeCount = 0;
				System.out.println("���� ���� ����"+base_state);
			} else if (ran == 0) {
				//0�̸� ��
				ballCount++;
				System.out.println(ballCount+"��");
			} else {
				//0�� �ƴϰų� ���ڰ� �ٸ��� ��Ʈ����ũ
				strikeCount++;
				System.out.println(strikeCount+"��Ʈ����ũ");
			}
			if (ballCount == 4) {
				System.out.println("4��");
				base_state++;
				strikeCount = 0;
				ballCount = 0;
			}
			if (strikeCount == 3) {
				ballCount = 0;
				strikeCount = 0;
				outCount++;
				System.out.println(outCount+"�ƿ�");
			}
			if (base_state == 4) {
				score++;
				base_state--;
				System.out.println("���� ȹ��");
			}
		} // end of while
		System.out.println("����: " +score);

	}

}
