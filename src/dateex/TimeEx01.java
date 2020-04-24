package dateex;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

// 구버전 자바 1.7이하
// java.sql.Date
// java.sql.Time (x)
// java.sql.Timestamp
// java.util.Calendar (x)
// java.util.Date 

// 신버전 자바 1.8이상
// java.time.LocalDate
// java.time.LocalDateTime
// java.time.LocalTime

public class TimeEx01 {

	public static void main(String[] args) {
		// 1. Calendar 안씀
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd hh mm ss");
		String today = formater.format(cal.getTime());
		System.out.println("cal.getTime() : " + cal.getTime());
		System.out.println("today : " + today);

		// 2.java.util.Date 안씀 1970.01.01 기준으로 해서 경과된 밀리초를 계산
		Date time2 = new Date();
		System.out.println("time2 : " + time2);
		System.out.println("time2.getTime() : " + time2.getTime());
		// System.out.println("time2.getDay() : "+time2.getDay()); @Deprecated은 취소선처리

		// 3. java.sql.Date 안씀
		// 위에 java.util.Date가 이미 되어있어서 java.sql.Date를 선언 못하고 패키지명이 적힌다.
		java.sql.Date time3 = new java.sql.Date(24 * 3600 * 1000);
		System.out.println("time3 : " + time3);

		// 4.java.sql.Timestamp
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date d = new Date();
		String timeStamp = sf.format(d.getTime());
		Timestamp ts = Timestamp.valueOf(timeStamp);
		System.out.println("ts:" + ts);

		// 5.LocalDateTime(LocalDate to Timestamp) DB에 넣을때 자바에서 Date는 Localdate로 한다!
		// +(3가지 Date,Time,DateTime 차이점!)
		Timestamp nowDate = Timestamp.valueOf(LocalDateTime.now()); // valueOf에 LocalDateTime을 넣을수 있다.
		System.out.println("nowDate : " + nowDate);

		// 6.LocalDateTime(Timestamp to LocalDateTime)
		LocalDateTime ldt = nowDate.toLocalDateTime();
		System.out.println("ldt : " + ldt);

		System.out.println("LocalDateTime : " + LocalDateTime.now());
		System.out.println("LocalDate : " + LocalDate.now());
		System.out.println("LocalTime : " + LocalTime.now());
	}
}
