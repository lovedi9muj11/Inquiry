package th.co.maximus.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.payment.bean.PaymentFirstBean;

public interface PaymentManualService {
	
	public int insertPaymentManual(PaymentFirstBean paymentBean)throws ParseException;
	public BigDecimal calVatAmount(BigDecimal amount , String vat);
	
	List<PaymentManualBean> PaymentManualAll();

}
