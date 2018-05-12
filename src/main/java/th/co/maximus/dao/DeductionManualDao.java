package th.co.maximus.dao;

import java.util.List;

import th.co.maximus.bean.DeductionManualBean;
import th.co.maximus.model.DuductionEpisOffline;

public interface DeductionManualDao {
	public void insert(DeductionManualBean deductionManualBean);
	
	public List<DeductionManualBean> findDeductionManualFromManualId(long manualId);
	
	public List<DuductionEpisOffline> findDeductionManual(long manualId) throws Exception;

}
