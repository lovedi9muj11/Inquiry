package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.payment.bean.PaymentFirstBean;
import th.co.maximus.payment.bean.PaymentOtherFirstBean;

public interface PaymentOtherManualService {
	
	public int insertPaymentManual(PaymentOtherFirstBean paymentBean);
	
	List<PaymentManualBean> PaymentManualAll();
}
