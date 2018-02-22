package th.co.maximus.dao;

import java.util.List;

import th.co.maximus.bean.TrscreDitrefManualBean;

public interface TrscreDitrefManualDao {
	public void insertTrscreDitrefManua(TrscreDitrefManualBean trscreDitrefManualBean);
	
	public List<TrscreDitrefManualBean> trscreDitrefManualFromManualId(long manualId);
}
