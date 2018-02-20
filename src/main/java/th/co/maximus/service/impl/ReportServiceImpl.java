package th.co.maximus.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.InvEpisOfflineReportBean;
import th.co.maximus.dao.ReportDao;
import th.co.maximus.service.ReportService;

@Service
public class ReportServiceImpl implements ReportService{

	@Autowired ReportDao reportDao;
	
	@Override
	public List<InvEpisOfflineReportBean> inqueryEpisOfflineJSONHandler(String documentNo) throws SQLException {
		
		return reportDao.inqueryEpisOfflineJSONHandler(documentNo);

	}

}
