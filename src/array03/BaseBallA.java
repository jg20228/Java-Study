package array03;

import java.util.Random;
import java.util.Scanner;

public class BaseBallA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		System.out.println("야구게임");
		System.out.println("1~4 입력");
		int score = 0;
		while (true) {
			int input = 0;// 입력값
			int r = 0;// 0~4 투수랜덤
			int r2 = 0;// 0~4 홈런랜덤

			int runner = 0;// 주자
			int ball = 0;// 볼
			int strike = 0;// 스트라이크
			int out = 0;// 아웃
			while (true) {
				r = ran.nextInt(5);
				r2 = ran.nextInt(5);
				System.out.println("HINT = r:" + r +" r2:" + r2);
				input = sc.nextInt();
				if (r == r2) {// 홈런
					System.out.println("홈런! 점수 : " + (runner + 1) + "획득");
					score = score + runner + 1;
					runner = 0;
					ball = 0;
					strike = 0;
				}
				if (input == r) {// 안타
					runner++;
					if (runner == 4) {
						runner = runner - 1;
						System.out.println("점수 획득");
					} else {
						System.out.print("안타! ");
						System.out.println("주자 :" + runner);
					}
					ball = 0;
					strike = 0;
					
				} else if (r == 0) {// 볼
					ball++;
					if (ball == 4) {// 4볼
						System.out.println("4볼!");
						ball = 0;
						runner++;
					} else {// 4볼이 아닐때
						System.out.println("볼 count: " + ball);
					}

				} else {// 스트라이크
					strike++;
					if (strike == 3) {
						out++;
						strike = 0;
						System.out.println("아웃 count: " + out);
					}
				}

			} // end of while
		} // end of while

	}

}
