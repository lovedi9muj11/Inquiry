package th.co.inquiry.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import th.co.inquiryx.bean.MasterDataBean;

@Repository
public interface MasterDataDao {
	
	List<MasterDataBean> findAll();
	
	public int insertMasterdata(MasterDataBean masterDataBean);
	
	void updateMasterdata(MasterDataBean masterDataBean);
	
	public int insertMasterdataGroup(MasterDataBean masterDataBean);
	
	public List<MasterDataBean> findAllByGropType(String groupType);
	
	public List<MasterDataBean> findAllByGropKey(String groupKey);
	
	public List<MasterDataBean> findAllQuestion();
	
	MasterDataBean findGroupTypeByKeyCode(String groupKey);
	
	MasterDataBean findGroupTypeByKeyCode(String groupKey, String keyCode);
	
	MasterDataBean findById(int id);
	
	public void delete(int id);
}
