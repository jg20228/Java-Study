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
			// 1�� �ּ� ��ü �����
			// URL url = new URL("https://www.naver.com");
			URL url = new URL(
					"http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList"
							+ "?serviceKey=b9Wuh6%2BeWkKlAtrxWGpQtTdO%2FYkEckdAnj1qdV%2Fs7B1Jr%2BtgRh6rRuUCTSadAGRgByH%2FdRUdi4ne0uDaIJbQMw%3D%3D"
							+ "&numOfRows=50" + "&pageNo=1" + "&depAirportId="
							+ FlightInfoService.airPortId.get(depAirportId) + "&arrAirportId="
							+ FlightInfoService.airPortId.get(arrAirportId) + "&airlineId="
							+ FlightInfoService.airLineId.get(arrAirportId) + "&depPlandTime=" + depPlandTime
							+ "&_type=json");

			// 2�� ��Ʈ�� ����
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			// 3�� ���� ����(���ڿ�)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

			// tip : ���Ͽ� ��Ʈ�� ����
			// FileWriter fr = new FileWriter("C:\\utils\\test.html");

			// 4.���� ���ϱ��Ҷ��� ��Ʈ�� ������ ����.
			StringBuilder sb = new StringBuilder();

			String input = "";

			while ((input = br.readLine()) != null) {
				sb.append(input);
			}

			br.close(); // ���� �ݱ�
			con.disconnect(); // ��Ʈ�� �ݱ�

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
			// 1�� �ּ� ��ü �����
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

			// 2�� ��Ʈ�� ����
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			// 3�� ���� ����(���ڿ�)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

			// tip : ���Ͽ� ��Ʈ�� ����
			// FileWriter fr = new FileWriter("C:\\utils\\test.html");

			// 4.���� ���ϱ��Ҷ��� ��Ʈ�� ������ ����.
			StringBuilder sb = new StringBuilder();

			String input = "";

			while ((input = br.readLine()) != null) {
				sb.append(input);
			}

			br.close(); // ���� �ݱ�
			con.disconnect(); // ��Ʈ�� �ݱ�

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
		System.out.println("������� �Է��ϼ���.");
		Scanner sc = new Scanner(System.in);
		String depAirportId = sc.next();// ����

		System.out.println("�������� �Է��ϼ���.");
		String arrAirportId = sc.next();

		System.out.println("������ڸ� �Է��ϼ���.");
		String depPlandTimeTemp = sc.next();

		// String�� Long����
		long depPlandTime = Long.parseLong(depPlandTimeTemp);
		// String�� Integer����
		Integer depPlandTimeInteger = Integer.parseInt(depPlandTimeTemp);
		// String�� Double����
		Double depPlandTimeDouble = Double.parseDouble(depPlandTimeTemp);
		// �Ÿ���� String����
		String strTemp = depPlandTime + "";
		// int->Integer�� �ٲٸ� toString ����
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
		for (AirplaneInfo airplaneInfo : airplaneInfos) { // 122�� - 3��
			List<Item> flightItems = airplaneInfo.getResponse().getBody().getItems().getItem();  
			
			// iterable (�ݺ�)	
			for (Item item : flightItems) { // forEach �� 50��
				System.out.println("�װ��� : "+item.getAirlineNm());
				System.out.println("����� : "+item.getDepAirportNm());
				System.out.println("������ : "+item.getArrAirportNm());
				System.out.println("��߽ð� : "+item.getDepPlandTime());
				System.out.println("�����ð� : "+item.getArrPlandTime());
				System.out.println("��� : "+item.getEconomyCharge());
				System.out.println();
			}
		}
	}
}
