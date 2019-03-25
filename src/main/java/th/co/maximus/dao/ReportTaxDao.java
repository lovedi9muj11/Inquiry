package th.co.maximus.dao;

import java.util.List;

import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.bean.ReportTaxRSBean;

public interface ReportTaxDao {
	
	public List<ReportTaxRSBean> findPaymentTaxRs(HistoryReportBean req);
	
}
