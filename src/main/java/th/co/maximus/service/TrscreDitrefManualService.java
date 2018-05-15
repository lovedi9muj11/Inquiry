package th.co.maximus.service;

import java.sql.SQLException;
import java.util.List;

import th.co.maximus.bean.TrscreDitrefManualBean;
import th.co.maximus.model.TrsCreditrefEpisOffline;

public interface TrscreDitrefManualService {

	void insertTrscreDitrefManua(TrscreDitrefManualBean trscreDitrefManualBean);

	List<TrscreDitrefManualBean> TrscreDitrefManualAll();
	public List<TrsCreditrefEpisOffline> findByMethodId(long methodId) throws SQLException;

}
