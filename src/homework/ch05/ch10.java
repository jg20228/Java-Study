package homework.ch05;

abstract class PairMap{
	protected String keyArray[]; //key 저장
	protected String valueArray[]; //value 저장
	abstract String get(String key); // key값을 가진 value 리턴, 없으면 null
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
		dic.put("황기태", "자바");
		dic.put("이재문", "파이썬");
		dic.put("이재문", "C++"); //이재문의 값을 C++로 수정
		System.out.println("이재문의 값은 "+dic.get("이재문"));
		System.out.println("황기태의 값은 "+dic.get("황기태"));
		dic.delete("황기태");
		System.out.println("황기태의 값은 "+dic.get("황기태"));
	}
}
