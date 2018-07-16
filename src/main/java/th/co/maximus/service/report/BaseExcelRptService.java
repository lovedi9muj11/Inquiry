package th.co.maximus.service.report;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

public class BaseExcelRptService {

	protected Logger log = Logger.getLogger(getClass());

	protected Font createFontTHSarabanPSK(Workbook workbook, int fontSize, boolean bold) {
		// create style font
		Font font = workbook.createFont();
		font.setFontHeightInPoints((short) (fontSize));
		font.setFontName("TH SarabunPSK");
		font.setBold(bold);
		return font;
	}

	protected CellStyle createCellStyleForTextLeftBorderAlignTop(Workbook workbook, Font font, boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);

		return cellStyle;
	}

	protected CellStyle createCellStyleForTextLeftBorder(Workbook workbook, Font font, boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);

		return cellStyle;
	}

	protected CellStyle createCellStyleForTextLeftBorderVerticalTop(Workbook workbook, Font font, boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);

		return cellStyle;
	}

	protected CellStyle createCellStyleForTextLeftBorderBgGrey50Percent(Workbook workbook, Font font,
			boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);

		return cellStyle;
	}

	protected CellStyle createCellStyleForTextCenterBorder(Workbook workbook, Font font, boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);

		return cellStyle;
	}

	protected CellStyle createCellStyleForTextCenterBorderBgGrey50Percent(Workbook workbook, Font font,
			boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);

		return cellStyle;
	}

	protected CellStyle createCellStyleForTextCenterBorderForRunningNumber(Workbook workbook, Font font,
			boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);

		return cellStyle;
	}

	protected CellStyle createCellStyleForTextRightBorderAlignTop(Workbook workbook, Font font, boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);

		return cellStyle;
	}

	protected CellStyle createCellStyleForTextCenterBorderAlignTop(Workbook workbook, Font font, boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);

		return cellStyle;
	}

	protected CellStyle createCellStyleForTextRightBorder(Workbook workbook, Font font, boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);

		return cellStyle;
	}

	protected CellStyle createCellStyleForTextRightBorderBgGrey25Percent(Workbook workbook, Font font,
			boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
//		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
//		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setFont(font);

		return cellStyle;
	} 

	protected CellStyle createCellStyleForTextLeftBorderBgGrey25Percent(Workbook workbook, Font font,
			boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		// cellStyle.setWrapText(warpText);
		cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setFont(font);

		return cellStyle;
	}

	protected CellStyle createCellStyleForTextCenterBorderBgGrey25Percent(Workbook workbook, Font font,
			boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setFont(font);

		return cellStyle;
	}

	protected CellStyle createCellStyleForTextLeftBgGrey25Percent(Workbook workbook, Font font, boolean warpText) {
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_NONE);
		cellStyle.setBorderRight(CellStyle.BORDER_NONE);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setFont(font);

		return cellStyle;
	}

	protected CellStyle createCellStyleForTextRightBorderBgGrey50Percent(Workbook workbook, Font font,
			boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setFont(font);

		return cellStyle;
	}
	
	protected CellStyle createStyleCellCenter(Workbook workbook, Font font, boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);

		return cellStyle;
	}
	
	protected CellStyle createStyleCellLeft(Workbook workbook, Font font, boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);

		return cellStyle;
	}
	
	protected CellStyle createStyleCellRight(Workbook workbook, Font font, boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);

		return cellStyle;
	}
	
	protected CellStyle createStyleCellLeftBorder(Workbook workbook, Font font, boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);

		return cellStyle;
	}
	
	protected CellStyle createStyleCellLefRight(Workbook workbook, Font font, boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);

		return cellStyle;
	}
	protected CellStyle createStyleCellFormetDecimal(Workbook workbook, Font font, boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);
		cellStyle.setDataFormat(workbook.createDataFormat().getFormat("0.00"));
		return cellStyle;
	}
	protected CellStyle createStyleCellFormetDecimalRight(Workbook workbook, Font font, boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);
		cellStyle.setDataFormat(workbook.createDataFormat().getFormat("0.00"));
		return cellStyle;
	}

	protected CellStyle createCellStyleForTextLeft(Workbook workbook, Font font, boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);

		return cellStyle;
	}

	protected CellStyle createCellStyleForTextCenter(Workbook workbook, Font font, boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);

		return cellStyle;
	}

	protected CellStyle createCellStyleForNumberBorderAlignTop(Workbook workbook, Font font) {
		// style for number
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = createCellStyleForTextRightBorder(workbook, font, false);
		DataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("#,##0.0000"));
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);

		return cellStyle;
	}

	protected CellStyle createCellStyleForNumberBorder(Workbook workbook, Font font) {
		// style for number
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = createCellStyleForTextRightBorder(workbook, font, false);
		DataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("#,##0.0000"));

		return cellStyle;
	}

	protected CellStyle createCellStyleForNumberTwoDecimalBorder(Workbook workbook, Font font) {
		// style for number
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = createCellStyleForTextRightBorder(workbook, font, false);
		DataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("#,##0.00"));

		return cellStyle;
	}

	protected CellStyle createCellStyleForNumberBorderNoDecimal(Workbook workbook, Font font) {
		// style for number
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = createCellStyleForTextRightBorder(workbook, font, false);
		DataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("#,##0"));

		return cellStyle;
	}

	protected CellStyle createCellStyleForNumberBorderVerticalTop(Workbook workbook, Font font) {
		// style for number
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = createCellStyleForTextRightBorder(workbook, font, false);
		DataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("#,##0.00"));
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);

		return cellStyle;
	}

	protected CellStyle createCellStyleForNumberBorderBgGrey25PercentAlignTop(Workbook workbook, Font font,
			boolean warpText) {
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = createCellStyleForTextRightBorder(workbook, font, false);
		DataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("#,##0.0000"));
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setFont(font);

		return cellStyle;
	}

	protected CellStyle createCellStyleForNumberBorderBgGrey25Percent(Workbook workbook, Font font, boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = createCellStyleForTextRightBorder(workbook, font, false);
		DataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("#,##0.0000"));
		// cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		// cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		// cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		// cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		// cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
		// cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		cellStyle.setWrapText(warpText);
		cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setFont(font);

		return cellStyle;
	}

	protected CellStyle createCellStyleForNumberBorderBgGrey50Percent(Workbook workbook, Font font, boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = createCellStyleForTextRightBorder(workbook, font, false);
		DataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("#,##0.0000"));
		// cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		// cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		// cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		// cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		// cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
		// cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		cellStyle.setWrapText(warpText);
		cellStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setFont(font);

		return cellStyle;
	}

	protected CellStyle createCellStyleForNumberTwoDecimalBorderBgGrey50Percent(Workbook workbook, Font font,
			boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = createCellStyleForTextRightBorder(workbook, font, false);
		DataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("#,##0.00"));
		// cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		// cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		// cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		// cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		// cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
		// cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		cellStyle.setWrapText(warpText);
		cellStyle.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setFont(font);

		return cellStyle;
	}

	protected CellStyle createCellStyleForNumberBorderNoDec(Workbook workbook, Font font) {
		// style for number
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = createCellStyleForTextRightBorder(workbook, font, false);
		DataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("#,##0"));

		return cellStyle;
	}

	protected CellStyle createCellStyleForNumberBorderNoDecBgGreyPercent(Workbook workbook, Font font, short percent) {
		// style for number
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = createCellStyleForTextRightBorder(workbook, font, false);
		cellStyle.setFillForegroundColor(percent);
		DataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("#,##0"));

		return cellStyle;
	}

	protected CellStyle createCellStyleForNumberBorderLeft(Workbook workbook, Font font) {
		// style for number
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(CellStyle.ALIGN_LEFT);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setFont(font);

		DataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("#,##0.00"));

		return cellStyle;
	}

	protected CellStyle createCellStyleForNumberBorderCenter(Workbook workbook, Font font, boolean warpText) {
		// style for number
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setFont(font);
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setWrapText(warpText);
		DataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("#,##0"));

		return cellStyle;
	}

	protected CellStyle createCellStyleForNumberLeftBorderBgGrey25Percent(Workbook workbook, Font font,
			boolean warpText) {
		// style for text
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = createCellStyleForTextLeftBorderBgGrey25Percent(workbook, font, warpText);
		DataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("#,##0.0000"));
		return cellStyle;
	}

	protected CellStyle createCellStyleForNumberBorderRed(Workbook workbook, Font font) {
		// style for number
		// font.setFontHeightInPoints((short)10);
		font.setColor(IndexedColors.RED.getIndex());
		CellStyle cellStyle = createCellStyleForTextRightBorder(workbook, font, false);
		DataFormat format = workbook.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("#,##0.00;[Red]#,##0.00"));
		return cellStyle;
	}

	protected CellStyle createCellStyleForTextCenterBorderFor14BoldFont(Workbook workbook, Font font,
			boolean warpText) {
		// style for text
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_TOP);
		cellStyle.setWrapText(warpText);
		cellStyle.setFont(font);
		return cellStyle;
	}
	protected CellStyle createBorderCellStyle(Workbook workbook , Font font) {
		font.setColor(IndexedColors.BLACK.getIndex());
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(CellStyle.ALIGN_RIGHT);
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		cellStyle.setFont(font);
		return cellStyle;
	}

	/* function report */

	public void borderMergs(CellRangeAddress mergedCellsumCell3, Sheet sh, Workbook workbook) {
		sh.addMergedRegion(mergedCellsumCell3);
		RegionUtil.setBorderTop(CellStyle.BORDER_THIN, mergedCellsumCell3, sh, workbook);
		RegionUtil.setBorderBottom(CellStyle.BORDER_THIN, mergedCellsumCell3, sh, workbook);
		RegionUtil.setBorderLeft(CellStyle.BORDER_THIN, mergedCellsumCell3, sh, workbook);
		RegionUtil.setBorderRight(CellStyle.BORDER_THIN, mergedCellsumCell3, sh, workbook);
	}

	public String sector(String req) {
		String returnStr = "";
		if (StringUtils.isNoneBlank(req)) {
			returnStr = req.substring(0, 1).equals("0") ? req.substring(1, 2) : req.substring(0, 2);
		}
		return returnStr;
	}

	public String fmYear(String req) {
		return (Integer.parseInt(req) - 543) + "";
	}

	public String beYear(String req) {
		return (Integer.parseInt(req) + 543) + "";
	}

	public String del1Year(String req) {
		return ((Integer.parseInt(req) + 543) - 1) + "";
	}

	public String setMount(String mount) {
		String result = "";

		if ("01".equals(mount)) {
			result = "มกราคม";
		} else if ("02".equals(mount)) {
			result = "กุมภาพันธ์";
		} else if ("03".equals(mount)) {
			result = "มีนาคม";
		} else if ("04".equals(mount)) {
			result = "เมษายน";
		} else if ("05".equals(mount)) {
			result = "พฤษภาคม";
		} else if ("06".equals(mount)) {
			result = "มิถุนายน";
		} else if ("07".equals(mount)) {
			result = "กรกฎาคม";
		} else if ("08".equals(mount)) {
			result = "สิงหาคม";
		} else if ("09".equals(mount)) {
			result = "กันยายน";
		} else if ("10".equals(mount)) {
			result = "ตุลาคม";
		} else if ("11".equals(mount)) {
			result = "พฤศจิกายน";
		} else if ("12".equals(mount)) {
			result = "ธันวาคม";
		} else {
			result = "";
		}

		return result;
	}

	public String setMonth2(String month) {
		String result = "";

		if ("1".equals(month)) {
			result = "มกราคม";
		} else if ("2".equals(month)) {
			result = "กุมภาพันธ์";
		} else if ("3".equals(month)) {
			result = "มีนาคม";
		} else if ("4".equals(month)) {
			result = "เมษายน";
		} else if ("5".equals(month)) {
			result = "พฤษภาคม";
		} else if ("6".equals(month)) {
			result = "มิถุนายน";
		} else if ("7".equals(month)) {
			result = "กรกฎาคม";
		} else if ("8".equals(month)) {
			result = "สิงหาคม";
		} else if ("9".equals(month)) {
			result = "กันยายน";
		} else if ("10".equals(month)) {
			result = "ตุลาคม";
		} else if ("11".equals(month)) {
			result = "พฤศจิกายน";
		} else if ("12".equals(month)) {
			result = "ธันวาคม";
		} else {
			result = "";
		}

		return result;
	}

	public String convertToFormatThaiDate(String date) {
		String day = setDate(date);
		String year = date.substring(6, date.length());
		String month = date.substring(3, 5);

		String result = day + " " + setMount(month) + " " + year;
		return result;
	}

	public String setDate(String date) {
		String day = "";
		
		if (date.substring(0, 1).equals("0")) {
			day = date.substring(1, 2);
		}
//		if (date.substring(0, 2).equals("01")) {
//			day = date.substring(1, 2);
//		} else if (date.substring(0, 2).equals("02")) {
//			day = date.substring(1, 2);
//		} else if (date.substring(0, 2).equals("03")) {
//			day = date.substring(1, 2);
//		} else if (date.substring(0, 2).equals("04")) {
//			day = date.substring(1, 2);
//		} else if (date.substring(0, 2).equals("05")) {
//			day = date.substring(1, 2);
//		} else if (date.substring(0, 2).equals("06")) {
//			day = date.substring(1, 2);
//		} else if (date.substring(0, 2).equals("07")) {
//			day = date.substring(1, 2);
//		} else if (date.substring(0, 2).equals("08")) {
//			day = date.substring(1, 2);
//		} else if (date.substring(0, 2).equals("09")) {
//			day = date.substring(1, 2);
//		} 
		else {
			day = date.substring(0, 2);
		}
		return day;
	}

}
