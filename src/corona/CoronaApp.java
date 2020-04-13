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
			// 1�� �ּ� ��ü �����
			URL url = new URL("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/stores/json?page="+page);
			// 2�� ��Ʈ�� ����
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			// 3�� ���� ���� (���ڿ�)
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			// 4. ���� ���ϱ�
			
			FileWriter fr = new FileWriter("C:\\src\\test.html");
			StringBuilder sb = new StringBuilder();
			String input = "";
			while ((input = br.readLine()) != null) {
					sb.append(input);
					fr.append(input);
			}
			br.close(); // ���� �ݱ�
			con.disconnect(); // ��Ʈ�� �ݱ�

			// 5. �ڹ� ������Ʈ�� ��ȯ
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
		System.out.println("�ε���");
		int page = 1;
		ArrayList<MaskInfo> maskInfos = new ArrayList<>();
		for (int i = 0; i < 30; i++) {
			MaskInfo maskInfo = TestApp.getMaskInfo(page);
			page++;
			maskInfos.add(maskInfo);
		}
		
//		System.out.println("������ �Է��ϼ���.");
//		Scanner sc = new Scanner(System.in);
//		String addr = sc.next();
		String addr = "�λ�";
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
					System.out.println("��ġ : "+item.getAddr());
					checkCode(item.getCode(),maskInfos);
//					System.out.println("�ڵ� : "+item.getCode());
					System.out.println("�̸� : "+item.getName());
					System.out.println();
				}
			}
		}
	}
}