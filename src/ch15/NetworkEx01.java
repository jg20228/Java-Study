package ch15;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

import jsontest.People;

public class NetworkEx01 {
	

	public static void main(String[] args) {
		
		try {
			//1�� �ּ� ��ü �����
			//URL url = new URL("https://www.naver.com");
			URL url = new URL("http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=b9Wuh6%2BeWkKlAtrxWGpQtTdO%2FYkEckdAnj1qdV%2Fs7B1Jr%2BtgRh6rRuUCTSadAGRgByH%2FdRUdi4ne0uDaIJbQMw%3D%3D&numOfRows=50&pageNo=1&depAirportId=NAARKJJ&arrAirportId=NAARKPC&depPlandTime=20200407&_type=json");
			
			//2�� ��Ʈ�� ����
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			//3�� ���� ����(���ڿ�)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			
			//tip : ���Ͽ� ��Ʈ�� ����
			//FileWriter fr = new FileWriter("C:\\utils\\test.html");
			
			// 4.���� ���ϱ��Ҷ��� ��Ʈ�� ������ ����.
			StringBuilder sb = new StringBuilder();
			
			
			String input = "";
			
			while((input = br.readLine())!=null) {
				sb.append(input);
			}
			System.out.println(sb);
			//fr.write(sb.toString());//toString ��� ������Ʈ�� ��Ʈ������ ����
			
			//People p = gson.fromJson(jsonData, People.class);
			Gson gson = new Gson();
			NetwroktoJson a = gson.fromJson(sb.toString(),NetwroktoJson.class);
			System.out.println(a.getResponse().getBody().getItems().getItem());
			
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
	}

}
