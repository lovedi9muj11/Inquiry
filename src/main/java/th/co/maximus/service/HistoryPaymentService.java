package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.PaymentMMapPaymentInvBean;

public interface HistoryPaymentService {

	public List<PaymentMMapPaymentInvBean> servicePaymentHitrory();
	
	public List<PaymentMMapPaymentInvBean> serviceHistroryPaymentFromAccountNo(String accountNo);
}
