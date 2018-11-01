package th.co.maximus.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.bean.InvEpisOfflineOtherBean;
import th.co.maximus.bean.InvEpisOfflineReportBean;
import th.co.maximus.bean.InvPaymentOrderTaxBean;
import th.co.maximus.dao.ReportDao;
import th.co.maximus.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired ReportDao reportDao;
	
	@Override
	public List<InvEpisOfflineReportBean> inqueryEpisOfflineJSONHandler(String documentNo) throws SQLException {
		
		return reportDao.inqueryEpisOfflineJSONHandler(documentNo);

	}

	@Override
	public List<InvEpisOfflineOtherBean> inqueryEpisOfflineOtherJSONHandler(String documentNo) throws SQLException {
		// TODO Auto-generated method stub
		return reportDao.inqueryEpisOfflineOtherJSONHandler(documentNo);
	}

	@Override
	public List<InvPaymentOrderTaxBean> inqueryInvPaymentOrderTaxBeanJSONHandler(HistoryReportBean creteria)
			throws SQLException {
		// TODO Auto-generated method stub
		return reportDao.inqueryInvPaymentOrderTaxBeanJSONHandler(creteria);
	}

	@Override
	public List<InvPaymentOrderTaxBean> vatSummarry(HistoryReportBean creteria ,boolean groupBy) throws SQLException {
		// TODO Auto-generated method stub
		return reportDao.summarryVay(creteria,groupBy);
	}

}
