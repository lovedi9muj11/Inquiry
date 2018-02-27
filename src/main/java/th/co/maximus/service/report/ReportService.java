package th.co.maximus.service.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.ReportBean;
import th.co.maximus.constants.Constants;

@Service("reportService")
public class ReportService {
	protected Logger log = Logger.getLogger(getClass());
	@Autowired
	private @Qualifier("reportExcelService") ReportExcelService reportExcelService;

	Locale localeTH = new Locale("th", "TH");
	Locale localeEN = new Locale("en", "EN");

	SimpleDateFormat formateYearTH = new SimpleDateFormat("yyyy", localeTH);


	public Workbook controlAllReports(Workbook workbook, String rptCode, ReportBean bean) throws Exception {
		if (rptCode.equals(Constants.report.XXX)) {
			bean.setReportId(1L);
			bean.setName("Ae");
			bean.setPayDate(new Date());
			bean.setPayDateTo(new Date());
			List<ReportBean> entity = xxx(bean);
			workbook = reportExcelService.getReportRptxxx(workbook, entity, bean);
		} 
		return workbook;
	}
	
	public List<ReportBean> xxx(ReportBean bean) {
		List<ReportBean> result = new ArrayList<ReportBean>();
		result.add(bean);
		return result;
	}

}
