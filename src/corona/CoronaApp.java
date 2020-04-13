package corona;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

public class CoronaApp {
	public static CoronaInfo getCoronaInfo(int page) {
		try {
			// 1번 주소 객체 만들기
			URL url = new URL("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page="+page);
			// 2번 스트림 연결
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			// 3번 버퍼 연결 (문자열)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			// 4. 문자 더하기
			
			FileWriter fr = new FileWriter("C:\\src\\test.html");
			StringBuilder sb = new StringBuilder();
			String input = "";
			while ((input = br.readLine()) != null) {
					sb.append(input);
					fr.append(input);
			}
			br.close(); // 버퍼 닫기
			con.disconnect(); // 스트림 닫기

			// 5. 자바 오브젝트로 변환
			Gson gson = new Gson();
			CoronaInfo coronaInfo = gson.fromJson(sb.toString(), CoronaInfo.class);
			return coronaInfo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String checkCode(String code, ArrayList<MaskInfo> maskInfos) {
		for (int i = 0; i < 30; i++) {
			for (int j = 0; j < 500; j++) {
				if(code.equals((maskInfos.get(i).getSales().get(j).getCode()))){
					System.out.println(i+"  "+j);
					System.out.println(maskInfos.get(i).getSales().get(j).getRemain_stat());
				}
			}
			
		}
		
		return code;
	}
	public static void main(String[] args) {
		System.out.println("로딩중");
		int page = 1;
		ArrayList<MaskInfo> maskInfos = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			MaskInfo maskInfo = TestApp.getMaskInfo(page);
			page++;
			maskInfos.add(maskInfo);
		}
		
//		System.out.println("지역을 입력하세요.");
//		Scanner sc = new Scanner(System.in);
//		String addr = sc.next();
		String addr = "부산";
		ArrayList<CoronaInfo> coronaInfos = new ArrayList<>();

		page = 1;
		for (int i = 0; i < 54; i++) {
			CoronaInfo coronaInfo = getCoronaInfo(page);
			page++;
			coronaInfos.add(coronaInfo);
			System.out.println(page);
		}

		for (CoronaInfo coronaInfo : coronaInfos) { 
			List<StoreInfos> storeInfos = coronaInfo.getStoreInfos();

			for (StoreInfos item : storeInfos) { 
				if(item.getAddr().contains(addr)) {
					System.out.println("위치 : "+item.getAddr());
					checkCode(item.getCode(),maskInfos);
//					System.out.println("코드 : "+item.getCode());
					System.out.println("이름 : "+item.getName());
					System.out.println();
				}
			}
		}
	}
}