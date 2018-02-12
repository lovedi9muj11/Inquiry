package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.PaymentManualBean;

public interface PaymentManualService {
	
	void insertPaymentManual(PaymentManualBean paymentManualBean);
	
	List<PaymentManualBean> PaymentManualAll();

}
