package airplane;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class AirplaneApp {

	public static int getTotalCount(String depAirportId, String arrAirportId, long depPlandTime) {
		try {
			// 1번 주소 객체 만들기
			// URL url = new URL("https://www.naver.com");
			URL url = new URL(
					"http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList"
							+ "?serviceKey=b9Wuh6%2BeWkKlAtrxWGpQtTdO%2FYkEckdAnj1qdV%2Fs7B1Jr%2BtgRh6rRuUCTSadAGRgByH%2FdRUdi4ne0uDaIJbQMw%3D%3D"
							+ "&numOfRows=50" + "&pageNo=1" + "&depAirportId="
							+ FlightInfoService.airPortId.get(depAirportId) + "&arrAirportId="
							+ FlightInfoService.airPortId.get(arrAirportId) + "&airlineId="
							+ FlightInfoService.airLineId.get(arrAirportId) + "&depPlandTime=" + depPlandTime
							+ "&_type=json");

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
			return a.getResponse().getBody().getTotalCount();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static AirplaneInfo getFlightInfo(String depAirportId, String arrAirportId, long depPlandTime, int page) {
		try {
			// 1번 주소 객체 만들기
			// URL url = new URL("https://www.naver.com");
			URL url = new URL(
					"http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList"
							+ "?serviceKey=b9Wuh6%2BeWkKlAtrxWGpQtTdO%2FYkEckdAnj1qdV%2Fs7B1Jr%2BtgRh6rRuUCTSadAGRgByH%2FdRUdi4ne0uDaIJbQMw%3D%3D"
							+ "&numOfRows=50" + "&pageNo=" + page 
							+ "&depAirportId=" + FlightInfoService.airPortId.get(depAirportId) 
							+ "&arrAirportId=" + FlightInfoService.airPortId.get(arrAirportId) 
							+ "&airlineId=" + FlightInfoService.airLineId.get(arrAirportId) 
							+ "&depPlandTime=" + depPlandTime
							+ "&_type=json");

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
		FlightInfoService.setAirLineId();
		FlightInfoService.setAirPortId();

		for (String key : FlightInfoService.airPortId.keySet()) {
			System.out.print(key + " ");
		}
		System.out.println();
		System.out.println("출발지를 입력하세요.");
		Scanner sc = new Scanner(System.in);
		String depAirportId = sc.next();// 김포

		System.out.println("도착지를 입력하세요.");
		String arrAirportId = sc.next();

		System.out.println("출발일자를 입력하세요.");
		String depPlandTimeTemp = sc.next();

		// String을 Long으로
		long depPlandTime = Long.parseLong(depPlandTimeTemp);
		// String을 Integer으로
		Integer depPlandTimeInteger = Integer.parseInt(depPlandTimeTemp);
		// String을 Double으로
		Double depPlandTimeDouble = Double.parseDouble(depPlandTimeTemp);
		// 어떤타입을 String으로
		String strTemp = depPlandTime + "";
		// int->Integer로 바꾸면 toString 가능
		String strTemp2 = depPlandTimeInteger.toString();
		// +"" or double -> Double
		String strTemp3 = depPlandTimeDouble + "";
		String strTemp4 = depPlandTimeDouble.toString();

		int totalCount = getTotalCount(depAirportId, arrAirportId, depPlandTime);
		int page = 1;
		int count = 0;
		if (totalCount % 50 == 0) {
			count = totalCount / 50;
		} else {
			count = totalCount / 50 + 1;
		}
		System.out.println(totalCount);
		
		ArrayList<AirplaneInfo> airplaneInfos = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			AirplaneInfo airplaneInfo = getFlightInfo(depAirportId, arrAirportId, depPlandTime, page);
			page++;
			airplaneInfos.add(airplaneInfo);
		}
		for (AirplaneInfo airplaneInfo : airplaneInfos) { // 122개 - 3번
			List<Item> flightItems = airplaneInfo.getResponse().getBody().getItems().getItem();  
			
			// iterable (반복)	
			for (Item item : flightItems) { // forEach 문 50번
				System.out.println("항공사 : "+item.getAirlineNm());
				System.out.println("출발지 : "+item.getDepAirportNm());
				System.out.println("도착지 : "+item.getArrAirportNm());
				System.out.println("출발시간 : "+item.getDepPlandTime());
				System.out.println("도착시간 : "+item.getArrPlandTime());
				System.out.println("요금 : "+item.getEconomyCharge());
				System.out.println();
			}
		}
	}
}
