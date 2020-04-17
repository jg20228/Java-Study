package ch06;

class Animal {
	public int hashCode() {
		return super.hashCode();
	}
}

public class ObjectEx01 {
//Object
	public static void main(String[] args) {
		String d1 = "��";
		String d2 = "��";

		System.out.println(d1.equals(d2));
		System.out.println(d1 == d2);

		String d3 = new String("��");
		String d4 = new String("��");

		System.out.println(d3.equals(d4));
		System.out.println(d3 == d4);

		System.out.println(d3.getClass());

		// .getclass Ŭ������ ������ ��������
		// ���߿� ���÷��Ƕ� �̿���
		System.out.println(new ObjectEx01().getClass());

		// �ؽ��ڵ� -> �ؽ� �˰��� = ������ ������ ���ڷ� ����
		System.out.println(d3.hashCode());
		System.out.println(d4.hashCode());
		// String�� ���� ������ ���� hashCode�� ������ �ٲ����.

		// ���� hashCode()�� ����
//	    public int hashCode() {
//	        int h = hash;
//	        if (h == 0 && value.length > 0) {
//	            char val[] = value;
//
//	            for (int i = 0; i < value.length; i++) {
//	                h = 31 * h + val[i];
//	            }
//	            hash = h;
//	        }
//	        return h;
//	    }

		// �������̵� �ؼ� �ؽ��ڵ�� �ٲܼ� �ֱ���
		// ������ �Ұ� �ƴϸ� ���� �� �ʿ� ����
		Animal a1 = new Animal();
		Animal a2 = new Animal();

		System.out.println(a1.hashCode());
		System.out.println(a2.hashCode());

		// ��ü�� Ÿ���� ������ ���ϴ¹�
		System.out.println(a1 instanceof Animal);
		System.out.println(a2 instanceof Animal);
		
	}
}
