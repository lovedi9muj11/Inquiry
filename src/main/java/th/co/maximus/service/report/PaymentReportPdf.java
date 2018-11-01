package th.co.maximus.service.report;

import java.awt.print.PrinterException;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
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
import org.springframework.beans.factory.annotation.Value;
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
import th.co.maximus.bean.VatBean;
import th.co.maximus.constants.Constants;
import th.co.maximus.model.UserBean;
import th.co.maximus.service.MasterDataService;

@SuppressWarnings("deprecation")
@Service("paymentReportPdf")
public class PaymentReportPdf {
	@Value("${text.posno}")
	private String posNo;
	
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
		double sumAllTotalUser = 0.00;
		double sumAllTotalNoVat = 0.00;
		double sumAllTotalNoVatUser = 0.00;
		double sumAllVat0 = 0.00;
		double sumAllVatUser = 0.00;
		int index = 1;
		int sumCount = 0;
		
		List<VatBean> vatBeans = new ArrayList<VatBean>();
		VatBean vatBean10 = new VatBean();
		VatBean vatBean0 = new VatBean();
		VatBean vatBeanNon = new VatBean();

		String serviceName = "";
		String type = "";
		String serviceCode = "";
		String departCode = "";
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
				reportPaymentBeanNew.setCreateBy(reportPaymentBean.getCreateBy());
				reportPaymentBeanNew.setPaymentMethod(reportPaymentBean.getPaymentMethod());
				reportPaymentBeanNew.setNoRefer(StringUtils.isNotBlank(reportPaymentBean.getRefNo())?reportPaymentBean.getRefNo():"");
				reportPaymentBeanNew.setBeforVatStr(String.format("%,.2f", reportPaymentBean.getBeforVat()));
				reportPaymentBeanNew.setVatAmountStr(String.format("%,.2f", reportPaymentBean.getVatAmount()));
				reportPaymentBeanNew.setAmountStr(String.format("%,.2f", reportPaymentBean.getAmount()));
				reportPaymentBeanNew.setServiceCode(reportPaymentBean.getServiceCode());
				reportPaymentBeanNew.setAmount(reportPaymentBean.getAmount());
				reportPaymentBeanNew.setBeforVat(reportPaymentBean.getBeforVat());
				reportPaymentBeanNew.setServiceName(reportPaymentBean.getServiceName());
				reportPaymentBeanNew.setStatusStr(reportPaymentBean.getStatus());
				reportPaymentBeanNew.setVatRate(reportPaymentBean.getVatRate());
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
			
			if(CollectionUtils.isNotEmpty(resultSource))departCode = resultSource.get(0).getDepartment();
			
