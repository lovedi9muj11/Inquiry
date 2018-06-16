package th.co.maximus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import th.co.maximus.model.UserBean;
@Repository("UserDao")
public class UserDaoImpl implements UserDao{
	@Autowired
	DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public UserBean findByUsername(String username) throws SQLException {
		Connection connect = dataSource.getConnection();
		UserBean bean = new UserBean();
		try {
			StringBuilder sqlStmt = new StringBuilder();
			sqlStmt.append("SELECT ur.Name,ur.SurName  ");
			sqlStmt.append(" FROM USER ur ");
			sqlStmt.append(" WHERE  ur.Username = ?  ");
			PreparedStatement preparedStatement = connect.prepareStatement(sqlStmt.toString());
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bean = new UserBean(resultSet.getString(1), resultSet.getString(2));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bean;
	}

}
