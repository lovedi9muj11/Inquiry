package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.TrsMethodManualBean;

public interface TrsmethodManualService {

	void insertTrsmethodManual(TrsMethodManualBean trsMethodManualBean);

	List<TrsMethodManualBean> TrsmethodManualAll();

}
