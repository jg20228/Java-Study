package sbs;

import java.util.Random;

public class Lo {

	public static void main(String[] args) {

		Random ran = new Random();
		int[] lo = new int[45];
		int[] lo2 = new int[6];

		for (int i = 0; i < lo.length; i++) {
			lo[i] = i + 1;
		}
		int r = (ran.nextInt(45)); //1~45
		int count = 0;
		while (true) {
			// 6자리 채우면 나가기.
			r = (ran.nextInt(45));
			if (lo[r] != 0) {
				lo2[count] = lo[r];
				lo[r] = 0;
				count++;
			}
			if (count == 6) {
				break;
			}
		}
		for (int i = 0; i < lo2.length; i++) {
			System.out.print(lo2[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < lo.length; i++) {
			System.out.print(lo[i] + " ");
		}
	}
}
