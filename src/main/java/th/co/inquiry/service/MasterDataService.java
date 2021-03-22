package th.co.inquiry.service;

import java.sql.SQLException;

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
	
	void insertBatch(MasterDataBean masterDataBean);

}
