package th.co.maximus.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.DeductionManualBean;
import th.co.maximus.service.DeductionManualService;

@Service
public class DeductionManualServiceImpl implements DeductionManualService{
	
private JdbcTemplate jdbcTemplate;
	
	public DeductionManualServiceImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insertDeductionManual(DeductionManualBean deductionManualBean) {
		String sql = "INSERT INTO deduction_manual (DEDUCTION_MANUAL_ID, DEDUCTIONNO, DEDUCTIONTYPE, AMOUNT, PAYMENTDATE, UPDATEDTTM, UPDATESYSTEM, UPDATEUSER, VERSIONSTAMP, INVOICE_NO, REMARK, CREATE_BY,CREATE_DATE,UPDATE_BY,UPDATE_DATE, RECORD_STATUS,MANUAL_ID)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, deductionManualBean.getDeductionManualId(), deductionManualBean.getDeDuctionNo(),deductionManualBean.getDeDuctionType(),deductionManualBean.getaMount(),deductionManualBean.getPaymentDate(),
				deductionManualBean.getUpdateDttm(),deductionManualBean.getUpdateSystem(),deductionManualBean.getUpdateUser(),deductionManualBean.getVersionStamp(),deductionManualBean.getInvoiceNo(),deductionManualBean.getRemark(),
				deductionManualBean.getCreateBy(),deductionManualBean.getCreateDate(),deductionManualBean.getUpdateBy(),deductionManualBean.getUpdateDate(),deductionManualBean.getRecordStatus(),deductionManualBean.getManualId());
	
	}
	
	@Override
	public List<DeductionManualBean> DeductionManualAll() {
		return jdbcTemplate.query("select * from deduction_manual", new DeductionManualJoin());
	}
	
	/*public PaymentManualBean xx() {
		return jdbcTemplate.queryForObject("select * from payment_manual", new PaymentManuaJoin());
	}*/
	
	private static final class DeductionManualJoin implements RowMapper<DeductionManualBean> {

		@Override
		public DeductionManualBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			DeductionManualBean deductionManualBean = new DeductionManualBean();
			deductionManualBean.setDeductionManualId(rs.getLong("DEDUCTION_MANUAL_ID"));
			deductionManualBean.setDeDuctionNo(rs.getString("DEDUCTIONNO"));
			deductionManualBean.setDeDuctionType(rs.getString("DEDUCTIONTYPE"));
			deductionManualBean.setaMount(rs.getLong("AMOUNT"));
			deductionManualBean.setPaymentDate(rs.getDate("PAYMENTDATE"));
			deductionManualBean.setUpdateDttm(rs.getTimestamp("UPDATEDTTM"));
			deductionManualBean.setUpdateSystem(rs.getString("UPDATESYSTEM"));
			deductionManualBean.setUpdateUser(rs.getString("UPDATEUSER"));
			deductionManualBean.setVersionStamp(rs.getLong("VERSIONSTAMP"));
			deductionManualBean.setInvoiceNo(rs.getString("INVOICE_NO"));
			deductionManualBean.setRemark(rs.getString("REMARK"));
			deductionManualBean.setCreateBy(rs.getString("CREATE_BY"));
			deductionManualBean.setCreateDate(rs.getTimestamp("CREATE_DATE"));
			deductionManualBean.setUpdateBy(rs.getString("UPDATE_BY"));
			deductionManualBean.setUpdateDate(rs.getTimestamp("UPDATE_DATE"));
			deductionManualBean.setRecordStatus(rs.getString("RECORD_STATUS"));
			deductionManualBean.setManualId(rs.getLong("MANUAL_ID"));
			return deductionManualBean;
		}

	}

}
