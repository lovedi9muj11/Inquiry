package th.co.maximus.service.report;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.ReportPaymentBean;
import th.co.maximus.bean.ReportPaymentCriteria;
import th.co.maximus.constants.Constants;
import th.co.maximus.model.UserBean;
import th.co.maximus.service.MasterDataService;

@Service("paymentReport")
public class PaymentReport extends BaseExcelRptService {
	
	@Autowired
	MasterDataService masterDataService;
	
	Locale localeTH = new Locale("th", "TH");
	Locale localeEN = new Locale("en", "EN");
	
	SimpleDateFormat formateDateEN = new SimpleDateFormat("dd/MM/yyyy", localeEN);
	SimpleDateFormat formateYearTH = new SimpleDateFormat("yyyy", localeTH);
	SimpleDateFormat formateHH = new SimpleDateFormat("HH:mm", localeTH);
	
	public Workbook generatePaymentReportExcel(Workbook workbook, ReportPaymentCriteria criteria, List<ReportPaymentBean>  result) throws ParseException {
		//StyleCell
		Font fontNormal = createFontTHSarabanPSK(workbook, 11, false);
		CellStyle txtCenterBor = createStyleCellLeft(workbook, fontNormal, true);
		CellStyle txtCenterHeadBor = createStyleCellCenter(workbook, fontNormal, true);
		CellStyle txtRightBor = createStyleCellRight(workbook, fontNormal, true);
		
		Font fontTable = createFontTHSarabanPSK(workbook, 10, false);
		CellStyle txtCenterTable = createStyleCellLeftBorder(workbook, fontTable, true);
		CellStyle txtCenterTableRight = createStyleCellLefRight(workbook, fontTable, true);
		CellStyle txtTableCenter = createStyleCellCenterBorder(workbook, fontTable, true);
									
		CellStyle txtCenterDecimalRight = createStyleCellFormetDecimalRight(workbook, fontTable, true);
		
		CellStyle borderCell = createBorderCellStyle(workbook, fontTable);
		
		String date = formateDateEN.format(new Date());
		String time = formateHH.format(new Date());
		String serviceName = "";
		int rowServiceOther = 4;
		int rowCellServiceOther = 0;
		
		if(CollectionUtils.isNotEmpty(result)) {
			if(Constants.Service.SERVICE_TYPE_IBACSS.equals(result.get(0).getServiceType())) {
				serviceName = "รับชำระค่าใช้บริการ";
			 }else if(Constants.Service.SERVICE_TYPE_OTHER.equals(result.get(0).getServiceType())) {
				 serviceName = "รับชำระค่าใช้บริการอื่น ๆ ";
				 rowServiceOther = 3;
				 rowCellServiceOther = 4;
			 }
		}
		
		//Create Sheet and name Sheet
		Sheet sh = workbook.getSheetAt(0);
		workbook.setSheetName(workbook.getSheetIndex(sh), "payment-report");
		
		//set row date header and style cell
		 Row row1 = sh.getRow(1);
		 Cell company = row1.getCell(0);
		 Cell dateFromToCriteria = row1.getCell(4);
		 Cell datePrint = row1.getCell(10);
		 company.setCellValue("บริษัท กสท โทรคมนาคม จำกัด (มหาชน)");
//		 dateFromToCriteria.setCellValue(Constants.report.HEARDER_DATE+" "+ convertDateFormat(criteria.getDateFrom())+" "+"- "+ convertTimeFormat(criteria.getDateTo()));
		 dateFromToCriteria.setCellValue(Constants.report.HEARDER_DATE+" "+ convertDateFormat(criteria.getDateFrom()));
		 datePrint.setCellValue(Constants.report.HEARDER_DATE_TIME+" "+ date+" "+time);
		 company.setCellStyle(txtCenterBor);
		 dateFromToCriteria.setCellStyle(txtCenterHeadBor);
		 datePrint.setCellStyle(txtRightBor);
		 
		 Row row2 = sh.getRow(2);
		 Cell agency = row2.getCell(0);
		 agency.setCellValue("หน่วยงานรับชำระ  :  "+ criteria.getMachinePaymentName());
		 agency.setCellStyle(txtCenterBor);
		 
		 Row row3 = sh.getRow(3);
		 Cell user = row3.getCell(0);
		 user.setCellValue("เจ้าหน้าที่  :  "+ criteria.getUser().concat(" ".concat(criteria.getFirstName().concat(" ".concat(criteria.getLastName())))));
		 user.setCellStyle(txtCenterBor);
		 

		 Row row4 = sh.getRow(rowServiceOther);
		 Cell service = row4.getCell(rowCellServiceOther);
		 service.setCellValue("บริการ :  "+serviceName);
		 if(CollectionUtils.isNotEmpty(result)) {if(Constants.Service.SERVICE_TYPE_IBACSS.equals(result.get(0).getServiceType())) {service.setCellStyle(txtCenterBor);}
		 else {service.setCellStyle(txtCenterHeadBor);}}else {service.setCellStyle(txtCenterBor);}
		 
		 int indexRow = 7;
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
				 Cell cell1Add = row.createCell(1);
				 Cell cell1 = row.createCell(2);
				 Cell cell2 = row.createCell(3);
				 Cell cell3 = row.createCell(4);
//				 Cell cell4 = row.createCell(5);
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
				 cell1Add.setCellValue(serviceName);
				 cell1.setCellValue(resultReportPayment.getReceiptNoManual());
				 cell2.setCellValue(resultReportPayment.getAccountSubNo());
				 
				 if(CollectionUtils.isNotEmpty(result)) {if(Constants.Service.SERVICE_TYPE_IBACSS.equals(result.get(0).getServiceType())) {cell3.setCellValue(resultReportPayment.getCustomerName());}
				 else {cell3.setCellValue(resultReportPayment.getDepartment());}}else {cell3.setCellValue("");}
				 
//				 cell4.setCellValue(resultReportPayment.getDepartment());
				 if(CollectionUtils.isNotEmpty(result)) {if(Constants.Service.SERVICE_TYPE_IBACSS.equals(result.get(0).getServiceType())) {cell5.setCellValue(resultReportPayment.getInvoiceNo());}
				 else {cell5.setCellValue(resultReportPayment.getServiceName());}}else {cell3.setCellValue("");}
				 
				 cell6.setCellValue(resultReportPayment.getPaymentMethod());
				 cell7.setCellValue(StringUtils.isNotBlank(resultReportPayment.getRefNo())?resultReportPayment.getRefNo():"");
//				 cell7.setCellValue(StringUtils.isNotBlank(resultReportPayment.getRefNoEx())?resultReportPayment.getRefNoEx():"");
				 cell8.setCellValue(String.format("%,.2f", resultReportPayment.getBeforVat()));
				 cell9.setCellValue(String.format("%,.2f", resultReportPayment.getVatAmount()));
				 cell10.setCellValue(String.format("%,.2f", resultReportPayment.getAmount()));
				 if("A".equals(resultReportPayment.getStatus())) {
					 cell11.setCellValue("-");
				 }else if("C".equals(resultReportPayment.getStatus())) {
					 cell11.setCellValue("ยกเลิก");
				 }
				 cell12.setCellValue(resultReportPayment.getCreateBy());
				 
				 // gen name surname
				 try {
					 UserBean userBean =  masterDataService.findByUsername(resultReportPayment.getCreateBy());
					 cell13.setCellValue(userBean.getSurName().concat(" ".concat(userBean.getLastName())));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				 
				 cell.setCellStyle(txtTableCenter);
				 cell1Add.setCellStyle(txtCenterTable);
				 cell1.setCellStyle(txtCenterTable);
				 cell2.setCellStyle(txtCenterTable);
				 cell3.setCellStyle(txtCenterTable);
//				 cell4.setCellStyle(txtCenterTable);
				 cell5.setCellStyle(txtCenterTable);
				 cell6.setCellStyle(txtTableCenter);
				 cell7.setCellStyle(txtTableCenter);
				 cell8.setCellStyle(txtCenterDecimalRight);
				 cell9.setCellStyle(txtCenterTableRight);
				 cell10.setCellStyle(txtCenterDecimalRight);
				 cell11.setCellStyle(txtTableCenter);
				 cell12.setCellStyle(txtTableCenter);
				 cell13.setCellStyle(txtTableCenter);
//				 String vatConverStr = resultReportPayment.getVatAmount()+"";
				 
				 if(Constants.Status.ACTIVE.equals(resultReportPayment.getStatus())) {
//					 if("0".equals(vatConverStr)) {
						 sumVat0 += resultReportPayment.getAmount().doubleValue() - resultReportPayment.getBeforVat().doubleValue();
//					 }else if("3".equals(vatConverStr)) {
//						 sumVat3 += resultReportPayment.getAmount().doubleValue() - resultReportPayment.getBeforVat().doubleValue();
//					 }else if("7".equals(vatConverStr)) {
//						 sumVat7 += resultReportPayment.getAmount().doubleValue() - resultReportPayment.getBeforVat().doubleValue();
//					 }
					 sumAllTotal += resultReportPayment.getAmount().doubleValue();
					 sumAllNoVat += resultReportPayment.getBeforVat().doubleValue();
				 }
				 
				 index++;
				 indexRow++;
			 }
		 }
		 
