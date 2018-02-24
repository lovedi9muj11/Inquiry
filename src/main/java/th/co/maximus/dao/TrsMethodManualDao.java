package th.co.maximus.dao;

import java.util.List;

import th.co.maximus.bean.TrsMethodManualBean;

public interface TrsMethodManualDao {

	int insertTrsMethod(TrsMethodManualBean trsMethodManualBean);
	
	public List<TrsMethodManualBean> findTrsMethodManualFromManualId(long manualId);
}
