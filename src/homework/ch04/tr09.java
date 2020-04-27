package homework.ch04;

class ArrayUtill {
	public static int[] concat(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];

		for (int i = 0; i < a.length; i++) {
			c[i] = a[i];
		}
		for (int i = a.length; i < a.length + b.length; i++) {
			c[i] = b[i - a.length];
		}
		return c;
	}

	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}

public class tr09 {

	public static void main(String[] args) {
		int[] array1 = { 1, 5, 7, 9 };
		int[] array2 = { 3, 6, -1, 100, -77 };
		int[] array3 = ArrayUtill.concat(array1, array2);
		ArrayUtill.print(array3);
	}

}
