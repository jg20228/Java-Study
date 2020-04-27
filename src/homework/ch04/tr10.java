package homework.ch04;

import java.util.Scanner;

public class tr10 {

	private static String[] kor = { "사랑", "아기", "돈", "미래", "희망" };
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
		System.out.println("한영 단어 검색 프로그램입니다.");
		while (true) {
			System.out.println("한글 단어?");
			String a = sc.next();
			String b = kor2Eng(a);

			if (b == null) {
				System.out.println(a + "는 저의 사전에 없습니다.");
			} else {
				System.out.println(b);
			}
			if (a.equals("그만")) {
				break;
			}
		}
	}

}
