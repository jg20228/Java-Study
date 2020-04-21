package sbs;

import java.util.Scanner;

class Test01 {
	public static void main(String[] args) {
		int [] unit = {50000,10000,1000,500,100,50,10,1};
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int money=a;
		for (int i = 0; i < unit.length; i++) {
			if(money/unit[i]>=1) {
				System.out.println(unit[i]+"원 짜리 : "+money/unit[i]+"개");
				money=money-money/unit[i]*unit[i];
			}
			
		}
	}
}