package th.co.maximus.service;

import java.sql.SQLException;
import java.util.List;

import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.bean.ReportTaxRSBean;

public interface ReportTaxService {

	public List<ReportTaxRSBean> findPaymentTaxRs(HistoryReportBean req) throws SQLException;
}
