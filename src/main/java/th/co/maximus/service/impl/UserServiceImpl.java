package th.co.maximus.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.UserBean;
import th.co.maximus.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserBean selectBy(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserBean> selectAll() {
		List<UserBean> result = new ArrayList<UserBean>();
		result = jdbcTemplate.query(" select * from user ", new mapper());
		return result;
	}
	
	private static final class mapper implements RowMapper<UserBean> {

		@Override
		public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserBean userBean = new UserBean();
			userBean.setId(rs.getInt("id"));
			userBean.setName(rs.getString("name"));
			userBean.setSurName(rs.getString("surName"));
			userBean.setRoleCode(rs.getString("roleCode"));
			return userBean;
		}

	}

}
