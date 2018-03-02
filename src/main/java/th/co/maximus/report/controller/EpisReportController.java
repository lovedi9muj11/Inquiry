package th.co.maximus.report.controller;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import th.co.maximus.bean.ExportPDFByInsaleReport;
import th.co.maximus.bean.ExportPDFReport;
import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.bean.InvEpisOfflineByInsaleBean;
import th.co.maximus.bean.InvEpisOfflineReportBean;
import th.co.maximus.bean.InvPaymentOrderTaxBean;
import th.co.maximus.constants.Constants;
import th.co.maximus.service.ReportService;

@Controller
public class EpisReportController {
	@Autowired
	ReportService reportService;

	
	private ServletContext context;

	@Autowired
	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
	}
	
	
	@RequestMapping(value= {"/previewPaymentEpisOffline.pdf"}) 
	public void previewReturnStockBySerialHTML(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
//		String documentNo = "";
 		String JASPER_JRXML_FILENAME = "InvEpisPayment";
		request.setAttribute("documentReport", "-1");
		String documentNo = request.getParameter("documentNo");
		List<InvEpisOfflineReportBean>collections= reportService.inqueryEpisOfflineJSONHandler(documentNo);
		
		if(collections != null) {
			previewEpisOffilneprint(request, response, collections, JASPER_JRXML_FILENAME);
		}
	}
	
	private void previewEpisOffilneprint(HttpServletRequest request, HttpServletResponse response, List<InvEpisOfflineReportBean> collections, final String JASPER_JRXML_FILENAME) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		List<InvEpisOfflineReportBean> printCollections = new ArrayList<InvEpisOfflineReportBean>();
		InvEpisOfflineReportBean invObject = (InvEpisOfflineReportBean)collections.get(0);
		ExportPDFReport exportPDFReport = new ExportPDFReport();
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		Date date =  new Date();
		String dateDocument = dt.format(date);
		
		exportPDFReport.setBranArea(invObject.getBranArea());
		exportPDFReport.setBracnCode(invObject.getBracnCode());
		exportPDFReport.setDocumentDate(invObject.getDocumentDate());
		exportPDFReport.setCustNo(invObject.getCustNo());
		exportPDFReport.setCustName(invObject.getCustName());
		exportPDFReport.setDocumentNo(invObject.getDocumentNo());
		exportPDFReport.setBalanceSummary(invObject.getBalanceSummary().setScale(2, RoundingMode.HALF_DOWN));
		exportPDFReport.setCustomerAddress(invObject.getCustomerAddress());
		exportPDFReport.setTaxId(invObject.getTaxId());
		exportPDFReport.setRemark(invObject.getRemark());
		exportPDFReport.setDateDocument(dateDocument);

		
		BigDecimal total = invObject.getBalanceSummary();
		BigDecimal vatRate = new BigDecimal(invObject.getVatRate());
		BigDecimal resVat = new BigDecimal(107);
		
		BigDecimal beforeVat = total.multiply(vatRate);
		
		BigDecimal vat = beforeVat.divide(resVat,2,RoundingMode.HALF_UP);
		
		BigDecimal beforeVats = total.subtract(vat);
		
		exportPDFReport.setBeforeVat(beforeVats.setScale(2, RoundingMode.HALF_DOWN));
		exportPDFReport.setVat(vat.setScale(2, RoundingMode.HALF_DOWN));
		
		String nameService = "";
		nameService = invObject.getBracnCode() + invObject.getBranArea()+ invObject.getSouce();
		
		String payCode="";
		List<String> result = new ArrayList<>();
		for(int i=0; i<collections.size();i++) {
			InvEpisOfflineReportBean stockObject = (InvEpisOfflineReportBean)collections.get(i);
			
			result.add(stockObject.getPaymentCode());
			
		}
		for(int f = 0; f<result.size();f++) {
			payCode += "-"+ result.get(f);
		}
		exportPDFReport.setPaymentCode(payCode);
		exportPDFReport.setSouce(nameService);
		parameters.put("ReportSource", exportPDFReport);
		
		response.setContentType("application/pdf");
		response.setCharacterEncoding("UTF-8");
