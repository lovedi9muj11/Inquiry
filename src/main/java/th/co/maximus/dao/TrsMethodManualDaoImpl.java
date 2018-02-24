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

import th.co.maximus.bean.TrsMethodManualBean;

@Repository("TrsMethodManualDao")
public class TrsMethodManualDaoImpl implements TrsMethodManualDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public TrsMethodManualDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public int insertTrsMethod(TrsMethodManualBean trsMethodManualBean) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO trsmethod_manual (CODE, NAME, CHEQUENO,ACCOUNTNO,AMOUNT,UPDATEDTTM, VERSIONSTAMP,REMARK,CREATE_BY,CREATE_DATE,UPDATE_BY,UPDATE_DATE,RECORD_STATUS,MANUAL_ID,CREDITNO) ");
		sql.append("  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
		
    	jdbcTemplate.update( new PreparedStatementCreator() { public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        	            PreparedStatement pst =con.prepareStatement(sql.toString(), new String[] {"METHOD_MANUAL_ID"});
        	            pst.setString(1, trsMethodManualBean.getCode());
        	            pst.setString(2, trsMethodManualBean.getName());
        	            pst.setString(3, trsMethodManualBean.getChequeNo());
        	            pst.setString(4, trsMethodManualBean.getAccountNo());
        	            pst.setDouble(5, trsMethodManualBean.getAmount());
        	            pst.setTimestamp(6, trsMethodManualBean.getUpdateDttm());
        	            pst.setLong(7, trsMethodManualBean.getVersionStamp());
        	            pst.setString(8, trsMethodManualBean.getRemark());
        	            pst.setString(9, trsMethodManualBean.getCreateBy());
        	            pst.setTimestamp(10, trsMethodManualBean.getCreateDate());
        	            pst.setString(11, trsMethodManualBean.getUpdateBy());
        	            pst.setTimestamp(12, trsMethodManualBean.getUpdateDate());
        	            pst.setString(13, trsMethodManualBean.getRecordStatus());
        	            pst.setLong(14, trsMethodManualBean.getManualId());
        	            pst.setString(15, trsMethodManualBean.getCreditId());
        	            return pst;
        	        }
        	    },
        	    keyHolder);
    	int newUserId= keyHolder.getKey().intValue();
    	return newUserId;
		
	}
	@Override
	public List<TrsMethodManualBean> findTrsMethodManualFromManualId(long manualId) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM trsmethod_manual trsmethod_m where trsmethod_m.MANUAL_ID = ");
		sql.append(manualId);
		return jdbcTemplate.query(sql.toString(), new TrsMethodManual());
	}
	
	private static final class TrsMethodManual implements RowMapper<TrsMethodManualBean> {

		@Override
		public TrsMethodManualBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			TrsMethodManualBean manualBean = new TrsMethodManualBean();
			manualBean.setMethodManualId(rs.getLong("METHOD_MANUAL_ID"));
			manualBean.setCode(rs.getString("CODE"));
			manualBean.setName(rs.getString("NAME"));
			manualBean.setChequeNo(rs.getString("CHEQUENO"));
			manualBean.setCreditId(rs.getString("CREDITNO"));
			manualBean.setAccountNo(rs.getString("ACCOUNTNO"));
			manualBean.setAmount(rs.getDouble("AMOUNT"));
			manualBean.setUpdateDttm(rs.getTimestamp("UPDATEDTTM"));
			manualBean.setUpdateSystem(rs.getString("UPDATESYSTEM"));
			manualBean.setUpdateUser(rs.getString("UPDATEUSER"));
			manualBean.setVersionStamp(rs.getLong("VERSIONSTAMP"));
			manualBean.setOffsetDocumentNo(rs.getString("OFFSET_DOCUMENT_NO"));
			manualBean.setOffsetAccountCode(rs.getString("OFFSET_ACCOUNT_CODE"));
			manualBean.setOffsetAccountName(rs.getString("OFFSET_ACCOUNT_NAME"));
			manualBean.setRemark(rs.getString("REMARK"));
			manualBean.setCreateBy(rs.getString("CREATE_BY"));
			manualBean.setCreateDate(rs.getTimestamp("CREATE_DATE"));
			manualBean.setUpdateBy(rs.getString("UPDATE_BY"));
			manualBean.setUpdateDate(rs.getTimestamp("UPDATE_DATE"));
			manualBean.setRecordStatus(rs.getString("RECORD_STATUS"));
			manualBean.setRefId(rs.getLong("REF_ID"));
			manualBean.setDeductionManualId(rs.getLong("DEDUCTION_MANUAL_ID"));
			manualBean.setManualId(rs.getLong("MANUAL_ID"));
			return manualBean;
		}

	}
	
}
