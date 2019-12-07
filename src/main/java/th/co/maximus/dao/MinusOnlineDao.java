package th.co.maximus.dao;

import th.co.maximus.bean.PaymentMMapPaymentInvBean;

public interface MinusOnlineDao {
	void updateStatusForMinusOnline(PaymentMMapPaymentInvBean creteria) throws Exception;
}
