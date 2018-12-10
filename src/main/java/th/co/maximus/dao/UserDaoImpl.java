package th.co.maximus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import th.co.maximus.model.UserBean;

@Repository("UserDao")
public class UserDaoImpl implements UserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public UserBean findByUsername(String username){
		List<Object> param = new LinkedList<Object>();
		
		UserBean bean = new UserBean();
		try {
			StringBuilder sqlStmt = new StringBuilder();
			sqlStmt.append("SELECT ur.Name, ur.SurName, ur.ID  ");
			sqlStmt.append(" FROM USER ur ");
			sqlStmt.append(" WHERE  ur.Username = ?  ");
			
			param.add(username);
			Object[] paramArr = param.toArray();
			bean = jdbcTemplate.queryForObject(sqlStmt.toString(), paramArr, new mapUserBean());
			
//			PreparedStatement preparedStatement = connect.prepareStatement(sqlStmt.toString());
//			preparedStatement.setString(1, username);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				bean = new UserBean(resultSet.getString(1), resultSet.getString(2));
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	private static final class mapUserBean implements RowMapper<UserBean> {

		@Override
		public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserBean userBean = new UserBean();
			userBean.setSurName(rs.getString("ur.Name"));
			userBean.setLastName(rs.getString("ur.SurName"));
			userBean.setRoleId(rs.getLong("ur.ID"));
			return userBean;
		}

	}
	
	private static final class mapUserRoleBean implements RowMapper<UserBean> {
		
		@Override
		public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserBean userBean = new UserBean();
			userBean.setRoleId(rs.getLong("r.Role_ID"));
			return userBean;
		}
		
	}

	@Override
	public UserBean findByUsernameFromRole(Long id) {
		UserBean bean = new UserBean();
		StringBuilder sqlStmt = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		
		sqlStmt.append("SELECT r.Role_ID  ");
		sqlStmt.append(" FROM USER_ROLE r ");
		sqlStmt.append(" WHERE r.User_ID = ? ");
		
		param.add(id);
		Object[] paramArr = param.toArray();
		bean = jdbcTemplate.queryForObject(sqlStmt.toString(), paramArr, new mapUserRoleBean());
		
		return bean;
	}

}
