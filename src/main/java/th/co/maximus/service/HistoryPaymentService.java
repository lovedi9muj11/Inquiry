package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.HistorySubFindBean;
import th.co.maximus.bean.PaymentMMapPaymentInvBean;

public interface HistoryPaymentService {

	public List<PaymentMMapPaymentInvBean> servicePaymentHitrory();
	
	public List<PaymentMMapPaymentInvBean> serviceHistroryPaymentFromAccountNo(String accountNo);
	
	public List<PaymentMMapPaymentInvBean> findPayOrder(HistorySubFindBean paymentInvBean);
	
	public List<PaymentMMapPaymentInvBean> findPayOrderFulln(HistorySubFindBean paymentInvBean);
}
