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
		
		BigDecimal vatRateAmountSum = BigDecimal.ZERO;
		BigDecimal vatRateSumAmountSum = BigDecimal.ZERO;
		double sumAllVatSum = 0.00;
		int vatListCountSum = 0;
		
		List<VatBean> vatBeans = new ArrayList<VatBean>();
		VatBean vatBean10 = new VatBean();
		VatBean vatBean8 = new VatBean();
		VatBean vatBean7 = new VatBean();
		VatBean vatBean0 = new VatBean();
		VatBean vatBeanNon = new VatBean();
//		VatBean vatBean = new VatBean();

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
		UserBean beanRole = masterDataService.findByUsernameFromRole(bean.getRoleId());
		Map<String, Object> parameters = new HashMap<String, Object>();

		// read and export pdf
		response.setContentType("application/pdf");
		response.setCharacterEncoding("UTF-8");
		JasperReport jasperReport = JasperCompileManager.compileReport(fileName);
		
//		List<MasterDataBean> listVat = masterDataService.findByVat();
//		BigDecimal sumAmountVat = BigDecimal.ZERO;
//		BigDecimal sumAmountVatAll = BigDecimal.ZERO;
		
		String userPay = "";
		if(Constants.Service.SERVICE_TYPE_OTHER.equals(type)) {
			
			String userPayment = "";
			String userPaymentOld = "";
			
			if(CollectionUtils.isNotEmpty(resultSource)) {serviceCode = resultSource.get(0).getServiceCode(); departCode = resultSource.get(0).getDepartment(); userPayment = resultSource.get(0).getCreateBy();}
			
			UserBean beanSup = new UserBean();
//			if(CollectionUtils.isNotEmpty(resultSource))departCode = resultSource.get(0).getDepartment();
			
			int count = 0;
			int countRow = 0;
			int i = 1;
			sumAllVat0 = 0;
			sumAllTotal = 0;
			sumAllTotalNoVat = 0;
			String glCode = "";
			BigDecimal sumAmountVat10 = BigDecimal.ZERO;
			BigDecimal sumAmountVat7 = BigDecimal.ZERO;
			BigDecimal sumAmountVat8 = BigDecimal.ZERO;
			BigDecimal sumAmountVatAll10 = BigDecimal.ZERO;
			BigDecimal sumAmountVatAll8 = BigDecimal.ZERO;
			BigDecimal sumAmountVatAll7 = BigDecimal.ZERO;
			BigDecimal sumAmountVat0 = BigDecimal.ZERO;
			BigDecimal sumAmountVatAll0 = BigDecimal.ZERO;
			BigDecimal sumAmountVatNon = BigDecimal.ZERO;
			BigDecimal sumAmountVatAllNon = BigDecimal.ZERO;
			
			int vat10 = 1;
			int vat8 = 1;
			int vat7 = 1;
			int vat0 = 1;
			int vatNon = 1;
			int pageNumber = 1;
			
			if(CollectionUtils.isNotEmpty(resultSource)) {
				for(ReportPaymentBean reportPaymentBean : resultSource) {
					
//					for(int v=0; v<listVat.size(); v++) {
//						vatBean = new VatBean();
//						if(Constants.VATRATE.SEVEN.equals(reportPaymentBean.getVatRate())) {
//							sumAmountVat = sumAmountVat.add(reportPaymentBean.getBeforVat());
//							vatBean.setAmount(sumAmountVat);
//							sumAmountVatAll = sumAmountVatAll.add(reportPaymentBean.getAmount());
//							vatBean.setSumAmount(sumAmountVatAll);
//							vatBean.setCount(vatNon++);
//							vatBean.setVatRat(reportPaymentBean.getVatRate());
//						}else {
//							
//						}
//					}
					
					if(Constants.VATRATE.TEN.equals(reportPaymentBean.getVatRate())) {
						sumAmountVat10 = sumAmountVat10.add(reportPaymentBean.getBeforVat());
						vatBean10.setAmount(sumAmountVat10);
						sumAmountVatAll10 = sumAmountVatAll10.add(reportPaymentBean.getAmount());
						vatBean10.setSumAmount(sumAmountVatAll10);
						vatBean10.setCount(vat10++);
						vatBean10.setVatRat(Constants.VATRATE.VATE_WORD.concat(" "+reportPaymentBean.getVatRate()+" %"));
					}else if(Constants.VATRATE.ZERO.equals(reportPaymentBean.getVatRate())) {
						sumAmountVat0 = sumAmountVat0.add(reportPaymentBean.getBeforVat());
						vatBean0.setAmount(sumAmountVat0);
						sumAmountVatAll0 = sumAmountVatAll0.add(reportPaymentBean.getAmount());
						vatBean0.setSumAmount(sumAmountVatAll0);
						vatBean0.setCount(vat0++);
						vatBean0.setVatRat(Constants.VATRATE.VATE_WORD.concat(" "+reportPaymentBean.getVatRate()+" %"));
					}else if(Constants.VATRATE.NON_VATE.equals(reportPaymentBean.getVatRate())) {
						sumAmountVatNon = sumAmountVatNon.add(reportPaymentBean.getBeforVat());
						vatBeanNon.setAmount(sumAmountVatNon);
						sumAmountVatAllNon = sumAmountVatAllNon.add(reportPaymentBean.getAmount());
						vatBeanNon.setSumAmount(sumAmountVatAllNon);
						vatBeanNon.setCount(vatNon++);
						vatBeanNon.setVatRat(reportPaymentBean.getVatRate());
					}else if(Constants.VATRATE.EIGHT.equals(reportPaymentBean.getVatRate())) {
						sumAmountVat8 = sumAmountVat8.add(reportPaymentBean.getBeforVat());
						vatBean8.setAmount(sumAmountVat8);
						sumAmountVatAll8 = sumAmountVatAll8.add(reportPaymentBean.getAmount());
						vatBean8.setSumAmount(sumAmountVatAll8);
						vatBean8.setCount(vat8++);
						vatBean8.setVatRat(Constants.VATRATE.VATE_WORD.concat(" "+reportPaymentBean.getVatRate()+" %"));
					}else if(Constants.VATRATE.SEVEN.equals(reportPaymentBean.getVatRate())) {
						sumAmountVat7 = sumAmountVat7.add(reportPaymentBean.getBeforVat());
						vatBean7.setAmount(sumAmountVat7);
						sumAmountVatAll7 = sumAmountVatAll7.add(reportPaymentBean.getAmount());
						vatBean7.setSumAmount(sumAmountVatAll7);
						vatBean7.setCount(vat7++);
						vatBean7.setVatRat(Constants.VATRATE.VATE_WORD.concat(" "+reportPaymentBean.getVatRate()+" %"));
					}
					
					if(userPayment.equals(reportPaymentBean.getCreateBy())) {
						userPaymentOld = userPayment;
						
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
								
								beanSup = masterDataService.findByUsername(userPaymentOld);
								
								parameters = new HashMap<String, Object>();
								parameters.put("serviceTypeHead", criteria.getMachinePaymentName());
								parameters.put("posNo", posNo);
								parameters.put("accountCode", "accountCode");
								parameters.put("printDates", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dates));
								parameters.put("dateFrom", convertDateFormat(criteria.getDateFrom()));
								parameters.put("dateTo", convertTimeFormat(criteria.getDateTo()));
								parameters.put("staff", criteria.getUser());
								parameters.put("fullNameUser", beanSup.getSurName() + " " + beanSup.getLastName());
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
								parameters.put("pageNumber", pageNumber);
								
//								userPay = "";
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
								pageNumber++;
								
								if(Constants.Status.ACTIVE.equals(reportPaymentBean.getStatusStr())) {
									sumAllVat0 += reportPaymentBean.getAmount().doubleValue() - reportPaymentBean.getBeforVat().doubleValue();
									sumAllTotal += reportPaymentBean.getAmount().doubleValue();
									sumAllTotalNoVat += reportPaymentBean.getBeforVat().doubleValue();
								}
								
							}
							
						} else {
							
							beanSup = masterDataService.findByUsername(userPaymentOld);
							
							parameters = new HashMap<String, Object>();
							parameters.put("serviceTypeHead", criteria.getMachinePaymentName());
							parameters.put("posNo", posNo);
							parameters.put("accountCode", "accountCode");
							parameters.put("printDates", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dates));
							parameters.put("dateFrom", convertDateFormat(criteria.getDateFrom()));
							parameters.put("dateTo", convertTimeFormat(criteria.getDateTo()));
							parameters.put("staff", criteria.getUser());
							parameters.put("fullNameUser", beanSup.getSurName() + " " + beanSup.getLastName());
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
							
							parameters.put("userPayment", userPaymentOld);
							parameters.put("userListCount", countRow);
							parameters.put("sumCount", "");
							parameters.put("sumAllVatUser", "");
							parameters.put("sumAllTotalUser", "");
							parameters.put("sumAllTotalNoVatUser", "");
							parameters.put("pageNumber", pageNumber);
							
							parameters.put("sumAllVatUser1", String.format("%,.2f", sumAllVat0));
							parameters.put("sumAllTotalUser1", String.format("%,.2f", sumAllTotal));
							parameters.put("sumAllTotalNoVatUser1", String.format("%,.2f", sumAllTotalNoVat));
							
//							userPay = "";
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
							pageNumber++;
							
							if(Constants.Status.ACTIVE.equals(reportPaymentBean.getStatusStr())) {
								sumAllVat0 += reportPaymentBean.getAmount().doubleValue() - reportPaymentBean.getBeforVat().doubleValue();
								sumAllTotal += reportPaymentBean.getAmount().doubleValue();
								sumAllTotalNoVat += reportPaymentBean.getBeforVat().doubleValue();
							}
							
						}
					} else {
						
						beanSup = masterDataService.findByUsername(userPaymentOld);
						
						parameters = new HashMap<String, Object>();
						parameters.put("serviceTypeHead", criteria.getMachinePaymentName());
						parameters.put("posNo", posNo);
						parameters.put("accountCode", "accountCode");
						parameters.put("printDates", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dates));
						parameters.put("dateFrom", convertDateFormat(criteria.getDateFrom()));
						parameters.put("dateTo", convertTimeFormat(criteria.getDateTo()));
						parameters.put("staff", criteria.getUser());
						parameters.put("fullNameUser", beanSup.getSurName() + " " + beanSup.getLastName());
						parameters.put("serviceNameHead", serviceName);

						parameters.put("summaryVat0", String.format("%,.2f", sumAllVat0));
						parameters.put("summaryAllVat", String.format("%,.2f", sumAllTotal));
						parameters.put("summaryAllNotVat", String.format("%,.2f", sumAllTotalNoVat));
						sumAllVatUser += sumAllVat0;
						sumAllVatSum += sumAllVat0;
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
						
						parameters.put("userPayment", userPaymentOld);
						parameters.put("userListCount", resultSources.size());
						parameters.put("sumCount", "");
						parameters.put("sumAllVatUser1", String.format("%,.2f", sumAllVatUser));
						parameters.put("sumAllTotalUser1", String.format("%,.2f", sumAllTotalUser));
						parameters.put("sumAllTotalNoVatUser1", String.format("%,.2f", sumAllTotalNoVatUser));
						parameters.put("sumAllVatUser", "");
						parameters.put("sumAllTotalUser", "");
						parameters.put("sumAllTotalNoVatUser", "");
						parameters.put("pageNumber", pageNumber);
						
