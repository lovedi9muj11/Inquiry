package th.co.inquiry.dao;

import java.util.List;

import th.co.inquiryx.bean.MasterDatasBean;

public interface MasterDatasDao {

	public MasterDatasBean findByKey(String keyCode);
	
	public MasterDatasBean findByGrop(String groupCode, String keyCode);
	
	public List<MasterDatasBean> findListByKey(String keyCode);

}
