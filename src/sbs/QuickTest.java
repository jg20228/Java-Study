package sbs;

import java.util.Scanner;

class QuickTest {
	public static void ReverseStar(int a) {
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a-i; j++) {
				System.out.print("*");				
			}System.out.println();
		}
	}
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		ReverseStar(a);
	} 

}