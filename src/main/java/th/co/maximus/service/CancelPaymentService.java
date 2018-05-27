package th.co.maximus.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import th.co.maximus.bean.PaymentMMapPaymentInvBean;

public interface CancelPaymentService {
	public List<PaymentMMapPaymentInvBean> findAllCancelPayment() throws Exception;
	
	public List<PaymentMMapPaymentInvBean> findAllCancelPaymentFromId(long manualId) throws Exception;
	
	public List<PaymentMMapPaymentInvBean> serviceCriteriaFromInvoiceOrReceiptNo(String receiptNo, String invoiceNo) throws Exception;
	
	public int insertAndUpdateCancelPayment(PaymentMMapPaymentInvBean paymentInvBean);
	
	public List<PaymentMMapPaymentInvBean> findAllCancelPayments(String clearing) throws Exception;
	
	
}
