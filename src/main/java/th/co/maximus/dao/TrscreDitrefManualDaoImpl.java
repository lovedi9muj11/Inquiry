package th.co.maximus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import th.co.maximus.bean.TrscreDitrefManualBean;
@Repository("TrscreDitrefManualDao")
public class TrscreDitrefManualDaoImpl implements TrscreDitrefManualDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void insertTrscreDitrefManua(TrscreDitrefManualBean trscreDitrefManualBean) {
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO trscreditref_manual ( CREDITNO, PUBLISHERDEC, CARDTYPE, AMOUNT, UPDATEDTTM, VERSIONSTAMP, METHOD_MANUAL_ID) ");
		sql.append(" VALUES (?,?,?,?,?,?,?) ");
		jdbcTemplate.update(sql.toString(),  trscreDitrefManualBean.getCreditNo(), trscreDitrefManualBean.getPublisherdec(),trscreDitrefManualBean.getCardType(),trscreDitrefManualBean.getaMount(),
				trscreDitrefManualBean.getUpdateDttm(),trscreDitrefManualBean.getVersionStamp(),trscreDitrefManualBean.getMethodManualId());
		
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

}
