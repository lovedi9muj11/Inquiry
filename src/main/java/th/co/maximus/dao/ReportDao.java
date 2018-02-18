package th.co.maximus.dao;

import java.sql.SQLException;
import java.util.List;

import th.co.maximus.bean.InvEpisOfflineReportBean;

public interface ReportDao {
	
	public List<InvEpisOfflineReportBean> inqueryEpisOfflineJSONHandler(String documentNo)throws SQLException ;
}
