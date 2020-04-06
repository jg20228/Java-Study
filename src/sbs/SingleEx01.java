package sbs;

class Printer{
	private static Printer printer = new Printer();
	private static int count = 0;
	
	private Printer() {}
	public static Printer getInstance() {
		return printer;
	}
		
}


public class SingleEx01 {

	public static void main(String[] args) {
		System.out.println();
	}

}
