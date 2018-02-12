package th.co.maximus.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.service.PaymentManualService;

@Service
public class PaymentManualServiceImpl implements PaymentManualService{
	
	private JdbcTemplate jdbcTemplate;
	
	public PaymentManualServiceImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insertPaymentManual(PaymentManualBean paymentManualBean) {
		String sql = "INSERT INTO payment_manual (MANUAL_ID, PAYMENT_ID, INVOICE_NO, RECEIPT_NO_MANUAL, PAID_DATE, BRANCH_AREA, BRANCH_CODE,PAID_AMOUNT,SOURCE,CLEARING,REMARK,CREATE_BY,CREATE_DATE,UPDATE_BY,UPDATE_DATE,RECORD_STATUS, REF_ID, ACCOUNT_NO, CLEARING_SAP)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, paymentManualBean.getManualId(), paymentManualBean.getPaymentId(), paymentManualBean.getInvoiceNo(),paymentManualBean.getReceiptNoManual(),
				paymentManualBean.getPaidDate(),paymentManualBean.getBrancharea(),paymentManualBean.getBranchCode(),paymentManualBean.getPaidAmount(),paymentManualBean.getSource(),
				paymentManualBean.getClearing(),paymentManualBean.getRemark(),paymentManualBean.getCreateBy(),paymentManualBean.getCreateDate(),paymentManualBean.getUpdateBy(),
				paymentManualBean.getUpdateDate(),paymentManualBean.getRecordStatus(),paymentManualBean.getRefid(),paymentManualBean.getAccountNo(),paymentManualBean.getClearingSap());
	
	}
	
	@Override
	public List<PaymentManualBean> PaymentManualAll() {
		return jdbcTemplate.query("select * from payment_manual", new PaymentManuaJoin());
	}
	
	/*public PaymentManualBean xx() {
		return jdbcTemplate.queryForObject("select * from payment_manual", new PaymentManuaJoin());
	}*/
	
	private static final class PaymentManuaJoin implements RowMapper<PaymentManualBean> {

		@Override
		public PaymentManualBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			PaymentManualBean manualBean = new PaymentManualBean();
			manualBean.setManualId(rs.getLong("MANUAL_ID"));
			manualBean.setPaymentId(rs.getLong("PAYMENT_ID"));
			manualBean.setInvoiceNo(rs.getString("INVOICE_NO"));
			manualBean.setReceiptNoManual(rs.getString("RECEIPT_NO_MANUAL"));
			manualBean.setPaidDate(rs.getTimestamp("PAID_DATE"));
			manualBean.setBrancharea(rs.getString("BRANCH_AREA"));
			manualBean.setBranchCode(rs.getString("BRANCH_CODE"));
			manualBean.setPaidAmount(rs.getLong("PAID_AMOUNT"));
			manualBean.setSource(rs.getString("SOURCE"));
			manualBean.setClearing(rs.getString("CLEARING"));
			manualBean.setRemark(rs.getString("REMARK"));
			manualBean.setCreateBy(rs.getString("CREATE_BY"));
			manualBean.setCreateDate(rs.getTimestamp("CREATE_DATE"));
			manualBean.setUpdateBy(rs.getString("UPDATE_BY"));
			manualBean.setUpdateDate(rs.getTimestamp("UPDATE_DATE"));
			manualBean.setRecordStatus(rs.getString("RECORD_STATUS"));
			manualBean.setRefid(rs.getLong("REF_ID"));
			manualBean.setAccountNo(rs.getString("ACCOUNT_NO"));
			manualBean.setClearingSap(rs.getString("CLEARING_SAP"));
			return manualBean;
		}

	}

}
