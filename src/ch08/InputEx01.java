package ch08;

import java.io.IOException;
import java.io.InputStream;

//스트림(Byte) => 물의흐름
//물이 흐를때 수도꼭지를 잠궈두면 물이 흐르지 않는다.
//물이 흐를때 수도곡지를 물이 흘러요.(통신 시작)
//물 = 바이트
public class InputEx01 {

	public static void main(String[] args) {

		InputStream in = System.in;//System.in = 키보드에 연결된 Byte Stream
		try {
			int data = in.read();
			System.out.println((char)data);
		} catch (IOException e) {//e = IOException의 문제가 서술된 변수
			System.out.println("IO 오류가 발생");
			e.getMessage(); //무슨 오류인지
			e.printStackTrace(); //다른 오류들 추적해서 알려줌
		}
	}
}
