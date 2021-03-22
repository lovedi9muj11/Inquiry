package th.co.inquiry.dao;

import th.co.inquiryx.bean.UserBean;

public interface MasOfficerDao {

	int insertUserService(UserBean userBean);
	
	void updatetUserService(UserBean userBean);

	void deleteBeforInsert();
	
	void deleteBeforInsertUserRole();
	
	void insertUserRole(int idUser, int idRole);
	
	int findRoleByRoleName(String roleName);
	
	boolean selectUserBeanByID(UserBean userBean);
	
	void updatePassword(String password, String username);
	
	int findUserRole(Long idUser);

}
