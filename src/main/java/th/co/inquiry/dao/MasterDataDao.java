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
	
	MasterDataBean findGroupTypeByKeyCode(String groupKey);
	
	public void delete(int id);
}
