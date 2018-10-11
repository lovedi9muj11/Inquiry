package th.co.maximus.service;

import java.math.BigDecimal;
import java.util.List;

import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.payment.bean.PaymentFirstBean;

public interface PaymentManualService {
	
	public int insertPaymentManual(PaymentFirstBean paymentBean);
	public BigDecimal calVatAmount(BigDecimal amount);
	
	List<PaymentManualBean> PaymentManualAll();

}