			int count = 0;
			int countRow = 0;
			int i = 1;
			sumAllVat0 = 0;
			sumAllTotal = 0;
			sumAllTotalNoVat = 0;
			String glCode = "";
			BigDecimal sumAmountVat10 = BigDecimal.ZERO;
			BigDecimal sumAmountVatAll10 = BigDecimal.ZERO;
			BigDecimal sumAmountVat0 = BigDecimal.ZERO;
			BigDecimal sumAmountVatAll0 = BigDecimal.ZERO;
			BigDecimal sumAmountVatNon = BigDecimal.ZERO;
			BigDecimal sumAmountVatAllNon = BigDecimal.ZERO;
			int vat10 = 1;
			int vat0 = 1;
			int vatNon = 1;
			for(ReportPaymentBean reportPaymentBean : resultSource) {
				
				
				if(Constants.VATRATE.TEN.equals(reportPaymentBean.getVatRate())) {
					sumAmountVat10 = sumAmountVat10.add(reportPaymentBean.getBeforVat());
					vatBean10.setAmount(sumAmountVat10);
					sumAmountVatAll10 = sumAmountVatAll10.add(reportPaymentBean.getAmount());
					vatBean10.setSumAmount(sumAmountVatAll10);
					vatBean10.setCount(vat10++);
					vatBean10.setVatRat(Constants.VATRATE.VATE_WORD.concat(" "+reportPaymentBean.getVatRate()));
				}else if(Constants.VATRATE.ZERO.equals(reportPaymentBean.getVatRate())) {
					sumAmountVat0 = sumAmountVat0.add(reportPaymentBean.getBeforVat());
					vatBean0.setAmount(sumAmountVat0);
					sumAmountVatAll0 = sumAmountVatAll0.add(reportPaymentBean.getAmount());
					vatBean0.setSumAmount(sumAmountVatAll0);
					vatBean0.setCount(vat0++);
					vatBean0.setVatRat(Constants.VATRATE.VATE_WORD.concat(" "+reportPaymentBean.getVatRate()));
				}else if(Constants.VATRATE.NON_VATE.equals(reportPaymentBean.getVatRate())) {
					sumAmountVatNon = sumAmountVatNon.add(reportPaymentBean.getBeforVat());
					vatBeanNon.setAmount(sumAmountVatNon);
					sumAmountVatAllNon = sumAmountVatAllNon.add(reportPaymentBean.getAmount());
					vatBeanNon.setSumAmount(sumAmountVatAllNon);
					vatBeanNon.setCount(vatNon++);
					vatBeanNon.setVatRat(reportPaymentBean.getVatRate());
				}
				
				if(serviceCode.equals(reportPaymentBean.getServiceCode())) {
					if(departCode.equals(reportPaymentBean.getDepartment())) {
						if(Constants.Status.ACTIVE.equals(reportPaymentBean.getStatusStr())) {
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
						parameters.put("posNo", posNo);
						parameters.put("accountCode", "accountCode");
						parameters.put("printDates", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dates));
						parameters.put("dateFrom", convertDateFormat(criteria.getDateFrom()));
						parameters.put("dateTo", convertTimeFormat(criteria.getDateTo()));
						parameters.put("staff", criteria.getUser());
						parameters.put("fullNameUser", bean.getSurName() + " " + bean.getLastName());
						parameters.put("serviceNameHead", serviceName);

						parameters.put("summaryVat0", String.format("%,.2f", sumAllVat0));
						parameters.put("summaryAllVat", String.format("%,.2f", sumAllTotal));
						parameters.put("summaryAllNotVat", String.format("%,.2f", sumAllTotalNoVat));
						sumAllVatUser += sumAllVat0;
						sumAllTotalUser += sumAllTotal;
						sumAllTotalNoVatUser += sumAllTotalNoVat;
						
						parameters.put("summaryVat0User", String.format("%,.2f", sumAllVat0));
						parameters.put("summaryVatUser", String.format("%,.2f", sumAllTotal));
						parameters.put("summaryNoVatUser", String.format("%,.2f", sumAllTotalNoVat));
						parameters.put("summaryVat0GL", String.format("%,.2f", sumAllVat0));
						parameters.put("summaryVatGL", String.format("%,.2f", sumAllTotal));
						parameters.put("summaryNoVatGL", String.format("%,.2f", sumAllTotalNoVat));
						parameters.put("serviceListCount", countRow);
						parameters.put("glListCount", countRow);
						parameters.put("departmentListCount", countRow);
						parameters.put("serviceName", serviceName);
						parameters.put("glName", glCode);
						parameters.put("departmentName", departCode);
						
						parameters.put("userPayment", "");
						parameters.put("userListCount", "");
						parameters.put("sumCount", "");
						parameters.put("sumAllVatUser", "");
						parameters.put("sumAllTotalUser", "");
						parameters.put("sumAllTotalNoVatUser", "");
						
//						userPay = "";
						glCode = reportPaymentBean.getServiceName().split(" ")[0];
						
						JRDataSource jrDataSource = (resultSources != null && !resultSources.isEmpty()) ? new JRBeanCollectionDataSource(resultSources) : new JREmptyDataSource();
						JasperPrint jasperPrint = new JasperPrint();
						
						jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
						jasperPrints.add(jasperPrint);
						
						resultSources = new ArrayList<ReportPaymentBean>();
						countRow = 0;
						count = 0;
						reportPaymentBean.setManualIdStr((countRow+1)+"");
						resultSources.add(reportPaymentBean);
						
						sumAllVat0 = 0;
						sumAllTotal = 0;
						sumAllTotalNoVat = 0;
						
						if(Constants.Status.ACTIVE.equals(reportPaymentBean.getStatusStr())) {
							sumAllVat0 += reportPaymentBean.getAmount().doubleValue() - reportPaymentBean.getBeforVat().doubleValue();
							sumAllTotal += reportPaymentBean.getAmount().doubleValue();
							sumAllTotalNoVat += reportPaymentBean.getBeforVat().doubleValue();
						}
						
					}
					
				}else {
					
					parameters = new HashMap<String, Object>();
					parameters.put("serviceTypeHead", criteria.getMachinePaymentName());
					parameters.put("posNo", posNo);
					parameters.put("accountCode", "accountCode");
					parameters.put("printDates", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dates));
					parameters.put("dateFrom", convertDateFormat(criteria.getDateFrom()));
					parameters.put("dateTo", convertTimeFormat(criteria.getDateTo()));
					parameters.put("staff", criteria.getUser());
					parameters.put("fullNameUser", bean.getSurName() + " " + bean.getLastName());
					parameters.put("serviceNameHead", serviceName);

					parameters.put("summaryVat0", String.format("%,.2f", sumAllVat0));
					parameters.put("summaryAllVat", String.format("%,.2f", sumAllTotal));
					parameters.put("summaryAllNotVat", String.format("%,.2f", sumAllTotalNoVat));
					sumAllVatUser += sumAllVat0;
					sumAllTotalUser += sumAllTotal;
					sumAllTotalNoVatUser += sumAllTotalNoVat;
					
					parameters.put("summaryVat0User", String.format("%,.2f", sumAllVat0));
					parameters.put("summaryVatUser", String.format("%,.2f", sumAllTotal));
					parameters.put("summaryNoVatUser", String.format("%,.2f", sumAllTotalNoVat));
					parameters.put("summaryVat0GL", String.format("%,.2f", sumAllVat0));
					parameters.put("summaryVatGL", String.format("%,.2f", sumAllTotal));
					parameters.put("summaryNoVatGL", String.format("%,.2f", sumAllTotalNoVat));
					parameters.put("serviceListCount", countRow);
					parameters.put("glListCount", countRow);
					parameters.put("departmentListCount", countRow);
					parameters.put("serviceName", serviceName);
					parameters.put("glName", glCode);
					parameters.put("departmentName", departCode);
					
					parameters.put("userPayment", "");
					parameters.put("userListCount", "");
					parameters.put("sumCount", "");
					parameters.put("sumAllVatUser", "");
					parameters.put("sumAllTotalUser", "");
					parameters.put("sumAllTotalNoVatUser", "");
					
//					userPay = "";
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
					
					if(Constants.Status.ACTIVE.equals(reportPaymentBean.getStatusStr())) {
						sumAllVat0 += reportPaymentBean.getAmount().doubleValue() - reportPaymentBean.getBeforVat().doubleValue();
						sumAllTotal += reportPaymentBean.getAmount().doubleValue();
						sumAllTotalNoVat += reportPaymentBean.getBeforVat().doubleValue();
					}
					
				}
				serviceCode = reportPaymentBean.getServiceCode();
				departCode = reportPaymentBean.getDepartment();
				count++;
				countRow++;
				sumCount++;
				
