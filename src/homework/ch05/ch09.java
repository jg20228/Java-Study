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
		System.out.println("������ �� ���� Ǫ�� �Ұ�!");
		return false;
	}
}


public class ch09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ���� ���� ������ ũ�� �Է� >>");
		
		StringStack stringStack = new StringStack(sc.nextInt());
		String a;
		while(true) {
			System.out.println("���ڿ� �Է� >>");
			a=sc.next();
			if(stringStack.push(a)) {
				System.out.println("��");
			}
			if(a.equals("�׸�")) {
				stringStack.pop();
			}
		}
	}
}
