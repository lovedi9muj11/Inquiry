package th.co.maximus.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import th.co.maximus.bean.HistorySubFindBean;
import th.co.maximus.bean.PaymentMMapPaymentInvBean;
//import scala.annotation.meta.setter;
import th.co.maximus.bean.ReportBean;
import th.co.maximus.service.HistoryPaymentService;
import th.co.maximus.service.report.ReportService;

@Controller
public class ReportController {
	
	HistorySubFindBean creteria = null;

	@Autowired
	ReportService reportService;
	
	@Autowired
	private HistoryPaymentService paymentManualService;
	
	@RequestMapping(value = { "/printReport.xls" }, method = RequestMethod.POST)
	public void payOther(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<PaymentMMapPaymentInvBean> result = new ArrayList<PaymentMMapPaymentInvBean>();

		String rptCode = request.getParameter("rptCode");
		String pathFile = request.getSession().getServletContext().getRealPath("/report/excel/" + rptCode + ".xls");
		FileInputStream input_document = new FileInputStream(new File(pathFile));
		Workbook workbook = new HSSFWorkbook(input_document);
		ReportBean bean = new ReportBean();

		input_document.close();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		
		if(creteria != null) {
			  result = paymentManualService.findPayOrder(creteria);
		  }
		
		reportService.controlAllReports(workbook, rptCode, bean).write(byteArrayOutputStream);
		byte[] bytes = byteArrayOutputStream.toByteArray();

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment;filename=" + rptCode+".xls");
		response.getOutputStream().write(bytes);
		response.getOutputStream().flush();
	}

}
