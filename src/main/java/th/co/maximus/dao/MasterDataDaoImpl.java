package th.co.maximus.dao;

import java.sql.Connection;
import java.sql.Date;
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
import th.co.maximus.bean.MasterDataSyncBean;
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
		sql.append(" SELECT * FROM MASTER_DATA ms  ");
		sql.append(" WHERE ms.group_key = 'BANK_TYPE' ");
		return jdbcTemplate.query(sql.toString() , new masterDataCode());
	}

	@Override
	public List<MasterDataBean> findAllByBankName() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MASTER_DATA ms  ");
		sql.append(" WHERE ms.group_key = 'BANK_TYPE' ");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}
	
	@Override
	public List<MasterDataBean> findAll() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MASTER_DATA  ");
//		sql.append(" WHERE ms.groupType = 'INITVALUE' ");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}
	
	@Override
	public int insertMasterdata(MasterDataBean masterDataBean) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO MASTER_DATA (valueKey, text, groupType)  VALUES (?,?,?)";
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
		String sql = "INSERT INTO MASTER_DATA (valueKey, text, groupType)  VALUES (?,?,?)";
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
		sql.append(" SELECT * FROM MAP_GL_SERVICE_TYPE mg  ");
		sql.append(" WHERE mg.SOURCE = '"+Constants.MasterData.OTHER+"'");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}
	
	@Override
	public List<MasterDataBean> findAllByServiceDepartment() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MASTER_DATA ms  ");
		sql.append(" WHERE ms.group_key = '"+Constants.MasterData.BUSINESS_AREA+"'");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}
	
	@Override
	public List<MasterDataBean> findAllByServiceName() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MASTER_DATA ms  ");
		sql.append(" WHERE ms.groupType = 'SERVICENAME'");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}
	@Override
	public List<MasterDataBean> findAllByCategory() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MASTER_DATA ms  ");
		sql.append(" WHERE ms.group_key = '"+Constants.MasterData.OTHER_PAYMENT_UNIT+"'");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}

	@Override
	public List<MasterDataBean> findAllByGropType(String groupType) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM MASTER_DATA ms  ");
		sql.append(" WHERE ms.groupType = ");
		sql.append("'"+groupType+"'");
		return jdbcTemplate.query(sql.toString() , new masterData());
	}

	@Override
	public void insertMasterDataSync(MasterDataSyncBean masterDataSyncBean) {
		String sql = "INSERT INTO MASTER_DATA (KEYCODE, VALUE, GROUP_KEY, TYPE, STATUS, ORDERED, PARENT_ID, REF_ID, PROPERTY_1, PROPERTY_2, PROPERTY_3, PROPERTY_4, PROPERTY_5, CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		java.util.Date now = new java.util.Date();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(sql, new String[] { "id" });
				pst.setString(1, masterDataSyncBean.getKey());
				pst.setString(2, masterDataSyncBean.getValue());
				pst.setString(3, masterDataSyncBean.getGroupKey());
				pst.setString(4, masterDataSyncBean.getType());
				pst.setString(5, masterDataSyncBean.getStatus());
				pst.setString(6, masterDataSyncBean.getOrdered());
				pst.setString(7, masterDataSyncBean.getParentId());
				pst.setString(8, masterDataSyncBean.getRefId());
				pst.setString(9, masterDataSyncBean.getProperty1());
				pst.setString(10, masterDataSyncBean.getProperty2());
				pst.setString(11, masterDataSyncBean.getProperty3());
				pst.setString(12, masterDataSyncBean.getProperty4());
				pst.setString(13, masterDataSyncBean.getProperty5());
//				pst.setString(14, masterDataSyncBean.getRemark());
				pst.setString(14, masterDataSyncBean.getCreateBy());
				pst.setDate(15, new Date(now.getTime()));
				pst.setString(16, masterDataSyncBean.getUpdateBy());
				pst.setDate(17, new Date(now.getTime()));
//				pst.setString(19, masterDataSyncBean.getRecordStatus());
				return pst;
			}
		});
	}

	@Override
	public void deleteBeforInsertMS() {
		String del = "delete from MASTER_DATA";
		jdbcTemplate.update(del);
	}
	
	private static final class masterData implements RowMapper<MasterDataBean> {

		@Override
		public MasterDataBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			MasterDataBean masterDataBean = new MasterDataBean();
			masterDataBean.setId(rs.getInt("id"));
			masterDataBean.setValue(rs.getString("KEYCODE"));
			masterDataBean.setText(rs.getString("VALUE"));
			masterDataBean.setGroup(rs.getString("GROUP_KEY"));
			
			return masterDataBean;
		}

	}
	
	private static final class masterDataCode implements RowMapper<MasterDataBean> {

		@Override
		public MasterDataBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			MasterDataBean masterDataBean = new MasterDataBean();
			masterDataBean.setId(rs.getInt("id"));
			masterDataBean.setValue(rs.getString("KEYCODE"));
			masterDataBean.setText(rs.getString("KEYCODE"));
			masterDataBean.setGroup(rs.getString("GROUP_KEY"));
			
			return masterDataBean;
		}

	}

	
}
