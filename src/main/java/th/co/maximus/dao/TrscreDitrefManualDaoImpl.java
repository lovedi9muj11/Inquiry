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

import th.co.maximus.bean.TrscreDitrefManualBean;
import th.co.maximus.model.TrsCreditrefEpisOffline;

@Repository("TrscreDitrefManualDao")
public class TrscreDitrefManualDaoImpl implements TrscreDitrefManualDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertTrscreDitrefManua(TrscreDitrefManualBean trscreDitrefManualBean) {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO TRSCREDITREF_MANUAL ( CREDITNO, PUBLISHERDEC, CARDTYPE, AMOUNT, UPDATEDTTM, VERSIONSTAMP, METHOD_MANUAL_ID ,CREATE_BY, CREATE_DATE,UPDATE_BY,UPDATE_DATE,EDC_CODE) ");
		sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ");
		jdbcTemplate.update(sql.toString(),  trscreDitrefManualBean.getCreditNo(), trscreDitrefManualBean.getPublisherdec(),trscreDitrefManualBean.getCardType(),trscreDitrefManualBean.getaMount(),
				trscreDitrefManualBean.getUpdateDttm(),trscreDitrefManualBean.getVersionStamp(),trscreDitrefManualBean.getMethodManualId(),trscreDitrefManualBean.getCreateBy(),trscreDitrefManualBean.getCreateDate(),trscreDitrefManualBean.getUpdateBy(),trscreDitrefManualBean.getUpdateDate(),trscreDitrefManualBean.getEdcCode());
		
	}
	
	private static final class TrscreDitrefManualJoin implements RowMapper<TrscreDitrefManualBean> {

		@Override
		public TrscreDitrefManualBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			TrscreDitrefManualBean manualBean = new TrscreDitrefManualBean();
			manualBean.setId(rs.getLong("ID"));
			manualBean.setCreditNo(rs.getString("CREDITNO"));
			manualBean.setPublisherdec(rs.getString("PUBLISHERDEC"));
			manualBean.setCardType(rs.getString("CARDTYPE"));
			manualBean.setaMount(rs.getLong("AMOUNT"));
			manualBean.setUpdateDttm(rs.getTimestamp("UPDATEDTTM"));
			manualBean.setUpdateSystem(rs.getString("UPDATESYSTEM"));
			manualBean.setUpdateUser(rs.getString("UPDATEUSER"));
			manualBean.setVersionStamp(rs.getLong("VERSIONSTAMP"));
			manualBean.setMethodManualId(rs.getString("METHOD_MANUAL_ID"));
			
			
			return manualBean;
		}

	}
	
	@Override
	public List<TrscreDitrefManualBean> trscreDitrefManualFromManualId(long manualId) {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from TRSCREDITREF_MANUAL trscreditref_m where trscreditref_m.ID = ");
		sql.append(manualId);
		return jdbcTemplate.query(sql.toString(), new TrscreDitrefManualJoin());
	}

	@Override
	public List<TrsCreditrefEpisOffline> findByMethodId(long methodId) {
//		List<TrsCreditrefEpisOffline> beanReReq = new ArrayList<TrsCreditrefEpisOffline>();
		List<TrsCreditrefEpisOffline> beanReReqs = new ArrayList<TrsCreditrefEpisOffline>();
		List<Object> param = new LinkedList<Object>();
//		TrsCreditrefEpisOffline bean = new TrsCreditrefEpisOffline();
		try {
			StringBuilder sqlStmt = new StringBuilder();
			sqlStmt.append("SELECT tcm.CREDITNO ,tcm.PUBLISHERDEC,tcm.CARDTYPE,tcm.AMOUNT,tcm.EDC_CODE ");
			sqlStmt.append(" FROM TRSCREDITREF_MANUAL tcm ");
			sqlStmt.append(" WHERE  tcm.METHOD_MANUAL_ID = ?  ");
			
			param.add(methodId);
			Object[] paramArr = param.toArray();
			beanReReqs = jdbcTemplate.query(sqlStmt.toString(), paramArr, new mapTrsCreditrefEpisOffline());
			
			
//			PreparedStatement preparedStatement = connect.prepareStatement(sqlStmt.toString());
//			preparedStatement.setLong(1, methodId);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				bean = new TrsCreditrefEpisOffline(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getBigDecimal(4));
//				beanReReq.add(bean);
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return beanReReqs;
	}
	
	private static final class mapTrsCreditrefEpisOffline implements RowMapper<TrsCreditrefEpisOffline> {

		@Override
		public TrsCreditrefEpisOffline mapRow(ResultSet rs, int rowNum) throws SQLException {
			TrsCreditrefEpisOffline trsCreditrefEpisOffline = new TrsCreditrefEpisOffline();
			trsCreditrefEpisOffline.setCreditNo(rs.getString("tcm.CREDITNO"));
			trsCreditrefEpisOffline.setPublisherdec(rs.getString("tcm.PUBLISHERDEC"));
			trsCreditrefEpisOffline.setCardtype(rs.getString("tcm.CARDTYPE"));
			trsCreditrefEpisOffline.setAmount(rs.getBigDecimal("tcm.AMOUNT"));
			trsCreditrefEpisOffline.setEdcCode(rs.getString("tcm.EDC_CODE"));
			return trsCreditrefEpisOffline;
		}

	}

}
