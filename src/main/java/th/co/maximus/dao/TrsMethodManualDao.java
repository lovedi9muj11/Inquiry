package th.co.maximus.dao;

import java.util.List;

import th.co.maximus.bean.TrsMethodManualBean;
import th.co.maximus.model.TrsMethodEpisOffline;

public interface TrsMethodManualDao {

	int insertTrsMethod(TrsMethodManualBean trsMethodManualBean);
	
	public List<TrsMethodManualBean> findTrsMethodManualFromManualId(long manualId);
	public List<TrsMethodEpisOffline> findByManualId(long manualId) throws Exception;
}
