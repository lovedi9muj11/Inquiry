package th.co.maximus.dao;

import java.util.List;

import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.payment.bean.PaymentResultReq;

public interface PaymentOtherManualDao {
	public int insertPayment(PaymentManualBean paymentManualBean);

	public PaymentResultReq findById(int id) throws Exception;
	
	public List<PaymentResultReq> findListById(Long id) throws Exception;
}
