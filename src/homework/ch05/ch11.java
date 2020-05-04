package homework.ch05;

import java.util.Scanner;

abstract class Calc {
	abstract void setValue(int a, int b);

	abstract int calculate();
}

class Add extends Calc {
	private int a;
	private int b;

	@Override
	void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	int calculate() {
		return a + b;
	}
}

class Sub extends Calc {
	private int a;
	private int b;

	@Override
	void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	int calculate() {
		return a - b;
	}
}

class Mul extends Calc {
	private int a;
	private int b;

	@Override
	void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	int calculate() {
		return a * b;
	}
}

class Div extends Calc {
	private int a;
	private int b;

	@Override
	void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	int calculate() {
		return a / b;
	}
}

public class ch11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Add add = new Add();
		Sub sub = new Sub();
		Mul mul = new Mul();
		Div div = new Div();

		System.out.println("두 정수와 연산자를 입력하시오");
		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			char c = sc.next().charAt(0);
			
			switch (c) {
			
			case '+' :
				add.setValue(a, b);
				System.out.println(add.calculate());
				break;
			case '-' :
				sub.setValue(a, b);
				System.out.println(sub.calculate());
				break;
			case '*' :
				mul.setValue(a, b);
				System.out.println(mul.calculate());
				break;
			case '/' :
				div.setValue(a, b);
				System.out.println(div.calculate());
				break;
			}
			break;
		}
	}
}
