package th.co.maximus.dao;

import java.util.List;

import th.co.maximus.bean.MasterDatasBean;

public interface MasterDatasDao {

	public List<MasterDatasBean> findByRevenueType();

	public List<MasterDatasBean> findByProduct();

	public List<MasterDatasBean> findByVat();

	public List<MasterDatasBean> findByBankName();
	
	public List<MasterDatasBean> findByBankEDCName();

	public MasterDatasBean findByKey(String keyCode);

	public MasterDatasBean findByGrop(String groupCode, String keyCode);
	
}
