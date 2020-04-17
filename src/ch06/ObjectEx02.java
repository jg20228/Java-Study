package ch06;

class Person {
	String name = "홍길동";
	int age = 15;
	String job = "학생";

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", job=" + job + "]";
	}
	// 우클릭 Source -> Generate toString()하면 위에 자동 생성
	// 오버라이딩해서 자기만의 재정의가 되어있음.
}

public class ObjectEx02 {
	// toString()
	// 모든 오브젝트는 toString 할수 있다.
	public static void main(String[] args) {
		Integer num = 10;
		String s = Integer.toString(num);
		System.out.println(s);

		Person p = new Person();
		// 원형은 이건데 return type이 String이다. <제일 중요함 '모든걸 String화' 할수 있다.
		// getClass().getName() + "@" + Integer.toHexString(hashCode());
		System.out.println(p.toString());
		// 주소를 호출하면 자동으로 toString이 사용됨.
		System.out.println(p);

		StringBuilder sb = new StringBuilder();
		sb.append("안녕");
		sb.append("반가워");

		System.out.println(sb.toString());
		// String화 해서 return 시켜줌
//	    public String toString() {
//	        // Create a copy, don't share the array
//	        return new String(value, 0, count);
//	    }

	}
}
