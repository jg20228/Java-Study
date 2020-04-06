package jsontest;

import com.google.gson.Gson;

public class GsonEx03 {

	public static void main(String[] args) {
		// 1.다운 받은 Json 데이터
		String jsonData = "{\"name\":\"코스\",\"age\":40}";
		System.out.println(jsonData);
		// 2. Json 데이터 -> java 오브젝트 변환
		Gson gson = new Gson();

		People p = gson.fromJson(jsonData, People.class);
		System.out.println(p.getName());
		System.out.println(p.getAge());
	}
}
