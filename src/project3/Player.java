package project3;

import java.util.Scanner;

class Player{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input  = sc.nextInt();
		
		if (input/50000>=1) {
			System.out.println("5������ "+input/50000+"��");
			input=input-((input/50000)*50000);
			System.out.println(input);
		}
		
	}
}