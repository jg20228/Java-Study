package array03;

import java.util.Random;
import java.util.Scanner;

public class CardGame {

	public static void main(String[] args) {

		Random ran = new Random();
		Scanner sc = new Scanner(System.in);

		while (true) {
			int r = ran.nextInt(100); // 랜덤
			int input = 0; // 입력값
			int count = 0;
			int min = 0;
			int max = 99;
			System.out.println("수를 결정하였습니다. 맞추어 보세요");
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
						System.out.println("맞았습니다.");
						break;
					} else if (input > r && input <= max) {
						max = input - 1;
						System.out.println("더 작게");
					} else if (input < r && input >= min) {
						min = input + 1;
						System.out.println("더 크게");
					} else
						System.out.println("잘못 입력하셨습니다.");

				} // end of while
			} catch (Exception e) {
				System.out.println("숫자를 입력하세요");
			}
			System.out.println("다시하시겠습니까?(y/n)>>");
			String text = sc.next();
			if (text.equals("n")) {
				System.out.println("중단");
				break;
			}

		} // end of while
	}

}
