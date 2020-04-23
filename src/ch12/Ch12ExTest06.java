package ch12;

import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ch12ExTest06 extends JFrame {
	static String a ="";
	static String c ="";
	private MyPanel panel = new MyPanel();

	public Ch12ExTest06() {
		setTitle("drawLine 사용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setLayout(null);
		setLocationRelativeTo(null); // 중앙

		setSize(800, 600);
		setVisible(true);

	}

	class MyPanel extends JPanel {
		int b = Integer.parseInt(a);
		int min = 1;
		int max = 1;
		String stdYymm = c; // 날짜 연결
		int height = b/100; // 숫자 데이터 연결

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			for (int i = 0; i < 10; i++) {
				g.setColor(Color.RED);
				g.fillRect((40 * i) + 20, 500 - height, 20, height); // (x,y,width,height)
				g.drawString(stdYymm + (i + ""), (40*i) + 20, 520); // (이름,x,y)
			}

		}
	}

	private static String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if (nValue == null)
			return null;
		return nValue.getNodeValue();
	}
	
	private static String getData() {
		int page = 1; // 페이지 초기값
		String ab="";
		//ArrayList ab = new ArrayList();
		try {
			while (true) {
				// parsing할 url 지정(API 키 포함해서)
				String url = "http://apis.data.go.kr/1192000/openapi/service/ManageExpNationItemService/getExpNationItemList?serviceKey=b9Wuh6%2BeWkKlAtrxWGpQtTdO%2FYkEckdAnj1qdV%2Fs7B1Jr%2BtgRh6rRuUCTSadAGRgByH%2FdRUdi4ne0uDaIJbQMw%3D%3D&numOfRows=10&pageNo=1&baseDt=201501&nationNm=%EC%A4%91%EA%B5%AD&imxprtSeNm=%EC%88%98%EC%9E%85&itemNm=%EB%B1%80%EC%9E%A5%EC%96%B4";

				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				// root tag
				doc.getDocumentElement().normalize();
				//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("body");
				// System.out.println("파싱할 리스트 수 : "+ nList.getLength());
				for (int temp = 0; temp < nList.getLength(); temp++) {
					Node nNode = nList.item(temp);
					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;
						System.out.println("######################");
						// System.out.println(eElement.getTextContent());
						c=(getTagValue("nationNm", eElement));
						System.out.println(c);
						ab=getTagValue("imxprtWt", eElement);
						//System.out.println("수량  : " + getTagValue("imxprtWt", eElement));
					} // for end
				} // if end
				page += 1;
				//System.out.println("page number : " + page);
				if (page > 1) {
					break;
				}
			} // while end
			return ab;
		} catch (Exception e) {
			e.printStackTrace();
		} // try~catch end
		return null;
		
	}

	public static void main(String[] args) {
		a = getData();
		new Ch12ExTest06();
	}
}
