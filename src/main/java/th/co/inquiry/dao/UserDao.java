package th.co.inquiry.dao;

import th.co.inquiry.model.UserBean;

public interface UserDao {
	public UserBean findByUsername(String username);
	
	public UserBean findByUsernameFromRole(Long id);
}
