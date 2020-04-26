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
		System.out.print(name + "에서 만든 ");
		System.out.print(date + "년형 ");
		System.out.print(inch + "인치 TV");
	}
}

public class tr01 {

	public static void main(String[] args) {
		Tv myTv = new Tv();
		myTv.show();
	}

}
