package th.co.maximus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import th.co.maximus.bean.TrsChequeRefManualBean;

@Repository("TrsChequeRefManualDao")
public class TrsChequeRefManualDaoImpl implements TrsChequeRefManualDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public TrsChequeRefManualDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public void insert(TrsChequeRefManualBean trsChequeRefManualBean) {
		String sql = "INSERT INTO trschequeref_manual ( CHEQUENO, PUBLISHERID, PUBLISHER, BRANCH, AMOUNT, UPDATEDTTM, UPDATESYSTEM, UPDATEUSER, VERSIONSTAMP, CHEQUEDATE, BOUNCE_CHEQUE_DATE, REVERSE_AR_DATE, BOUNCE_STATUS, METHOD_MANUAL_ID)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,  trsChequeRefManualBean.getChequeNo(), trsChequeRefManualBean.getPublisherId(),trsChequeRefManualBean.getPublisher(),trsChequeRefManualBean.getBranch(),trsChequeRefManualBean.getaMount(),
				trsChequeRefManualBean.getUpdateDttm(),trsChequeRefManualBean.getUpdateSystem(),trsChequeRefManualBean.getUpdateUser(),trsChequeRefManualBean.getVersionStamp(),trsChequeRefManualBean.getCheDate(),trsChequeRefManualBean.getBounceChequeDate(),
				trsChequeRefManualBean.getReverseArDate(),trsChequeRefManualBean.getBounceStatus(),trsChequeRefManualBean.getMethodManualId());
		
	}
	
	
	
	private static final class TrsChequeRefManualJoin implements RowMapper<TrsChequeRefManualBean> {

		@Override
		public TrsChequeRefManualBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			TrsChequeRefManualBean trsChequeRefManualBean = new TrsChequeRefManualBean();
			trsChequeRefManualBean.setId(rs.getLong("ID"));
			trsChequeRefManualBean.setChequeNo(rs.getString("CHEQUENO"));
			trsChequeRefManualBean.setPublisherId(rs.getString("PUBLISHERID"));
			trsChequeRefManualBean.setPublisher(rs.getString("PUBLISHER"));
			trsChequeRefManualBean.setBranch(rs.getString("BRANCH"));
			trsChequeRefManualBean.setaMount(rs.getLong("AMOUNT"));
			trsChequeRefManualBean.setUpdateDttm(rs.getTimestamp("UPDATEDTTM"));
			trsChequeRefManualBean.setUpdateSystem(rs.getString("UPDATESYSTEM"));
			trsChequeRefManualBean.setUpdateUser(rs.getString("UPDATEUSER"));
			trsChequeRefManualBean.setVersionStamp(rs.getLong("VERSIONSTAMP"));
			trsChequeRefManualBean.setChequeDate(rs.getTimestamp("CHEQUEDATE"));
			trsChequeRefManualBean.setBounceChequeDate(rs.getTimestamp("BOUNCE_CHEQUE_DATE"));
			trsChequeRefManualBean.setReverseArDate(rs.getTimestamp("REVERSE_AR_DATE"));
			trsChequeRefManualBean.setBounceStatus(rs.getString("BOUNCE_STATUS"));
			trsChequeRefManualBean.setMethodManualId(rs.getLong("METHOD_MANUAL_ID"));
			return trsChequeRefManualBean;
		}

	}

	@Override
	public List<TrsChequeRefManualBean> findTrachequeFromManualId(long manualId) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from trschequeref_manual trschequeref_m where trschequeref_m.ID = ");
		sql.append(manualId);
		return jdbcTemplate.query(sql.toString() , new TrsChequeRefManualJoin());
	}

}
