package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.PaymentInvoiceManualBean;
import th.co.maximus.payment.bean.PaymentFirstBean;

public interface PaymentInvoiceManualService {

	List<PaymentInvoiceManualBean> PaymentInvoiceManualAll();

	void insertPaymentInvoiceManual(PaymentFirstBean paymentBean,int userId);

}
