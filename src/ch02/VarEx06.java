package ch02;

class Person {
	String name = "�� ���ʽ���";
	int age = 64;
	char gender = '��';
	String email = "abcd@1234.com";
	String phone = "010-0000-0000";
}

public class VarEx06 {
	public static void main(String[] args) {
		Person p = new Person();
		System.out.println(p.name);
		System.out.println(p.age);
		System.out.println(p.gender);
		System.out.println(p.email);
		System.out.println(p.phone);

	}
}
