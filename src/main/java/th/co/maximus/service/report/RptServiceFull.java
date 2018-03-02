package th.co.maximus.service.report;

import java.math.BigDecimal;
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
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.HistoryPaymentRS;
import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.constants.Constants;

@Service("rptServiceFull")
public class RptServiceFull extends BaseExcelRptService{
	
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
		SimpleDateFormat formatter2 = new SimpleDateFormat(Constants.DateTime.DATE_FORMAT, new Locale("th", "TH"));
		SimpleDateFormat formatter3 = new SimpleDateFormat(Constants.DateTime.DB_DATE_FORMAT, new Locale("th", "TH"));
		Font fontNormal = createFontTHSarabanPSK(workbook, 14, false);
		Font fontBold = createFontTHSarabanPSK(workbook, 14, true);
		CellStyle txtLeftBor = createCellStyleForTextLeftBorder(workbook, fontNormal, true);
		CellStyle txtCenterBor = createCellStyleForTextCenterBorder(workbook, fontNormal, true);
		CellStyle summary = createCellStyleForTextRightBorderBgGrey25Percent(workbook, fontBold, true);

		String date = formatter2.format(new Date());
		String time = formateHH.format(new Date());

		Sheet sh = workbook.getSheetAt(0);
		Header header = sh.getHeader();
		header.setCenter(sh.getHeader().getCenter().concat("ประจำวันที่ "+" ").concat((formatter2.format(formatter3.parse(bean.getDateFrom()))+" ").concat("ถึงวันที่".concat(" ").concat(""+formatter2.format(formatter3.parse(bean.getDateTo()))))));
		header.setLeft(sh.getHeader().getLeft().concat("xxx").concat("\n").concat("หน่วยงานรับชำระ : ").concat("\n").concat("เจ้าหน้าที่ : "));
		header.setRight(sh.getHeader().getRight().concat(date+" "+time));

		Footer footer = sh.getFooter();
		footer.setCenter(sh.getFooter().getCenter());
//		footer.setLeft(sh.getFooter().getLeft().concat(StringUtils.isNotBlank(bean.getCustName()) ? bean.getCustName():""));
//		footer.setRight(sh.getFooter().getRight().concat(StringUtils.isNotBlank(bean.getCustName()) ? bean.getCustName() :""));
		
		int rowNum = 1;

