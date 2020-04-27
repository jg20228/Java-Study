package homework.ch04;

import java.util.Scanner;

class Add {
	private int a;
	private int b;

	public void setValue(int a, int b) {
		this.a=a;
		this.b=b;
	}

	public int calculate() {
		return a+b;
	}
}

class Sub {
	private int a;
	private int b;

	public void setValue(int a, int b) {
		this.a=a;
		this.b=b;
	}

	public int calculate() {
		return a-b;
	}
}

class Mul {
	private int a;
	private int b;

	public void setValue(int a, int b) {
		this.a=a;
		this.b=b;
	}
	public int calculate() {
		return a*b;
	}
}

class Div {
	private int a;
	private int b;

	public void setValue(int a, int b) {
		this.a=a;
		this.b=b;
	}
	public int calculate() {
		return a/b;
	}
}

public class tr11 {

	public static void main(String[] args) {
		Add add = new Add();
		Sub sub = new Sub();
		Mul mul = new Mul();
		Div div = new Div();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("두 정수와 연산자를 입력하시오>>");
		System.out.println("+,-,*,/");
		int a = sc.nextInt();
		int b = sc.nextInt();
		String c = sc.next();
			if(c.equals("+")) {
				add.setValue(a, b);
				System.out.println(add.calculate());
			}else if(c.equals("-")) {
				sub.setValue(a, b);
				System.out.println(sub.calculate());
			}else if(c.equals("/")) {
				div.setValue(a, b);
				System.out.println(div.calculate());
			}else if(c.equals("*")) {
				mul.setValue(a, b);
				System.out.println(mul.calculate());
			}
	}
}
