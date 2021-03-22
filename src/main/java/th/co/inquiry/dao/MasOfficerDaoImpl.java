package th.co.inquiry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import th.co.inquiry.constants.Constants;
import th.co.inquiryx.bean.RoleBean;
import th.co.inquiryx.bean.UserBean;

@Service
public class MasOfficerDaoImpl implements MasOfficerDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insertUserService(UserBean userBean) {
		String sql = "INSERT INTO user (Password, Username, Name, SurName, LoginFlag)  VALUES (?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
//		java.util.Date now = new java.util.Date();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(sql, new String[] { "id" });
				pst.setString(1, userBean.getPassword());
				pst.setString(2, userBean.getUserName());
				pst.setString(3, userBean.getName());
				pst.setString(4, userBean.getSurName());
				pst.setString(5, userBean.getLoginFlag());
				return pst;
			}
		}, keyHolder);
		
		return keyHolder.getKey().intValue();
	}

	@Override
	public void deleteBeforInsert() {
		String del = " delete from user where username <> 'admin' and loginflag <> 'N' ";
		jdbcTemplate.update(del);
	}

	@Override
	public void deleteBeforInsertUserRole() {
//		String del = "delete from user_role where Role_ID <> '1'";
		String delsql = "DELETE user_role FROM user_role INNER JOIN user ON user.ID=user_role.User_ID WHERE user.loginflag <> 'N'";
		jdbcTemplate.update(delsql);
	}

	@Override
	public void insertUserRole(int idUser, int idRole) {
		String sql = "INSERT INTO user_role (User_ID, Role_ID)  VALUES (?,?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setInt(1, idUser);
				pst.setInt(2, idRole);
				return pst;
			}
		});
		
	}

	@Override
	public int findRoleByRoleName(String roleName) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM role  ");
		sql.append(" WHERE Name =  '");
		sql.append(roleName+"'");
		List<RoleBean> res = jdbcTemplate.query(sql.toString() , new RoleBeanMap());
		return res.get(0).getId();
	}
	
	@Override
	public boolean selectUserBeanByID(UserBean userBean) {
		boolean result = true;
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM user  ");
		sql.append(" WHERE username =  '");
		sql.append(userBean.getUserName()+"'");
		UserBean res = jdbcTemplate.queryForObject(sql.toString() , new UserBeanMap());
		if(null == res) {
			result = false;
		}
		return result;
	}
	
	private static final class RoleBeanMap implements RowMapper<RoleBean> {

		@Override
		public RoleBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			RoleBean roleBean = new RoleBean();
			roleBean.setId(rs.getInt("ID"));
			return roleBean;
		}

	}
	
	private static final class UserBeanMap implements RowMapper<UserBean> {

		@Override
		public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserBean userBean = new UserBean();
			userBean.setUserName(rs.getString("Username"));
			return userBean;
		}

	}
	
	private static final class UserRoleBeanMap implements RowMapper<RoleBean> {
		
		@Override
		public RoleBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			RoleBean roleBean = new RoleBean();
			roleBean.setId(rs.getInt("Role_ID"));
			return roleBean;
		}
		
	}

	@Override
	public void updatePassword(String password, String username) {
		StringBuilder sqlStmt = new StringBuilder();
		sqlStmt.append("UPDATE user SET  Password = '"+password+"', LoginFlag = '"+Constants.USER.LOGIN_FLAG_N+"'");
		sqlStmt.append(" WHERE  Username = ? ");
		Object param = username;
		jdbcTemplate.update(sqlStmt.toString(), param);
	}

	@Override
	public int findUserRole(Long idUser) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM user_role  ");
		sql.append(" WHERE User_ID =  '");
		sql.append(idUser+"'");
		RoleBean res = jdbcTemplate.queryForObject(sql.toString() , new UserRoleBeanMap());
		
		return res.getId();
	}

	@Override
	public void updatetUserService(UserBean userBean) {
		StringBuilder sqlStmt = new StringBuilder();
		sqlStmt.append("UPDATE user SET  Password = '"+userBean.getPassword()+"', Username = '"+userBean.getUserName()+"'");
		sqlStmt.append(", Name = '"+userBean.getName()+"', SurName = '"+userBean.getSurName()+"'");
		sqlStmt.append(" WHERE  ID = ? ");
		Object param = userBean.getId();
		jdbcTemplate.update(sqlStmt.toString(), param);
	}

}
