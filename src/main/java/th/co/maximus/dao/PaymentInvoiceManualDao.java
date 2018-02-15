package th.co.maximus.dao;

import java.util.List;

import th.co.maximus.bean.PaymentInvoiceManualBean;
import th.co.maximus.bean.PaymentMMapPaymentInvBean;

public interface PaymentInvoiceManualDao {
	
	public List<PaymentMMapPaymentInvBean> findPaymentMuMapPaymentInV();
	
	public void insert(PaymentInvoiceManualBean paymentInvoiceManualBean);

	public List<PaymentMMapPaymentInvBean> findPaymentMuMapPaymentInVAccountId(String accountNo);
}