package sbs;

import java.util.Random;




public class Lo {
	
	public static int RandomInt() {
		Random ran = new Random();
		int random = ran.nextInt(45);
		return random;
	}

	public static void main(String[] args) {

		Random ran = new Random();
		int[] lo = new int[45];
		int[] lo2 = new int[6];

		for (int i = 0; i < lo.length; i++) {
			lo[i] = i + 1;
		}
		int r = RandomInt();
		int count = 0;
		while (true) {
			// 6자리 채우면 나가기.
			r = RandomInt();
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
