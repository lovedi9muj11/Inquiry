package th.co.maximus.service.report;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Footer;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.apache.poi.ss.util.CellRangeAddress;

import th.co.maximus.bean.ReportBean;
import th.co.maximus.constants.Constants;

@Service("rptServicexxx")
public class RptServicexxx extends BaseExcelRptService {

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

	public Workbook getReport(Workbook workbook, List<ReportBean> entity, ReportBean bean) {
		SimpleDateFormat formatter2 = new SimpleDateFormat(Constants.DateTime.DATE_FORMAT, new Locale("th", "TH"));
		Font fontNormal = createFontTHSarabanPSK(workbook, 14, false);
		Font fontBold = createFontTHSarabanPSK(workbook, 14, true);
		CellStyle txtLeftBor = createCellStyleForTextLeftBorder(workbook, fontNormal, true);
		CellStyle txtCenterBor = createCellStyleForTextCenterBorder(workbook, fontNormal, true);
		CellStyle summary = createCellStyleForTextRightBorderBgGrey25Percent(workbook, fontBold, true);

		String date = formatter2.format(new Date());
		String time = formateHH.format(new Date());

		Sheet sh = workbook.getSheetAt(0);
		Header header = sh.getHeader();
		header.setCenter(sh.getHeader().getCenter().concat("ประจำวันที่ "+" ").concat((formatter2.format(bean.getPayDate())+" ").concat("ถึงวันที่".concat(" ").concat(""+formatter2.format(bean.getPayDateTo())))));
		header.setLeft(sh.getHeader().getLeft().concat("xxx").concat("\n").concat("xx").concat("\n").concat("x"));
		header.setRight(sh.getHeader().getRight().concat(date+" "+time));

		Footer footer = sh.getFooter();
		footer.setCenter(sh.getFooter().getCenter());
		footer.setLeft(sh.getFooter().getLeft().concat(StringUtils.isNotBlank(bean.getName()) ? bean.getName():""));
		footer.setRight(sh.getFooter().getRight().concat(StringUtils.isNotBlank(bean.getName()) ? bean.getName() :""));
		
		int rowNum = 1;

		if (CollectionUtils.isNotEmpty(entity)) {
			for(int i=0; i<entity.size(); i++) {
		
				Row row1 = sh.createRow(rowNum++);
				Cell cell1 = row1.createCell(0);
				Cell cell2 = row1.createCell(1);
				
				cell1.setCellValue(i+1);
				cell2.setCellValue(entity.get(i).getName());
				
				cell1.setCellStyle(txtCenterBor);
				cell2.setCellStyle(txtLeftBor);
				
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
			sumCell2.setCellValue("x1");
			sumCell3.setCellValue("x2");
			sumCell4.setCellValue("x3");
			sumCell5.setCellValue("x4");
			sumCell6.setCellValue("x5");
			sumCell7.setCellValue("x6");
			sumCell8.setCellValue("x7");
			sumCell9.setCellValue("x8");
			sumCell10.setCellValue("x9");
			
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
		}
		return workbook;
	}

}
