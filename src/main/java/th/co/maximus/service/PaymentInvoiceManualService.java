package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.PaymentInvoiceManualBean;

public interface PaymentInvoiceManualService {

	List<PaymentInvoiceManualBean> PaymentInvoiceManualAll();

	void insertPaymentInvoiceManual(PaymentInvoiceManualBean paymentInvoiceManualBean);

}
