package th.co.maximus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.CasualCustomerBean;

@Service
public class CasualCustomerDaoImp implements CasualCustomerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final class mapCasualModel implements RowMapper<CasualCustomerBean> {

		@Override
		public CasualCustomerBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			CasualCustomerBean customerBean = new CasualCustomerBean();
			customerBean.setCasualId(rs.getLong("CASUAL_ID"));
			customerBean.setName(rs.getString("NAME"));
			customerBean.setTaxId(rs.getString("TAX_ID"));
			customerBean.setServiceCode(rs.getString("SERVICE_CODE"));
			customerBean.setBranch(rs.getString("BRANCH"));
			customerBean.setAddress(rs.getString("ADDRESS"));
			return customerBean;
		}

	}
		
	@Override
	public void insert(CasualCustomerBean bean) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO OTHER_TEMP_CUSTOMER ");
		sql.append("(NAME, TAX_ID, SERVICE_CODE, BRANCH, ADDRESS, REMARK, CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE) ");
		sql.append("VALUES (?,?,?,?,?,?,?,?,?,?) ");
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(sql.toString(), new String[] { "id" });
				pst.setString(1, bean.getName());
				pst.setString(2, bean.getTaxId());
				pst.setString(3, bean.getServiceCode());
				pst.setString(4, bean.getBranch());
				pst.setString(5, bean.getAddress());
				pst.setString(6, null);
				pst.setString(7, null);
				pst.setString(8, null);
				pst.setString(9, null);
				pst.setString(10, null);
				return pst;
			}
		});
	}

	@Override
	public void update(CasualCustomerBean bean) throws Exception {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		sql.append(" UPDATE OTHER_TEMP_CUSTOMER set NAME = ?, SERVICE_CODE = ?, BRANCH = ?, ADDRESS = ? WHERE TAX_ID = ? ");
		
		param.add(bean.getName());
		param.add(bean.getServiceCode());
		param.add(bean.getBranch());
		param.add(bean.getAddress());
		param.add(bean.getTaxId());
		
		Object[] paramArr = param.toArray();
		
		jdbcTemplate.update(sql.toString(), paramArr);
	}

	@Override
	public CasualCustomerBean findByTaxId(String taxId) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM OTHER_TEMP_CUSTOMER WHERE 1=1 and TAX_ID = '"+taxId+"'");
		
		List<CasualCustomerBean> data = jdbcTemplate.query(sql.toString(), new mapCasualModel());
		
		return CollectionUtils.isNotEmpty(data)?data.get(0):null;
	}

	@Override
	public List<CasualCustomerBean> findByTaxIdNName(String taxId, String name) throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM OTHER_TEMP_CUSTOMER WHERE 1=1 ");
		
		if(StringUtils.isNotBlank(taxId)) {
			sql.append(" and TAX_ID = '"+taxId+"'");
		}
		
		if(StringUtils.isNotBlank(name)) {
			sql.append(" and NAME like '%"+name+"%'");
		}
		
		List<CasualCustomerBean> data = jdbcTemplate.query(sql.toString(), new mapCasualModel());
		
		return CollectionUtils.isNotEmpty(data)?data:null;
	}

	@Override
	public List<CasualCustomerBean> findAll() throws Exception {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM OTHER_TEMP_CUSTOMER ");
		
		return jdbcTemplate.query(sql.toString(), new mapCasualModel());
	}

}
