package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.PaymentInvoiceManualBean;
import th.co.maximus.payment.bean.PaymentFirstBean;
import th.co.maximus.payment.bean.PaymentOtherFirstBean;

public interface PaymentOtherInvoiceManualService {
	
	
	List<PaymentInvoiceManualBean> PaymentInvoiceManualAll();

	void insertPaymentInvoiceManual(PaymentOtherFirstBean paymentBean,int userId);

}
