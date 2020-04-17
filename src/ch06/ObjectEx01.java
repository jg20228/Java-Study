package ch06;

class Animal {
	public int hashCode() {
		return super.hashCode();
	}
}

public class ObjectEx01 {
//Object
	public static void main(String[] args) {
		String d1 = "물";
		String d2 = "물";

		System.out.println(d1.equals(d2));
		System.out.println(d1 == d2);

		String d3 = new String("물");
		String d4 = new String("물");

		System.out.println(d3.equals(d4));
		System.out.println(d3 == d4);

		System.out.println(d3.getClass());

		// .getclass 클래스의 정보를 리턴해줌
		// 나중에 리플렉션때 이용함
		System.out.println(new ObjectEx01().getClass());

		// 해쉬코드 -> 해쉬 알고리즘 = 동일한 길이의 숫자로 리턴
		System.out.println(d3.hashCode());
		System.out.println(d4.hashCode());
		// String은 값이 같으면 같은 hashCode가 나오게 바꿔놨다.

		// 밑은 hashCode()의 내부
//	    public int hashCode() {
//	        int h = hash;
//	        if (h == 0 && value.length > 0) {
//	            char val[] = value;
//
//	            for (int i = 0; i < value.length; i++) {
//	                h = 31 * h + val[i];
//	            }
//	            hash = h;
//	        }
//	        return h;
//	    }

		// 오버라이드 해서 해시코드는 바꿀수 있긴함
		// 재정의 할것 아니면 굳이 쓸 필요 없음
		Animal a1 = new Animal();
		Animal a2 = new Animal();

		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode());

		// 객체의 타입이 같은지 비교하는법
		System.out.println(a1 instanceof Animal);
		System.out.println(a2 instanceof Animal);
		
	}
}