//		JRProperties.setProperty("net.sf.jasperreports.default.pdf.font.name", "THSarabun.ttf"); JRProperties.setProperty("net.sf.jasperreports.default.pdf.encoding", "UTF-8"); JRProperties.setProperty("net.sf.jasperreports.default.pdf.embedded", "true");
		JasperReport jasperReport = JasperCompileManager.compileReport(context.getRealPath(Constants.report.repotPathc) + File.separatorChar + JASPER_JRXML_FILENAME + ".jrxml");
		JRDataSource jrDataSource = (printCollections != null && !printCollections.isEmpty()) ? new JRBeanCollectionDataSource(printCollections) : new JREmptyDataSource();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,jrDataSource);
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
//        exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
	}
	
	@RequestMapping(value= {"/previewPaymentEpisOfflineByInsale.pdf"}) 
	public void previewPaymentEpisOfflineByInsale(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		//String documentNo = "";
 		String JASPER_JRXML_FILENAME = "InvEpisPaymentByInsale";
		request.setAttribute("documentReport", "-1");
		String documentNo = request.getParameter("documentNo");
		List<InvEpisOfflineByInsaleBean>collections= reportService.inqueryEpisOfflineByInsaleJSONHandler(documentNo);
		
		if(collections != null) {
			previewEpisOffilneprintByInsale(request, response, collections, JASPER_JRXML_FILENAME);
		}
	}
	
	private void previewEpisOffilneprintByInsale(HttpServletRequest request, HttpServletResponse response, List<InvEpisOfflineByInsaleBean> collections, final String JASPER_JRXML_FILENAME) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		List<InvEpisOfflineByInsaleBean> printCollections = new ArrayList<InvEpisOfflineByInsaleBean>();
		InvEpisOfflineByInsaleBean invObject = (InvEpisOfflineByInsaleBean)collections.get(0);
		ExportPDFByInsaleReport exportPDFReport = new ExportPDFByInsaleReport();
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		Date date =  new Date();
		String dateDocument = dt.format(date);
		BigDecimal zro = new BigDecimal(0);
		if(invObject.getDiscountSpecial() == null) {
			exportPDFReport.setDiscountSpecial(zro.setScale(2, RoundingMode.HALF_DOWN));
		}else {
			exportPDFReport.setDiscountSpecial(invObject.getDiscountSpecial().setScale(2, RoundingMode.HALF_DOWN));
		}
		exportPDFReport.setBranArea(invObject.getBranArea());
		exportPDFReport.setBracnCode(invObject.getBracnCode());
		exportPDFReport.setDocumentDate(invObject.getDocumentDate());
		exportPDFReport.setCustNo(invObject.getCustNo());
		exportPDFReport.setCustName(invObject.getCustName());
		exportPDFReport.setDocumentNo(invObject.getDocumentNo());
		exportPDFReport.setBalanceSummary(invObject.getBalanceSummary().setScale(2, RoundingMode.HALF_DOWN).add(exportPDFReport.getDiscountSpecial().setScale(2, RoundingMode.HALF_DOWN)));
		exportPDFReport.setCustomerAddress(invObject.getCustomerAddress());
		exportPDFReport.setTaxId(invObject.getTaxId());
		exportPDFReport.setRemark(invObject.getRemark());
		exportPDFReport.setDateDocument(dateDocument);
		exportPDFReport.setServiceName(invObject.getServiceName());
		exportPDFReport.setAmount(invObject.getAmount());
		exportPDFReport.setDiscountbeforvat(invObject.getDiscountbeforvat());
		
		exportPDFReport.setBalanceBefore(invObject.getBalanceSummary().setScale(2, RoundingMode.HALF_DOWN));
		
		
		BigDecimal total = invObject.getBalanceSummary().setScale(2, RoundingMode.HALF_DOWN).add(exportPDFReport.getDiscountSpecial().setScale(2, RoundingMode.HALF_DOWN));
		BigDecimal vatRate = new BigDecimal(invObject.getVatRate());
		BigDecimal resVat = new BigDecimal(107);
		
		BigDecimal beforeVat = total.multiply(vatRate);
		
		BigDecimal vat = beforeVat.divide(resVat,2,RoundingMode.HALF_UP);
		
		BigDecimal beforeVats = total.subtract(vat);
		
		exportPDFReport.setBeforeVat(beforeVats.setScale(2, RoundingMode.HALF_DOWN));
		exportPDFReport.setVat(vat.setScale(2, RoundingMode.HALF_DOWN));
		
		String nameService = "";
		nameService = invObject.getBracnCode() + invObject.getBranArea()+ invObject.getSouce();
		
		String payCode="";
		List<String> result = new ArrayList<>();
		for(int i=0; i<collections.size();i++) {
			InvEpisOfflineByInsaleBean stockObject = (InvEpisOfflineByInsaleBean)collections.get(i);
			
			result.add(stockObject.getPaymentCode());
			
		}
		for(int f = 0; f<result.size();f++) {
			payCode += "-"+ result.get(f);
		}
		exportPDFReport.setPaymentCode(payCode);
		exportPDFReport.setSouce(nameService);
		parameters.put("ReportSource", exportPDFReport);
		
		response.setContentType("application/pdf");
		response.setCharacterEncoding("UTF-8");
