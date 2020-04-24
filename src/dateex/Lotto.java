package dateex;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lotto {

	public static void main(String[] args) {
		// 6개의 번호 - (1~45)
		// Set의 종류는 여러가지 있다.
		// HashSet 순서가 없음 (빠름)
		// TreeSet 순서대로 정렬(HashSet보다 느림)
		Set<Integer> lottoSet = new HashSet<>();
		//Set<Integer> lottoSet = new TreeSet<>();
		Random r = new Random();
		while (lottoSet.size() < 6) {
			int value = r.nextInt(45) + 1;
			lottoSet.add(value);
		}

		System.out.println(lottoSet);
		
		//6-10예제
		System.out.println(Math.PI);
		System.out.println(Math.ceil(3.1));
		System.out.println(Math.floor(3.1));
		System.out.println(Math.sqrt(9));
		System.out.println(Math.exp(2));
		System.out.println(Math.round(3.14));
		
		System.out.println(Math.floor(Math.PI));
		System.out.println(Math.min(-10.5, -11.0));
	}
}
