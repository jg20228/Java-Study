package array03;

import java.util.Scanner;

public class CharTest {

	public static void main(String[] args) {

		// int ch = 65;
		// System.out.println((char)65); �ƽ�Ű�ڵ� 'A'
		// System.out.println((char)90); �ƽ�Ű�ڵ� 'Z'

		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		char c = input.charAt(0);

		for (int i = c + 1; i <= 'Z'; i++) {
			System.out.print((char) i + " ");
		}

	}

}
