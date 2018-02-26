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
		CellStyle txtLeftBor = createCellStyleForTextLeftBorder(workbook, fontNormal, true);
		CellStyle txtCenterBor = createCellStyleForTextCenterBorder(workbook, fontNormal, true);


		String date = formatter2.format(new Date());
		String time = formateHH.format(new Date());

		Sheet sh = workbook.getSheetAt(0);
		Header header = sh.getHeader();
		header.setCenter(sh.getHeader().getCenter().concat("222"+" ").concat((bean.getName()+" ").concat("1122".concat("2211"+" ").concat(bean.getName()))));
		header.setLeft(sh.getHeader().getLeft().concat(date + "111" + time));
		header.setRight(sh.getHeader().getRight());

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
		}
		return workbook;
	}

}
