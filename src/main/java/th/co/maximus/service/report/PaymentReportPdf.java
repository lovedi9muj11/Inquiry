package th.co.maximus.service.report;

import java.awt.print.PrinterException;
import java.io.IOException;
import java.io.OutputStream;
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

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import th.co.maximus.auth.model.UserProfile;
import th.co.maximus.bean.ReportPaymentBean;
import th.co.maximus.bean.ReportPaymentCriteria;
import th.co.maximus.constants.Constants;
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
		List<ReportPaymentBean> resultSources = new ArrayList<ReportPaymentBean>();
		List<JasperPrint> jasperPrints = new ArrayList<JasperPrint>();
		// DecimalFormat df2 = new DecimalFormat("#0.00");
		double sumAllTotal = 0.00;
		double sumAllTotalNoVat = 0.00;
		double sumAllVat0 = 0.00;
		int index = 1;

		String serviceName = "";
		String type = "";
		String serviceCode = "";
		// set new DataSource
		if (date.size() != 0) {
			type = date.get(0).getServiceType();
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
//				reportPaymentBeanNew.setCreateBy(reportPaymentBean.getCreateBy());
				reportPaymentBeanNew.setCreateBy(reportPaymentBean.getPaymentMethod());
				reportPaymentBeanNew.setNoRefer(StringUtils.isNotBlank(reportPaymentBean.getRefNo())?reportPaymentBean.getRefNo():"");
				reportPaymentBeanNew.setBeforVatStr(String.format("%,.2f", reportPaymentBean.getBeforVat()));
				reportPaymentBeanNew.setVatAmountStr(String.format("%,.2f", reportPaymentBean.getVatAmount()));
				reportPaymentBeanNew.setAmountStr(String.format("%,.2f", reportPaymentBean.getAmount()));
				reportPaymentBeanNew.setServiceCode(reportPaymentBean.getServiceCode());
				reportPaymentBeanNew.setAmount(reportPaymentBean.getAmount());
				reportPaymentBeanNew.setBeforVat(reportPaymentBean.getBeforVat());
				reportPaymentBeanNew.setServiceName(reportPaymentBean.getServiceName());
				if ("A".equals(reportPaymentBean.getStatus())) {
					reportPaymentBeanNew.setStatus("-");
				} else if ("C".equals(reportPaymentBean.getStatus())) {
					reportPaymentBeanNew.setStatus("ยกเลิก");
				}

				index++;
				resultSource.add(reportPaymentBeanNew);

				if(Constants.Status.ACTIVE.equals(reportPaymentBean.getStatus())) {
					sumAllVat0 += reportPaymentBean.getAmount().doubleValue() - reportPaymentBean.getBeforVat().doubleValue();
					sumAllTotal += reportPaymentBean.getAmount().doubleValue();
					sumAllTotalNoVat += reportPaymentBean.getBeforVat().doubleValue();
				}
				
			}
		}

		// set new params
		Date dates = new Date();
		UserProfile profile = (UserProfile) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserBean bean = masterDataService.findByUsername(profile.getUsername());
		Map<String, Object> parameters = new HashMap<String, Object>();
