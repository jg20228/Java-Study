package array03;

public class WhileTest01 {

	public static void main(String[] args) {
		int destination = 11271;
		int speed = 3;
		int count = 1;
		int car = 0;

		while (destination != car) {
			destination = destination - speed;
			count++;
		}
		System.out.println("Ƚ�� : " + count);
		int hour = count / 3600;
		int min = count / 60;
		double dhour = count / 60;
		System.out.println("�� : " + min);
		System.out.println("�ð� : " + hour);
		System.out.println("�ð�(�Ҽ���) : " + dhour / 60);

		System.out.println("�� : " + min % 60);
		System.out.println(hour + "�ð� " + min % 60 + "��");

	}

}
