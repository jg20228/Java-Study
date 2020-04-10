package corona;

import java.util.List;
import lombok.Data;
@Data
public class CoronaInfo {
	private int count;
	private String page;
	private List<StoreInfos> storeInfos = null;
	private int totalCount;
	private int totalPages;
	
}

@Data
class StoreInfos{
	private String addr;
	private String code;
	private double lat;
	private double lng;
	private String name;
	private String type;
}