//		parameters.put("serviceTypeHead", criteria.getMachinePaymentName());
//		parameters.put("printDates", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dates));
//		parameters.put("dateFrom", convertTimeFormat(criteria.getDateFrom()));
//		parameters.put("dateTo", convertTimeFormat(criteria.getDateTo()));
//		parameters.put("staff", criteria.getUser());
//		parameters.put("fullNameUser", bean.getSurName() + " " + bean.getLastName());
//		parameters.put("serviceNameHead", serviceName);
//
//		parameters.put("summaryVat0", String.format("%,.2f", sumAllVat0));
//		parameters.put("summaryAllVat", String.format("%,.2f", sumAllTotal));
//		parameters.put("summaryAllNotVat", String.format("%,.2f", sumAllTotalNoVat));

		// read and export pdf
		response.setContentType("application/pdf");
		response.setCharacterEncoding("UTF-8");
		JasperReport jasperReport = JasperCompileManager.compileReport(fileName);
		
		String userPay = "";
		if(Constants.Service.SERVICE_TYPE_OTHER.equals(type)) {
			if(CollectionUtils.isNotEmpty(resultSource))serviceCode = resultSource.get(0).getServiceCode();
			
			int count = 0;
			int countRow = 0;
			sumAllVat0 = 0;
			sumAllTotal = 0;
			sumAllTotalNoVat = 0;
			String glCode = "";
			for(ReportPaymentBean reportPaymentBean : resultSource) {
				if(serviceCode.equals(reportPaymentBean.getServiceCode())) {
					
					if(Constants.Status.ACTIVE.equals(reportPaymentBean.getStatus())) {
						sumAllVat0 += reportPaymentBean.getAmount().doubleValue() - reportPaymentBean.getBeforVat().doubleValue();
						sumAllTotal += reportPaymentBean.getAmount().doubleValue();
						sumAllTotalNoVat += reportPaymentBean.getBeforVat().doubleValue();
					}
					
					if(count==0) {
						userPay = reportPaymentBean.getCreateBy();
					}else {
						if(0>userPay.indexOf(reportPaymentBean.getCreateBy())) {
							String comma = "";
							
							if(StringUtils.isNotBlank(userPay))comma=", ";
							
							userPay = userPay.concat(comma).concat(reportPaymentBean.getCreateBy());
						}
					}
					count++;
					
					reportPaymentBean.setManualIdStr((countRow+1)+"");
					glCode = reportPaymentBean.getServiceName().split(" ")[0];
					resultSources.add(reportPaymentBean);
				}else {
					
					parameters = new HashMap<String, Object>();
					parameters.put("serviceTypeHead", criteria.getMachinePaymentName());
					parameters.put("printDates", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dates));
					parameters.put("dateFrom", convertDateFormat(criteria.getDateFrom()));
					parameters.put("dateTo", convertTimeFormat(criteria.getDateTo()));
					parameters.put("staff", criteria.getUser());
					parameters.put("fullNameUser", bean.getSurName() + " " + bean.getLastName());
					parameters.put("serviceNameHead", serviceName);

					parameters.put("summaryVat0", String.format("%,.2f", sumAllVat0));
					parameters.put("summaryAllVat", String.format("%,.2f", sumAllTotal));
					parameters.put("summaryAllNotVat", String.format("%,.2f", sumAllTotalNoVat));
					parameters.put("summaryVat0User", String.format("%,.2f", sumAllVat0));
					parameters.put("summaryVatUser", String.format("%,.2f", sumAllTotal));
					parameters.put("summaryNoVatUser", String.format("%,.2f", sumAllTotalNoVat));
					parameters.put("summaryVat0GL", String.format("%,.2f", sumAllVat0));
					parameters.put("summaryVatGL", String.format("%,.2f", sumAllTotal));
					parameters.put("summaryNoVatGL", String.format("%,.2f", sumAllTotalNoVat));
					parameters.put("serviceListCount", countRow);
					parameters.put("userListCount", countRow);
					parameters.put("glListCount", countRow);
					parameters.put("serviceName", serviceName);
					parameters.put("userPayment", userPay);
					parameters.put("glName", glCode);
					
					userPay = "";
					glCode = reportPaymentBean.getServiceName().split(" ")[0];
					
					JRDataSource jrDataSource = (resultSources != null && !resultSources.isEmpty()) ? new JRBeanCollectionDataSource(resultSources) : new JREmptyDataSource();
					JasperPrint jasperPrint = new JasperPrint();
					
					jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
					jasperPrints.add(jasperPrint);
					
					resultSources = new ArrayList<ReportPaymentBean>();
					countRow = 0;
					reportPaymentBean.setManualIdStr((countRow+1)+"");
					resultSources.add(reportPaymentBean);
					
					sumAllVat0 = 0;
					sumAllTotal = 0;
					sumAllTotalNoVat = 0;
					
					if(Constants.Status.ACTIVE.equals(reportPaymentBean.getStatus())) {
						sumAllVat0 += reportPaymentBean.getAmount().doubleValue() - reportPaymentBean.getBeforVat().doubleValue();
						sumAllTotal += reportPaymentBean.getAmount().doubleValue();
						sumAllTotalNoVat += reportPaymentBean.getBeforVat().doubleValue();
					}
					
				}
				serviceCode = reportPaymentBean.getServiceCode();
				count++;
				countRow++;
				
				if(count==resultSource.size()) {
					parameters = new HashMap<String, Object>();
					parameters.put("serviceTypeHead", criteria.getMachinePaymentName());
					parameters.put("printDates", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dates));
					parameters.put("dateFrom", convertDateFormat(criteria.getDateFrom()));
					parameters.put("dateTo", convertTimeFormat(criteria.getDateTo()));
					parameters.put("staff", criteria.getUser());
					parameters.put("fullNameUser", bean.getSurName() + " " + bean.getLastName());
					parameters.put("serviceNameHead", serviceName);

					parameters.put("summaryVat0", String.format("%,.2f", sumAllVat0));
					parameters.put("summaryAllVat", String.format("%,.2f", sumAllTotal));
					parameters.put("summaryAllNotVat", String.format("%,.2f", sumAllTotalNoVat));
					parameters.put("summaryVat0User", String.format("%,.2f", sumAllVat0));
					parameters.put("summaryVatUser", String.format("%,.2f", sumAllTotal));
					parameters.put("summaryNoVatUser", String.format("%,.2f", sumAllTotalNoVat));
					parameters.put("summaryVat0GL", String.format("%,.2f", sumAllVat0));
					parameters.put("summaryVatGL", String.format("%,.2f", sumAllTotal));
					parameters.put("summaryNoVatGL", String.format("%,.2f", sumAllTotalNoVat));
					parameters.put("serviceListCount", countRow);
					parameters.put("userListCount", countRow);
					parameters.put("glListCount", countRow);
					parameters.put("serviceName", serviceName);
					parameters.put("userPayment", userPay);
					parameters.put("glName", glCode);
					
					JRDataSource jrDataSource = (resultSources != null && !resultSources.isEmpty()) ? new JRBeanCollectionDataSource(resultSources) : new JREmptyDataSource();
					JasperPrint jasperPrint = new JasperPrint();
					
					jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
					jasperPrints.add(jasperPrint);
				}
			}
			
		}else {
			
			parameters = new HashMap<String, Object>();
			parameters.put("serviceTypeHead", criteria.getMachinePaymentName());
			parameters.put("printDates", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dates));
			parameters.put("dateFrom", convertDateFormat(criteria.getDateFrom()));
			parameters.put("dateTo", convertTimeFormat(criteria.getDateTo()));
			parameters.put("staff", criteria.getUser());
			parameters.put("fullNameUser", bean.getSurName() + " " + bean.getLastName());
			parameters.put("serviceNameHead", serviceName);

			parameters.put("summaryVat0", String.format("%,.2f", sumAllVat0));
			parameters.put("summaryAllVat", String.format("%,.2f", sumAllTotal));
			parameters.put("summaryAllNotVat", String.format("%,.2f", sumAllTotalNoVat));
			parameters.put("summaryVat0User", String.format("%,.2f", sumAllVat0));
			parameters.put("summaryVatUser", String.format("%,.2f", sumAllTotal));
			parameters.put("summaryNoVatUser", String.format("%,.2f", sumAllTotalNoVat));
			
			parameters.put("serviceName", serviceName);
			parameters.put("serviceListCount", resultSource.size());
			parameters.put("userListCount", resultSource.size());
			
			int count = 0;
			for(ReportPaymentBean reportPaymentBean : resultSource) {
				if(count==0) {
					userPay = reportPaymentBean.getCreateBy();
				}else {
					if(0>userPay.indexOf(reportPaymentBean.getCreateBy())) {
						userPay = userPay.concat(", ").concat(reportPaymentBean.getCreateBy());
					}
				}
				count++;
			}
			
			parameters.put("userPayment", userPay);
			
			JRDataSource jrDataSource = (resultSource != null && !resultSource.isEmpty()) ? new JRBeanCollectionDataSource(resultSource) : new JREmptyDataSource();
			JasperPrint jasperPrint = new JasperPrint();
			
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
			jasperPrints.add(jasperPrint);
		}
		
		try {
			pushReportToOutputStream(response, jasperPrints);
		} catch (PrinterException e) {
			e.printStackTrace();
		}
	}
	
	private void pushReportToOutputStream(HttpServletResponse response, List<JasperPrint> jasperPrints) throws IOException, JRException, PrinterException  {
		OutputStream outputStream = response.getOutputStream();
		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, jasperPrints);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
		exporter.setParameter(JRPdfExporterParameter.PDF_JAVASCRIPT, "this.print();");
		exporter.exportReport();
	}

	private String convertDateFormat(String dateFormat) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateFormat);
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);
	}
	
	private String convertTimeFormat(String dateFormat) throws ParseException {
		Date date = new SimpleDateFormat("HH:mm:ss").parse(dateFormat);
		return new SimpleDateFormat("HH:mm:ss").format(date);
	}

}
