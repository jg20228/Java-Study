package ch04;

public class Circle {
	private int radius;
	private String name;

	public Circle() {
	}

	public double getArea() {
		return 3.14 * radius * radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		Circle pizza;
		pizza = new Circle();
		//pizza.radius = 10;
		pizza.setRadius(10);
		//pizza.name = "�ڹ�����";
		pizza.setName("�ڹ�����");
		//Double area = pizza.getArea();
		System.out.println(pizza.name + "�� ������ " + pizza.getArea());

		Circle donut = new Circle();
		//donut.radius = 2;
		donut.setRadius(2);
		//donut.name = "�ڹٵ���";
		donut.setName("�ڹٵ���");
		//area = donut.getArea();
		System.out.println(donut.name + "�� ������ " + donut.getArea());
	}

}
