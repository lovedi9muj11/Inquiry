package th.co.maximus.dao;

import java.sql.SQLException;
import java.util.List;

import th.co.maximus.bean.TrscreDitrefManualBean;
import th.co.maximus.model.TrsCreditrefEpisOffline;

public interface TrscreDitrefManualDao {
	
	public void insertTrscreDitrefManua(TrscreDitrefManualBean trscreDitrefManualBean);
	
	public List<TrscreDitrefManualBean> trscreDitrefManualFromManualId(long manualId);
	
	public List<TrsCreditrefEpisOffline> findByMethodId(long methodId) throws SQLException;
}