//		JRProperties.setProperty("net.sf.jasperreports.default.pdf.font.name", "THSarabun.ttf"); JRProperties.setProperty("net.sf.jasperreports.default.pdf.encoding", "UTF-8"); JRProperties.setProperty("net.sf.jasperreports.default.pdf.embedded", "true");
		JasperReport jasperReport = JasperCompileManager.compileReport(context.getRealPath(Constants.report.repotPathc) + File.separatorChar + JASPER_JRXML_FILENAME + ".jrxml");
		JRDataSource jrDataSource = (printCollections != null && !printCollections.isEmpty()) ? new JRBeanCollectionDataSource(printCollections) : new JREmptyDataSource();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,jrDataSource);
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
//        exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
	}
	
	 @RequestMapping(value = {"previewPaymentPrintOrder.pdf"})
	    public void paymentPrint(HistoryReportBean creteria,HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		  if(creteria != null) {
			  String JASPER_JRXML_FILENAME = "InvPaymentOrderTax";
			  List<InvPaymentOrderTaxBean> collections = reportService.inqueryInvPaymentOrderTaxBeanJSONHandler(creteria);
			  if(collections != null) {
				  previewPaymentPrintOrder(request, response, collections, JASPER_JRXML_FILENAME,creteria);
				}
			  
		  }
	      
	    }
	 
	 private void previewPaymentPrintOrder(HttpServletRequest request, HttpServletResponse response, List<InvPaymentOrderTaxBean> collections, final String JASPER_JRXML_FILENAME,HistoryReportBean creteria) throws Exception {
			Map<String, Object> parameters = new HashMap<String, Object>();
			List<InvPaymentOrderTaxBean> printCollections = new ArrayList<InvPaymentOrderTaxBean>();
			InvPaymentOrderTaxBean invObject = (InvPaymentOrderTaxBean)collections.get(0);
			InvPaymentOrderTaxBean exportPDFReport = new InvPaymentOrderTaxBean();
			
			SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			Date date =  new Date();
			String dateDocument = dt.format(date);
			String dateFrom = convertDateString(creteria.getDateFrom())+ " " + creteria.getDateFromHour()+ ":"+creteria.getDateFromMinute(); 
			String dateTo = creteria.getDateTo()+ " "  + creteria.getDateToHour()+ ":"+creteria.getDateToMinute(); 
			
			if(creteria.getTypePrint().equals("F")) {
				exportPDFReport.setHeadName("รายงานภาษีใบเสร็จรับเงิน/ใบกำกับภาษีเต็มรูป");
				exportPDFReport.setReportStatus("1");
			}else {
				exportPDFReport.setHeadName("รายงานภาษีใบเสร็จรับเงิน/ใบกำกับภาษีแบบย่อ");
			}
			
			exportPDFReport.setDateForm(dateFrom);
			exportPDFReport.setDateTo(dateTo);
			exportPDFReport.setPrintDate(dateDocument);
			exportPDFReport.setBranchArea(invObject.getBranchArea());
			exportPDFReport.setInvoiceNo(invObject.getInvoiceNo());
			exportPDFReport.setBranchCodeEmp(invObject.getBranchCode());
			exportPDFReport.setVatRate(invObject.getVatRate());
			exportPDFReport.setEmpSummaryName(invObject.getEmpName());
			
			
			BigDecimal beforeVatRq = new BigDecimal(0);
			BigDecimal vatRq = new BigDecimal(0);
			BigDecimal summarySummary = new BigDecimal(0);
			for(int i=0; i<collections.size(); i++) {
				InvPaymentOrderTaxBean colles = new InvPaymentOrderTaxBean();
				colles = collections.get(i);
				colles.setAutoNumber(i+1);
				colles.setDocumentDate(colles.getDocumentDate());
				colles.setDocumentNo(colles.getDocumentNo());
				colles.setCustName(colles.getCustName());
				colles.setEmpName(colles.getEmpName());
				colles.setTaxId(colles.getTaxId());
				colles.setBranchCode(colles.getBranchCode());
				colles.setSummary(colles.getSummary().setScale(2, RoundingMode.HALF_DOWN));
				
				// BeforeVat and Vat 
				BigDecimal total = colles.getSummary().setScale(2, RoundingMode.HALF_DOWN);
				BigDecimal vatRate = new BigDecimal(colles.getVatRate());
				BigDecimal resVat = new BigDecimal(107);
				BigDecimal beforeVat = total.multiply(vatRate);				
				BigDecimal vat = beforeVat.divide(resVat,2,RoundingMode.HALF_UP);
				
				BigDecimal beforeVats = total.subtract(vat);
				
				
				colles.setBeforeVat(beforeVats.setScale(2, RoundingMode.HALF_DOWN));
				colles.setVat(vat.setScale(2, RoundingMode.HALF_DOWN));
				if(colles.getPayType().equals("A")) {
					colles.setPayType("ปกติ");
				}else {
					colles.setPayType("ยกเลิก");
				}
				beforeVatRq = beforeVats.setScale(2, RoundingMode.HALF_DOWN);
				vatRq = vat.setScale(2, RoundingMode.HALF_DOWN);
				summarySummary = colles.getSummary().setScale(2, RoundingMode.HALF_DOWN);
				
				colles.setAutoNumberReport(String.valueOf(colles.getAutoNumber()));
				colles.setDocumentDateReport(String.valueOf(colles.getDocumentDate().toString()));	
				colles.setBeforeVatReport(String.valueOf(colles.getBeforeVat()));
				colles.setVatReport(String.valueOf(colles.getVat()));
				colles.setSummaryReport(String.valueOf(colles.getSummary()));
				printCollections.add(colles);

			}
			
			exportPDFReport.setBeforeVatRq(beforeVatRq);
			exportPDFReport.setVatRq(vatRq);
			exportPDFReport.setSummaryRq(summarySummary);
			exportPDFReport.setBeforeVatSummary(beforeVatRq);
			exportPDFReport.setVatSummary(vatRq);
			exportPDFReport.setSummarySummary(summarySummary);
			
			parameters.put("ReportSource", exportPDFReport);
			
			response.setContentType("application/pdf");
			response.setCharacterEncoding("UTF-8");
			JasperReport jasperReport = JasperCompileManager.compileReport(context.getRealPath(Constants.report.repotPathc) + File.separatorChar + JASPER_JRXML_FILENAME + ".jrxml");
			JRDataSource jrDataSource = (printCollections != null && !printCollections.isEmpty()) ? new JRBeanCollectionDataSource(printCollections) : new JREmptyDataSource();
	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,jrDataSource);
	        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
		}

	 public static final String convertDateString(String str) {
			return str.replaceAll("([0-9]{2})/([0-9]{2})/([0-9]{4})", "$3-$2-$1");

		} 
}
