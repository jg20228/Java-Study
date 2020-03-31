package animal;

interface 부서{
	//도메인을 준다.
	//공통 코드
	int 총무과 = 10;
	int 생산팀 = 20;
	int 인사과 = 30;
	int 행정과 = 40;
}

public class TestInterfaceEx01 {

	public static void main(String[] args) {
		System.out.println(부서.총무과);
	}
}
