package ch04;

import java.util.Scanner;

class Rectangle {
	private int witdh;
	private int height;

	void setWitdh(int witdh) {
		this.witdh = witdh;
	}

	void setHeight(int height) {
		this.height = height;
	}

	public int getArea() {
		return witdh * height;
	}
}

public class RectApp {

	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		Scanner sc = new Scanner(System.in);
		System.out.println(">> ");
		r.setWitdh(sc.nextInt());
		r.setHeight(sc.nextInt());
		System.out.println("사각형의 면적은 : " + r.getArea());
		sc.close();
	}

}
