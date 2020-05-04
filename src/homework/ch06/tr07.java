package homework.ch06;

import java.util.Scanner;
import java.util.StringTokenizer;

public class tr07 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		StringTokenizer st = new StringTokenizer(input);
		System.out.println("어절 개수는"+st.countTokens());
		String []word = input.split(" ");
		System.out.println(word.length);
	}
}
