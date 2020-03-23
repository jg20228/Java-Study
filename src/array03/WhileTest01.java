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
		System.out.println("횟수 : " + count);
		int hour = count / 3600;
		int min = count / 60;
		double dhour = count / 60;
		System.out.println("분 : " + min);
		System.out.println("시간 : " + hour);
		System.out.println("시간(소수점) : " + dhour / 60);

		System.out.println("분 : " + min % 60);
		System.out.println(hour + "시간 " + min % 60 + "분");

	}

}
