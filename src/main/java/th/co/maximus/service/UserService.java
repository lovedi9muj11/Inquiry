package th.co.maximus.service;

import java.util.List;

import th.co.maximus.bean.UserBean;

public interface UserService {
	
	void insert();
	
	void update();
	
	void delete();
	
	UserBean selectBy(String name);
	
	List<UserBean> selectAll();
	
	UserBean authenLogin(String username,String password);
	

}
