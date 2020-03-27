package ch04;

//상태(state)와 행동(behavior)
public class Person {
	String name;
	String job;
	int age;
	char gender;
	String bloodType;

	// 디폴트 생성자-매개변수가 없는 아이
	// (용도:초기화)클래스랑 똑같은 이름을 가진 함수
	public Person() {
	}

	// 매개변수가 있는 생성자
	// 오버로딩
	public Person(String name, String job, int age, char gender, String bloodType) {
		this.name = name;
		this.job = job;
		this.age = age;
		this.gender = gender;
		this.bloodType = bloodType;
	}
	
}
