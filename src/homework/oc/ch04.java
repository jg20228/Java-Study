package homework.oc;

import java.util.Scanner;

public class ch04 {
	Scanner sc = new Scanner(System.in);
	String player[];

	public ch04() {
		System.out.println("�����ձ� ������ �����մϴ�...");
		System.out.println("���ӿ� �����ϴ� �ο��� ����Դϱ�?>>");
		player = new String[sc.nextInt()];
		for (int i = 0; i < player.length; i++) {
			System.out.println("�������� �̸��� �Է��ϼ���>>>");
			player[i] = sc.nextLine();
		}
		System.out.println("�����ϴ� �ܾ�� �ƹ����Դϴ�.");
	}

	public static void main(String[] args) {
		ch04 a = new ch04();
	}

}
