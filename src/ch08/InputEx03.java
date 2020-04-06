package ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputEx03 {

	public static void main(String[] args) {
		InputStream in = System.in;
		InputStreamReader reader = new InputStreamReader(in);
		// �� �ΰ��� ����� �״�� ����ϸ鼭 Buffer�� �̿�
		BufferedReader br = new BufferedReader(reader);

		// �� 3���� ���ٷ� ǥ��
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		// Scanner = BufferedReader
		String data = "";
		try {
			while ((data = br2.readLine()) != null) { //readLine�� �ѹ���, �ι� �̻󾲸� ����
				System.out.println(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Reader <-> Writer
		// Input <-> Output
	}
}
