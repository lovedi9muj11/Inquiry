package th.co.maximus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.MasterDatasBean;

@Service
public class MasterDatasDaoImpl implements MasterDatasDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final class masterData implements RowMapper<MasterDatasBean> {

		@Override
		public MasterDatasBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			MasterDatasBean glBean = new MasterDatasBean();
			glBean.setId(rs.getLong("ID"));
			glBean.setKeyCode(rs.getString("KEYCODE"));
			glBean.setValue(rs.getString("VALUE"));
			glBean.setGroupKey(rs.getString("GROUP_KEY"));
			glBean.setType(rs.getString("TYPE"));
			glBean.setStatus(rs.getString("STATUS"));
			glBean.setOrdered(rs.getString("ORDERED"));
			glBean.setParentId(rs.getString("PARENT_ID"));
			glBean.setRefId(rs.getString("REF_ID"));
			glBean.setProperty1(rs.getString("PROPERTY_1"));
			glBean.setProperty2(rs.getString("PROPERTY_2"));
			glBean.setProperty3(rs.getString("PROPERTY_3"));
			glBean.setProperty4(rs.getString("PROPERTY_4"));
			glBean.setProperty5(rs.getString("PROPERTY_5"));
			glBean.setRemark(rs.getString("REMARK"));
			glBean.setRecordStatus(rs.getString("RECORD_STATUS"));
			
			return glBean;
		}

	}

	@Override
	public List<MasterDatasBean> findByRevenueType() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MASTER_DATA WHERE GROUP_KEY = 'REVENUE_TYPE'  ");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}

	@Override
	public List<MasterDatasBean> findByProduct() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MASTER_DATA WHERE GROUP_KEY = 'PRODUCT'  ");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}

	@Override
	public List<MasterDatasBean> findByVat() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MASTER_DATA WHERE GROUP_KEY = 'VAT'  ");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}

	@Override
	public List<MasterDatasBean> findByBankName() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MASTER_DATA WHERE GROUP_KEY = 'BANK_TYPE'  ");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}

	@Override
	public MasterDatasBean findByKey(String keyCode) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM MASTER_DATA WHERE KEYCODE = ? ");
		MasterDatasBean master = (MasterDatasBean)jdbcTemplate.queryForObject(sql.toString(), new Object[] { keyCode }, new masterData());
		return master;
	}

	@Override
	public MasterDatasBean findByGrop(String groupCode, String keyCode) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM MASTER_DATA WHERE GROUP_KEY = ? and KEYCODE = ? ");
		MasterDatasBean master = (MasterDatasBean)jdbcTemplate.queryForObject(sql.toString(), new Object[] { groupCode, keyCode }, new masterData());
		return master;
	}
}
