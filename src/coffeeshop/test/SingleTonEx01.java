package coffeeshop.test;

class ����� {

	public static ����� instance = new �����();

	public static ����� getInstance() {
		return instance;
	}

	private �����() {
	}
}

public class SingleTonEx01 {

	public static void main(String[] args) {
		����� d1 = �����.getInstance();
		����� d2 = �����.getInstance();
		
		
		System.out.println(d1);
		System.out.println(d2);
		
	}
}
