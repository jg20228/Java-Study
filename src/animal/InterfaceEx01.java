package animal;

//interface
//1.변수 : public static final 생략
//2.함수 : public abstract 생략
//3.통로의 역할 - 동적바인딩하는 용도
//4.무조건 추상메서드만 존재가능 = 하위 클래스에 강제성 부여
//5.new 할 수 없다. (자식을 new해서 같이 heap에뜨는방법밖에 없다)

interface Cal{
	//public static final이 생략되어있다.
	int num = 10;
}

public class InterfaceEx01 {

	public static void main(String[] args) {
		System.out.println(Cal.num);
	}

}
