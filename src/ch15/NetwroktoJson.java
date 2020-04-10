package ch15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
class Body {

	private Items items;
	private Integer numOfRows;
	private Integer pageNo;
	private Integer totalCount;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}

class Header {

	private String resultCode;
	private String resultMsg;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}

class Item {

	private String airlineNm;
	private String arrAirportNm;
	private long arrPlandTime;
	private String depAirportNm;
	private long depPlandTime;
	private String vihicleId;
	private Integer economyCharge;
	private Integer prestigeCharge;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}

class Items {

	private List<Item> item = null;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}

public class NetwroktoJson {

	private Response response;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}

class Response {

	private Header header;
	private Body body;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}