package th.co.maximus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
	
	@Override
	public void insert(TrsChequeRefManualBean trsChequeRefManualBean) {
		String sql = " INSERT INTO TRSCHEQUEREF_MANUAL(CHEQUENO, PUBLISHERID, PUBLISHER, BRANCH, AMOUNT, UPDATEDTTM, VERSIONSTAMP, CHEQUEDATE, BOUNCE_CHEQUE_DATE, REVERSE_AR_DATE, BOUNCE_STATUS, METHOD_MANUAL_ID,CREATE_BY, CREATE_DATE,UPDATE_BY,UPDATE_DATE)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,  trsChequeRefManualBean.getChequeNo(), trsChequeRefManualBean.getPublisherId(),trsChequeRefManualBean.getPublisher(),trsChequeRefManualBean.getBranch(),trsChequeRefManualBean.getaMount(),
				trsChequeRefManualBean.getUpdateDttm(),trsChequeRefManualBean.getVersionStamp(),trsChequeRefManualBean.getCheDate(),trsChequeRefManualBean.getBounceChequeDate(),
				trsChequeRefManualBean.getReverseArDate(),trsChequeRefManualBean.getBounceStatus(),trsChequeRefManualBean.getMethodManualId(),trsChequeRefManualBean.getCreateBy(),trsChequeRefManualBean.getCreateDate(),trsChequeRefManualBean.getUpdateBy(),trsChequeRefManualBean.getUpdateDate());
		
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
		sql.append(" select * from TRSCHEQUEREF_MANUAL trschequeref_m where trschequeref_m.ID = ");
		sql.append(manualId);
		return jdbcTemplate.query(sql.toString() , new TrsChequeRefManualJoin());
	}
	@Override
	public List<TrsChequerefEpisOffline> findByManualId(long methodManualId){
//		List<TrsChequerefEpisOffline> beanReReq = new ArrayList<TrsChequerefEpisOffline>();
		List<TrsChequerefEpisOffline> beanReReqs = new ArrayList<TrsChequerefEpisOffline>();
		List<Object> param = new LinkedList<Object>();
//		TrsChequerefEpisOffline bean = new TrsChequerefEpisOffline();
		try {
			StringBuilder sqlStmt = new StringBuilder();
			sqlStmt.append("SELECT tcm.CHEQUENO ,tcm.PUBLISHERID,tcm.PUBLISHER,tcm.BRANCH,tcm.AMOUNT,tcm.CHEQUEDATE,tcm.BOUNCE_CHEQUE_DATE,tcm.REVERSE_AR_DATE,tcm.BOUNCE_STATUS ");
			sqlStmt.append(" FROM TRSCHEQUEREF_MANUAL tcm ");
			sqlStmt.append(" WHERE  tcm.METHOD_MANUAL_ID = ?  ");
			
			param.add(methodManualId);
			Object[] paramArr = param.toArray();
			beanReReqs = jdbcTemplate.query(sqlStmt.toString(), paramArr, new mapTrsChequerefEpisOffline());
			
//			PreparedStatement preparedStatement = connect.prepareStatement(sqlStmt.toString());
//			preparedStatement.setLong(1, methodManualId);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				bean = new TrsChequerefEpisOffline(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getBigDecimal(5), resultSet.getDate(6), resultSet.getDate(7), resultSet.getDate(8), resultSet.getString(9));
//				beanReReq.add(bean);
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return beanReReqs;
	}
	
	private static final class mapTrsChequerefEpisOffline implements RowMapper<TrsChequerefEpisOffline> {

		@Override
		public TrsChequerefEpisOffline mapRow(ResultSet rs, int rowNum) throws SQLException {
			TrsChequerefEpisOffline trsChequerefEpisOffline = new TrsChequerefEpisOffline();
			trsChequerefEpisOffline.setChequeNo(rs.getString("tcm.CHEQUENO"));
			trsChequerefEpisOffline.setPublisherid(rs.getString("tcm.PUBLISHERID"));
			trsChequerefEpisOffline.setPublisher(rs.getString("tcm.PUBLISHER"));
			trsChequerefEpisOffline.setBranch(rs.getString("tcm.BRANCH"));
			trsChequerefEpisOffline.setAmount(rs.getBigDecimal("tcm.AMOUNT"));
			trsChequerefEpisOffline.setChequeDate(rs.getDate("tcm.CHEQUEDATE"));
			trsChequerefEpisOffline.setBounceChequeDate(rs.getDate("tcm.BOUNCE_CHEQUE_DATE"));
			trsChequerefEpisOffline.setReverseArDate(rs.getDate("tcm.REVERSE_AR_DATE"));
			trsChequerefEpisOffline.setBounceStatus(rs.getString("tcm.BOUNCE_STATUS"));
			return trsChequerefEpisOffline;
		}

	}

}
