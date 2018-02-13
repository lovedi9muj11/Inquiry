package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.payment.bean.PaymentFirstBean;

public interface PaymentManualService {
	
	public int insertPaymentManual(PaymentFirstBean paymentBean);
	
	List<PaymentManualBean> PaymentManualAll();

}
