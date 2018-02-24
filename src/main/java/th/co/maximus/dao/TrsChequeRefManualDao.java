package th.co.maximus.dao;

import java.util.List;

import th.co.maximus.bean.TrsChequeRefManualBean;

public interface TrsChequeRefManualDao {
	public void insert(TrsChequeRefManualBean trsChequeRefManualBean);
	
	public List<TrsChequeRefManualBean> findTrachequeFromManualId(long manualId);

}
