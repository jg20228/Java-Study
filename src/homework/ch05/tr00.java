package homework.ch05;

import java.util.Scanner;

public class tr00 {
	public static final int BUS = 1200;
	public static final int SUBWAY = 1250;
	public static final int TAXI = 3800;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("교통수단 입력");
		String trans = scanner.next();
		//입력값이 버스, 지하철, 택시인지 검사
		if (trans.equals("버스") || trans.equals("지하철") || trans.equals("택시")) {
			System.out.println("이동거리(km) 입력");
			int way = scanner.nextInt(); //이동거리 입력
			int pay = 0; //요금 선언 및 초기화
			int transit = 0; //이동 비례 요금 저장
			//--------버스와 지하철 요금 결정
			if (trans.equals("버스")) {
				pay = BUS;
			} else if (trans.equals("지하철")) {
				pay = SUBWAY;
			}
			//10km 초과시 추가 요금
			if (way > 10) {
				transit = (((way - 10) / 5) + 1) * 100;
			}
			//택시는 기본요금, 아닐경우 버스,지하철이므로 정보 출력
			if (trans.equals("택시")) {
				System.out.println("택시는 기본요금 " + TAXI + "원 구간만 이동합니다.");
			} else {
				System.out.println("입력 교통수단은" + trans + "이고, 이동거리는 " + way + "km입니다. " + "기본요금은 " 
						+ pay + "원 이고, 결제요금은"+ (pay + transit) + "원 입니다.");
			}
			//입력한 교통정보가 버스,지하철,택시가 아니면 실행
		} else {
			System.out.println(trans + "는 대중교통이 아닙니다.");
		}//첫 if문
	}//main
}//class
