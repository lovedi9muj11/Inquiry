package th.co.maximus.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.bean.InvEpisOfflineByInsaleBean;
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
	public List<InvEpisOfflineByInsaleBean> inqueryEpisOfflineByInsaleJSONHandler(String documentNo) throws SQLException {
		// TODO Auto-generated method stub
		return reportDao.inqueryEpisOfflineByInsaleJSONHandler(documentNo);
	}

	@Override
	public List<InvPaymentOrderTaxBean> inqueryInvPaymentOrderTaxBeanJSONHandler(HistoryReportBean creteria)
			throws SQLException {
		// TODO Auto-generated method stub
		return reportDao.inqueryInvPaymentOrderTaxBeanJSONHandler(creteria);
	}

}
