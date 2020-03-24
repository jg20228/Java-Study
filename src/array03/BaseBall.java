package array03;

import java.util.Random;
import java.util.Scanner;

/*
 * 사용자가 1부터 4까지의 수 중 하나를 입력!! 
 * Random함수로 0부터 4까지 난수 발생 
 * 숫자가 같으면 안타 
 * 숫자가 다르면 스트라이크
 * 0이 나오면 볼 
 * 3아웃 프로그램 종료
 */

public class BaseBall {
	// https://blog.naver.com/codingspecialist/221277589049
	public static void main(String[] args) {
		Random r = new Random();
		int score = 0; // 점수
		int base_state = 0; // 주자
		int ballCount = 0; // 볼 카운트
		int strikeCount = 0; // 스트라이크 카운트
		int outCount = 0; // 아웃 카운트
		Scanner sc = new Scanner(System.in);
		int ran = r.nextInt(5);
		int input = 0;
		System.out.println("1~4 입력");
		while (outCount != 3) {
			ran = r.nextInt(5);
			input = sc.nextInt();

			if (input == ran) {
				//숫자 같으면 안타
				System.out.println("안타!");
				base_state++;
				ballCount = 0;
				strikeCount = 0;
				System.out.println("현재 주자 숫자"+base_state);
			} else if (ran == 0) {
				//0이면 볼
				ballCount++;
				System.out.println(ballCount+"볼");
			} else {
				//0이 아니거나 숫자가 다르면 스트라이크
				strikeCount++;
				System.out.println(strikeCount+"스트라이크");
			}
			if (ballCount == 4) {
				System.out.println("4볼");
				base_state++;
				strikeCount = 0;
				ballCount = 0;
			}
			if (strikeCount == 3) {
				ballCount = 0;
				strikeCount = 0;
				outCount++;
				System.out.println(outCount+"아웃");
			}
			if (base_state == 4) {
				score++;
				base_state--;
				System.out.println("점수 획득");
			}
		} // end of while
		System.out.println("점수: " +score);

	}

}
