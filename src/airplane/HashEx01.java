package airplane;

import java.util.HashMap;

//공항 목록 해시로 만듬
public class HashEx01 {

	public static void main(String[] args) {
		HashMap<String, String> auth = new HashMap<>();
		auth.put("아이디", "ssarmango");
		auth.put("비밀번호", "1234");
		auth.put("아이디", "cos");

		System.out.println(auth.get("아이디"));
	}

}
