package th.co.inquiry.service.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.inquiry.constants.Constants;
import th.co.inquiry.dao.QuestionDao;
import th.co.inquiry.dao.ScoreDao;
import th.co.inquiry.model.ScoreBean;
import th.co.inquiry.service.MasterDataService;
import th.co.inquiry.service.QuestionService;
import th.co.inquiryx.bean.MasterDataBean;
import th.co.inquiryx.bean.ReportBean;

@Service("rptService")
public class RptService extends BaseExcelRptService {
	
	@Autowired
	MasterDataService masterDataService;
	
	@Autowired
	QuestionService questionService;
	
	@Autowired
	QuestionDao questionDao;
	
	@Autowired
	ScoreDao scoreDao;

	public Workbook getReport(Workbook workbook, List<ReportBean> entity, ReportBean bean) {
		Font fontNormal = createFontTHSarabanPSK(workbook, 14, false);
		CellStyle txtLeftBor = createCellStyleForTextLeftBorder(workbook, fontNormal, true);
		CellStyle txtCenterBor = createCellStyleForTextCenterBorder(workbook, fontNormal, true);
		CellStyle numRightBor = createCellStyleForNumberTwoDecimalBorder(workbook, fontNormal);

		List<MasterDataBean> masterDatas = new ArrayList<MasterDataBean>();
		List<ReportBean> reportBeans = new ArrayList<ReportBean>();
		List<ReportBean> reportBean2s = new ArrayList<ReportBean>();
		ReportBean reportBean = new ReportBean();
		ReportBean bean2 = new ReportBean();
		masterDatas = masterDataService.findQuestionByGroupKey(Constants.QUESTION_TYPE_DD);
		List<MasterDataBean> msQuestion = masterDataService.findQuestionByGroupKey(Constants.QUESTION);
		
		int rowNum = 0;
		for(int i=0; i<=masterDatas.size(); i++) {
			Sheet sh = workbook.getSheetAt(i);
			rowNum = 0;
			
			Row row1 = sh.createRow(rowNum++);
			
			if(i<masterDatas.size()) {
				Cell cell1 = row1.createCell(0);
				
				cell1.setCellValue("คำนวนคะแนนแบบสอบถาม ".concat(masterDatas.get(i).getText()).concat(" โดยผู้เชี่ยวชาญทั้งหมด 7 ท่าน"));
				CellRangeAddress mergedCell = new CellRangeAddress((rowNum-1), (rowNum-1), 0, 6);
				borderMergs(mergedCell, sh, workbook);
				rowNum++;
				
				cell1.setCellStyle(txtLeftBor);
				
//				List<QuestionBean> questions = new ArrayList<QuestionBean>();
				try {
//					questions = questionService.findByType(masterDatas.get(i).getValue());
					reportBean2s = new ArrayList<ReportBean>();
					reportBean = new ReportBean();
					
					Row row2 = sh.createRow(rowNum++);
					Cell cell2 = row2.createCell(0);
					Cell cell3 = row2.createCell(1);
					Cell cell4 = row2.createCell(2);
					Cell cell5 = row2.createCell(3);
					Cell cell6 = row2.createCell(4);
					Cell cell7 = row2.createCell(5);
					Cell cell8 = row2.createCell(6);
					Cell cell9 = row2.createCell(7);
					
					cell2.setCellValue("ข้อที่");
					cell3.setCellValue("มากที่สุด");
					cell4.setCellValue("มาก");
					cell5.setCellValue("ปานกลาง");
					cell6.setCellValue("น้อย");
					cell7.setCellValue("น้อยที่สุด");
					cell8.setCellValue("คะแนน");
					cell9.setCellValue("คะแนนรวม");
					
					cell2.setCellStyle(txtCenterBor);
					cell3.setCellStyle(txtCenterBor);
					cell4.setCellStyle(txtCenterBor);
					cell5.setCellStyle(txtCenterBor);
					cell6.setCellStyle(txtCenterBor);
					cell7.setCellStyle(txtCenterBor);
					cell8.setCellStyle(txtCenterBor);
					cell9.setCellStyle(txtCenterBor);
					
					int iNum = 1;
					BigDecimal sumSub = BigDecimal.ZERO;
					for(int q=0; q<msQuestion.size(); q++) {
						List<MasterDataBean> msQuestionSub = masterDataService.findQuestionByGroupKey(msQuestion.get(q).getValue());
						
						for(int qs=0; qs<msQuestionSub.size(); qs++) {
							Row row3 = sh.createRow(rowNum++);
							Cell cell11 = row3.createCell(0);
							cell11.setCellValue((q+1)+ "." +(qs+1));
							cell11.setCellStyle(txtCenterBor);
							
							int score5 = questionDao.findByGroupAndTypeAndScoreAndSeq(msQuestion.get(q).getValue(), masterDatas.get(i).getValue(), Constants.report.SCORE_5, String.valueOf(iNum));
							
							int score4 = questionDao.findByGroupAndTypeAndScoreAndSeq(msQuestion.get(q).getValue(), masterDatas.get(i).getValue(), Constants.report.SCORE_4, String.valueOf(iNum));
							
							int score3 = questionDao.findByGroupAndTypeAndScoreAndSeq(msQuestion.get(q).getValue(), masterDatas.get(i).getValue(), Constants.report.SCORE_3, String.valueOf(iNum));
							
							int score2 = questionDao.findByGroupAndTypeAndScoreAndSeq(msQuestion.get(q).getValue(), masterDatas.get(i).getValue(), Constants.report.SCORE_2, String.valueOf(iNum));
							
							int score1 = questionDao.findByGroupAndTypeAndScoreAndSeq(msQuestion.get(q).getValue(), masterDatas.get(i).getValue(), Constants.report.SCORE_1, String.valueOf(iNum));
							iNum++;
							
							List<ScoreBean> scroes = scoreDao.findByGroupAndQGroupAndQCode(masterDatas.get(i).getValue(), msQuestion.get(q).getValue(), msQuestionSub.get(qs).getValue());
							ScoreBean score = new ScoreBean();
							if(CollectionUtils.isNotEmpty(scroes)) {
								score = scroes.get(0);
							}
							
							Cell cell12 = row3.createCell(1);
							Cell cell13 = row3.createCell(2);
							Cell cell14 = row3.createCell(3);
							Cell cell15 = row3.createCell(4);
							Cell cell16 = row3.createCell(5);
							Cell cell17 = row3.createCell(6);
							
							cell12.setCellValue(isNullInt(score5));
							cell13.setCellValue(isNullInt(score4));
							cell14.setCellValue(isNullInt(score3));
							cell15.setCellValue(isNullInt(score2));
							cell16.setCellValue(isNullInt(score1));
							BigDecimal calSum = calScore(score1, score2, score3, score4, score5, score);
							String calSumStr = formatComma(calSum);
							cell17.setCellValue(calSumStr);
							sumSub = sumSub.add(calSum);
							
							cell12.setCellStyle(numRightBor);
							cell13.setCellStyle(numRightBor);
							cell14.setCellStyle(numRightBor);
							cell15.setCellStyle(numRightBor);
							cell16.setCellStyle(numRightBor);
							cell17.setCellStyle(numRightBor);
							
							if((msQuestionSub.size()-1)==(qs)) {
								bean2 = new ReportBean();
								Cell cell18 = row3.createCell(7);
								cell18.setCellValue(formatComma(sumSub));
								cell18.setCellStyle(numRightBor);
								
								bean2.setSumScore(sumSub);
								reportBean2s.add(bean2);
								sumSub = BigDecimal.ZERO;
							}else {
								Cell cell18 = row3.createCell(7);
								cell18.setCellValue("");
								cell18.setCellStyle(numRightBor);
							}
						}
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				reportBean.setList(reportBean2s);
				reportBeans.add(reportBean);
			}else {
				
			}
			
		}
		
		//sum
		Sheet sh = workbook.getSheetAt(masterDatas.size());
		rowNum = 0;
		int rowNumc1 = 0;
		
		Row row1 = sh.createRow(rowNum++);
		
		Cell cell1 = row1.createCell(0);
		
		cell1.setCellValue("สรุปผลการประเมิน");
		CellRangeAddress mergedCell = new CellRangeAddress((rowNum-1), (rowNum-1), 0, 3);
		borderMergs(mergedCell, sh, workbook);
		rowNum++;
		
		cell1.setCellStyle(txtLeftBor);
		
		Row row2 = sh.createRow(rowNum++);
		Cell cell2 = row2.createCell(0);
		cell2.setCellValue("");
		cell2.setCellStyle(txtCenterBor);
		
		rowNumc1 = rowNum;
		
		for(MasterDataBean data : msQuestion) {
			Row row3 = sh.createRow(rowNumc1++);
			Cell cell31 = row3.createCell(0);
			cell31.setCellValue(subTextQuestion(data.getText()));
			cell31.setCellStyle(txtLeftBor);
		}
		
		Row row7 = sh.createRow(rowNumc1++);
		Cell cell71 = row7.createCell(0);
		cell71.setCellValue("");
		cell71.setCellStyle(txtCenterBor);
		
		for(int i=0; i<masterDatas.size(); i++) {
			int rowNumc2 = 3;
			Cell cell3 = row2.createCell(i+1);
			
			cell3.setCellValue(masterDatas.get(i).getText());
			
			cell3.setCellStyle(txtCenterBor);
			
			//sum score
			ReportBean data = reportBeans.get(i);
			int iNum = 0;
			BigDecimal sumScore = BigDecimal.ZERO;
			
			for(int ii=0; ii<msQuestion.size(); ii++) {
				sumScore = sumScore.add(data.getList().get(iNum).getSumScore());
				Row row33 = sh.getRow((rowNumc2));
				Cell cell331 = row33.createCell(i+1);
				cell331.setCellValue(formatComma(data.getList().get(iNum++).getSumScore()));
				cell331.setCellStyle(numRightBor);
				rowNumc2++;
			}
			
			Row row77 = sh.getRow((rowNumc2));
			Cell cell771 = row77.createCell(i+1);
			cell771.setCellValue(formatComma(sumScore.divide(new BigDecimal("4"))));
			cell771.setCellStyle(numRightBor);
			rowNumc2++;
		}
		
		return workbook;
	}
	
	String isNullInt(int score) {
		if(score>0) {
			return String.valueOf(score);
		}
		
		return "";
	}
	
	String isNullBigDecimal(BigDecimal score) {
		return String.valueOf(score);
	}
	
	BigDecimal calScore(int score1, int score2, int score3, int score4, int score5, ScoreBean score) {
		BigDecimal result = BigDecimal.ZERO;
		
		result = (parseBigDecimal(score.getScore5()).multiply(new BigDecimal(score5))).add((parseBigDecimal(score.getScore4()).multiply(new BigDecimal(score4)))).add((parseBigDecimal(score.getScore3()).multiply(new BigDecimal(score3)))).add((parseBigDecimal(score.getScore2()).multiply(new BigDecimal(score2)))).add((parseBigDecimal(score.getScore1()).multiply(new BigDecimal(score1))));
		
		return result;
	}
	
	BigDecimal parseBigDecimal(String score) {
		if(StringUtils.isNotBlank(score)) {
			return new BigDecimal(score);
		}
		
		return BigDecimal.ZERO;
	}
	
	String formatComma(BigDecimal score) {
		return String.format("%,.2f", score);
	}
	
	String subTextQuestion(String value) {
		String result = "";
		
		if(StringUtils.isNotBlank(value)) {
			String[] splits = value.split("\\(");
			if(splits.length>1) {
				String[] splits2 = splits[1].split("\\)");
				result = splits2[0];
			}
		}
		
		return result;
	}

}
