package th.co.maximus.service.impl;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import th.co.maximus.dao.ReportDao;
import th.co.maximus.service.ReportService;
@Service
public class ReportServiceImpl implements ReportService{

	@Autowired ReportDao reportDao;
	
	@Override
	public void inqueryEpisOfflineJSONHandler(HttpServletRequest request,HttpServletResponse response, Model model) throws SQLException {
		
		reportDao.inqueryEpisOfflineJSONHandler(request, response, model);

	}

}
