package ch05;

class A {
	void run() {
		System.out.println("A �޸���");
	}
}

class B extends A {
	void run() {
		System.out.println("B �޸���");
	}
}

class C extends B {
	String name = "C";
	void run() {
		System.out.println(name + " �޸���");
	}

}

public class OverrideEx01 {

	public static void main(String[] args) {
		A a1 = new C(); // A B C
		a1.run();
	}
}
