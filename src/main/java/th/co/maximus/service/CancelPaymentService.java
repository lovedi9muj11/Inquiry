package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.PaymentMMapPaymentInvBean;

public interface CancelPaymentService {
	public List<PaymentMMapPaymentInvBean> findAllCancelPayment();
	
	public List<PaymentMMapPaymentInvBean> findAllCancelPaymentFromId(long manualId);
	
	public List<PaymentMMapPaymentInvBean> serviceCriteriaFromInvoiceOrReceiptNo(String receiptNo, String invoiceNo);
	
	public boolean insertAndUpdateCancelPayment(PaymentMMapPaymentInvBean paymentInvBean);
	
}
