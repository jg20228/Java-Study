package homework.ch04;

class Tv {
	private String name;
	private String date;
	private int inch;

	public Tv() {
		this.name = "LG";
		this.date = "2017";
		this.inch = 32;
	}

	public void show() {
		System.out.print(name + "���� ���� ");
		System.out.print(date + "���� ");
		System.out.print(inch + "��ġ TV");
	}
}

public class tr01 {

	public static void main(String[] args) {
		Tv myTv = new Tv();
		myTv.show();
	}

}
