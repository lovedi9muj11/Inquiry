package th.co.maximus.dao;

import java.util.List;

import th.co.maximus.bean.DeductionManualBean;

public interface DeductionManualDao {
	public void insert(DeductionManualBean deductionManualBean);
	
	public List<DeductionManualBean> findDeductionManualFromManualId(long manualId);

}
