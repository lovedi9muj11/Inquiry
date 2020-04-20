package th.co.maximus.service.report;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import th.co.maximus.auth.model.UserProfile;
import th.co.maximus.bean.HistoryPaymentRS;
import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.bean.ReportTaxRSBean;
import th.co.maximus.constants.Constants;
import th.co.maximus.model.UserBean;
import th.co.maximus.service.MasterDataService;

@Service("rptServiceFull")
public class RptServiceFull extends BaseExcelRptService{
	
//	@Autowired
//	private MasterDatasDao masterDatasDao;
	
	@Autowired
	MasterDataService masterDataService;

	
	protected Logger log = Logger.getLogger(getClass());
	Locale localeTH = new Locale("th", "TH");
	Locale localeEN = new Locale("en", "EN");
	SimpleDateFormat formate = new SimpleDateFormat("dd/MM/yyyy HH:mm", localeTH);
	SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy ", new Locale("th", "TH"));
	SimpleDateFormat formateEN = new SimpleDateFormat("dd/MM/yyyy", localeEN);
	SimpleDateFormat formateDateTH = new SimpleDateFormat("dd/MM/yyyy", localeTH);
	SimpleDateFormat formateDateEN = new SimpleDateFormat("dd/MM/yyyy", localeEN);
	SimpleDateFormat formateYearTH = new SimpleDateFormat("yyyy", localeTH);
	SimpleDateFormat formateHH = new SimpleDateFormat("HH:mm", localeTH);

