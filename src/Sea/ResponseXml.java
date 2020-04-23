package Sea;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@XmlRootElement(name = "responseXml")
public class ResponseXml {
	@XmlElement(name = "header")
	private List<Header> header = null;
	@XmlElement(name = "body")
	private String body;

	@ToString
	@Data
	@XmlRootElement
	public static class Header {
		@XmlElement(name = "title")
		private String title;
		@XmlElement(name = "resultCode")
		private String resultCode;
		@XmlElement(name = "resultMsg")
		private String resultMsg;
		@XmlElement(name = "currentPageNo")
		private String currentPageNo;
		@XmlElement(name = "recordCountPerPage")
		private String recordCountPerPage;
		@XmlElement(name = "totalCount")
		private String totalCount;
	}

	@Data
	@ToString
	@XmlRootElement
	public static class body {
		private List<Item> item = null;

		@Data
		@ToString
		@XmlRootElement
		public static class Item {
			@XmlElement(name = "stdYymm")
			private String stdYymm;
			@XmlElement(name = "nationCode")
			private String nationCode;
			@XmlElement(name = "mprcExipitmCode")
			private String mprcExipitmCode;
			@XmlElement(name = "imxprtSeCode")
			private String imxprtSeCode;
			@XmlElement(name = "nationNm")
			private String nationNm;
			@XmlElement(name = "ecoblNm")
			private String ecoblNm;
			@XmlElement(name = "mprcExipitmNm")
			private String mprcExipitmNm;
			@XmlElement(name = "imxprtSeNm")
			private String imxprtSeNm;
			@XmlElement(name = "imxprtWt")
			private String imxprtWt;
			@XmlElement(name = "imxprtDollarAmount")
			private String imxprtDollarAmount;
		}

	}

}