		 Row textTotalSummary = sh.createRow(indexRow);
//		 Cell cellTotalSummary = textTotalSummary.createCell(2);
//		 cellTotalSummary.setCellValue("ผลรวมทั้งหมด");
//		 cellTotalSummary.setCellStyle(txtCenterTable);
		 
		 Cell totalSummaryNoVat = textTotalSummary.createCell(8);
		 totalSummaryNoVat.setCellValue(String.format("%,.2f", sumAllNoVat));
		 totalSummaryNoVat.setCellStyle(txtCenterTable);
		 totalSummaryNoVat.setCellStyle(borderCell);
		 
		 Cell totalVat0 = textTotalSummary.createCell(9);
		 totalVat0.setCellValue(String.format("%,.2f", sumVat0));
		 totalVat0.setCellStyle(borderCell);
		 
		 Cell totalSummary = textTotalSummary.createCell(10);
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
	
	private String convertDateFormat(String dateFormat) throws ParseException {
//	    Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateFormat);
	    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateFormat);
//	    return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);
	    return new SimpleDateFormat("dd/MM/yyyy").format(date);
	}
	
	@SuppressWarnings("unused")
	private String convertTimeFormat(String dateFormat) throws ParseException {
	    Date date = new SimpleDateFormat("HH:mm:ss").parse(dateFormat);
	    return new SimpleDateFormat("HH:mm:ss").format(date);
	}
}
