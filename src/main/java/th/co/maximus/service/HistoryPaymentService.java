package th.co.maximus.service;

import java.sql.SQLException;
import java.util.List;

import th.co.maximus.bean.HistoryPaymentRS;
import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.bean.HistorySubFindBean;
import th.co.maximus.bean.PaymentInvoiceManualBean;
import th.co.maximus.bean.PaymentMMapPaymentInvBean;

public interface HistoryPaymentService {

	public List<PaymentMMapPaymentInvBean> servicePaymentHitrory() throws Exception;
	
	public List<PaymentMMapPaymentInvBean> serviceHistroryPaymentFromAccountNo(String accountNo,String payType) throws Exception;
	
	public List<PaymentMMapPaymentInvBean> findPayOrder(HistorySubFindBean paymentInvBean);
	
	public List<PaymentMMapPaymentInvBean> findPayOrderFulln(HistorySubFindBean paymentInvBean);
	
	public List<HistoryPaymentRS> findPaymentOrder(HistoryReportBean historyRpt) throws SQLException;
	
	public PaymentInvoiceManualBean findInvoiceManuleByManualIdService(Long manualId);
}