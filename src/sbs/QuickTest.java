package sbs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class QuickTest {
	public static void main(String[] args) {
		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/1192000/openapi/service/ManageExpNationItemService/getExpNationItemList"); //URL
		try {
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=����Ű");
			/* Service Key */
			urlBuilder.append("&" + URLEncoder.encode("ServiceKey", "UTF-8") + "="
					+ URLEncoder.encode("fhhkKKWJ1J5q1lOW2", "UTF-8")); /* ����Ű */
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
					+ URLEncoder.encode("10", "UTF-8")); /* ǥ�ðǼ�(�ִ� 100��) */
			urlBuilder.append(
					"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /* ��������ȣ */
			urlBuilder.append(
					"&" + URLEncoder.encode("baseDt", "UTF-8") + "=" + URLEncoder.encode("201501", "UTF-8")); /* ���س�� */
			urlBuilder.append("&" + URLEncoder.encode("nationNm", "UTF-8") + "="
					+ URLEncoder.encode("�߱�", "UTF-8")); /* ������ ������ */
			urlBuilder.append("&" + URLEncoder.encode("imxprtSeNm", "UTF-8") + "="
					+ URLEncoder.encode("����", "UTF-8")); /* ����,���� */
			urlBuilder.append(
					"&" + URLEncoder.encode("itemNm", "UTF-8") + "=" + URLEncoder.encode("�����", "UTF-8")); /* ������ǰ��� */
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
			BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}
			rd.close();
			conn.disconnect();
		
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}