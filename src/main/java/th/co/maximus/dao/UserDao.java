package th.co.maximus.dao;

import th.co.maximus.model.UserBean;

public interface UserDao {
	public UserBean findByUsername(String username);
	
	public UserBean findByUsernameFromRole(Long id);
}