//						userPay = "";
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
						pageNumber++;
						
						if(Constants.Status.ACTIVE.equals(reportPaymentBean.getStatusStr())) {
							sumAllVat0 += reportPaymentBean.getAmount().doubleValue() - reportPaymentBean.getBeforVat().doubleValue();
							sumAllTotal += reportPaymentBean.getAmount().doubleValue();
							sumAllTotalNoVat += reportPaymentBean.getBeforVat().doubleValue();
						}
						
					}
					serviceCode = reportPaymentBean.getServiceCode();
					departCode = reportPaymentBean.getDepartment();
					userPayment = reportPaymentBean.getCreateBy();
					count++;
					countRow++;
					sumCount++;
					
					if(i==resultSource.size()) {
						
						beanSup = masterDataService.findByUsername(userPayment);
						
						parameters = new HashMap<String, Object>();
						parameters.put("serviceTypeHead", criteria.getMachinePaymentName());
						parameters.put("posNo", posNo);
						parameters.put("accountCode", "accountCode");
						parameters.put("printDates", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dates));
						parameters.put("dateFrom", convertDateFormat(criteria.getDateFrom()));
						parameters.put("dateTo", convertTimeFormat(criteria.getDateTo()));
						parameters.put("staff", criteria.getUser());
						parameters.put("fullNameUser", beanSup.getSurName() + " " + beanSup.getLastName());
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
						parameters.put("pageNumber", pageNumber);
						
						parameters.put("lastPage", "Y");
						parameters.put("userPayment", userPayment);
						parameters.put("userListCount", countRow);
						parameters.put("sumCount", sumCount);
						parameters.put("sumAllVatUser1", String.format("%,.2f", sumAllVat0));
						parameters.put("sumAllTotalUser1", String.format("%,.2f", sumAllTotal));
						parameters.put("sumAllTotalNoVatUser1", String.format("%,.2f", sumAllTotalNoVat));
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
						if(StringUtils.isNotBlank(vatBean7.getVatRat())) {
							vatBeans.add(vatBean7);
						}
						if(StringUtils.isNotBlank(vatBean8.getVatRat())) {
							vatBeans.add(vatBean8);
						}
						
						for(int ii=0; ii<vatBeans.size(); ii++) {
							parameters.put("chkVat"+ii, "Y");
							parameters.put("vatListCount"+ii, vatBeans.get(ii).getCount());
							parameters.put("vatRate"+ii, vatBeans.get(ii).getVatRat());
							parameters.put("vatRateAmount"+ii, String.format("%,.2f", vatBeans.get(ii).getAmount()));
							parameters.put("vatRateSumAmount"+ii, String.format("%,.2f", vatBeans.get(ii).getSumAmount()));
							
							vatRateAmountSum = vatRateAmountSum.add(vatBeans.get(ii).getAmount());
							vatRateSumAmountSum = vatRateSumAmountSum.add(vatBeans.get(ii).getSumAmount());
							vatListCountSum += vatBeans.get(ii).getCount();
							if(ii==(vatBeans.size()-1)) {
								parameters.put("chkSumLast"+(ii+1), "Y");
								parameters.put("chkVat"+(ii+1), "Y");
								parameters.put("vatListCount"+(ii+1), vatListCountSum);
								parameters.put("vatRate"+(ii+1), Constants.report.SUM_TH);
								parameters.put("sumAllVatAmoutLast", String.format("%,.2f", sumAllVatSum));
								parameters.put("vatRateAmount"+(ii+1), String.format("%,.2f",vatRateAmountSum));
								parameters.put("vatRateSumAmount"+(ii+1), String.format("%,.2f", vatRateSumAmountSum));
							}
						}
						
						JRDataSource jrDataSource = (resultSources != null && !resultSources.isEmpty()) ? new JRBeanCollectionDataSource(resultSources) : new JREmptyDataSource();
						JasperPrint jasperPrint = new JasperPrint();
						
						jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
						jasperPrints.add(jasperPrint);
					}
					
					i++;
				}
			}else {
				JasperPrint jasperPrint = new JasperPrint();
				jasperPrints.add(jasperPrint);
			}
			
			
		}else {
			
			if(Constants.Role.SUPPERVISOR_2.equals(beanRole.getRoleId()+"")) {
				
				String vatRate = "";
				String userPayment = "";
				String userPaymentOld = "";
				int countRow = 0;
				sumAllVat0 = 0;
				sumAllTotal = 0;
				sumAllTotalNoVat = 0;
				int count = 0;
				
				UserBean beanSup = new UserBean();
				
				BigDecimal sumAmountVat10 = BigDecimal.ZERO;
				BigDecimal sumAmountVatAll10 = BigDecimal.ZERO;
				BigDecimal sumAmountVat0 = BigDecimal.ZERO;
				BigDecimal sumAmountVatAll0 = BigDecimal.ZERO;
				BigDecimal sumAmountVatNon = BigDecimal.ZERO;
				BigDecimal sumAmountVatAllNon = BigDecimal.ZERO;
				
				BigDecimal sumAmountVat7 = BigDecimal.ZERO;
				BigDecimal sumAmountVat8 = BigDecimal.ZERO;
				BigDecimal sumAmountVatAll8 = BigDecimal.ZERO;
				BigDecimal sumAmountVatAll7 = BigDecimal.ZERO;
				int vat10 = 1;
				int vat8 = 1;
				int vat7 = 1;
				int vat0 = 1;
				int vatNon = 1;
				int pageNumber = 1;
				
				if(CollectionUtils.isNotEmpty(resultSource)) {
					for(int i=0; i<resultSource.size(); i++) {
						
						if(Constants.VATRATE.TEN.equals(resultSource.get(i).getVatRate())) {
							sumAmountVat10 = sumAmountVat10.add(resultSource.get(i).getBeforVat());
							vatBean10.setAmount(sumAmountVat10);
							sumAmountVatAll10 = sumAmountVatAll10.add(resultSource.get(i).getAmount());
							vatBean10.setSumAmount(sumAmountVatAll10);
							vatBean10.setCount(vat10++);
							vatBean10.setVatRat(Constants.VATRATE.VATE_WORD.concat(" "+resultSource.get(i).getVatRate()+" %"));
						}else if(Constants.VATRATE.ZERO.equals(resultSource.get(i).getVatRate())) {
							sumAmountVat0 = sumAmountVat0.add(resultSource.get(i).getBeforVat());
							vatBean0.setAmount(sumAmountVat0);
							sumAmountVatAll0 = sumAmountVatAll0.add(resultSource.get(i).getAmount());
							vatBean0.setSumAmount(sumAmountVatAll0);
							vatBean0.setCount(vat0++);
							vatBean0.setVatRat(Constants.VATRATE.VATE_WORD.concat(" "+resultSource.get(i).getVatRate()+" %"));
						}else if(Constants.VATRATE.NON_VATE.equals(resultSource.get(i).getVatRate())) {
							sumAmountVatNon = sumAmountVatNon.add(resultSource.get(i).getBeforVat());
							vatBeanNon.setAmount(sumAmountVatNon);
							sumAmountVatAllNon = sumAmountVatAllNon.add(resultSource.get(i).getAmount());
							vatBeanNon.setSumAmount(sumAmountVatAllNon);
							vatBeanNon.setCount(vatNon++);
							vatBeanNon.setVatRat(resultSource.get(i).getVatRate());
						}else if(Constants.VATRATE.EIGHT.equals(resultSource.get(i).getVatRate())) {
							sumAmountVat8 = sumAmountVat8.add(resultSource.get(i).getBeforVat());
							vatBean8.setAmount(sumAmountVat8);
							sumAmountVatAll8 = sumAmountVatAll8.add(resultSource.get(i).getAmount());
							vatBean8.setSumAmount(sumAmountVatAll8);
							vatBean8.setCount(vat8++);
							vatBean8.setVatRat(Constants.VATRATE.VATE_WORD.concat(" "+resultSource.get(i).getVatRate()+" %"));
						}else if(Constants.VATRATE.SEVEN.equals(resultSource.get(i).getVatRate())) {
							sumAmountVat7 = sumAmountVat7.add(resultSource.get(i).getBeforVat());
							vatBean7.setAmount(sumAmountVat7);
							sumAmountVatAll7 = sumAmountVatAll7.add(resultSource.get(i).getAmount());
							vatBean7.setSumAmount(sumAmountVatAll7);
							vatBean7.setCount(vat7++);
							vatBean7.setVatRat(Constants.VATRATE.VATE_WORD.concat(" "+resultSource.get(i).getVatRate()+" %"));
						}
						
						if(i==0) { vatRate = resultSource.get(i).getVatRate(); userPayment = resultSource.get(i).getCreateBy();}
						
						if(userPayment.equals(resultSource.get(i).getCreateBy())) {
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
								
							}
							
							userPaymentOld = userPayment;
						}else {
							
							beanSup = masterDataService.findByUsername(userPaymentOld);
							
							parameters = new HashMap<String, Object>();
							parameters.put("serviceTypeHead", criteria.getMachinePaymentName());
							parameters.put("posNo", posNo);
							parameters.put("accountCode", "accountCode");
							parameters.put("printDates", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dates));
							parameters.put("dateFrom", convertDateFormat(criteria.getDateFrom()));
							parameters.put("dateTo", convertTimeFormat(criteria.getDateTo()));
							parameters.put("staff", criteria.getUser());
							parameters.put("fullNameUser", beanSup.getSurName() + " " + beanSup.getLastName());
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
							parameters.put("pageNumber", pageNumber);
							
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
							pageNumber++;
							
							if(Constants.Status.ACTIVE.equals(resultSource.get(i).getStatusStr())) {
								sumAllVat0 += resultSource.get(i).getAmount().doubleValue() - resultSource.get(i).getBeforVat().doubleValue();
								sumAllTotal += resultSource.get(i).getAmount().doubleValue();
								sumAllTotalNoVat += resultSource.get(i).getBeforVat().doubleValue();
							}
							
						}
						
						vatRate = resultSource.get(i).getVatRate();
						userPayment = resultSource.get(i).getCreateBy();
						countRow++;
						sumCount++;
						
						if(i==(resultSource.size()-1)) {
							
							beanSup = masterDataService.findByUsername(userPayment);
							
							parameters = new HashMap<String, Object>();
							parameters.put("serviceTypeHead", criteria.getMachinePaymentName());
							parameters.put("posNo", posNo);
							parameters.put("accountCode", "accountCode");
							parameters.put("printDates", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dates));
							parameters.put("dateFrom", convertDateFormat(criteria.getDateFrom()));
							parameters.put("dateTo", convertTimeFormat(criteria.getDateTo()));
							parameters.put("staff", criteria.getUser());
							parameters.put("fullNameUser", beanSup.getSurName() + " " + beanSup.getLastName());
							parameters.put("serviceNameHead", serviceName);

							parameters.put("summaryVat0", String.format("%,.2f", sumAllVat0));
							parameters.put("summaryAllVat", String.format("%,.2f", sumAllTotal));
							parameters.put("summaryAllNotVat", String.format("%,.2f", sumAllTotalNoVat));
							sumAllVatUser += sumAllVat0;
							sumAllVatSum += sumAllVat0;
							sumAllTotalUser += sumAllTotal;
							sumAllTotalNoVatUser += sumAllTotalNoVat;
							parameters.put("summaryVat0User", String.format("%,.2f", sumAllVat0));
							parameters.put("summaryVatUser", String.format("%,.2f", sumAllTotal));
							parameters.put("summaryNoVatUser", String.format("%,.2f", sumAllTotalNoVat));
							
							parameters.put("serviceName", serviceName);
							parameters.put("serviceListCount", resultSources.size());
							parameters.put("userListCount", resultSources.size());
							parameters.put("userPayment", userPay);
							parameters.put("pageNumber", pageNumber);
							
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
							if(StringUtils.isNotBlank(vatBean8.getVatRat())) {
								vatBeans.add(vatBean8);
							}
							if(StringUtils.isNotBlank(vatBean7.getVatRat())) {
								vatBeans.add(vatBean7);
							}
							
							for(int ii=0; ii<vatBeans.size(); ii++) {
								parameters.put("chkVat"+ii, "Y");
								parameters.put("vatListCount"+ii, vatBeans.get(ii).getCount());
								parameters.put("vatRate"+ii, vatBeans.get(ii).getVatRat());
								parameters.put("vatRateAmount"+ii, String.format("%,.2f", vatBeans.get(ii).getAmount()));
								parameters.put("vatRateSumAmount"+ii, String.format("%,.2f", vatBeans.get(ii).getSumAmount()));
								
								vatRateAmountSum = vatRateAmountSum.add(vatBeans.get(ii).getAmount());
								vatRateSumAmountSum = vatRateSumAmountSum.add(vatBeans.get(ii).getSumAmount());
								vatListCountSum += vatBeans.get(ii).getCount();
								if(ii==(vatBeans.size()-1)) {
									parameters.put("chkSumLast"+(ii+1), "Y");
									parameters.put("chkVat"+(ii+1), "Y");
									parameters.put("vatListCount"+(ii+1), vatListCountSum);
									parameters.put("vatRate"+(ii+1), Constants.report.SUM_TH);
									parameters.put("sumAllVatAmoutLast", String.format("%,.2f", sumAllVatSum));
									parameters.put("vatRateAmount"+(ii+1), String.format("%,.2f",vatRateAmountSum));
									parameters.put("vatRateSumAmount"+(ii+1), String.format("%,.2f", vatRateSumAmountSum));
								}
							}
							
							JRDataSource jrDataSource = (resultSources != null && !resultSources.isEmpty()) ? new JRBeanCollectionDataSource(resultSources) : new JREmptyDataSource();
							JasperPrint jasperPrint = new JasperPrint();
							
							jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
							jasperPrints.add(jasperPrint);
						}
						
					}
				}else {
					JasperPrint jasperPrint = new JasperPrint();
					jasperPrints.add(jasperPrint);
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
				
				BigDecimal sumAmountVat7 = BigDecimal.ZERO;
				BigDecimal sumAmountVat8 = BigDecimal.ZERO;
				BigDecimal sumAmountVatAll8 = BigDecimal.ZERO;
				BigDecimal sumAmountVatAll7 = BigDecimal.ZERO;
				int vat10 = 1;
				int vat8 = 1;
				int vat7 = 1;
				int vat0 = 1;
				int vatNon = 1;
				int pageNumber = 1;
				
				for(int i=0; i<resultSource.size(); i++) {
					
					if(Constants.VATRATE.TEN.equals(resultSource.get(i).getVatRate())) {
						sumAmountVat10 = sumAmountVat10.add(resultSource.get(i).getBeforVat());
						vatBean10.setAmount(sumAmountVat10);
						sumAmountVatAll10 = sumAmountVatAll10.add(resultSource.get(i).getAmount());
						vatBean10.setSumAmount(sumAmountVatAll10);
						vatBean10.setCount(vat10++);
						vatBean10.setVatRat(Constants.VATRATE.VATE_WORD.concat(" "+resultSource.get(i).getVatRate()+" %"));
					}else if(Constants.VATRATE.ZERO.equals(resultSource.get(i).getVatRate())) {
						sumAmountVat0 = sumAmountVat0.add(resultSource.get(i).getBeforVat());
						vatBean0.setAmount(sumAmountVat0);
						sumAmountVatAll0 = sumAmountVatAll0.add(resultSource.get(i).getAmount());
						vatBean0.setSumAmount(sumAmountVatAll0);
						vatBean0.setCount(vat0++);
						vatBean0.setVatRat(Constants.VATRATE.VATE_WORD.concat(" "+resultSource.get(i).getVatRate()+" %"));
					}else if(Constants.VATRATE.NON_VATE.equals(resultSource.get(i).getVatRate())) {
						sumAmountVatNon = sumAmountVatNon.add(resultSource.get(i).getBeforVat());
						vatBeanNon.setAmount(sumAmountVatNon);
						sumAmountVatAllNon = sumAmountVatAllNon.add(resultSource.get(i).getAmount());
						vatBeanNon.setSumAmount(sumAmountVatAllNon);
						vatBeanNon.setCount(vatNon++);
						vatBeanNon.setVatRat(resultSource.get(i).getVatRate());
					}else if(Constants.VATRATE.EIGHT.equals(resultSource.get(i).getVatRate())) {
						sumAmountVat8 = sumAmountVat8.add(resultSource.get(i).getBeforVat());
						vatBean8.setAmount(sumAmountVat8);
						sumAmountVatAll8 = sumAmountVatAll8.add(resultSource.get(i).getAmount());
						vatBean8.setSumAmount(sumAmountVatAll8);
						vatBean8.setCount(vat8++);
						vatBean8.setVatRat(Constants.VATRATE.VATE_WORD.concat(" "+resultSource.get(i).getVatRate()+" %"));
					}else if(Constants.VATRATE.SEVEN.equals(resultSource.get(i).getVatRate())) {
						sumAmountVat7 = sumAmountVat7.add(resultSource.get(i).getBeforVat());
						vatBean7.setAmount(sumAmountVat7);
						sumAmountVatAll7 = sumAmountVatAll7.add(resultSource.get(i).getAmount());
						vatBean7.setSumAmount(sumAmountVatAll7);
						vatBean7.setCount(vat7++);
						vatBean7.setVatRat(Constants.VATRATE.VATE_WORD.concat(" "+resultSource.get(i).getVatRate()+" %"));
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
						parameters.put("pageNumber", pageNumber);
						
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
						pageNumber++;
						
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
						sumAllVatSum += sumAllVat0;
						sumAllTotalUser += sumAllTotal;
						sumAllTotalNoVatUser += sumAllTotalNoVat;
						parameters.put("summaryVat0User", String.format("%,.2f", sumAllVat0));
						parameters.put("summaryVatUser", String.format("%,.2f", sumAllTotal));
						parameters.put("summaryNoVatUser", String.format("%,.2f", sumAllTotalNoVat));
						
						parameters.put("serviceName", serviceName);
						parameters.put("serviceListCount", resultSources.size());
						parameters.put("userListCount", resultSources.size());
						parameters.put("userPayment", userPay);
						parameters.put("pageNumber", pageNumber);
						
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
						if(StringUtils.isNotBlank(vatBean8.getVatRat())) {
							vatBeans.add(vatBean8);
						}
						if(StringUtils.isNotBlank(vatBean7.getVatRat())) {
							vatBeans.add(vatBean7);
						}
						
//						BigDecimal vatRateAmountSum = BigDecimal.ZERO;
//						BigDecimal vatRateSumAmountSum = BigDecimal.ZERO;
//						int vatListCountSum = 0;
//						BigDecimal vatRateAmountSum = BigDecimal.ZERO;
						
						for(int ii=0; ii<vatBeans.size(); ii++) {
							parameters.put("chkVat"+ii, "Y");
							parameters.put("vatListCount"+ii, vatBeans.get(ii).getCount());
							parameters.put("vatRate"+ii, vatBeans.get(ii).getVatRat());
							parameters.put("vatRateAmount"+ii, String.format("%,.2f", vatBeans.get(ii).getAmount()));
							parameters.put("vatRateSumAmount"+ii, String.format("%,.2f", vatBeans.get(ii).getSumAmount()));
							
							vatRateAmountSum = vatRateAmountSum.add(vatBeans.get(ii).getAmount());
							vatRateSumAmountSum = vatRateSumAmountSum.add(vatBeans.get(ii).getSumAmount());
							vatListCountSum += vatBeans.get(ii).getCount();
							if(ii==(vatBeans.size()-1)) {
								parameters.put("chkSumLast"+(ii+1), "Y");
								parameters.put("chkVat"+(ii+1), "Y");
								parameters.put("vatListCount"+(ii+1), vatListCountSum);
								parameters.put("vatRate"+(ii+1), Constants.report.SUM_TH);
								parameters.put("sumAllVatAmoutLast", String.format("%,.2f", sumAllVatSum));
								parameters.put("vatRateAmount"+(ii+1), String.format("%,.2f",vatRateAmountSum));
								parameters.put("vatRateSumAmount"+(ii+1), String.format("%,.2f", vatRateSumAmountSum));
							}
						}
						
						JRDataSource jrDataSource = (resultSources != null && !resultSources.isEmpty()) ? new JRBeanCollectionDataSource(resultSources) : new JREmptyDataSource();
						JasperPrint jasperPrint = new JasperPrint();
						
						jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
						jasperPrints.add(jasperPrint);
					}
					
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