	public Workbook getReport(Workbook workbook, List<HistoryPaymentRS> entity, HistoryReportBean bean) throws Exception{
//		SimpleDateFormat formatter2 = new SimpleDateFormat(Constants.DateTime.DATE_FORMAT, new Locale("th", "TH"));
		SimpleDateFormat formatter3 = new SimpleDateFormat(Constants.DateTime.DB_DATE_FORMAT, new Locale("th", "TH"));
		Font fontNormal = createFontTHSarabanPSK(workbook, 14, false);
		Font fontBold = createFontTHSarabanPSK(workbook, 14, true);
//		CellStyle txtLeftBor = createCellStyleForTextLeftBorder(workbook, fontNormal, true);
//		CellStyle txtLeftNoBor = createStyleCellLeft(workbook, fontBold, false);
		CellStyle txtCentertNoBor = createStyleCellCenter(workbook, fontBold, false);
		CellStyle txtRightNoBor = createStyleCellRight(workbook, fontBold, false);
		CellStyle txtLeft = createCellStyleForTextLeft(workbook, fontNormal, true);
		CellStyle numRightBor = createCellStyleForNumberTwoDecimalBorder(workbook, fontNormal);
		CellStyle txtCenter = createCellStyleForTextCenter(workbook, fontNormal, true);
		CellStyle summary = createCellStyleForTextRightBorderBgGrey25Percent(workbook, fontBold, true);
		CellStyle summaryBorder = createCellStyleForTextRightBorderBgGrey25PercentBorder(workbook, fontBold, true);
		UserProfile profile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String date = formateDateEN.format(new Date());
		String time = formateHH.format(new Date());
		
		BigDecimal vat7 = BigDecimal.ZERO;
		BigDecimal vat72 = BigDecimal.ZERO;
		BigDecimal vat73 = BigDecimal.ZERO;
		
		BigDecimal vat0 = BigDecimal.ZERO;
		BigDecimal vat02 = BigDecimal.ZERO;
		BigDecimal vat03 = BigDecimal.ZERO;
		
		BigDecimal vat10 = BigDecimal.ZERO;
		BigDecimal vat102 = BigDecimal.ZERO;
		BigDecimal vat103 = BigDecimal.ZERO;
		
		BigDecimal vat8 = BigDecimal.ZERO;
		BigDecimal vat82 = BigDecimal.ZERO;
		BigDecimal vat83 = BigDecimal.ZERO;
		
//		String nameBranch = masterDatasDao.findByKey(branArea).getValue();
		
		int rowNumHead = 1;

		Sheet sh = workbook.getSheetAt(0);
//		Header header = sh.getHeader();
//		header.setCenter(sh.getHeader().getCenter().concat("ประจำวันที่ "+" ").concat((formatter2.format(formatter3.parse(bean.getDateFrom())))).concat("ถึงวันที่".concat(" ").concat(""+formatter2.format(formatter3.parse(bean.getDateTo())))));
//		header.setLeft(sh.getHeader().getLeft().concat(nameBranch.replace(Constants.Service.CENTER_SERVICE, Constants.Service.CENTER_SERVICE_)).concat("\n").concat("เจ้าหน้าที่ : ")+nameBranch.replace(Constants.Service.CENTER_SERVICE, Constants.Service.CENTER_SERVICE_));
//		header.setRight(sh.getHeader().getRight().concat(date+" "+time));

		Footer footer = sh.getFooter();
		footer.setCenter(sh.getFooter().getCenter());
//		footer.setLeft(sh.getFooter().getLeft().concat(StringUtils.isNotBlank(bean.getCustName()) ? bean.getCustName():""));
//		footer.setRight(sh.getFooter().getRight().concat(StringUtils.isNotBlank(bean.getCustName()) ? bean.getCustName() :""));
		
		Row rowHead = sh.createRow(rowNumHead++);
		Cell cellH1 = rowHead.createCell(0);
		cellH1.setCellValue(("ระหว่างวันที่  "+" ").concat((formatter2.format(formatter3.parse(bean.getDateFrom())).concat(" "+bean.getDateFromHour()).concat(":"+bean.getDateFromMinute()))).concat(" ถึงวันที่".concat(" ").concat(""+formatter2.format(formatter3.parse(bean.getDateTo()))).concat(" "+bean.getDateToHour()).concat(":"+bean.getDateToMinute())));
		cellH1.setCellStyle(txtCentertNoBor);
		rowNumHead++;
		Row rowHead2 = sh.createRow(rowNumHead++);
//		Cell cellH2 = rowHead2.createCell(0);
//		cellH2.setCellValue("หน่วยงานรับชำระ : ".concat((nameBranch.replace(Constants.Service.CENTER_SERVICE, Constants.Service.CENTER_SERVICE_))));
//		cellH2.setCellStyle(txtLeftNoBor);
		Cell cellH22 = rowHead2.createCell(11);
		cellH22.setCellValue("วันเวลาพิมพ์  : ".concat(date+" "+time));
		cellH22.setCellStyle(txtRightNoBor);
		
//		Row rowHead3 = sh.createRow(rowNumHead++);
//		Cell cellH3 = rowHead3.createCell(0);
//		cellH3.setCellValue(("สาขาที่ : ")+nameBranch.replace(Constants.Service.CENTER_SERVICE, Constants.Service.CENTER_SERVICE_));
//		cellH3.setCellStyle(txtLeftNoBor);
		int rowNum = 7;

		if (CollectionUtils.isNotEmpty(entity)) {
			for(int i=0; i<entity.size(); i++) {
				
				if(Constants.Status.ACTIVE.equals(entity.get(i).getRecordStatus())) {
					if(7 == entity.get(i).getVatRate()) {
						vat7 = vat7.add(entity.get(i).getBeforeVat()==null?BigDecimal.ZERO:entity.get(i).getBeforeVat());
						vat72 = vat72.add(entity.get(i).getVat()==null?BigDecimal.ZERO:entity.get(i).getVat());
						vat73 = vat73.add(entity.get(i).getAmount()==null?BigDecimal.ZERO:entity.get(i).getAmount());
					}else if(0 == entity.get(i).getVatRate()) {
						vat0 = vat0.add(entity.get(i).getBeforeVat()==null?BigDecimal.ZERO:entity.get(i).getBeforeVat());
						vat02 = vat02.add(entity.get(i).getVat()==null?BigDecimal.ZERO:entity.get(i).getVat());
						vat03 = vat03.add(entity.get(i).getAmount()==null?BigDecimal.ZERO:entity.get(i).getAmount());
					}else if(10 == entity.get(i).getVatRate()) {
						vat10 = vat10.add(entity.get(i).getBeforeVat()==null?BigDecimal.ZERO:entity.get(i).getBeforeVat());
						vat102 = vat102.add(entity.get(i).getVat()==null?BigDecimal.ZERO:entity.get(i).getVat());
						vat103 = vat103.add(entity.get(i).getAmount()==null?BigDecimal.ZERO:entity.get(i).getAmount());
					}else if(8 == entity.get(i).getVatRate()) {
						vat8 = vat8.add(entity.get(i).getBeforeVat()==null?BigDecimal.ZERO:entity.get(i).getBeforeVat());
						vat82 = vat82.add(entity.get(i).getVat()==null?BigDecimal.ZERO:entity.get(i).getVat());
						vat83 = vat83.add(entity.get(i).getAmount()==null?BigDecimal.ZERO:entity.get(i).getAmount());
					}
				}
		
				Row row1 = sh.createRow(rowNum++);
				Cell cell1 = row1.createCell(0);
				Cell cell2 = row1.createCell(1);
				Cell cell3 = row1.createCell(2);
				Cell cell4 = row1.createCell(3);
				Cell cell5 = row1.createCell(4);
				Cell cell6 = row1.createCell(5);
				Cell cell7 = row1.createCell(6);
				Cell cell8 = row1.createCell(7);
				Cell cell9 = row1.createCell(8);
				Cell cell10 = row1.createCell(9);
				Cell cell11 = row1.createCell(10);
				Cell cell12 = row1.createCell(11);
				Cell cell13 = row1.createCell(12);
				Cell cell14 = row1.createCell(13);
				
				cell1.setCellValue(i+1);
				cell2.setCellValue(formateDateEN.format(entity.get(i).getDocumentDate()).toString());
				cell3.setCellValue(entity.get(i).getDocumentNo());
				cell4.setCellValue(entity.get(i).getCustName());
				cell5.setCellValue(entity.get(i).getTaxId());
				cell6.setCellValue(entity.get(i).getBranCode().equals("00000") ? "สำนักงานใหญ่" : entity.get(i).getBranCode());
//				cell6.setCellValue(entity.get(i).getBranCode());
				cell7.setCellValue(new Double((entity.get(i).getAmount()==null?BigDecimal.ZERO:entity.get(i).getAmount().subtract(entity.get(i).getVatAmount()==null?BigDecimal.ZERO:entity.get(i).getVatAmount())).toString()));
				cell8.setCellValue(new Double((entity.get(i).getVatAmount()==null?BigDecimal.ZERO:entity.get(i).getVatAmount()).toString()));
				cell9.setCellValue(new Double((entity.get(i).getAmount()==null?BigDecimal.ZERO:entity.get(i).getAmount()).toString()));
				cell10.setCellValue(Constants.Status.ACTIVE.equals(entity.get(i).getRecordStatus())?Constants.Status.ACTIVE_:Constants.Status.ACTIVE_C);
				cell11.setCellValue(profile.getBranchArea());
				cell12.setCellValue(masterDataService.findByKeyCode(profile.getBranchArea()).getValue());
				cell13.setCellValue(entity.get(i).getCreateBy());
				
				// gen name surname
				 try {
					 UserBean userBean =  masterDataService.findByUsername(entity.get(i).getCreateBy());
					 cell14.setCellValue(userBean.getSurName().concat(" ".concat(userBean.getLastName())));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				cell1.setCellStyle(txtCenter);
				cell2.setCellStyle(txtLeft);
				cell3.setCellStyle(txtLeft);
				cell4.setCellStyle(txtLeft);
				cell5.setCellStyle(txtLeft);
				cell6.setCellStyle(txtLeft);
				cell7.setCellStyle(numRightBor);
				cell8.setCellStyle(numRightBor);
				cell9.setCellStyle(numRightBor);
				cell10.setCellStyle(txtLeft);
				cell11.setCellStyle(txtLeft);
				cell12.setCellStyle(txtLeft);
				cell13.setCellStyle(txtLeft);
				cell14.setCellStyle(txtLeft);
				
			}
//			rowNum++;
//			Row sumRow = sh.createRow(rowNum);
//			Cell sumCell1 = sumRow.createCell(0);
//			Cell sumCell2 = sumRow.createCell(1);
//			Cell sumCell3 = sumRow.createCell(2);
//			Cell sumCell4 = sumRow.createCell(3);
//			Cell sumCell5 = sumRow.createCell(4);
//			Cell sumCell6 = sumRow.createCell(5);
//			Cell sumCell7 = sumRow.createCell(6);
//			Cell sumCell8 = sumRow.createCell(7);
//			Cell sumCell9 = sumRow.createCell(8);
//			Cell sumCell10 = sumRow.createCell(9);
//			Cell sumCell11 = sumRow.createCell(10);
//			Cell sumCell12 = sumRow.createCell(11);
//			Cell sumCell13 = sumRow.createCell(12);
//			Cell sumCell14 = sumRow.createCell(13);
//			
//			sumCell1.setCellValue("รวมตาม UserID");
//			sumCell2.setCellValue("");
//			sumCell3.setCellValue("");
//			sumCell4.setCellValue("");
//			sumCell5.setCellValue("");
//			sumCell6.setCellValue("");
//			sumCell7.setCellValue("");
//			sumCell8.setCellValue("");
//			sumCell9.setCellValue("");
//			sumCell10.setCellValue("");
//			sumCell11.setCellValue("");
//			sumCell12.setCellValue("");
//			sumCell13.setCellValue("");
//			sumCell14.setCellValue("");
//			
//			sumCell1.setCellStyle(summary);
//			sumCell2.setCellStyle(summary);
//			sumCell3.setCellStyle(summary);
//			sumCell4.setCellStyle(summary);
//			sumCell5.setCellStyle(summary);
//			sumCell6.setCellStyle(summary);
//			sumCell7.setCellStyle(summary);
//			sumCell8.setCellStyle(summary);
//			sumCell9.setCellStyle(summary);
//			sumCell10.setCellStyle(summary);
//			sumCell11.setCellStyle(summary);
//			sumCell12.setCellStyle(summary);
//			sumCell13.setCellStyle(summary);
//			sumCell14.setCellStyle(summaryBorder);
//			
//			CellRangeAddress mergedCell = new CellRangeAddress(rowNum, rowNum, 0, 1);
//			borderMergs(mergedCell, sh, workbook);
//			
//			if(vat10 != BigDecimal.ZERO) {
//				rowNum++;
//				Row sumRow1 = sh.createRow(rowNum);
//				Cell sumCell21 = sumRow1.createCell(0);
//				Cell sumCell22 = sumRow1.createCell(1);
//				Cell sumCell23 = sumRow1.createCell(2);
//				Cell sumCell24 = sumRow1.createCell(3);
//				Cell sumCell25 = sumRow1.createCell(4);
//				Cell sumCell26 = sumRow1.createCell(5);
//				Cell sumCell27 = sumRow1.createCell(6);
//				Cell sumCell28 = sumRow1.createCell(7);
//				Cell sumCell29 = sumRow1.createCell(8);
//				Cell sumCell210 = sumRow1.createCell(9);
//				Cell sumCell211 = sumRow1.createCell(10);
//				Cell sumCell212 = sumRow1.createCell(11);
//				Cell sumCell213 = sumRow1.createCell(12);
//				Cell sumCell214 = sumRow1.createCell(13);
//				
//				sumCell21.setCellValue("รวมอัตรา 10%");
//				sumCell22.setCellValue("");
//				sumCell23.setCellValue("");
//				sumCell24.setCellValue("");
//				sumCell25.setCellValue("");
//				sumCell26.setCellValue("");
//				sumCell27.setCellFormula(vat10.toString());
//				sumCell28.setCellFormula(vat102.toString());
//				sumCell29.setCellFormula(vat103.toString());
//				sumCell210.setCellValue("");
//				sumCell211.setCellValue("");
//				sumCell212.setCellValue("");
//				sumCell213.setCellValue("");
//				sumCell214.setCellValue("");
//				
//				sumCell21.setCellStyle(summary);
//				sumCell22.setCellStyle(summary);
//				sumCell23.setCellStyle(summary);
//				sumCell24.setCellStyle(summary);
//				sumCell25.setCellStyle(summary);
//				sumCell26.setCellStyle(summary);
//				sumCell27.setCellStyle(numRightBor);
//				sumCell28.setCellStyle(numRightBor);
//				sumCell29.setCellStyle(numRightBor);
//				sumCell210.setCellStyle(summary);
//				sumCell211.setCellStyle(summaryBorder);
//				sumCell212.setCellStyle(summaryBorder);
//				sumCell213.setCellStyle(summaryBorder);
//				sumCell214.setCellStyle(summaryBorder);
//				
//				CellRangeAddress mergedCell1 = new CellRangeAddress(rowNum, rowNum, 0, 1);
//				borderMergs(mergedCell1, sh, workbook);
//			}
//			
//			if(vat8 != BigDecimal.ZERO) {
//				rowNum++;
//				Row sumRow1 = sh.createRow(rowNum);
//				Cell sumCell21 = sumRow1.createCell(0);
//				Cell sumCell22 = sumRow1.createCell(1);
//				Cell sumCell23 = sumRow1.createCell(2);
//				Cell sumCell24 = sumRow1.createCell(3);
//				Cell sumCell25 = sumRow1.createCell(4);
//				Cell sumCell26 = sumRow1.createCell(5);
//				Cell sumCell27 = sumRow1.createCell(6);
//				Cell sumCell28 = sumRow1.createCell(7);
//				Cell sumCell29 = sumRow1.createCell(8);
//				Cell sumCell210 = sumRow1.createCell(9);
//				Cell sumCell211 = sumRow1.createCell(10);
//				Cell sumCell212 = sumRow1.createCell(11);
//				Cell sumCell213 = sumRow1.createCell(12);
//				Cell sumCell214 = sumRow1.createCell(13);
//				
//				sumCell21.setCellValue("รวมอัตรา 8%");
//				sumCell22.setCellValue("");
//				sumCell23.setCellValue("");
//				sumCell24.setCellValue("");
//				sumCell25.setCellValue("");
//				sumCell26.setCellValue("");
//				sumCell27.setCellFormula(vat8.toString());
//				sumCell28.setCellFormula(vat82.toString());
//				sumCell29.setCellFormula(vat83.toString());
//				sumCell210.setCellValue("");
//				sumCell211.setCellValue("");
//				sumCell212.setCellValue("");
//				sumCell213.setCellValue("");
//				sumCell214.setCellValue("");
//				
//				sumCell21.setCellStyle(summary);
//				sumCell22.setCellStyle(summary);
//				sumCell23.setCellStyle(summary);
//				sumCell24.setCellStyle(summary);
//				sumCell25.setCellStyle(summary);
//				sumCell26.setCellStyle(summary);
//				sumCell27.setCellStyle(numRightBor);
//				sumCell28.setCellStyle(numRightBor);
//				sumCell29.setCellStyle(numRightBor);
//				sumCell210.setCellStyle(summary);
//				sumCell211.setCellStyle(summaryBorder);
//				sumCell212.setCellStyle(summaryBorder);
//				sumCell213.setCellStyle(summaryBorder);
//				sumCell214.setCellStyle(summaryBorder);
//				
//				CellRangeAddress mergedCell1 = new CellRangeAddress(rowNum, rowNum, 0, 1);
//				borderMergs(mergedCell1, sh, workbook);
//			}
//			
//			if(vat7 != BigDecimal.ZERO) {
//				rowNum++;
//				Row sumRow1 = sh.createRow(rowNum);
//				Cell sumCell21 = sumRow1.createCell(0);
//				Cell sumCell22 = sumRow1.createCell(1);
//				Cell sumCell23 = sumRow1.createCell(2);
//				Cell sumCell24 = sumRow1.createCell(3);
//				Cell sumCell25 = sumRow1.createCell(4);
//				Cell sumCell26 = sumRow1.createCell(5);
//				Cell sumCell27 = sumRow1.createCell(6);
//				Cell sumCell28 = sumRow1.createCell(7);
//				Cell sumCell29 = sumRow1.createCell(8);
//				Cell sumCell210 = sumRow1.createCell(9);
//				Cell sumCell211 = sumRow1.createCell(10);
//				Cell sumCell212 = sumRow1.createCell(11);
//				Cell sumCell213 = sumRow1.createCell(12);
//				Cell sumCell214 = sumRow1.createCell(13);
//				
//				sumCell21.setCellValue("รวมอัตรา 7%");
//				sumCell22.setCellValue("");
//				sumCell23.setCellValue("");
//				sumCell24.setCellValue("");
//				sumCell25.setCellValue("");
//				sumCell26.setCellValue("");
//				sumCell27.setCellFormula(vat7.toString());
//				sumCell28.setCellFormula(vat72.toString());
//				sumCell29.setCellFormula(vat73.toString());
//				sumCell210.setCellValue("");
//				sumCell211.setCellValue("");
//				sumCell212.setCellValue("");
//				sumCell213.setCellValue("");
//				sumCell214.setCellValue("");
//				
//				sumCell21.setCellStyle(summary);
//				sumCell22.setCellStyle(summary);
//				sumCell23.setCellStyle(summary);
//				sumCell24.setCellStyle(summary);
//				sumCell25.setCellStyle(summary);
//				sumCell26.setCellStyle(summary);
//				sumCell27.setCellStyle(numRightBor);
//				sumCell28.setCellStyle(numRightBor);
//				sumCell29.setCellStyle(numRightBor);
//				sumCell210.setCellStyle(summary);
//				sumCell211.setCellStyle(summaryBorder);
//				sumCell212.setCellStyle(summaryBorder);
//				sumCell213.setCellStyle(summaryBorder);
//				sumCell214.setCellStyle(summaryBorder);
//				
//				CellRangeAddress mergedCell1 = new CellRangeAddress(rowNum, rowNum, 0, 1);
//				borderMergs(mergedCell1, sh, workbook);
//			}
//			
//			if(vat0 != BigDecimal.ZERO) {
//				rowNum++;
//				Row sumRow2 = sh.createRow(rowNum);
//				Cell sumCell31 = sumRow2.createCell(0);
//				Cell sumCell32 = sumRow2.createCell(1);
//				Cell sumCell33 = sumRow2.createCell(2);
//				Cell sumCell34 = sumRow2.createCell(3);
//				Cell sumCell35 = sumRow2.createCell(4);
//				Cell sumCell36 = sumRow2.createCell(5);
//				Cell sumCell37 = sumRow2.createCell(6);
//				Cell sumCell38 = sumRow2.createCell(7);
//				Cell sumCell39 = sumRow2.createCell(8);
//				Cell sumCell310 = sumRow2.createCell(9);
//				Cell sumCell311 = sumRow2.createCell(10);
//				Cell sumCell312 = sumRow2.createCell(11);
//				Cell sumCell313 = sumRow2.createCell(12);
//				Cell sumCell314 = sumRow2.createCell(13);
//				
//				sumCell31.setCellValue("รวมอัตรา 0%");
//				sumCell32.setCellValue("");
//				sumCell33.setCellValue("");
//				sumCell34.setCellValue("");
//				sumCell35.setCellValue("");
//				sumCell36.setCellValue("");
//				sumCell37.setCellFormula(vat0.toString());
//				sumCell38.setCellFormula(vat02.toString());
//				sumCell39.setCellFormula(vat03.toString());
//				sumCell310.setCellValue("");
//				sumCell311.setCellValue("");
//				sumCell312.setCellValue("");
//				sumCell313.setCellValue("");
//				sumCell314.setCellValue("");
//				
//				sumCell31.setCellStyle(summary);
//				sumCell32.setCellStyle(summary);
//				sumCell33.setCellStyle(summary);
//				sumCell34.setCellStyle(summary);
//				sumCell35.setCellStyle(summary);
//				sumCell36.setCellStyle(summary);
//				sumCell37.setCellStyle(numRightBor);
//				sumCell38.setCellStyle(numRightBor);
//				sumCell39.setCellStyle(numRightBor);
//				sumCell310.setCellStyle(summary);
//				sumCell311.setCellStyle(summaryBorder);
//				sumCell312.setCellStyle(summaryBorder);
//				sumCell313.setCellStyle(summaryBorder);
//				sumCell314.setCellStyle(summaryBorder);
//				
//				CellRangeAddress mergedCell2 = new CellRangeAddress(rowNum, rowNum, 0, 1);
//				borderMergs(mergedCell2, sh, workbook);
//			}
//			
//			rowNum+=2;
//			Row sumRow3 = sh.createRow(rowNum);
//			Cell sumCell41 = sumRow3.createCell(0);
//			Cell sumCell42 = sumRow3.createCell(1);
//			Cell sumCell43 = sumRow3.createCell(2);
//			Cell sumCell44 = sumRow3.createCell(3);
//			Cell sumCell45 = sumRow3.createCell(4);
//			Cell sumCell46 = sumRow3.createCell(5);
//			Cell sumCell47 = sumRow3.createCell(6);
//			Cell sumCell48 = sumRow3.createCell(7);
//			Cell sumCell49 = sumRow3.createCell(8);
//			Cell sumCell410 = sumRow3.createCell(9);
//			Cell sumCell411 = sumRow3.createCell(10);
//			Cell sumCell412 = sumRow3.createCell(11);
//			Cell sumCell413 = sumRow3.createCell(12);
//			Cell sumCell414 = sumRow3.createCell(13);
//			
//			sumCell41.setCellValue("รวมทั้งสิ้น");
//			sumCell42.setCellValue("");
//			sumCell43.setCellValue("");
//			sumCell44.setCellValue("");
//			sumCell45.setCellValue("");
//			sumCell46.setCellValue("");
//			sumCell47.setCellFormula("SUM(G"+(rowNum)+":G"+(rowNum-3)+")");
//			sumCell48.setCellFormula("SUM(H"+(rowNum)+":H"+(rowNum-3)+")");
//			sumCell49.setCellFormula("SUM(I"+(rowNum)+":I"+(rowNum-3)+")");
//			sumCell410.setCellValue("");
//			sumCell411.setCellValue("");
//			sumCell412.setCellValue("");
//			sumCell413.setCellValue("");
//			sumCell414.setCellValue("");
//			
//			sumCell41.setCellStyle(summary);
//			sumCell42.setCellStyle(summary);
//			sumCell43.setCellStyle(summary);
//			sumCell44.setCellStyle(summary);
//			sumCell45.setCellStyle(summary);
//			sumCell46.setCellStyle(summary);
//			sumCell47.setCellStyle(numRightBor);
//			sumCell48.setCellStyle(numRightBor);
//			sumCell49.setCellStyle(numRightBor);
//			sumCell410.setCellStyle(summary);
//			sumCell411.setCellStyle(summaryBorder);
//			sumCell412.setCellStyle(summaryBorder);
//			sumCell413.setCellStyle(summaryBorder);
//			sumCell414.setCellStyle(summaryBorder);
//			
//			CellRangeAddress mergedCell3 = new CellRangeAddress(rowNum, rowNum, 0, 1);
//			borderMergs(mergedCell3, sh, workbook);
		}
		return workbook;
	}
	
	public Workbook getReportNotFull(Workbook workbook, List<HistoryPaymentRS> entity, HistoryReportBean bean, List<ReportTaxRSBean> rsBeans) throws Exception{
		SimpleDateFormat formatter3 = new SimpleDateFormat(Constants.DateTime.DB_DATE_FORMAT, new Locale("th", "TH"));
		Font fontNormal = createFontTHSarabanPSK(workbook, 14, false);
		Font fontBold = createFontTHSarabanPSK(workbook, 14, true);
		CellStyle txtCentertNoBor = createStyleCellCenter(workbook, fontBold, false);
		CellStyle txtRightNoBor = createStyleCellRight(workbook, fontBold, false);
		CellStyle txtLeft = createCellStyleForTextLeft(workbook, fontNormal, true);
		CellStyle numRightBor = createCellStyleForNumberTwoDecimalBorder(workbook, fontNormal);
		CellStyle txtCenter = createCellStyleForTextCenter(workbook, fontNormal, true);
		UserProfile profile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String date = formateDateEN.format(new Date());
		String time = formateHH.format(new Date());
		
		int rowNumHead = 1;
		
		Sheet sh = workbook.getSheetAt(0);
//		Header header = sh.getHeader();
//		header.setCenter(sh.getHeader().getCenter().concat("ประจำวันที่ "+" ").concat((formatter2.format(formatter3.parse(bean.getDateFrom())))).concat("ถึงวันที่".concat(" ").concat(""+formatter2.format(formatter3.parse(bean.getDateTo())))));
//		header.setLeft(sh.getHeader().getLeft().concat(nameBranch.replace(Constants.Service.CENTER_SERVICE, Constants.Service.CENTER_SERVICE_)).concat("\n").concat("เจ้าหน้าที่ : ")+nameBranch.replace(Constants.Service.CENTER_SERVICE, Constants.Service.CENTER_SERVICE_));
//		header.setRight(sh.getHeader().getRight().concat(date+" "+time));
		
		Footer footer = sh.getFooter();
		footer.setCenter(sh.getFooter().getCenter());
//		footer.setLeft(sh.getFooter().getLeft().concat(StringUtils.isNotBlank(bean.getCustName()) ? bean.getCustName():""));
//		footer.setRight(sh.getFooter().getRight().concat(StringUtils.isNotBlank(bean.getCustName()) ? bean.getCustName() :""));
		
		Row rowHead = sh.createRow(rowNumHead++);
		Cell cellH1 = rowHead.createCell(0);
		cellH1.setCellValue(("ระหว่างวันที่  "+" ").concat((formatter2.format(formatter3.parse(bean.getDateFrom())).concat(" "+bean.getDateFromHour()).concat(":"+bean.getDateFromMinute()))).concat(" ถึงวันที่".concat(" ").concat(""+formatter2.format(formatter3.parse(bean.getDateTo()))).concat(" "+bean.getDateToHour()).concat(":"+bean.getDateToMinute())));
		cellH1.setCellStyle(txtCentertNoBor);
		rowNumHead++;
		Row rowHead2 = sh.createRow(rowNumHead++);
//		Cell cellH2 = rowHead2.createCell(0);
//		cellH2.setCellValue("หน่วยงานรับชำระ : ".concat((nameBranch.replace(Constants.Service.CENTER_SERVICE, Constants.Service.CENTER_SERVICE_))));
//		cellH2.setCellStyle(txtLeftNoBor);
		Cell cellH22 = rowHead2.createCell(11);
		cellH22.setCellValue("วันเวลาพิมพ์  : ".concat(date+" "+time));
		cellH22.setCellStyle(txtRightNoBor);
		
//		Row rowHead3 = sh.createRow(rowNumHead++);
//		Cell cellH3 = rowHead3.createCell(0);
//		cellH3.setCellValue(("สาขาที่ : ")+nameBranch.replace(Constants.Service.CENTER_SERVICE, Constants.Service.CENTER_SERVICE_));
//		cellH3.setCellStyle(txtLeftNoBor);
		int rowNum = 7;
		
		if (CollectionUtils.isNotEmpty(rsBeans)) {
			for(int i=0; i<rsBeans.size(); i++) {
				
				Row row1 = sh.createRow(rowNum++);
				Cell cell1 = row1.createCell(0);
				Cell cell2 = row1.createCell(1);
				Cell cell3 = row1.createCell(2);
				Cell cell4 = row1.createCell(3);
				Cell cell5 = row1.createCell(4);
				Cell cell6 = row1.createCell(5);
				Cell cell7 = row1.createCell(6);
				Cell cell8 = row1.createCell(7);
				Cell cell9 = row1.createCell(8);
				Cell cell10 = row1.createCell(9);
				Cell cell11 = row1.createCell(10);
				Cell cell12 = row1.createCell(11);
				Cell cell13 = row1.createCell(12);
				Cell cell14 = row1.createCell(13);
				
				cell1.setCellValue(i+1);
				cell2.setCellValue(formateDateEN.format(entity.get(i).getDocumentDate()).toString());
				cell3.setCellValue(rsBeans.get(i).getPosName());
				cell4.setCellValue(rsBeans.get(i).getBranchCode());
				cell5.setCellValue(rsBeans.get(i).getBranchArea());
				cell6.setCellValue(masterDataService.findByKeyCode(rsBeans.get(i).getBranchArea()).getValue());
				cell7.setCellValue(rsBeans.get(i).getUserName());
				
				UserBean user = masterDataService.findByUsername(rsBeans.get(i).getUserName());
				cell8.setCellValue(user.getSurName().concat(" ").concat(user.getLastName()));
				cell9.setCellValue(rsBeans.get(i).getQuantity());
				cell10.setCellValue(rsBeans.get(i).getFrom());
				cell11.setCellValue(rsBeans.get(i).getTo());
				cell12.setCellValue(new Double((rsBeans.get(i).getBeforeVat()==null?BigDecimal.ZERO:rsBeans.get(i).getBeforeVat()).toString()));
				cell13.setCellValue(new Double((rsBeans.get(i).getVat()==null?BigDecimal.ZERO:rsBeans.get(i).getVat()).toString()));
				cell14.setCellValue(new Double((rsBeans.get(i).getPaidAmount()==null?BigDecimal.ZERO:rsBeans.get(i).getPaidAmount()).toString()));
				
				cell1.setCellStyle(txtCenter);
				cell2.setCellStyle(txtLeft);
				cell3.setCellStyle(txtLeft);
				cell4.setCellStyle(txtLeft);
				cell5.setCellStyle(txtLeft);
				cell6.setCellStyle(txtLeft);
				cell7.setCellStyle(txtLeft);
				cell8.setCellStyle(txtLeft);
				cell9.setCellStyle(numRightBor);
				cell10.setCellStyle(txtLeft);
				cell11.setCellStyle(txtLeft);
				cell12.setCellStyle(numRightBor);
				cell13.setCellStyle(numRightBor);
				cell14.setCellStyle(numRightBor);
				
			}
		}
		return workbook;
	}

}