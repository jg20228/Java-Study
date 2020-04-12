package corona;

import java.util.List;

import lombok.Data;

@Data
public class MaskInfo {
	private String count;
	private String page;
	private List<Sales> sales = null;
	private String totalCount;
	private String totalPage;
}

@Data
class Sales {
	private String code;
	private String created_at;
	private String remain_stat;
	private String stock_at;
}

