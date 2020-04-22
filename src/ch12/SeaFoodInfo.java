package ch12;

import java.util.List;

import lombok.Data;

@Data
public class SeaFoodInfo {

	private ResponseXml responseXml;
	String header;
	String body;

}

@Data
class Body {

	private List<Item> item = null;

}

@Data
class Header {

	private String title;
	private String resultCode;
	private String resultMsg;
	private String currentPageNo;
	private String recordCountPerPage;
	private String totalCount;

}

@Data
class Item {

	private String stdYymm;
	private String nationCode;
	private String mprcExipitmCode;
	private String imxprtSeCode;
	private String nationNm;
	private String ecoblNm;
	private String mprcExipitmNm;
	private String imxprtSeNm;
	private String imxprtWt;
	private String imxprtDollarAmount;

}

@Data
class ResponseXml {

	private Header header;
	private Body body;

}
