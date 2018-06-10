package th.co.maximus.dao;

import th.co.maximus.bean.UserBean;

public interface MasOfficerDao {

	int insertUserService(UserBean userBean);

	void deleteBeforInsert();
	
	void deleteBeforInsertUserRole();
	
	void insertUserRole(int idUser, int idRole);
	
	int findRoleByRoleName(String roleName);

}
