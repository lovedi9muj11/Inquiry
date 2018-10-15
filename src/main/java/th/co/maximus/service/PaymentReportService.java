package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.ReportPaymentBean;
import th.co.maximus.bean.ReportPaymentCriteria;

public interface PaymentReportService {
	
	public List<ReportPaymentBean> findPaymnetReportService(ReportPaymentCriteria criteria,String serviceType) throws Exception;
	
	public List<ReportPaymentBean> findPaymnetReportServiceOtherSearch(ReportPaymentCriteria criteria,String serviceType) throws Exception;

}
