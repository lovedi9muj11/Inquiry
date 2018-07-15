package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.TrsChequeRefManualBean;
import th.co.maximus.model.TrsChequerefEpisOffline;

public interface TrsChequeRefManualService {

	void insertTrsChequeRefManual(TrsChequeRefManualBean trsChequeRefManualBean);

	List<TrsChequeRefManualBean> TrsChequeRefManualAll();

	public List<TrsChequerefEpisOffline> findTrsCredit(long methodTrsId) throws Exception;

}
