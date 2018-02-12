package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.TrsChequeRefManualBean;

public interface TrsChequeRefManualService {

	void insertTrsChequeRefManual(TrsChequeRefManualBean trsChequeRefManualBean);

	List<TrsChequeRefManualBean> TrsChequeRefManualAll();

}
