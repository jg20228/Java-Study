package ch08;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

//���ڷ� �а� ����.
//�Ѱ� �̻��� �ް� �;��.
public class InputEx02 {

	public static void main(String[] args) {
		InputStream in = System.in;
		
		//Reader
		InputStreamReader reader = new InputStreamReader(in);
		
		char[] data = new char[1];
		try {
			reader.read(data);
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
