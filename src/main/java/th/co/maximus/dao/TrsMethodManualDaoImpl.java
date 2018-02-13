package th.co.maximus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
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
	
}
