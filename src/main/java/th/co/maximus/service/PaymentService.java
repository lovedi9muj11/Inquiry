package th.co.maximus.service;

import th.co.maximus.payment.bean.PaymentFirstBean;

public interface PaymentService {
	
	public void insert(PaymentFirstBean paymentBean);
	public void delete(String id);
	public void update(PaymentFirstBean paymentBean);
}
