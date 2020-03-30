package sbs;

public class Bubble {

	public static void main(String[] args) {

		int arr[] = {3,8,5,9,1};
		for(int i=arr.length-1;i>=0;i--) {
			for (int j = 0; j < arr.length-1; j++) {
				int temp;
				if(arr[j]>arr[j+1]) {
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
			for (int z = 0; z <= arr.length-1; z++) {
				System.out.print(arr[z]+" ");
			}
			System.out.println();
		}
		
		
		for (int i = 0; i <= arr.length-1; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}

}
