package th.co.maximus.service.report;

import java.io.ByteArrayOutputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRProperties;
import th.co.maximus.bean.ReportPaymentBean;
import th.co.maximus.bean.ReportPaymentCriteria;

@Service("paymentReportPdf")
public class PaymentReportPdf {
	Locale TH = new Locale("th", "TH");
	SimpleDateFormat dateFormate = new SimpleDateFormat("dd/MM/yyyy HH-mm-ss", TH);
	
	public byte[] jasperGanarationPDF(String fileName , ReportPaymentCriteria criteria, List<ReportPaymentBean> date) throws JRException, ParseException {
		 List<ReportPaymentBean> resultSource = new ArrayList();
		 DecimalFormat df2 = new DecimalFormat("#0.00");
		 double sumAllTotal = 0.00;
		 double sumAllTotalNoVat = 0.00;
		 double sumAllVat0 = 0.00;
		 double sumAllVat3 = 0.00;
		 double sumAllVat7 = 0.00;
		 int index = 1;
		 
		 // set new DataSource
		 if(date.size() != 0) {
			for(ReportPaymentBean reportPaymentBean : date) {
				ReportPaymentBean reportPaymentBeanNew = new ReportPaymentBean();
				reportPaymentBeanNew.setManualIdStr(index+"");
				reportPaymentBeanNew.setServiceType(reportPaymentBean.getServiceType());
				reportPaymentBeanNew.setReceiptNoManual(reportPaymentBean.getReceiptNoManual());
				reportPaymentBeanNew.setAccountSubNo(reportPaymentBean.getAccountSubNo());
				reportPaymentBeanNew.setCustomerName(reportPaymentBean.getCustomerName());
				reportPaymentBeanNew.setDepartment(reportPaymentBean.getDepartment());
				reportPaymentBeanNew.setInvoiceNo(reportPaymentBean.getInvoiceNo());
				reportPaymentBeanNew.setCreateBy(reportPaymentBean.getCreateBy());
				reportPaymentBeanNew.setNoRefer("-");
				reportPaymentBeanNew.setBeforVatStr(reportPaymentBean.getBeforVat()+"");
				reportPaymentBeanNew.setVatAmountStr(reportPaymentBean.getVatAmount()+"");
				reportPaymentBeanNew.setAmountStr(reportPaymentBean.getAmount()+"");
				reportPaymentBeanNew.setStatus(reportPaymentBean.getStatusStr());
				index++;
				resultSource.add(reportPaymentBeanNew);
				
				String vatConverStr = reportPaymentBean.getVatAmount()+"";
				 if("0".equals(vatConverStr)) {
					 sumAllVat0 += reportPaymentBean.getAmount().doubleValue() - reportPaymentBean.getBeforVat().doubleValue();
				 }else if("3".equals(vatConverStr)) {
					 sumAllVat3 += reportPaymentBean.getAmount().doubleValue() - reportPaymentBean.getBeforVat().doubleValue();
				 }else if("7".equals(vatConverStr)) {
					 sumAllVat7 += reportPaymentBean.getAmount().doubleValue() - reportPaymentBean.getBeforVat().doubleValue();
				 }
				 sumAllTotal += reportPaymentBean.getAmount().doubleValue();
				 sumAllTotalNoVat += reportPaymentBean.getBeforVat().doubleValue();
			}
		 }
		 
		//set new params
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("serviceTypeHead", criteria.getMachinePaymentName());
		parameters.put("printDateFrom", convertDateFormat(criteria.getDateFrom()));
		parameters.put("printDateTo", convertDateFormat(criteria.getDateTo()));
		parameters.put("dateFrom",convertDateFormat(criteria.getDateFrom()));
		parameters.put("dateTo", convertDateFormat(criteria.getDateTo()));
		parameters.put("staff",  criteria.getUser());
		
		parameters.put("summaryVat0", df2.format(sumAllVat0)+"");
		parameters.put("summaryVat3",  df2.format(sumAllVat3)+"");
		parameters.put("summaryVat7",  df2.format(sumAllVat7)+"");
		parameters.put("summaryAllVat",  df2.format(sumAllTotal)+"");
		parameters.put("summaryAllNotVat",  df2.format(sumAllTotalNoVat)+"");
		
		//read and export pdf
        JasperReport jasperReport = JasperCompileManager.compileReport(fileName);
        JRDataSource jrDataSource = (resultSource != null && !resultSource.isEmpty()) ? new JRBeanCollectionDataSource(resultSource) : new JREmptyDataSource();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
        JRProperties.setProperty("net.sf.jasperreports.default.pdf.font.name", "th/co/maximus/report/font/THSarabunNew.ttf");
		return JasperExportManager.exportReportToPdf(jasperPrint);
	}
	
	private String convertDateFormat(String dateFormat) throws ParseException {
	    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateFormat);
	    return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);
	}

}
