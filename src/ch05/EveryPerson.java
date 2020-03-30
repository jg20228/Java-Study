package ch05;

class 사람 {
	int num = 10;
}
class 아시아인 extends 사람 {
	int num = 30;
}
class 한국인 extends 아시아인 {

}
//class 배우 {다른 트리}
class 박서준 extends 한국인 {
	int num = 20;
}
public class EveryPerson {

	public static void main(String[] args) {
		// 스캔을 박서준->한국인->아시아인->사람
		박서준 b1 = new 박서준();
		System.out.println(b1.num);

		// 스캔을 한국인->아시아인->사람
		한국인 b2 = new 박서준(); //업캐스팅(묵시적 형변환)
		System.out.println(b2.num);
		
		//다운캐스팅
		박서준 downB2= (박서준)b2;
		System.out.println("downB2 : "+downB2.num);
		
		// 스캔을 사람
		사람 b3 = new 한국인();
		System.out.println(b3.num);
		//박서준 downB3 = (박서준) b3;
		//메모리에 박서준이 없어서 오류가 뜸
		
		// new를하면 extends된 만큼 메모리에 뜬다
		// 가르키는 대상을 앞에 적는다
	}
}
