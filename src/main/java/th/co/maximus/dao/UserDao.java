package th.co.maximus.dao;

import java.sql.SQLException;

import th.co.maximus.model.UserBean;

public interface UserDao {
	public UserBean findByUsername(String username)throws SQLException;
}
