package homework.ch04;

import java.util.Scanner;

public class tr10 {

	private static String[] kor = { "���", "�Ʊ�", "��", "�̷�", "���" };
	private static String[] eng = { "love", "baby", "money", "future", "hope" };

	public static String kor2Eng(String word) {
		for (int i = 0; i < eng.length; i++) {
			if (kor[i].equals(word)) {
				return eng[i];
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ѿ� �ܾ� �˻� ���α׷��Դϴ�.");
		while (true) {
			System.out.println("�ѱ� �ܾ�?");
			String a = sc.next();
			String b = kor2Eng(a);

			if (b == null) {
				System.out.println(a + "�� ���� ������ �����ϴ�.");
			} else {
				System.out.println(b);
			}
			if (a.equals("�׸�")) {
				break;
			}
		}
	}

}
