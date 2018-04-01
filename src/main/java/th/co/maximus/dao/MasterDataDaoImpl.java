package th.co.maximus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import th.co.maximus.bean.MasterDataBean;
@Repository
public class MasterDataDaoImpl implements MasterDataDao{
	@Autowired
	DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public MasterDataDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public List<MasterDataBean> findAllByBankCode() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM master_data ms  ");
		sql.append(" WHERE ms.group = 'BANK_CODE' ");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}

	@Override
	public List<MasterDataBean> findAllByBankName() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM master_data ms  ");
		sql.append(" WHERE ms.group = 'BANK_NAME' ");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}
	
	@Override
	public List<MasterDataBean> findAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM master_data ms  ");
		sql.append(" WHERE ms.group = 'INITVALUE' ");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}
	


	private static final class masterData implements RowMapper<MasterDataBean> {

		@Override
		public MasterDataBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			MasterDataBean masterDataBean = new MasterDataBean();
			masterDataBean.setId(rs.getInt("id"));
			masterDataBean.setValue(rs.getString("value"));
			masterDataBean.setText(rs.getString("text"));
			masterDataBean.setGroup(rs.getString("group"));
			
			return masterDataBean;
		}

	}
}
