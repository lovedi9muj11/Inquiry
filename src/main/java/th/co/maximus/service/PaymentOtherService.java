package th.co.maximus.service;

import th.co.maximus.payment.bean.PaymentFirstBean;
import th.co.maximus.payment.bean.PaymentOtherFirstBean;
import th.co.maximus.payment.bean.PaymentResultReq;

public interface PaymentOtherService {
	public int insert(PaymentOtherFirstBean paymentBean);
	public void delete(String id);
	public void update(PaymentOtherFirstBean paymentBean);
	public PaymentResultReq findByid(int id)throws Exception;
}
