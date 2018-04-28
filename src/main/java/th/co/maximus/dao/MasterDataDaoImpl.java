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
import org.springframework.stereotype.Repository;

import th.co.maximus.bean.MasterDataBean;
import th.co.maximus.constants.Constants;
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
		sql.append(" WHERE ms.groupType = 'BANK_CODE' ");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}

	@Override
	public List<MasterDataBean> findAllByBankName() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM master_data ms  ");
		sql.append(" WHERE ms.groupType = 'BANK_NAME' ");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}
	
	@Override
	public List<MasterDataBean> findAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM master_data ms  ");
		sql.append(" WHERE ms.groupType = 'INITVALUE' ");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}
	


	private static final class masterData implements RowMapper<MasterDataBean> {

		@Override
		public MasterDataBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			MasterDataBean masterDataBean = new MasterDataBean();
			masterDataBean.setId(rs.getInt("id"));
			masterDataBean.setValue(rs.getString("valueKey"));
			masterDataBean.setText(rs.getString("text"));
			masterDataBean.setGroup(rs.getString("groupType"));
			
			return masterDataBean;
		}

	}



	@Override
	public int insertMasterdata(MasterDataBean masterDataBean) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO master_data (valueKey, text, groupType)  VALUES (?,?,?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(sql, new String[] { "id" });
				pst.setString(1, masterDataBean.getValue());
				pst.setString(2, masterDataBean.getText());
				pst.setString(3, masterDataBean.getGroup());
				return pst;
			}
		}, keyHolder);
		int newUserId = keyHolder.getKey().intValue();
		return newUserId;
	}
	
	@Override
	public int insertMasterdataGroup(MasterDataBean masterDataBean) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO master_data (valueKey, text, groupType)  VALUES (?,?,?)";
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(sql, new String[] { "id" });
				pst.setString(1, masterDataBean.getValue());
				pst.setString(2, masterDataBean.getValue());
				pst.setString(3, Constants.MasterData.MASTERDATA_GROUP);
				return pst;
			}
		}, keyHolder);
		int newUserId = keyHolder.getKey().intValue();
		return newUserId;
	}
	
	@Override
	public List<MasterDataBean> findAllByServiceType() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM master_data ms  ");
		sql.append(" WHERE ms.groupType = 'SERVICETYPE'");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}
	
	@Override
	public List<MasterDataBean> findAllByServiceDepartment() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM master_data ms  ");
		sql.append(" WHERE ms.groupType = 'SERVICEDEPARTMENT'");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}
	
	@Override
	public List<MasterDataBean> findAllByServiceName() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM master_data ms  ");
		sql.append(" WHERE ms.groupType = 'SERVICENAME'");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}
	@Override
	public List<MasterDataBean> findAllByCategory() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM master_data ms  ");
		sql.append(" WHERE ms.groupType = 'CATEGORY'");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}
}
