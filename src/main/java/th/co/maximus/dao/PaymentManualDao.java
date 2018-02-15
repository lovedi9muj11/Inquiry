package th.co.maximus.dao;

import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.payment.bean.PaymentResultReq;

public interface PaymentManualDao {
	public int insertPayment(PaymentManualBean paymentManualBean);
	public PaymentResultReq findById(int id)throws Exception;
}
