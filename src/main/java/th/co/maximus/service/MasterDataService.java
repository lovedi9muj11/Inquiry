package th.co.maximus.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import th.co.maximus.auth.model.GroupTypeDropdown;
import th.co.maximus.bean.MasterDataBean;
import th.co.maximus.bean.MasterDataSyncBean;
import th.co.maximus.bean.MasterDatasBean;
import th.co.maximus.model.UserBean;

@Service
public interface MasterDataService {
	
	public List<MasterDataBean> findAllByBankCode() ;
	
	public List<MasterDataBean> findAllByBankName() ;
	
	List<GroupTypeDropdown> findAll();
	
	List<GroupTypeDropdown> findBatch(String code);
	
	public int insert(MasterDataBean masterDataBean);
	
	public int insertGroup(MasterDataBean masterDataBean);
	
	public List<MasterDataBean> findAllByServiceType();
	
	public List<MasterDataBean> findAllByServiceDepartment();
	
	public List<MasterDataBean> findAllByServiceName();
	
	public List<MasterDataBean> findAllByCategory();
	
	String insertMasterDataSync(List<MasterDataSyncBean> masterDataSyncBean);
	
	public MasterDatasBean findByKeyCode(String keyCode);
	
	public UserBean findByUsername(String username)throws SQLException;
	
	public UserBean findByUsernameFromRole(Long id)throws SQLException;
	
	List<MasterDataBean> showAllMSNGL();
	
	MasterDataBean findGroupTypeByKeyCode(String groupKey);
	
	void insertBatch(MasterDataBean masterDataBean);

	List<MasterDataBean> findByVat();
	
	List<MasterDatasBean> findByCMSegment();
	
	List<MasterDatasBean> findByCMSegmentByCRM();
	
	public MasterDatasBean findByGrop(String groupCode, String keyCode);
	
	public MasterDatasBean findByppt1(String ppt1);
	
}
