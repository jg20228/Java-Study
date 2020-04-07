package airplane;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class AirplaneApp {

	public static AirplaneInfo getFlightInfo(String depAirportId, String arrAirportId, Integer depPlandTime) {
		try {
			// 1번 주소 객체 만들기
			// URL url = new URL("https://www.naver.com");
			URL url = new URL(
					"http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=b9Wuh6%2BeWkKlAtrxWGpQtTdO%2FYkEckdAnj1qdV%2Fs7B1Jr%2BtgRh6rRuUCTSadAGRgByH%2FdRUdi4ne0uDaIJbQMw%3D%3D&numOfRows=50&pageNo=1&depAirportId=NAARKJJ&arrAirportId=NAARKPC&depPlandTime=20200407&_type=json");

			// 2번 스트림 연결
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			// 3번 버퍼 연결(문자열)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

			// tip : 파일에 스트림 연결
			// FileWriter fr = new FileWriter("C:\\utils\\test.html");

			// 4.문자 더하기할때는 스트링 빌더를 쓴다.
			StringBuilder sb = new StringBuilder();

			String input = "";

			while ((input = br.readLine()) != null) {
				sb.append(input);
			}

			br.close(); // 버퍼 닫기
			con.disconnect(); // 스트림 닫기

			Gson gson = new Gson();
			AirplaneInfo a = gson.fromJson(sb.toString(), AirplaneInfo.class);
			return a;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] args) {
		String depAirportId = "NAARKJJ";
		String arrAirportId = "NAARKPC";
		Integer depPlandTime = 20200407;
		AirplaneInfo airplaneInfo = getFlightInfo(depAirportId,arrAirportId,depPlandTime);
		Item item1 = new Item();
		System.out.println(item1.getAirlineNm());
		System.out.println(airplaneInfo.getResponse().getBody().getItems().getItem());
		int n= 0;
		for (Item item : airplaneInfo.getResponse().getBody().getItems().getItem()) {
			n++;
			System.out.println("테스트 "+n);
			System.out.println(item.getAirlineNm());
		}
		
		
//		for (Item item : airplaneInfo.getResponse().getBody().getItems().getItem()) {
//			System.out.println("항공사 : "+item.getAirlineNm());
//			System.out.println("출발지 : "+item.getDepAirportNm());
//			System.out.println("도착지 : "+item.getArrAirportNm());
//			System.out.println("출발시간 : "+item.getDepPlandTime());
//			System.out.println("도착시간 : "+item.getArrPlandTime());
//			System.out.println("요금 : "+item.getEconomyCharge());
//			System.out.println();
//		}
	}
}
