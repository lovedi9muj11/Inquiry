package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.PaymentMMapPaymentInvBean;

public interface CancelPaymentService {
	public List<PaymentMMapPaymentInvBean> findAllCancelPayment() throws Exception;
	
	public List<PaymentMMapPaymentInvBean> findAllCancelPaymentFromId(Long manualId) throws Exception;
	
	public List<PaymentMMapPaymentInvBean> serviceCriteriaFromInvoiceOrReceiptNo(String receiptNo, String invoiceNo) throws Exception;
	
	public boolean insertAndUpdateCancelPayment(PaymentMMapPaymentInvBean paymentInvBean);
	
	public List<PaymentMMapPaymentInvBean> findAllCancelPayments(String clearing) throws Exception;


	
	
}
