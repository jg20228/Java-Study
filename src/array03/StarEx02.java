package array03;

public class StarEx02 {

	static void printStars(int i) {
		for (int j = 1; j < i; j++) {
			System.out.print("_");
		}
		for (int j = 4; j >= i; j--) {
			System.out.print("*");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		for (int i = 4; i >= 1; i--) {
			printStars(i);

		}

//		System.out.print("___*");
//		System.out.print("__**");
//		System.out.print("_***");
//		System.out.print("****");

	}

}
