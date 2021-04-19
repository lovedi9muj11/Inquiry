package th.co.inquiry.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import th.co.inquiry.service.report.ReportService;
import th.co.inquiryx.bean.ReportBean;

@Controller
public class ReportController {
	
	@Autowired
	private ReportService reportService;

	@RequestMapping(value = {"/qReport"})
	public void payOther(ReportBean reportBean, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String rptCode = request.getParameter("rptCode");
		String pathFile = request.getSession().getServletContext().getRealPath("/report/excel/" + "InquiryReport" + ".xls");
		FileInputStream input_document = new FileInputStream(new File(pathFile));
		Workbook workbook = new HSSFWorkbook(input_document);
//		XSSFWorkbook workbook2 = new XSSFWorkbook(input_document);

		input_document.close();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
//		workbook.createSheet("Text1");
		reportService.controlAllReports(workbook, rptCode).write(byteArrayOutputStream);
		byte[] bytes = byteArrayOutputStream.toByteArray();
		
		Locale TH = new Locale("th", "TH");
		SimpleDateFormat dateFormate = new SimpleDateFormat("dd-MM-yyyy", TH);
		String fileName = "Result_Question"+ dateFormate.format(new Date());

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName +".xlsx");
		response.getOutputStream().write(bytes);
		response.getOutputStream().flush();
	}
	
}
