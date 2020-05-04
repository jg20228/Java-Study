package homework.ch05;

import java.util.Scanner;

abstract class Converter{
	abstract protected double convert(double src);
	abstract protected String getSrcString();
	abstract protected String getDestString();
	protected double ratio; //����

	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(getSrcString()+"�� "+getDestString()+"�� �ٲߴϴ�.");
		System.out.print(getSrcString()+"�� �Է��ϼ���>> ");
		double val = scanner.nextDouble();
		double res = convert(val);
		System.out.println("��ȯ ���: "+res+getDestString()+"�Դϴ�");
		scanner.close();
	}
}

class Won2Dollar extends Converter{
	String src;
	String dest;
	double a;
	
	public Won2Dollar(double a) {
		src="��";
		dest="�޷�";
		this.a = a;
	}
	@Override
	protected double convert(double src) {
		return src/a;
	}
	@Override
	protected String getSrcString() {
		return src;
	}
	@Override
	protected String getDestString() {
		return dest;
	}
}
class Km2Mile extends Converter{
	String src;
	String dest;
	double a;
	
	public Km2Mile(double a) {
		src="Km";
		dest="mile";
		this.a = a;
		
	}
	@Override
	protected double convert(double src) {
		return src/a;
	}
	@Override
	protected String getSrcString() {
		return src;
	}
	@Override
	protected String getDestString() {
		return dest;
	}
}


public class tr03 {

	public static void main(String[] args) {
//		Won2Dollar toDollar = new Won2Dollar(1200);
//		toDollar.run();
		Km2Mile toMile = new Km2Mile(1.6);
		toMile.run();
	}
}
