package homework.ch04;

import java.util.Scanner;

class Circle {
	private double x;
	private double y;
	private int radius;

	public Circle(double x, double y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public void show() {
		System.out.println("x= " + x + " y= " + y + " raduis= " + radius);
	}
	
	public double getArea() {
		return radius*Math.PI;
	}
}

public class tr05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Circle c[] = new Circle[3];
		for (int i = 0; i < c.length; i++) {
			System.out.println("x, y, radius >>");
			double x = scanner.nextDouble();
			double y = scanner.nextDouble();
			int radius = scanner.nextInt();
			c[i] = new Circle(x, y, radius);
		}
		int bestIndex=0;
		for (int i = 0; i < c.length; i++) {
			c[i].show();
			if(c[bestIndex].getArea()<c[i].getArea()) bestIndex=i;
		}
		System.out.print("best : ");
		c[bestIndex].show();
		System.out.println();
		scanner.close();
	}

}
