package homework.oc;

import java.util.Scanner;

public class ch04 {
	Scanner sc = new Scanner(System.in);
	String player[];

	public ch04() {
		System.out.println("끝말잇기 게임을 시작합니다...");
		System.out.println("게임에 참가하는 인원은 몇명입니까?>>");
		player = new String[sc.nextInt()];
		for (int i = 0; i < player.length; i++) {
			System.out.println("참가자의 이름을 입력하세요>>>");
			player[i] = sc.nextLine();
		}
		System.out.println("시작하는 단어는 아버지입니다.");
	}

	public static void main(String[] args) {
		ch04 a = new ch04();
	}

}
