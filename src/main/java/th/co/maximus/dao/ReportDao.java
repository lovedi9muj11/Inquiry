package th.co.maximus.dao;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface ReportDao {
	
	public void inqueryEpisOfflineJSONHandler(HttpServletRequest request,HttpServletResponse response, Model model)throws SQLException ;
}
