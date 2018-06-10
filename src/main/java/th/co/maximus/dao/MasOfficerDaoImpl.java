package th.co.maximus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.RoleBean;
import th.co.maximus.bean.UserBean;

@Service
public class MasOfficerDaoImpl implements MasOfficerDao{
	
	@Autowired
	DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	public MasOfficerDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int insertUserService(UserBean userBean) {
		String sql = "INSERT INTO user (Password, Username, Name, SurName)  VALUES (?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
//		java.util.Date now = new java.util.Date();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(sql, new String[] { "id" });
				pst.setString(1, userBean.getPassword());
				pst.setString(2, userBean.getUserName());
				pst.setString(3, userBean.getName());
				pst.setString(4, userBean.getSurName());
				return pst;
			}
		}, keyHolder);
		
		return keyHolder.getKey().intValue();
	}

	@Override
	public void deleteBeforInsert() {
		String del = "delete from user";
		jdbcTemplate.update(del);
	}

	@Override
	public void deleteBeforInsertUserRole() {
		String del = "delete from user_role";
		jdbcTemplate.update(del);
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
	
	private static final class RoleBeanMap implements RowMapper<RoleBean> {

		@Override
		public RoleBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			RoleBean roleBean = new RoleBean();
			roleBean.setId(rs.getInt("ID"));
			return roleBean;
		}

	}

}
