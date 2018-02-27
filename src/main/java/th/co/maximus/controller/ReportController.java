package th.co.maximus.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import scala.annotation.meta.setter;
import th.co.maximus.bean.ReportBean;
import th.co.maximus.service.report.ReportService;

@Controller
public class ReportController {

	@Autowired
	ReportService reportService;
	
	@RequestMapping(value = { "/printReport.xls" }, method = RequestMethod.POST)
	public void payOther(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String rptCode = request.getParameter("rptCode");
		String pathFile = request.getSession().getServletContext().getRealPath("/report/excel/" + rptCode + ".xls");
		FileInputStream input_document = new FileInputStream(new File(pathFile));
		Workbook workbook = new HSSFWorkbook(input_document);
		ReportBean bean = new ReportBean();

		input_document.close();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		reportService.controlAllReports(workbook, rptCode, bean).write(byteArrayOutputStream);
		byte[] bytes = byteArrayOutputStream.toByteArray();

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=" + rptCode+".xls");
		response.getOutputStream().write(bytes);
		response.getOutputStream().flush(); // commits response!
	}

}
