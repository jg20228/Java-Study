package sbs;

import java.util.ArrayList;

class Student {
	ArrayList<Integer> a = new ArrayList<>();

	String name;
	String num;

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