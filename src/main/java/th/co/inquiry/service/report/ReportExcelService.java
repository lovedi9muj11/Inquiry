package th.co.inquiry.service.report;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.inquiryx.bean.ReportBean;

@Service("reportExcelService")
public class ReportExcelService extends BaseExcelRptService {

	@SuppressWarnings("unused")
	private Logger log = Logger.getLogger(getClass());

	@Autowired private RptService rpt1Service;

	public Workbook getReportRpt(Workbook workbook, List<ReportBean> entity, ReportBean bean) throws Exception {
		return rpt1Service.getReport(workbook, entity, bean);
	}
}
