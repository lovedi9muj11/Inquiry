package th.co.inquiry.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import th.co.inquiry.model.UserBean;
import th.co.inquiryx.bean.MasterDataBean;

@Service
public interface MasterDataService {
	
	public int insert(MasterDataBean masterDataBean);
	
	public int insertGroup(MasterDataBean masterDataBean);
	
	public UserBean findByUsername(String username)throws SQLException;
	
	public UserBean findByUsernameFromRole(Long id)throws SQLException;
	
	MasterDataBean findGroupTypeByKeyCode(String groupKey);
	
	List<MasterDataBean> findGroupTypeByGroupKey(String groupKey);
	
	List<MasterDataBean> findAll();

	public void save(MasterDataBean masterDataBean);
	
	void delete(MasterDataBean masterDataBean, String username);
}
