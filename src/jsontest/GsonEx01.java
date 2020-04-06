package jsontest;

import com.google.gson.Gson;

class Person{
	//키 값이 똑같아야한다.
	String 이름;
	int 나이;
	String 성별;
	String 주소;
	String[] 특기;//Json이 알아서 new를 해준다.(해줘도 상관없음)
	Family 가족관계;
	String 회사;
}

class Family{
	int 샵;
	String 아버지;
	String 어머니;
	
}

public class GsonEx01 {
	public static void main(String[] args) {
		//JsonEx01를 JsonParser에서 구한값
		//http://json.parser.online.fr/
		String jsonPerson="{\"이름\":\"홍길동\",\"나이\":25,\"성별\":\"여\",\"주소\":\"서울특별시 양천구 목동\",\"특기\":[\"농구\",\"도술\"],\"가족관계\":{\"샵\":2,\"아버지\":\"홍판서\",\"어머니\":\"춘섬\"},\"회사\":\"경기 수원시 팔달구 우만동\"}\r\n" + 
				"";
		// 역슬래쉬 \는 그다음 문자를 무시함
		Gson gson = new Gson();
		Person p = gson.fromJson(jsonPerson,Person.class);
		System.out.println(p.특기[0]);
	}
}
