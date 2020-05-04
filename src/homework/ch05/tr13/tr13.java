package homework.ch05.tr13;
//13~14번 문제
interface Shape{
	final double PI = 3.14;
	void draw();
	double getArea();
	default public void redraw() {
		System.out.print("--- 다시 그립니다. ");
		draw();
	}
}

class Circle implements Shape{
	double r;
	public Circle(double a) {
		r=a;
	}
	@Override
	public void draw() {
		System.out.println("반지름이 "+r+"인 원입니다.");
	}
	@Override
	public double getArea() {
		return r*r*PI;
	}
}

class Oval implements Shape{
	
	private double a;
	private double b;
	
	public Oval(double a, double b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public void draw() {
		System.out.println(a+"x"+b+"에 내접하는 타원입니다.");
	}

	@Override
	public double getArea() {
		return 2*PI*a/2*b;
	}
	
}

class Rect implements Shape{

	private double a;
	private double b;
	
	public Rect(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public void draw() {
		System.out.println(a+"x"+b+"크기의 사각형입니다.");
	}

	@Override
	public double getArea() {
		return a*b;
	}
	
}
public class tr13 {
	public static void main(String[] args) {
//		Shape donut = new Circle(10); 
//		donut.redraw();
//		System.out.println("면적은 "+donut.getArea());
		
		Shape[]list = new Shape[3];
		list[0] = new Circle(10);
		list[1] = new Oval(20,30);
		list[2] = new Rect(10,40);
		for (int i = 0; i < list.length; i++) {
			list[i].redraw();
		}
		for (int i = 0; i < list.length; i++) {
			System.out.println("면적은 "+list[i].getArea());
		}
		
	}
}
