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
 * 학생정보들을 저장하고, 학생이름으로 검색했을때 학번을 출력하는 프로그램 작성.
 * 
 * - Student 클래스 생성 String name, no를 가짐 (이름과 학번)
 * 
 * 학생들을 ArrayList에 저장1
 * 
 * 검색을 하겠느냐 y 종료하고싶으면 n
 * 
 * 학생이름이있는경우 그학생의 학번을 저장 학생이름이 없으면, 없는 학생이름이라고 출력
 * 
 * while, flag, ArrayList, foreach
 */