package th.co.maximus.service;

import java.sql.SQLException;
import java.util.List;

import th.co.maximus.bean.InvEpisOfflineReportBean;

public interface ReportService {
	
	public List<InvEpisOfflineReportBean> inqueryEpisOfflineJSONHandler(String documentNo)throws SQLException;

}