package homework.ch05;

import java.util.Scanner;

interface Stack{
	int length();
	int capacity();
	String pop();
	boolean push(String val);
}

class StringStack implements Stack{
	String [] index;
	int count;
	
	public StringStack(int a) {
		index = new String[a];
		count = -1;
	}
	
	@Override
	public int length() {
		return count+1;
	}

	@Override
	public int capacity() {
		return index.length;
	}

	@Override
	public String pop() {
		if(count==-1) {return null;}
		String a = index[count];
		count--;
		return a;
	}

	@Override
	public boolean push(String val) {
		if(index.length-1>count) {
			index[count] = val;
			count++;
			return true;
		}
		System.out.println("스택이 꽉 차서 푸시 불가!");
		return false;
	}
}


public class ch09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("총 스택 저장 공간의 크기 입력 >>");
		
		StringStack stringStack = new StringStack(sc.nextInt());
		String a;
		while(true) {
			System.out.println("문자열 입력 >>");
			a=sc.next();
			if(stringStack.push(a)) {
				System.out.println("참");
			}
			if(a.equals("그만")) {
				stringStack.pop();
			}
		}
	}
}