				if(i==resultSource.size()) {
					parameters = new HashMap<String, Object>();
					parameters.put("serviceTypeHead", criteria.getMachinePaymentName());
					parameters.put("posNo", posNo);
					parameters.put("accountCode", "accountCode");
					parameters.put("printDates", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dates));
					parameters.put("dateFrom", convertDateFormat(criteria.getDateFrom()));
					parameters.put("dateTo", convertTimeFormat(criteria.getDateTo()));
					parameters.put("staff", criteria.getUser());
					parameters.put("fullNameUser", bean.getSurName() + " " + bean.getLastName());
					parameters.put("serviceNameHead", serviceName);

					parameters.put("summaryVat0", String.format("%,.2f", sumAllVat0));
					parameters.put("summaryAllVat", String.format("%,.2f", sumAllTotal));
					parameters.put("summaryAllNotVat", String.format("%,.2f", sumAllTotalNoVat));
					sumAllVatUser += sumAllVat0;
					sumAllTotalUser += sumAllTotal;
					sumAllTotalNoVatUser += sumAllTotalNoVat;
					
					parameters.put("summaryVat0User", String.format("%,.2f", sumAllVat0));
					parameters.put("summaryVatUser", String.format("%,.2f", sumAllTotal));
					parameters.put("summaryNoVatUser", String.format("%,.2f", sumAllTotalNoVat));
					parameters.put("summaryVat0GL", String.format("%,.2f", sumAllVat0));
					parameters.put("summaryVatGL", String.format("%,.2f", sumAllTotal));
					parameters.put("summaryNoVatGL", String.format("%,.2f", sumAllTotalNoVat));
					parameters.put("serviceListCount", countRow);
					parameters.put("glListCount", countRow);
					parameters.put("departmentListCount", countRow);
					parameters.put("serviceName", serviceName);
					parameters.put("glName", glCode);
					parameters.put("departmentName", departCode);
					
