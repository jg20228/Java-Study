package coffeeshop.test;

//제네릭 (일반적인) - 클래스 생성시 타입 결정
//내가 객체 만들때 동적으로 타입을 설정할 수 있다.
//E - Element , K - Key, V - Value, T - Type, N - Number
class Data<T> {
	T value;
}

class Str<K, V> {
	K k;
	V v;
}

public class GenericEx01 {
	public static void main(String[] args) {
		Data<String> data = new Data<>();
		data.value = "문자열";
		System.out.println(data.value);
		// Wrapper 클래스
		// 기본 자료형을 클래스화 시켜주는 기술
		// int -> Integer , char -> Character 그 외 6개 앞에 대문자만 
		Data<Integer> data2 = new Data<>();
		data2.value = 10;
		System.out.println(data2.value);

		Str<String, String> s = new Str<>();
		s.k = "비밀번호";
		s.v = "bitc5500";

		System.out.println(s.k);
		System.out.println(s.v);
	}

}
