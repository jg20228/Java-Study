package dateex;

import java.util.Calendar;

public class CalendarEx {
	// DB DATE ����)2020-03-18:22:11:05
	public static void printCalendar(String msg, Calendar cal) {
		int year = cal.get(Calendar.YEAR);// 2020
		int month = cal.get(Calendar.MONTH) + 1;// 4 (0���� ������)
		String mon = (month < 10) ? "0" + month : "" + month;
		int day = cal.get(Calendar.DAY_OF_MONTH); // 24
		String d = (day < 10) ? "0" + day : "" + day;
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 6 �Ͽ�ȭ������� - �߾Ⱦ�
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		String h = (hour < 10) ? "0" + hour : "" + hour;
		int min = cal.get(Calendar.MINUTE);
		String m = (min < 10) ? "0" + min : "" + min;
		int sec = cal.get(Calendar.SECOND);
		String s = (sec < 10) ? "0" + sec : "" + sec;

		System.out.println(year + "-" + mon + "-" + d + ":" + h + ":" + m + ":" + s);
		
		//SimpleDataFormat - �� Ŭ������ ����ϸ� ���� �밡�ٸ� ���ص� �ȴ�.
	}

	public static void main(String[] args) {
		// JVM�� heap������ ���°��� �����ͼ� �� (new�� ����)
		Calendar now = Calendar.getInstance(); // �̱���
		printCalendar("����", now);
	}

}
