package Sea;


import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class GetTest {
    // tag���� ������ �������� �޼ҵ�
	private static String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	}

	public static void main(String[] args) {
		int page = 1;	// ������ �ʱⰪ 
		ArrayList ab = new ArrayList();
		try{
			while(true){
				// parsing�� url ����(API Ű �����ؼ�)
				String url = "http://apis.data.go.kr/1192000/openapi/service/ManageExpNationItemService/getExpNationItemList?serviceKey=b9Wuh6%2BeWkKlAtrxWGpQtTdO%2FYkEckdAnj1qdV%2Fs7B1Jr%2BtgRh6rRuUCTSadAGRgByH%2FdRUdi4ne0uDaIJbQMw%3D%3D&numOfRows=10&pageNo=1&baseDt=201501&nationNm=%EC%A4%91%EA%B5%AD&imxprtSeNm=%EC%88%98%EC%9E%85&itemNm=%EB%B1%80%EC%9E%A5%EC%96%B4";
				
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				// root tag 
				doc.getDocumentElement().normalize();
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
				// �Ľ��� tag
				NodeList nList = doc.getElementsByTagName("body");
				//System.out.println("�Ľ��� ����Ʈ �� : "+ nList.getLength());
				for(int temp = 0; temp < nList.getLength(); temp++){
					Node nNode = nList.item(temp);
					if(nNode.getNodeType() == Node.ELEMENT_NODE){
						
						Element eElement = (Element) nNode;
						System.out.println("######################");
						//System.out.println(eElement.getTextContent());
						ab.add(getTagValue("imxprtWt", eElement));
						System.out.println("����  : " + getTagValue("imxprtWt", eElement));
					}	// for end
				}	// if end
				page += 1;
				System.out.println("page number : "+page);
				if(page > 1){	
					break;
				}
			}	// while end
			System.out.println(ab.get(0));
		} catch (Exception e){	
			e.printStackTrace();
		}	// try~catch end
	}	// main end
}	// class end