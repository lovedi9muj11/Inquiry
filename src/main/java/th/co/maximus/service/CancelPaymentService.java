package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.PaymentMMapPaymentInvBean;

public interface CancelPaymentService {
	public List<PaymentMMapPaymentInvBean> findAllCancelPayment();
}
