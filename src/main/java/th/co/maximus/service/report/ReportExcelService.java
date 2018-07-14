package th.co.maximus.service.report;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import th.co.maximus.bean.HistoryPaymentRS;
import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.bean.ReportBean;
import th.co.maximus.bean.ReportPaymentBean;
import th.co.maximus.bean.ReportPaymentCriteria;

@Service("reportExcelService")
public class ReportExcelService extends BaseExcelRptService {

	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(getClass());

	@Autowired private RptServicexxx rpt1Servicexxx;
	@Autowired private RptServiceFull rptServiceFull;
	@Autowired private PaymentReportPdf paymentReportPdf;

	@Autowired private PaymentReport paymentReport;
	public Workbook getReportRptxxx(Workbook workbook, List<ReportBean> entity, ReportBean bean) throws Exception {
		return rpt1Servicexxx.getReport(workbook, entity, bean);
	}
	
	public Workbook getReportRptFull(Workbook workbook, List<HistoryPaymentRS> entity, HistoryReportBean bean) throws Exception {
		return rptServiceFull.getReport(workbook, entity, bean);
	}
	
	public Workbook reportPaymentExcelService(Workbook workbook, ReportPaymentCriteria criteria, List<ReportPaymentBean>  result) throws Exception{
		return paymentReport.generatePaymentReportExcel(workbook, criteria, result);
		
	}
	public void generationPaymentPDFService(String fileName , ReportPaymentCriteria criteria, List<ReportPaymentBean> date,HttpServletResponse response) throws JRException, ParseException, IOException, SQLException {
			paymentReportPdf.jasperGanarationPDF(fileName, criteria, date,response);
	}
}
