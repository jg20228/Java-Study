package sbs;

public class QuickTest {

	static int A[] = { 40, 30, 100, 60, 80, 70, 90, 10, 20, 50 };

	static int Partition(int A[], int start, int end) {
		int temp;
		int index = start;
		int pivot = A[end];

		for (int i = start; i < end; i++) {
			if (pivot >= A[i]) {
				temp = A[i];
				A[i] = A[index];
				A[index] = temp;
				index++;
			}
		}

		temp = A[end];
		A[end] = A[index];
		A[index] = temp;
		return index;
	}

	static void QuickSort(int A[], int start, int end) {
		int index;
		for (int i = start; i < end; i++) {
			index = Partition(A, start, end);
			QuickSort(A, start, index - 1);
			QuickSort(A, index + 1, end);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.println();
		QuickSort(A, 0, A.length - 1);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}
}