		if (CollectionUtils.isNotEmpty(entity)) {
			for(int i=0; i<entity.size(); i++) {
		
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
				
				cell1.setCellValue(i+1);
				cell2.setCellValue(entity.get(i).getDocumentDate().toString());
				cell3.setCellValue(entity.get(i).getDocumentNo());
				cell4.setCellValue(entity.get(i).getCustName());
				cell5.setCellValue(entity.get(i).getTaxId());
				cell6.setCellValue(entity.get(i).getBranCode());
				cell7.setCellValue(new Double((entity.get(i).getBeforeVat()==null?BigDecimal.ZERO:entity.get(i).getBeforeVat()).toString()));
				cell8.setCellValue(new Double((entity.get(i).getVat()==null?BigDecimal.ZERO:entity.get(i).getVat()).toString()));
				cell9.setCellValue(new Double((entity.get(i).getPaidAmount()==null?BigDecimal.ZERO:entity.get(i).getPaidAmount()).toString()));
				cell10.setCellValue(Constants.Status.ACTIVE.equals(entity.get(i).getRecordStatus())?Constants.Status.ACTIVE_A:Constants.Status.ACTIVE_C);
				
				cell1.setCellStyle(txtCenterBor);
				cell2.setCellStyle(txtLeftBor);
				cell3.setCellStyle(txtLeftBor);
				cell4.setCellStyle(txtLeftBor);
				cell5.setCellStyle(txtLeftBor);
				cell6.setCellStyle(txtLeftBor);
				cell7.setCellStyle(txtLeftBor);
				cell8.setCellStyle(txtLeftBor);
				cell9.setCellStyle(txtLeftBor);
				cell10.setCellStyle(txtLeftBor);
				
			}
			rowNum++;
			Row sumRow = sh.createRow(rowNum);
			Cell sumCell1 = sumRow.createCell(0);
			Cell sumCell2 = sumRow.createCell(1);
			Cell sumCell3 = sumRow.createCell(2);
			Cell sumCell4 = sumRow.createCell(3);
			Cell sumCell5 = sumRow.createCell(4);
			Cell sumCell6 = sumRow.createCell(5);
			Cell sumCell7 = sumRow.createCell(6);
			Cell sumCell8 = sumRow.createCell(7);
			Cell sumCell9 = sumRow.createCell(8);
			Cell sumCell10 = sumRow.createCell(9);
			
			sumCell1.setCellValue("รวมตาม UserID");
			sumCell2.setCellValue("");
			sumCell3.setCellValue("");
			sumCell4.setCellValue("");
			sumCell5.setCellValue("");
			sumCell6.setCellValue("");
			sumCell7.setCellValue("");
			sumCell8.setCellValue("");
			sumCell9.setCellValue("");
			sumCell10.setCellValue("");
			
			sumCell1.setCellStyle(summary);
			sumCell2.setCellStyle(summary);
			sumCell3.setCellStyle(summary);
			sumCell4.setCellStyle(summary);
			sumCell5.setCellStyle(summary);
			sumCell6.setCellStyle(summary);
			sumCell7.setCellStyle(summary);
			sumCell8.setCellStyle(summary);
			sumCell9.setCellStyle(summary);
			sumCell10.setCellStyle(summary);
			
			CellRangeAddress mergedCell = new CellRangeAddress(rowNum, rowNum, 0, 1);
			borderMergs(mergedCell, sh, workbook);
			
			rowNum++;
			Row sumRow1 = sh.createRow(rowNum);
			Cell sumCell21 = sumRow1.createCell(0);
			Cell sumCell22 = sumRow1.createCell(1);
			Cell sumCell23 = sumRow1.createCell(2);
			Cell sumCell24 = sumRow1.createCell(3);
			Cell sumCell25 = sumRow1.createCell(4);
			Cell sumCell26 = sumRow1.createCell(5);
			Cell sumCell27 = sumRow1.createCell(6);
			Cell sumCell28 = sumRow1.createCell(7);
			Cell sumCell29 = sumRow1.createCell(8);
			Cell sumCell210 = sumRow1.createCell(9);
			
			sumCell21.setCellValue("รวมอัตรา 7%");
			sumCell22.setCellValue("");
			sumCell23.setCellValue("");
			sumCell24.setCellValue("");
			sumCell25.setCellValue("");
			sumCell26.setCellValue("");
			sumCell27.setCellFormula("SUM(G2:G"+(rowNum-2)+")");
			sumCell28.setCellFormula("SUM(H2:H"+(rowNum-2)+")");
			sumCell29.setCellFormula("SUM(I2:I"+(rowNum-2)+")");
			sumCell210.setCellValue("");
			
			sumCell21.setCellStyle(summary);
			sumCell22.setCellStyle(summary);
			sumCell23.setCellStyle(summary);
			sumCell24.setCellStyle(summary);
			sumCell25.setCellStyle(summary);
			sumCell26.setCellStyle(summary);
			sumCell27.setCellStyle(summary);
			sumCell28.setCellStyle(summary);
			sumCell29.setCellStyle(summary);
			sumCell210.setCellStyle(summary);
			
			CellRangeAddress mergedCell1 = new CellRangeAddress(rowNum, rowNum, 0, 1);
			borderMergs(mergedCell1, sh, workbook);
			
			rowNum++;
			Row sumRow2 = sh.createRow(rowNum);
			Cell sumCell31 = sumRow2.createCell(0);
			Cell sumCell32 = sumRow2.createCell(1);
			Cell sumCell33 = sumRow2.createCell(2);
			Cell sumCell34 = sumRow2.createCell(3);
			Cell sumCell35 = sumRow2.createCell(4);
			Cell sumCell36 = sumRow2.createCell(5);
			Cell sumCell37 = sumRow2.createCell(6);
			Cell sumCell38 = sumRow2.createCell(7);
			Cell sumCell39 = sumRow2.createCell(8);
			Cell sumCell310 = sumRow2.createCell(9);
			
			sumCell31.setCellValue("รวมอัตรา 0%");
			sumCell32.setCellValue("");
			sumCell33.setCellValue("");
			sumCell34.setCellValue("");
			sumCell35.setCellValue("");
			sumCell36.setCellValue("");
			sumCell37.setCellFormula("SUM(G"+(rowNum)+":G"+(rowNum-3)+")");
			sumCell38.setCellFormula("SUM(G"+(rowNum)+":G"+(rowNum-3)+")");
			sumCell39.setCellFormula("SUM(G"+(rowNum)+":G"+(rowNum-3)+")");
			sumCell310.setCellValue("");
			
			sumCell31.setCellStyle(summary);
			sumCell32.setCellStyle(summary);
			sumCell33.setCellStyle(summary);
			sumCell34.setCellStyle(summary);
			sumCell35.setCellStyle(summary);
			sumCell36.setCellStyle(summary);
			sumCell37.setCellStyle(summary);
			sumCell38.setCellStyle(summary);
			sumCell39.setCellStyle(summary);
			sumCell310.setCellStyle(summary);
			
			CellRangeAddress mergedCell2 = new CellRangeAddress(rowNum, rowNum, 0, 1);
			borderMergs(mergedCell2, sh, workbook);
			
			rowNum+=2;
			Row sumRow3 = sh.createRow(rowNum);
			Cell sumCell41 = sumRow3.createCell(0);
			Cell sumCell42 = sumRow3.createCell(1);
			Cell sumCell43 = sumRow3.createCell(2);
			Cell sumCell44 = sumRow3.createCell(3);
			Cell sumCell45 = sumRow3.createCell(4);
			Cell sumCell46 = sumRow3.createCell(5);
			Cell sumCell47 = sumRow3.createCell(6);
			Cell sumCell48 = sumRow3.createCell(7);
			Cell sumCell49 = sumRow3.createCell(8);
			Cell sumCell410 = sumRow3.createCell(9);
			
			sumCell41.setCellValue("รวมทั้งสิ้น");
			sumCell42.setCellValue("");
			sumCell43.setCellValue("");
			sumCell44.setCellValue("");
			sumCell45.setCellValue("");
			sumCell46.setCellValue("");
			sumCell47.setCellFormula("SUM(G"+(rowNum)+":G"+(rowNum-3)+")");
			sumCell48.setCellFormula("SUM(H"+(rowNum)+":H"+(rowNum-3)+")");
			sumCell49.setCellFormula("SUM(I"+(rowNum)+":I"+(rowNum-3)+")");
			sumCell410.setCellValue("");
			
			sumCell41.setCellStyle(summary);
			sumCell42.setCellStyle(summary);
			sumCell43.setCellStyle(summary);
			sumCell44.setCellStyle(summary);
			sumCell45.setCellStyle(summary);
			sumCell46.setCellStyle(summary);
			sumCell47.setCellStyle(summary);
			sumCell48.setCellStyle(summary);
			sumCell49.setCellStyle(summary);
			sumCell410.setCellStyle(summary);
			
			CellRangeAddress mergedCell3 = new CellRangeAddress(rowNum, rowNum, 0, 1);
			borderMergs(mergedCell3, sh, workbook);
		}
		return workbook;
	}

}