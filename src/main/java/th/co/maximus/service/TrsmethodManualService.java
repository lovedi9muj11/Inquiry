package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.TrsMethodManualBean;
import th.co.maximus.payment.bean.PaymentFirstBean;

public interface TrsmethodManualService {

	int insertTrsmethodManual(PaymentFirstBean paymentBean,int userId);

	List<TrsMethodManualBean> TrsmethodManualAll();

}
