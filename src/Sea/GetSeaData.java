//package Sea;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//
//
//public class GetSeaData {
//
//	public static ResponseXml getResponseXml() {
//		try {
//			URL url = new URL(
//					"http://apis.data.go.kr/1192000/openapi/service/ManageExpNationItemService/getExpNationItemList?serviceKey=b9Wuh6%2BeWkKlAtrxWGpQtTdO%2FYkEckdAnj1qdV%2Fs7B1Jr%2BtgRh6rRuUCTSadAGRgByH%2FdRUdi4ne0uDaIJbQMw%3D%3D&numOfRows=10&pageNo=10&baseDt=201501&nationNm=%EC%A4%91%EA%B5%AD&imxprtSeNm=%EC%88%98%EC%9E%85&itemNm=%EB%B1%80%EC%9E%A5%EC%96%B4");
//			HttpURLConnection con = (HttpURLConnection) url.openConnection();
//			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
//			StringBuilder sb = new StringBuilder();
//			String input = "";
//			while ((input = br.readLine()) != null) {
//				sb.append(input);
//			}
//			br.close(); // ¹öÆÛ ´Ý±â
//			con.disconnect(); // ½ºÆ®¸² ´Ý±â
////			ResponseXml responseXml = sb;
//			return responseXml;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	public static void main(String[] args) {
//		ArrayList<ResponseXml> responseXmls = new ArrayList<>();
//		responseXmls.add(getResponseXml());
//
//	}
//
//}
