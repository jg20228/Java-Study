package homework.ch05;

abstract class PairMap{
	protected String keyArray[]; //key ����
	protected String valueArray[]; //value ����
	abstract String get(String key); // key���� ���� value ����, ������ null
	abstract void put(String key,String value);
	abstract String delete(String key);
	abstract int length();
}

class Dictionary extends PairMap{
	int count;
	public Dictionary(int a) {
		keyArray = new String[a];
		valueArray = new String[a];
		count=0;
	}
	
	@Override
	String get(String key) {
		for (int i = 0; i < count; i++) {
			if(keyArray[i].equals(key)) {
				return valueArray[i];
			}
		}
		return null;
	}

	
	@Override
	void put(String key, String value) {
		keyArray[count]=key;
		valueArray[count]=value;
		count++;
	}

	@Override
	String delete(String key) {
		for (int i = 0; i < count; i++) {
			if(keyArray[i].equals(key)) {
				valueArray[i]=null;
			}
		}
		return null;
	}

	@Override
	int length() {
		return count;
	}
	
}


public class ch10 {

	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("Ȳ����", "�ڹ�");
		dic.put("���繮", "���̽�");
		dic.put("���繮", "C++"); //���繮�� ���� C++�� ����
		System.out.println("���繮�� ���� "+dic.get("���繮"));
		System.out.println("Ȳ������ ���� "+dic.get("Ȳ����"));
		dic.delete("Ȳ����");
		System.out.println("Ȳ������ ���� "+dic.get("Ȳ����"));
	}
}
