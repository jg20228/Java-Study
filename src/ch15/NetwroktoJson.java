package ch15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Body {

	private Items items;
	private Integer numOfRows;
	private Integer pageNo;
	private Integer totalCount;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	public Integer getNumOfRows() {
		return numOfRows;
	}

	public void setNumOfRows(Integer numOfRows) {
		this.numOfRows = numOfRows;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}

class Header {

	private String resultCode;
	private String resultMsg;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

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

	public String getAirlineNm() {
		return airlineNm;
	}

	public void setAirlineNm(String airlineNm) {
		this.airlineNm = airlineNm;
	}

	public String getArrAirportNm() {
		return arrAirportNm;
	}

	public void setArrAirportNm(String arrAirportNm) {
		this.arrAirportNm = arrAirportNm;
	}

	public long getArrPlandTime() {
		return arrPlandTime;
	}

	public void setArrPlandTime(Integer arrPlandTime) {
		this.arrPlandTime = arrPlandTime;
	}

	public String getDepAirportNm() {
		return depAirportNm;
	}

	public void setDepAirportNm(String depAirportNm) {
		this.depAirportNm = depAirportNm;
	}

	public long getDepPlandTime() {
		return depPlandTime;
	}

	public void setDepPlandTime(Integer depPlandTime) {
		this.depPlandTime = depPlandTime;
	}

	public String getVihicleId() {
		return vihicleId;
	}

	public void setVihicleId(String vihicleId) {
		this.vihicleId = vihicleId;
	}

	public Integer getEconomyCharge() {
		return economyCharge;
	}

	public void setEconomyCharge(Integer economyCharge) {
		this.economyCharge = economyCharge;
	}

	public Integer getPrestigeCharge() {
		return prestigeCharge;
	}

	public void setPrestigeCharge(Integer prestigeCharge) {
		this.prestigeCharge = prestigeCharge;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}

class Items {

	private List<Item> item = null;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}

public class NetwroktoJson {

	private Response response;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}

class Response {

	private Header header;
	private Body body;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}