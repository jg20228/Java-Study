package ch15;

//내부클래스 - 클래스안에 클래스를 넣는것
//내부에서 나 자신이 접근할때 사용
class MyOuterClass {
	int outerNum = 10;
	
	public MyOuterClass() {
		MyInnerClass mc = new MyInnerClass();
		System.out.println(mc.innerNum);
	}

	class MyInnerClass {
		int innerNum = 20;
	}
}

public class InnerEx01 {

	public static void main(String[] args) {
		//외부에서 내부클래스에 접근할때
		//이렇게 사용할거면 클래스를 외부로 꺼내서 쓰는게 낫다
		MyOuterClass moc = new MyOuterClass();
		MyOuterClass.MyInnerClass d = moc.new MyInnerClass();
	}
}
