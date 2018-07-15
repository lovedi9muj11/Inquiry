package th.co.maximus.dao;

import java.sql.SQLException;
import java.util.List;

import th.co.maximus.bean.TrsChequeRefManualBean;
import th.co.maximus.model.TrsChequerefEpisOffline;

public interface TrsChequeRefManualDao {
	
	public void insert(TrsChequeRefManualBean trsChequeRefManualBean);

	public List<TrsChequeRefManualBean> findTrachequeFromManualId(long manualId);

	public List<TrsChequerefEpisOffline> findByManualId(long methodManualId) throws SQLException;

}
