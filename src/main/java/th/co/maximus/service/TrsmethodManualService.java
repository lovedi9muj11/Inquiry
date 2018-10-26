package th.co.maximus.service;

import java.util.List;

import th.co.maximus.model.TrsMethodEpisOffline;
import th.co.maximus.payment.bean.PaymentFirstBean;

public interface TrsmethodManualService {

	int insertTrsmethodManual(PaymentFirstBean paymentBean,int userId);

	List<TrsMethodEpisOffline> TrsmethodManualAll(Long manualId) throws Exception;

}
