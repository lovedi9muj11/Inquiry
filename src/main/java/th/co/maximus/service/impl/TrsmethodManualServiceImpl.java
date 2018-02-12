package th.co.maximus.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.bean.TrsMethodManualBean;
import th.co.maximus.service.TrsmethodManualService;

@Service
public class TrsmethodManualServiceImpl implements TrsmethodManualService{
	
private JdbcTemplate jdbcTemplate;
	
	public TrsmethodManualServiceImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insertTrsmethodManual(TrsMethodManualBean trsMethodManualBean) {
		String sql = "INSERT INTO trsmethod_manual (METHOD_MANUAL_ID,CODE, NAME, CHEQUENO,ACCOUNTNO,AMOUNT,UPDATEDTTM, UPDATESYSTEM, UPDATEUSER, VERSIONSTAMP, OFFSET_DOCUMENT_NO, OFFSET_ACCOUNT_CODE,OFFSET_ACCOUNT_NAME,REMARK,CREATE_BY,CREATE_DATE,UPDATE_BY,UPDATE_DATE,RECORD_STATUS,MANUAL_ID)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, trsMethodManualBean.getMethodManualId(), trsMethodManualBean.getCode(), trsMethodManualBean.getName());
	
	}
	
	@Override
	public List<TrsMethodManualBean> TrsmethodManualAll() {
		return jdbcTemplate.query("select * from trsmethod_manual", new TrsMethodManualJoin());
	}
	
	/*public PaymentManualBean xx() {
		return jdbcTemplate.queryForObject("select * from payment_manual", new PaymentManuaJoin());
	}*/
	
	private static final class TrsMethodManualJoin implements RowMapper<TrsMethodManualBean> {

		@Override
		public TrsMethodManualBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			TrsMethodManualBean methodManualBean = new TrsMethodManualBean();
			methodManualBean.setMethodManualId(rs.getLong("METHOD_MANUAL_ID"));
			methodManualBean.setCode(rs.getString("CODE"));
			methodManualBean.setName(rs.getString("NAME"));
			methodManualBean.setChequeNo(rs.getString("CHEQUENO"));
			methodManualBean.setAccountNo(rs.getString("ACCOUNTNO"));
			methodManualBean.setAmount(rs.getLong("AMOUNT"));
			methodManualBean.setUpdateDttm(rs.getTimestamp("UPDATEDTTM"));
			methodManualBean.setUpdateSystem(rs.getString("UPDATESYSTEM"));
			methodManualBean.setUpdateUser(rs.getString("UPDATEUSER"));
			methodManualBean.setVersionStamp(rs.getLong("VERSIONSTAMP"));
			methodManualBean.setOffsetDocumentNo(rs.getString("OFFSET_DOCUMENT_NO"));
			methodManualBean.setOffsetAccountCode(rs.getString("OFFSET_ACCOUNT_CODE"));
			methodManualBean.setOffsetAccountName(rs.getString("OFFSET_ACCOUNT_NAME"));
			methodManualBean.setRemark(rs.getString("REMARK"));
			methodManualBean.setCreateBy(rs.getString("CREATE_BY"));
			methodManualBean.setCreateDate(rs.getTimestamp("CREATE_DATE"));
			methodManualBean.setUpdateBy(rs.getString("UPDATE_BY"));
			methodManualBean.setUpdateDate(rs.getTimestamp("UPDATE_DATE"));
			methodManualBean.setRecordStatus(rs.getString("RECORD_STATUS"));
			methodManualBean.setManualId(rs.getLong("MANUAL_ID"));
			return methodManualBean;
		}

	}

}