					parameters.put("lastPage", "Y");
					parameters.put("userPayment", userPay);
					parameters.put("userListCount", countRow);
					parameters.put("sumCount", sumCount);
					parameters.put("sumAllVatUser", String.format("%,.2f", sumAllVatUser));
					parameters.put("sumAllTotalUser", String.format("%,.2f", sumAllTotalUser));
					parameters.put("sumAllTotalNoVatUser", String.format("%,.2f", sumAllTotalNoVatUser));
					
					if(StringUtils.isNotBlank(vatBean10.getVatRat())) {
						vatBeans.add(vatBean10);
//						parameters.put("chkVat10", "Y");
//						parameters.put("vatListCount10", vatBean10.getCount());
//						parameters.put("vatRate10", vatBean10.getVatRat());
//						parameters.put("vatRateAmount10", String.format("%,.2f", vatBean10.getAmount()));
//						parameters.put("vatRateSumAmount10", String.format("%,.2f", vatBean10.getSumAmount()));
					}
					if(StringUtils.isNotBlank(vatBean0.getVatRat())) {
						vatBeans.add(vatBean0);
//						parameters.put("chkVat0", "Y");
//						parameters.put("vatListCount0", vatBean0.getCount());
//						parameters.put("vatRate0", vatBean0.getVatRat());
//						parameters.put("vatRateAmount0", String.format("%,.2f", vatBean0.getAmount()));
//						parameters.put("vatRateSumAmount0", String.format("%,.2f", vatBean0.getSumAmount()));
					}
					if(StringUtils.isNotBlank(vatBeanNon.getVatRat())) {
						vatBeans.add(vatBeanNon);
//						parameters.put("chkVatNon", "Y");
//						parameters.put("vatListCountNon", vatBeanNon.getCount());
//						parameters.put("vatRateNon", vatBeanNon.getVatRat());
//						parameters.put("vatRateAmountNon", String.format("%,.2f", vatBeanNon.getAmount()));
//						parameters.put("vatRateSumAmountNon", String.format("%,.2f", vatBeanNon.getSumAmount()));
					}
					
