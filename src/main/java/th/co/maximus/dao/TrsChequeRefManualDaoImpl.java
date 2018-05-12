package th.co.maximus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import th.co.maximus.bean.TrsChequeRefManualBean;
import th.co.maximus.model.TrsChequerefEpisOffline;

@Repository("TrsChequeRefManualDao")
public class TrsChequeRefManualDaoImpl implements TrsChequeRefManualDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public TrsChequeRefManualDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Autowired
	DataSource dataSource;
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
	@Override
	public List<TrsChequerefEpisOffline> findByManualId(long methodManualId) throws SQLException {
		Connection connect = dataSource.getConnection();
		List<TrsChequerefEpisOffline> beanReReq = new ArrayList<TrsChequerefEpisOffline>();
		TrsChequerefEpisOffline bean = new TrsChequerefEpisOffline();
		try {
			StringBuilder sqlStmt = new StringBuilder();
			sqlStmt.append("SELECT tcm.CHEQUENO ,tcm.PUBLISHERID,tcm.PUBLISHER,tcm.BRANCH,tcm.AMOUNT,tcm.CHEQUEDATE,tcm.BOUNCE_CHEQUE_DATE,tcm.REVERSE_AR_DATE,tcm.BOUNCE_STATUS ");
			sqlStmt.append(" FROM trschequeref_manual tcm ");
			sqlStmt.append(" WHERE  tcm.METHOD_MANUAL_ID = ?  ");
			
			
			PreparedStatement preparedStatement = connect.prepareStatement(sqlStmt.toString());
			preparedStatement.setLong(1, methodManualId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bean = new TrsChequerefEpisOffline(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getBigDecimal(5), resultSet.getDate(6), resultSet.getDate(7), resultSet.getDate(8), resultSet.getString(9));
				beanReReq.add(bean);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return beanReReq;
	}

}
