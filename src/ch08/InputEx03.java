package ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputEx03 {

	public static void main(String[] args) {
		InputStream in = System.in;
		InputStreamReader reader = new InputStreamReader(in);
		// 위 두개의 기능을 그대로 사용하면서 Buffer를 이용
		BufferedReader br = new BufferedReader(reader);

		// 위 3줄을 한줄로 표현
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		// Scanner = BufferedReader
		String data = "";
		try {
			while ((data = br2.readLine()) != null) { //readLine을 한번만, 두번 이상쓰면 오류
				System.out.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Reader <-> Writer
		// Input <-> Output
	}
}