					for(int ii=0; ii<vatBeans.size(); ii++) {
						parameters.put("chkVat"+ii, "Y");
						parameters.put("vatListCount"+ii, vatBeans.get(ii).getCount());
						parameters.put("vatRate"+ii, vatBeans.get(ii).getVatRat());
						parameters.put("vatRateAmount"+ii, String.format("%,.2f", vatBeans.get(ii).getAmount()));
						parameters.put("vatRateSumAmount"+ii, String.format("%,.2f", vatBeans.get(ii).getSumAmount()));
					}
					
					JRDataSource jrDataSource = (resultSources != null && !resultSources.isEmpty()) ? new JRBeanCollectionDataSource(resultSources) : new JREmptyDataSource();
					JasperPrint jasperPrint = new JasperPrint();
					
					jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
					jasperPrints.add(jasperPrint);
				}
				i++;
			}
			
		}else {
			
			String vatRate = "";
			int countRow = 0;
			sumAllVat0 = 0;
			sumAllTotal = 0;
			sumAllTotalNoVat = 0;
			int count = 0;
			
			BigDecimal sumAmountVat10 = BigDecimal.ZERO;
			BigDecimal sumAmountVatAll10 = BigDecimal.ZERO;
			BigDecimal sumAmountVat0 = BigDecimal.ZERO;
			BigDecimal sumAmountVatAll0 = BigDecimal.ZERO;
			BigDecimal sumAmountVatNon = BigDecimal.ZERO;
			BigDecimal sumAmountVatAllNon = BigDecimal.ZERO;
			int vat10 = 1;
			int vat0 = 1;
			int vatNon = 1;
			
			for(int i=0; i<resultSource.size(); i++) {
				
				if(Constants.VATRATE.TEN.equals(resultSource.get(i).getVatRate())) {
					sumAmountVat10 = sumAmountVat10.add(resultSource.get(i).getBeforVat());
					vatBean10.setAmount(sumAmountVat10);
					sumAmountVatAll10 = sumAmountVatAll10.add(resultSource.get(i).getAmount());
					vatBean10.setSumAmount(sumAmountVatAll10);
					vatBean10.setCount(vat10++);
					vatBean10.setVatRat(Constants.VATRATE.VATE_WORD.concat(" "+resultSource.get(i).getVatRate()));
				}else if(Constants.VATRATE.ZERO.equals(resultSource.get(i).getVatRate())) {
					sumAmountVat0 = sumAmountVat0.add(resultSource.get(i).getBeforVat());
					vatBean0.setAmount(sumAmountVat0);
					sumAmountVatAll0 = sumAmountVatAll0.add(resultSource.get(i).getAmount());
					vatBean0.setSumAmount(sumAmountVatAll0);
					vatBean0.setCount(vat0++);
					vatBean0.setVatRat(Constants.VATRATE.VATE_WORD.concat(" "+resultSource.get(i).getVatRate()));
				}else if(Constants.VATRATE.NON_VATE.equals(resultSource.get(i).getVatRate())) {
					sumAmountVatNon = sumAmountVatNon.add(resultSource.get(i).getBeforVat());
					vatBeanNon.setAmount(sumAmountVatNon);
					sumAmountVatAllNon = sumAmountVatAllNon.add(resultSource.get(i).getAmount());
					vatBeanNon.setSumAmount(sumAmountVatAllNon);
					vatBeanNon.setCount(vatNon++);
					vatBeanNon.setVatRat(resultSource.get(i).getVatRate());
				}
				
				if(i==0) { vatRate = resultSource.get(i).getVatRate(); }
				
				if(vatRate.equals(resultSource.get(i).getVatRate())) {
					
					if(Constants.Status.ACTIVE.equals(resultSource.get(i).getStatusStr())) {
						sumAllVat0 += resultSource.get(i).getAmount().doubleValue() - resultSource.get(i).getBeforVat().doubleValue();
						sumAllTotal += resultSource.get(i).getAmount().doubleValue();
						sumAllTotalNoVat += resultSource.get(i).getBeforVat().doubleValue();
					}
					
					if(count==0) {
						userPay = resultSource.get(i).getCreateBy();
					}else {
						if(0>userPay.indexOf(resultSource.get(i).getCreateBy())) {
							String comma = "";
							
							if(StringUtils.isNotBlank(userPay))comma=", ";
							
							userPay = userPay.concat(comma).concat(resultSource.get(i).getCreateBy());
						}
					}
					count++;
					
					resultSource.get(i).setManualIdStr((countRow+1)+"");
					resultSources.add(resultSource.get(i));
					
				}else {
					
					parameters = new HashMap<String, Object>();
					parameters.put("serviceTypeHead", criteria.getMachinePaymentName());
					parameters.put("posNo", posNo);
					parameters.put("accountCode", "accountCode");
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
					
					sumAllVatUser += sumAllVat0;
					sumAllTotalUser += sumAllTotal;
					sumAllTotalNoVatUser += sumAllTotalNoVat;
					
					parameters.put("serviceName", serviceName);
					parameters.put("serviceListCount", resultSources.size());
					parameters.put("userListCount", resultSources.size());
					parameters.put("userPayment", userPay);
					
					JRDataSource jrDataSource = (resultSources != null && !resultSources.isEmpty()) ? new JRBeanCollectionDataSource(resultSources) : new JREmptyDataSource();
					JasperPrint jasperPrint = new JasperPrint();
					
					jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
					jasperPrints.add(jasperPrint);
					
					resultSources = new ArrayList<ReportPaymentBean>();
					countRow = 0;
					resultSource.get(i).setManualIdStr((countRow+1)+"");
					resultSources.add(resultSource.get(i));
					count = 0;
					
					userPay = resultSource.get(i).getCreateBy();
					
					sumAllVat0 = 0;
					sumAllTotal = 0;
					sumAllTotalNoVat = 0;
					
					if(Constants.Status.ACTIVE.equals(resultSource.get(i).getStatusStr())) {
						sumAllVat0 += resultSource.get(i).getAmount().doubleValue() - resultSource.get(i).getBeforVat().doubleValue();
						sumAllTotal += resultSource.get(i).getAmount().doubleValue();
						sumAllTotalNoVat += resultSource.get(i).getBeforVat().doubleValue();
					}
					
				}
				
				vatRate = resultSource.get(i).getVatRate();
				countRow++;
				sumCount++;
				
				if(i==(resultSource.size()-1)) {
					parameters = new HashMap<String, Object>();
					parameters.put("serviceTypeHead", criteria.getMachinePaymentName());
					parameters.put("posNo", posNo);
					parameters.put("accountCode", "accountCode");
					parameters.put("printDates", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dates));
					parameters.put("dateFrom", convertDateFormat(criteria.getDateFrom()));
					parameters.put("dateTo", convertTimeFormat(criteria.getDateTo()));
					parameters.put("staff", criteria.getUser());
					parameters.put("fullNameUser", bean.getSurName() + " " + bean.getLastName());
					parameters.put("serviceNameHead", serviceName);

					parameters.put("summaryVat0", String.format("%,.2f", sumAllVat0));
					parameters.put("summaryAllVat", String.format("%,.2f", sumAllTotal));
					parameters.put("summaryAllNotVat", String.format("%,.2f", sumAllTotalNoVat));
					sumAllVatUser += sumAllVat0;
					sumAllTotalUser += sumAllTotal;
					sumAllTotalNoVatUser += sumAllTotalNoVat;
					parameters.put("summaryVat0User", String.format("%,.2f", sumAllVat0));
					parameters.put("summaryVatUser", String.format("%,.2f", sumAllTotal));
					parameters.put("summaryNoVatUser", String.format("%,.2f", sumAllTotalNoVat));
					
					parameters.put("serviceName", serviceName);
					parameters.put("serviceListCount", resultSources.size());
					parameters.put("userListCount", resultSources.size());
					parameters.put("userPayment", userPay);
					
					parameters.put("lastPage", "Y");
					parameters.put("userListCount", countRow);
					parameters.put("sumCount", sumCount);
					parameters.put("sumAllVatUser", String.format("%,.2f", sumAllVatUser));
					parameters.put("sumAllTotalUser", String.format("%,.2f", sumAllTotalUser));
					parameters.put("sumAllTotalNoVatUser", String.format("%,.2f", sumAllTotalNoVatUser));
					
					if(StringUtils.isNotBlank(vatBean10.getVatRat())) {
						vatBeans.add(vatBean10);
					}
					if(StringUtils.isNotBlank(vatBean0.getVatRat())) {
						vatBeans.add(vatBean0);
					}
					if(StringUtils.isNotBlank(vatBeanNon.getVatRat())) {
						vatBeans.add(vatBeanNon);
					}
					
					for(int ii=0; ii<vatBeans.size(); ii++) {
						parameters.put("chkVat"+ii, "Y");
						parameters.put("vatListCount"+ii, vatBeans.get(ii).getCount());
						parameters.put("vatRate"+ii, vatBeans.get(ii).getVatRat());
						parameters.put("vatRateAmount"+ii, String.format("%,.2f", vatBeans.get(ii).getAmount()));
						parameters.put("vatRateSumAmount"+ii, String.format("%,.2f", vatBeans.get(ii).getSumAmount()));
					}
					
					JRDataSource jrDataSource = (resultSources != null && !resultSources.isEmpty()) ? new JRBeanCollectionDataSource(resultSources) : new JREmptyDataSource();
					JasperPrint jasperPrint = new JasperPrint();
					
					jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
					jasperPrints.add(jasperPrint);
				}
				
			}
			
