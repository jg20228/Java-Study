package sbs;

import java.util.Random;




public class Lo {
	
	public static int RandomInt() {//1~45
		Random ran = new Random();
		int random = ran.nextInt(45);
		return random;
	}

	public static int[] init(int[] lo) {//초기화
		for (int i = 0; i < lo.length; i++) {
			lo[i] = i + 1;
		}
		return lo;
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
				lo = init(lo);//초기화
				break;
			}
		}
		for (int i = 0; i < lo2.length; i++) {
			System.out.print(lo2[i] + " ");
		}
		
		//버블정렬
		int temp=0;
		for (int i = 0; i < lo2.length; i++) {
			for (int j = 0; j < lo2.length-1; j++) {
				if(lo2[j]>lo2[j+1]) {
					temp=lo2[j];
					lo2[j]=lo2[j+1];
					lo2[j+1]=temp;
				}
			}
		}
		System.out.println();
		for (int i = 0; i < lo2.length; i++) {
			System.out.print(lo2[i] + " ");
		}	
	}
}
