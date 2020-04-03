package coffeeshop.test;

//���׸� (�Ϲ�����) - Ŭ���� ������ Ÿ�� ����
//���� ��ü ���鶧 �������� Ÿ���� ������ �� �ִ�.
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
		data.value = "���ڿ�";
		System.out.println(data.value);
		// Wrapper Ŭ����
		// �⺻ �ڷ����� Ŭ����ȭ �����ִ� ���
		// int -> Integer , char -> Character �� �� 6�� �տ� �빮�ڸ� 
		Data<Integer> data2 = new Data<>();
		data2.value = 10;
		System.out.println(data2.value);

		Str<String, String> s = new Str<>();
		s.k = "��й�ȣ";
		s.v = "bitc5500";

		System.out.println(s.k);
		System.out.println(s.v);
	}

}