//			parameters = new HashMap<String, Object>();
//			parameters.put("serviceTypeHead", criteria.getMachinePaymentName());
//			parameters.put("posNo", posNo);
//			parameters.put("accountCode", "accountCode");
//			parameters.put("printDates", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dates));
//			parameters.put("dateFrom", convertDateFormat(criteria.getDateFrom()));
//			parameters.put("dateTo", convertTimeFormat(criteria.getDateTo()));
//			parameters.put("staff", criteria.getUser());
//			parameters.put("fullNameUser", bean.getSurName() + " " + bean.getLastName());
//			parameters.put("serviceNameHead", serviceName);
//
//			parameters.put("summaryVat0", String.format("%,.2f", sumAllVat0));
//			parameters.put("summaryAllVat", String.format("%,.2f", sumAllTotal));
//			parameters.put("summaryAllNotVat", String.format("%,.2f", sumAllTotalNoVat));
//			parameters.put("summaryVat0User", String.format("%,.2f", sumAllVat0));
//			parameters.put("summaryVatUser", String.format("%,.2f", sumAllTotal));
//			parameters.put("summaryNoVatUser", String.format("%,.2f", sumAllTotalNoVat));
//			
//			parameters.put("serviceName", serviceName);
//			parameters.put("serviceListCount", resultSource.size());
//			parameters.put("userListCount", resultSource.size());
			
//			int count = 0;
//			for(ReportPaymentBean reportPaymentBean : resultSource) {
//				if(count==0) {
//					userPay = reportPaymentBean.getCreateBy();
//				}else {
//					if(0>userPay.indexOf(reportPaymentBean.getCreateBy())) {
//						userPay = userPay.concat(", ").concat(reportPaymentBean.getCreateBy());
//					}
//				}
//				count++;
//			}
			
//			parameters.put("userPayment", userPay);
			
//			JRDataSource jrDataSource = (resultSource != null && !resultSource.isEmpty()) ? new JRBeanCollectionDataSource(resultSource) : new JREmptyDataSource();
//			JasperPrint jasperPrint = new JasperPrint();
//			
//			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
//			jasperPrints.add(jasperPrint);
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
