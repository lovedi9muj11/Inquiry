package th.co.maximus.service.report;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import th.co.maximus.auth.model.UserProfile;
import th.co.maximus.bean.ReportPaymentBean;
import th.co.maximus.bean.ReportPaymentCriteria;
import th.co.maximus.model.UserBean;
import th.co.maximus.service.MasterDataService;

@SuppressWarnings("deprecation")
@Service("paymentReportPdf")
public class PaymentReportPdf {
	Locale TH = new Locale("th", "TH");
	SimpleDateFormat dateFormate = new SimpleDateFormat("dd/MM/yyyy HH-mm-ss", TH);
	@Autowired
	private MasterDataService masterDataService;

	public void jasperGanarationPDF(String fileName, ReportPaymentCriteria criteria, List<ReportPaymentBean> date, HttpServletResponse response) throws JRException, ParseException, IOException, SQLException {
		List<ReportPaymentBean> resultSource = new ArrayList<ReportPaymentBean>();
		List<JasperPrint> jasperPrints = new ArrayList<JasperPrint>();
		// DecimalFormat df2 = new DecimalFormat("#0.00");
		double sumAllTotal = 0.00;
		double sumAllTotalNoVat = 0.00;
		double sumAllVat0 = 0.00;
		int index = 1;

		String serviceName = "";
		// set new DataSource
		if (date.size() != 0) {
			for (ReportPaymentBean reportPaymentBean : date) {
				ReportPaymentBean reportPaymentBeanNew = new ReportPaymentBean();
				reportPaymentBeanNew.setManualIdStr(index + "");
				reportPaymentBeanNew.setServiceType(reportPaymentBean.getServiceType().equals("IBACSS") ? "รับชำระค่าใช้บริการ" : "รับชำระค่าใช้บริการอื่นๆ");
				serviceName = reportPaymentBeanNew.getServiceType();
				reportPaymentBeanNew.setReceiptNoManual(reportPaymentBean.getReceiptNoManual());
				if (null != reportPaymentBean.getAccountSubNo()) {
					reportPaymentBeanNew.setAccountSubNo(reportPaymentBean.getAccountSubNo());
				} else {
					reportPaymentBeanNew.setAccountSubNo("-");
				}
				if (null != reportPaymentBean.getCustomerName()) {
					reportPaymentBeanNew.setCustomerName(reportPaymentBean.getCustomerName());
				} else {
					reportPaymentBeanNew.setCustomerName("-");
				}
				if (null != reportPaymentBean.getDepartment()) {
					reportPaymentBeanNew.setDepartment(reportPaymentBean.getDepartment());
				} else {
					reportPaymentBeanNew.setDepartment("-");
				}
				if (null != reportPaymentBean.getInvoiceNo()) {
					reportPaymentBeanNew.setInvoiceNo(reportPaymentBean.getInvoiceNo());
				} else {
					
					reportPaymentBeanNew.setInvoiceNo(reportPaymentBean.getServiceName()==null?"-":reportPaymentBean.getServiceName());
				}
				reportPaymentBeanNew.setCreateBy(reportPaymentBean.getPaymentMethod());
				reportPaymentBeanNew.setNoRefer(StringUtils.isNotBlank(reportPaymentBean.getRefNo())?reportPaymentBean.getRefNo():"-");
				reportPaymentBeanNew.setBeforVatStr(String.format("%,.2f", reportPaymentBean.getBeforVat()));
				reportPaymentBeanNew.setVatAmountStr(String.format("%,.2f", reportPaymentBean.getVatAmount()));
				reportPaymentBeanNew.setAmountStr(String.format("%,.2f", reportPaymentBean.getAmount()));
				if ("A".equals(reportPaymentBean.getStatus())) {
					reportPaymentBeanNew.setStatus("-");
				} else if ("C".equals(reportPaymentBean.getStatus())) {
					reportPaymentBeanNew.setStatus("ยกเลิก");
				}

				index++;
				resultSource.add(reportPaymentBeanNew);

				sumAllVat0 += reportPaymentBean.getAmount().doubleValue()
						- reportPaymentBean.getBeforVat().doubleValue();

				sumAllTotal += reportPaymentBean.getAmount().doubleValue();
				sumAllTotalNoVat += reportPaymentBean.getBeforVat().doubleValue();
			}
		}

		// set new params
		Date dates = new Date();
		UserProfile profile = (UserProfile) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserBean bean = masterDataService.findByUsername(profile.getUsername());
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("serviceTypeHead", criteria.getMachinePaymentName());
		parameters.put("printDates", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dates));
		parameters.put("dateFrom", convertTimeFormat(criteria.getDateFrom()));
		parameters.put("dateTo", convertTimeFormat(criteria.getDateTo()));
		parameters.put("staff", criteria.getUser());
		parameters.put("fullNameUser", bean.getSurName() + " " + bean.getLastName());
		parameters.put("serviceNameHead", serviceName);

		parameters.put("summaryVat0", String.format("%,.2f", sumAllVat0));
		parameters.put("summaryAllVat", String.format("%,.2f", sumAllTotal));
		parameters.put("summaryAllNotVat", String.format("%,.2f", sumAllTotalNoVat));

		// read and export pdf
		response.setContentType("application/pdf");
		response.setCharacterEncoding("UTF-8");
		JasperReport jasperReport = JasperCompileManager.compileReport(fileName);
		JRDataSource jrDataSource = (resultSource != null && !resultSource.isEmpty()) ? new JRBeanCollectionDataSource(resultSource) : new JREmptyDataSource();
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
		
//		JRXlsExporter exporter = new JRXlsExporter(DefaultJasperReportsContext.getInstance());
//		jasperPrints.add(jasperPrint);
		
//		exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST,jasperPrints);
//		exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File("xxx.pdf"));
//		exporter.exportReport();
		
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}

	@SuppressWarnings("unused")
	private String convertDateFormat(String dateFormat) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateFormat);
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);
	}
	
	private String convertTimeFormat(String dateFormat) throws ParseException {
		Date date = new SimpleDateFormat("HH:mm:ss").parse(dateFormat);
		return new SimpleDateFormat("HH:mm:ss").format(date);
	}

}
