package corona;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class TestApp {
	
	public static MaskInfo getMaskInfo(int page) {
		try {
			URL url = new URL("https://8oi9s0nnth.apigw.ntruss.com/corona19-masks/v1/sales/json?page="+page);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

			StringBuilder sb = new StringBuilder();
			String input = "";

			while ((input = br.readLine()) != null) {
					sb.append(input);
			}
			br.close();
			con.disconnect();

			Gson gson = new Gson();
			MaskInfo maskInfo = gson.fromJson(sb.toString(), MaskInfo.class);
			return maskInfo;

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		int page=1;
		ArrayList<MaskInfo> maskInfos = new ArrayList<>();
		for (int i = 0; i < 52; i++) {
			MaskInfo maskInfo = getMaskInfo(page);
			page++;
			maskInfos.add(maskInfo);
		}
		System.out.println(maskInfos.get(0).getSales().get(0).getCode());
//		for (MaskInfo maskInfo : maskInfos) { 
//			List<Sales> sales = maskInfo.getSales();
//
//			for (Sales item : sales) { 
//					System.out.println("코드 : "+item.getCode());
//					System.out.println("코드 : "+item.getRemain_stat());
//					System.out.println();
//			}
//		}

	}

}
