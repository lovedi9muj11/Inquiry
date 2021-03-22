package th.co.inquiry.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import th.co.inquiry.service.ServiceClass;
import th.co.inquiryx.bean.BeanClass;

@Service
public class ServiceImpl implements ServiceClass{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String testMethod(String req) {
		return "Test :: "+req;
	}

	@Override
	public List<BeanClass> allBeanClass() {
		List<BeanClass> result = new ArrayList<BeanClass>();
		result = jdbcTemplate.query(" select * from user ", new mapper());
		return result;
	}
	
	private static final class mapper implements RowMapper<BeanClass> {

		@Override
		public BeanClass mapRow(ResultSet rs, int rowNum) throws SQLException {
			BeanClass beanClass = new BeanClass();
			beanClass.setId(rs.getInt("OrderID"));
			beanClass.setName(rs.getString("OrderNumber"));
			beanClass.setSueName(rs.getString("PersonID"));
			return beanClass;
		}

	}

}
