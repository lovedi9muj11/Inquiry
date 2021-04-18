package th.co.inquiry.service.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import th.co.inquiry.constants.Constants;
import th.co.inquiryx.bean.ReportBean;


@Service("reportService")
public class ReportService {
	protected Logger log = Logger.getLogger(getClass());
	@Autowired
	private @Qualifier("reportExcelService") ReportExcelService reportExcelService;

	Locale localeTH = new Locale("th", "TH");
	Locale localeEN = new Locale("en", "EN");

	SimpleDateFormat formateYearTH = new SimpleDateFormat("yyyy", localeTH);

	public Workbook controlAllReports(Workbook workbook, String rptCode) throws Exception {
		if (rptCode.equals(Constants.report.RPT_CODE)) {
			ReportBean bean = new ReportBean();
			bean.setReportId(1L);
			bean.setName("Ae");
			List<ReportBean> entity = setBeanList(bean);
			workbook = reportExcelService.getReportRpt(workbook, entity, bean);
		} 
		return workbook;
	}
	
	public List<ReportBean> setBeanList(ReportBean bean) {
		List<ReportBean> result = new ArrayList<ReportBean>();
		result.add(bean);
		return result;
	}
	
}