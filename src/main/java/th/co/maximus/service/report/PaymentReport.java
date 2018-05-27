package th.co.maximus.service.report;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import th.co.maximus.bean.ExportPDFReport;
import th.co.maximus.bean.InvEpisOfflineReportBean;
import th.co.maximus.bean.ReportPaymentBean;
import th.co.maximus.bean.ReportPaymentCriteria;
import th.co.maximus.constants.Constants;
import th.co.maximus.model.TrsChequerefEpisOffline;
import th.co.maximus.model.TrsCreditrefEpisOffline;
import th.co.maximus.service.TrsChequeRefManualService;
import th.co.maximus.service.TrscreDitrefManualService;

@Service("paymentReport")
public class PaymentReport extends BaseExcelRptService {
	@Autowired
	private TrscreDitrefManualService trscreDitrefManualService;
	
	@Autowired
	private TrsChequeRefManualService trsChequeRefManualService;
	
	private ServletContext context;
	@Autowired
	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
	}
	public Workbook generatePaymentReportExcel(Workbook workbook, ReportPaymentCriteria criteria, List<ReportPaymentBean>  result) throws ParseException {
		//StyleCell
		Font fontNormal = createFontTHSarabanPSK(workbook, 11, false);
		CellStyle txtCenterBor = createStyleCellLeft(workbook, fontNormal, true);
		
		Font fontTable = createFontTHSarabanPSK(workbook, 10, false);
		CellStyle txtCenterTable = createStyleCellLeftBorder(workbook, fontTable, true);
		CellStyle txtCenterTableRight = createStyleCellLefRight(workbook, fontTable, true);
									
		CellStyle txtCenterDecimalRight = createStyleCellFormetDecimalRight(workbook, fontTable, true);
		
		CellStyle borderCell = createBorderCellStyle(workbook, fontTable);
		
		
		
		//Create Sheet and name Sheet
		Sheet sh = workbook.getSheetAt(0);
		workbook.setSheetName(workbook.getSheetIndex(sh), "payment-report");
		
		//set row date header and style cell
		 Row row1 = sh.createRow(1);
		 Cell company = row1.createCell(0);
		 Cell dateFromToCriteria = row1.createCell(4);
		 Cell datePrint = row1.createCell(9);
		 company.setCellValue("บริษัท กสท โทรคมนาคม จำกัด (มหาชน)");
		 dateFromToCriteria.setCellValue("ประจำวันที่"+" "+ convertDateFormat(criteria.getDateFrom())+" "+" ถึง "+ convertDateFormat(criteria.getDateTo()));
		 datePrint.setCellValue("พิมพ์วันที่"+" "+ convertDateFormat(criteria.getDateFrom())+" "+" ถึง "+ convertDateFormat(criteria.getDateTo()));
		 company.setCellStyle(txtCenterBor);
		 dateFromToCriteria.setCellStyle(txtCenterBor);
		 datePrint.setCellStyle(txtCenterBor);
		 
		 Row row2 = sh.createRow(2);
		 Cell agency = row2.createCell(0);
		 agency.setCellValue("หน่วยงานรับชำระ "+ criteria.getMachinePaymentName());
		 agency.setCellStyle(txtCenterBor);
		 
		 Row row3 = sh.createRow(3);
		 Cell user = row3.createCell(0);
		 user.setCellValue("เจ้าหน้าที่ "+ criteria.getUser());
		 user.setCellStyle(txtCenterBor);
		 
		 int indexRow = 6;
		 int index = 1;
		 double sumAllTotal = 0.00;
		 double sumAllNoVat = 0.00;
		 double sumVat0 = 0.00;
//		 double sumVat3 = 0.00;
//		 double sumVat7 = 0.00;
//		 DecimalFormat df2 = new DecimalFormat("#0.00");
		 
		 
		 if(result.size() > 0 && !result.isEmpty()) {
			 for(ReportPaymentBean resultReportPayment : result) {
				 Row row = sh.createRow(indexRow);
				 Cell cell = row.createCell(0);
				 Cell cell1= row.createCell(1);
				 Cell cell2 = row.createCell(2);
				 Cell cell3 = row.createCell(3);
				 Cell cell4 = row.createCell(4);
				 Cell cell5 = row.createCell(5);
				 Cell cell6 = row.createCell(6);
				 Cell cell7 = row.createCell(7);
				 Cell cell8 = row.createCell(8);
				 Cell cell9 = row.createCell(9);
				 Cell cell10 = row.createCell(10);
				 Cell cell11 = row.createCell(11);
				 Cell cell12 = row.createCell(12);
				 Cell cell13 = row.createCell(13);
				 
				 cell.setCellValue(index);
				 if("IBACSS".equals(resultReportPayment.getServiceType())) {
					 cell1.setCellValue("รับชำระค่าใช้บริการ");
				 }else if("OTHER".equals(resultReportPayment.getServiceType())) {
					 cell1.setCellValue("รับชำระค่าใช้บริการอื่น ๆ ");
				 }
				 cell2.setCellValue(resultReportPayment.getReceiptNoManual());
				 cell3.setCellValue(resultReportPayment.getAccountSubNo());
				 cell4.setCellValue(resultReportPayment.getCustomerName());
				 cell5.setCellValue(resultReportPayment.getDepartment());
				 cell6.setCellValue(resultReportPayment.getInvoiceNo());
				 cell7.setCellValue(resultReportPayment.getPaymentMethod());
				 cell8.setCellValue("-");
				 cell9.setCellValue(String.format("%,.2f", resultReportPayment.getBeforVat()));
				 cell10.setCellValue(String.format("%,.2f", resultReportPayment.getVatAmount()));
				 cell11.setCellValue(String.format("%,.2f", resultReportPayment.getAmount()));
				 if("A".equals(resultReportPayment.getStatus())) {
					 cell12.setCellValue("ยกเลิก");
				 }else if("C".equals(resultReportPayment.getStatus())) {
					 cell12.setCellValue("-");
				 }
				 cell13.setCellValue(resultReportPayment.getCreateBy());
				 
				 
				 
				 cell.setCellStyle(txtCenterTableRight);
				 cell1.setCellStyle(txtCenterTable);
				 cell2.setCellStyle(txtCenterTable);
				 cell3.setCellStyle(txtCenterTable);
				 cell4.setCellStyle(txtCenterTable);
				 cell5.setCellStyle(txtCenterTable);
				 cell6.setCellStyle(txtCenterTable);
				 cell7.setCellStyle(txtCenterTable);
				 cell8.setCellStyle(txtCenterTable);
				 cell9.setCellStyle(txtCenterDecimalRight);
				 cell10.setCellStyle(txtCenterTableRight);
				 cell11.setCellStyle(txtCenterDecimalRight);
				 cell12.setCellStyle(txtCenterTable);
				 cell13.setCellStyle(txtCenterTable);
//				 String vatConverStr = resultReportPayment.getVatAmount()+"";
				 
//				 if("0".equals(vatConverStr)) {
					 sumVat0 += resultReportPayment.getAmount().doubleValue() - resultReportPayment.getBeforVat().doubleValue();
//				 }else if("3".equals(vatConverStr)) {
//					 sumVat3 += resultReportPayment.getAmount().doubleValue() - resultReportPayment.getBeforVat().doubleValue();
//				 }else if("7".equals(vatConverStr)) {
//					 sumVat7 += resultReportPayment.getAmount().doubleValue() - resultReportPayment.getBeforVat().doubleValue();
//				 }
				 sumAllTotal += resultReportPayment.getAmount().doubleValue();
				 sumAllNoVat += resultReportPayment.getBeforVat().doubleValue();
				 
				 index++;
				 indexRow++;
			 }
		 }
		 
		 Row textTotalSummary = sh.createRow(indexRow);
//		 Cell cellTotalSummary = textTotalSummary.createCell(2);
//		 cellTotalSummary.setCellValue("ผลรวมทั้งหมด");
//		 cellTotalSummary.setCellStyle(txtCenterTable);
		 
		 Cell totalSummaryNoVat = textTotalSummary.createCell(9);
		 totalSummaryNoVat.setCellValue(String.format("%,.2f", sumAllNoVat));
		 totalSummaryNoVat.setCellStyle(txtCenterTable);
		 totalSummaryNoVat.setCellStyle(borderCell);
		 
		 Cell totalVat0 = textTotalSummary.createCell(10);
		 totalVat0.setCellValue(String.format("%,.2f", sumVat0));
		 totalVat0.setCellStyle(borderCell);
		 
		 Cell totalSummary = textTotalSummary.createCell(11);
		 totalSummary.setCellValue(String.format("%,.2f", sumAllTotal));
		 totalSummary.setCellStyle(borderCell);
		 

		 
//		 Row vat0 = sh.createRow(indexRow++);
//		 Cell cellvat0 = vat0.createCell(2);
//		 cellvat0.setCellValue("ผลรวม Vat 0%");
//		 cellvat0.setCellStyle(txtCenterTable);
//		 Cell totalVat0 = vat0.createCell(10);
//		 totalVat0.setCellValue(String.format("%,.2f", sumVat0));
//		 totalVat0.setCellStyle(txtCenterTable);

		 
		 
//		 Row vat3 = sh.createRow(indexRow + 3);
//		 Cell cellvat3 = vat3.createCell(2);
//		 cellvat3.setCellValue("ผลรวม Vat 3%");
//		 cellvat3.setCellStyle(txtCenterTable);
//		
//		 Cell totalVat3 = vat3.createCell(10);
//		 totalVat3.setCellValue(String.format("%,.2f", sumVat3));
//		 totalVat3.setCellStyle(txtCenterTable);
//		 
//		 Row vat7 = sh.createRow(indexRow + 4);
//		 Cell cellvat7 = vat7.createCell(2);
//		 cellvat7.setCellValue("ผลรวม Vat 7%");
//		 cellvat7.setCellStyle(txtCenterTable);
//		
//		 Cell totalVat7 = vat7.createCell(10);
//		 totalVat7.setCellValue(String.format("%,.2f", sumVat7));
//		 totalVat7.setCellStyle(txtCenterTable);
//		 
		 
		
		return workbook;
	}
	public void previewEpisOffilneprint(HttpServletRequest request, HttpServletResponse response,
			List<InvEpisOfflineReportBean> collections, final String JASPER_JRXML_FILENAME) throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		List<InvEpisOfflineReportBean> printCollections = new ArrayList<InvEpisOfflineReportBean>();
		InvEpisOfflineReportBean invObject = (InvEpisOfflineReportBean) collections.get(0);
		ExportPDFReport exportPDFReport = new ExportPDFReport();
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy hh:ss");
		Date date = new Date();
		String dateDocument = dt.format(date);

		exportPDFReport.setBranArea(invObject.getNameArea());
		exportPDFReport.setBracnCode(invObject.getBracnCode());
		exportPDFReport.setDocumentDate(invObject.getDocumentDate());
		exportPDFReport.setCustNo(invObject.getCustNo());
		exportPDFReport.setDocumentNo(invObject.getDocumentNo());
		exportPDFReport.setBalanceSummary(invObject.getBalanceSummary().setScale(2, RoundingMode.HALF_DOWN));
		exportPDFReport.setRemark(invObject.getRemark());
		exportPDFReport.setDateDocument(dateDocument);
		
		exportPDFReport.setServiceNo(invObject.getServiceNo());
		if(StringUtils.isNotBlank(invObject.getServiceNo())) {
			exportPDFReport.setCheckSubNo("Y");
		}else {
			exportPDFReport.setCheckSubNo("N");
		}
		
		
		exportPDFReport.setBeforeVat(invObject.getBeforeVat().setScale(2, RoundingMode.HALF_DOWN));
		
		if(Integer.parseInt(invObject.getVatRate()) < 0) {
			exportPDFReport.setVatRate("(NON VAT)");
		}else {
			exportPDFReport.setVatRate("(VAT "+invObject.getVatRate()+"%)");
		}
		exportPDFReport.setVat(invObject.getVat().setScale(2, RoundingMode.HALF_DOWN));
		
		
		exportPDFReport.setCustName(invObject.getCustName());
		exportPDFReport.setCustomerAddress(invObject.getCustomerAddress());
		exportPDFReport.setTaxId(invObject.getTaxId());
		
		if(StringUtils.isNotBlank(invObject.getCustName())) {
			exportPDFReport.setCheckCustomerName("Y");
		}else {
			exportPDFReport.setCheckCustomerName("N");
		}
		if(StringUtils.isNotBlank(invObject.getCustomerAddress())) {
			exportPDFReport.setCheckAddress("Y");
		}else {
			exportPDFReport.setCheckAddress("N");
		}
		if(StringUtils.isNotBlank(invObject.getTaxId())) {
			exportPDFReport.setCheckTaxId("Y");
		}else {
			exportPDFReport.setCheckTaxId("N");
		}

		String preiod = "";
		// nameService = invObject.getBracnCode() + invObject.getBranArea()+
		// invObject.getSouce();
		if (invObject.getPreiod() != null) {
			String preiods = invObject.getPreiod();
			String yearFrist = preiods.substring(0, 4);
			String mountFrist = preiods.substring(4, 6);
			String dayFrist = preiods.substring(6, 8);
			String yearEnd = preiods.substring(8, 12);
			String mountEnd = preiods.substring(12, 14);
			String dayEnd = preiods.substring(14, 16);

			preiod = dayFrist + "/" + mountFrist + "/" + yearFrist + "-" + dayEnd + "/" + mountEnd + "/" + yearEnd;
			exportPDFReport.setPreiod(preiod);
		} else {
			exportPDFReport.setPreiod(preiod);
		}

		String paymentCodeRes = "";
		String checkWT = "";
		List<String> result = new ArrayList<>();
		for (int i = 0; i < collections.size(); i++) {
			String payCode = "";
			InvEpisOfflineReportBean stockObject = (InvEpisOfflineReportBean) collections.get(i);

			if (stockObject.getPaymentCode().equals("CC")) {
				payCode = "เงินสด";
				result.add(payCode);
			} else if (stockObject.getPaymentCode().equals("CD")) {
				List<TrsCreditrefEpisOffline> res = trscreDitrefManualService.findByMethodId(stockObject.getMethodId());
				String code = res.get(0).getCreditNo();
				payCode = "บัตรเครดิต" +" " +res.get(0).getCardtype() +" "+ "เลขที่ : ************" + code.substring(12, 16);
				result.add(payCode);
			} else if (stockObject.getPaymentCode().equals("CH")) {
				List<TrsChequerefEpisOffline> res = trsChequeRefManualService.findTrsCredit(stockObject.getMethodId());
				payCode = "เช็ค " + res.get(0).getPublisher() + "เลขที่ :" + res.get(0).getChequeNo();
				result.add(payCode);
			}

			

		}
		for (int i = 0; i < collections.size(); i++) {
			InvEpisOfflineReportBean stockObject = (InvEpisOfflineReportBean) collections.get(i);
			if (stockObject.getPaymentCode().equals("DEDUC")) {
				checkWT = "WT";
				result.add(checkWT);
			}
			
		}
		for (int f = 0; f < result.size(); f++) {
			if (f == 0) {
				paymentCodeRes += result.get(f);
			} else {
				paymentCodeRes += " + " + result.get(f);
			}

		}

		String bran = "";
		if (invObject.getBracnCode().equals("0000")) {
			bran = "สำนักงานใหญ่";
			exportPDFReport.setCheckBran("N");
		} else {
			bran = invObject.getBracnCode();
			exportPDFReport.setCheckBran("Y");
		}
		exportPDFReport.setPaymentCode(paymentCodeRes);
		exportPDFReport.setSouce(bran);
		if (invObject.getDiscount().signum() == 0) {
			exportPDFReport.setDiscount(invObject.getDiscount());
			exportPDFReport.setCheckDiscount("N");
		} else {
			exportPDFReport.setDiscount(invObject.getDiscount());
			exportPDFReport.setCheckDiscount("Y");
		}
		exportPDFReport.setDiscount(invObject.getDiscount().setScale(2, RoundingMode.HALF_DOWN));
		exportPDFReport.setAmountPayment(invObject.getAmountPayment().setScale(2, RoundingMode.HALF_DOWN));
		exportPDFReport.setInvoiceNo(invObject.getInvoiceNo());
		parameters.put("ReportSource", exportPDFReport);

		response.setContentType("application/pdf");
		response.setCharacterEncoding("UTF-8");
		JasperReport jasperReport = JasperCompileManager.compileReport(context.getRealPath(Constants.report.repotPathc)
				+ File.separatorChar + JASPER_JRXML_FILENAME + ".jrxml");
		JRDataSource jrDataSource = (printCollections != null && !printCollections.isEmpty())
				? new JRBeanCollectionDataSource(printCollections)
				: new JREmptyDataSource();
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
		JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
	}
	
	
	private String convertDateFormat(String dateFormat) throws ParseException {
	    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateFormat);
	    return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);
	}
}
