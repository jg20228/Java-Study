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
			//1번 주소 객체 만들기
			//URL url = new URL("https://www.naver.com");
			URL url = new URL("http://openapi.tago.go.kr/openapi/service/DmstcFlightNvgInfoService/getFlightOpratInfoList?serviceKey=b9Wuh6%2BeWkKlAtrxWGpQtTdO%2FYkEckdAnj1qdV%2Fs7B1Jr%2BtgRh6rRuUCTSadAGRgByH%2FdRUdi4ne0uDaIJbQMw%3D%3D&numOfRows=50&pageNo=1&depAirportId=NAARKJJ&arrAirportId=NAARKPC&depPlandTime=20200407&_type=json");
			
			//2번 스트림 연결
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			//3번 버퍼 연결(문자열)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
			
			//tip : 파일에 스트림 연결
			//FileWriter fr = new FileWriter("C:\\utils\\test.html");
			
			// 4.문자 더하기할때는 스트링 빌더를 쓴다.
			StringBuilder sb = new StringBuilder();
			
			
			String input = "";
			
			while((input = br.readLine())!=null) {
				sb.append(input);
			}
			System.out.println(sb);
			//fr.write(sb.toString());//toString 모든 오브젝트를 스트링으로 만듬
			
			//People p = gson.fromJson(jsonData, People.class);
			Gson gson = new Gson();
			NetwroktoJson a = gson.fromJson(sb.toString(),NetwroktoJson.class);
			System.out.println(a.getResponse().getBody().getItems().getItem());
			
			
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
	}

}
