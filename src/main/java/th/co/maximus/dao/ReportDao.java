package th.co.maximus.dao;

import java.sql.SQLException;
import java.util.List;

import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.bean.InvEpisOfflineByInsaleBean;
import th.co.maximus.bean.InvEpisOfflineReportBean;
import th.co.maximus.bean.InvPaymentOrderTaxBean;

public interface ReportDao {
	
	public List<InvEpisOfflineReportBean> inqueryEpisOfflineJSONHandler(String documentNo)throws SQLException ;
	public List<InvEpisOfflineByInsaleBean> inqueryEpisOfflineByInsaleJSONHandler(String documentNo)throws SQLException ;
	public List<InvPaymentOrderTaxBean> inqueryInvPaymentOrderTaxBeanJSONHandler(HistoryReportBean creteria)throws SQLException;
}
