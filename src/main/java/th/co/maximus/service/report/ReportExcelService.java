package th.co.maximus.service.report;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.HistoryPaymentRS;
import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.bean.ReportBean;

@Service("reportExcelService")
public class ReportExcelService extends BaseExcelRptService {

	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(getClass());

	@Autowired private RptServicexxx rpt1Servicexxx;
	@Autowired private RptServiceFull rptServiceFull;

	public Workbook getReportRptxxx(Workbook workbook, List<ReportBean> entity, ReportBean bean) throws Exception {
		return rpt1Servicexxx.getReport(workbook, entity, bean);
	}
	
	public Workbook getReportRptFull(Workbook workbook, List<HistoryPaymentRS> entity, HistoryReportBean bean) throws Exception {
		return rptServiceFull.getReport(workbook, entity, bean);
	}

}
