package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.TrscreDitrefManualBean;

public interface TrscreDitrefManualService {

	void insertTrscreDitrefManua(TrscreDitrefManualBean trscreDitrefManualBean);

	List<TrscreDitrefManualBean> TrscreDitrefManualAll();

}
