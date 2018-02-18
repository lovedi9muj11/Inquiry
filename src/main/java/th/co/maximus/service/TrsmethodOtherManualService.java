package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.TrsMethodManualBean;
import th.co.maximus.payment.bean.PaymentFirstBean;
import th.co.maximus.payment.bean.PaymentOtherFirstBean;

public interface TrsmethodOtherManualService {

	int insertTrsmethodManual(PaymentOtherFirstBean paymentBean,int userId);

	List<TrsMethodManualBean> TrsmethodManualAll();
}
