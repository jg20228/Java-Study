package sbs;

public class Student {

	private String name;
	private String num;
	
	public Student(String name, String num) {
		super();
		this.name = name;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNo(String no) {
		this.num = num;
	}

}

/*
 * �л��������� �����ϰ�, �л��̸����� �˻������� �й��� ����ϴ� ���α׷� �ۼ�.
 * 
 * - Student Ŭ���� ���� String name, no�� ���� (�̸��� �й�)
 * 
 * �л����� ArrayList�� ����1
 * 
 * �˻��� �ϰڴ��� y �����ϰ������ n
 * 
 * �л��̸����ִ°�� ���л��� �й��� ���� �л��̸��� ������, ���� �л��̸��̶�� ���
 * 
 * while, flag, ArrayList, foreach
 */