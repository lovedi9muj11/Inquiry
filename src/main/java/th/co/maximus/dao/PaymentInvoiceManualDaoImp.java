package th.co.maximus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import th.co.maximus.bean.PaymentMMapPaymentInvBean;



@Repository("PaymentInvoiceManualDao")
@Transactional(readOnly = true)
public class PaymentInvoiceManualDaoImp implements PaymentInvoiceManualDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public PaymentInvoiceManualDaoImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<PaymentMMapPaymentInvBean> findPaymentMuMapPaymentInV() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM payment_manual payment_m ");
		sql.append(" INNER JOIN payment_invoice_manual paument_inv ON payment_m.INVOICE_NO = paument_inv.INVOICE_NO ");
			
		return jdbcTemplate.query(sql.toString() , new PaymentManual());
	}
	
	private static final class PaymentManual implements RowMapper<PaymentMMapPaymentInvBean> {

		@Override
		public PaymentMMapPaymentInvBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			PaymentMMapPaymentInvBean paymentManual = new PaymentMMapPaymentInvBean();
			paymentManual.setManualId(rs.getLong("MANUAL_ID"));
			paymentManual.setPaymentId(rs.getLong("PAYMENT_ID"));
			paymentManual.setInvoiceNo(rs.getString("INVOICE_NO"));
			paymentManual.setReceiptNoManual(rs.getString("RECEIPT_NO_MANUAL"));
			paymentManual.setPaidDate(rs.getTimestamp("PAID_DATE"));
			paymentManual.setBrancharea(rs.getString("BRANCH_AREA"));
			paymentManual.setBranchCode(rs.getString("BRANCH_CODE"));
			paymentManual.setPaidAmount(rs.getLong("PAID_AMOUNT"));
			paymentManual.setSource(rs.getString("SOURCE"));
			paymentManual.setClearing(rs.getString("CLEARING"));
			paymentManual.setRemark(rs.getString("REMARK"));
			paymentManual.setCreateBy(rs.getString("CREATE_BY"));
			paymentManual.setCreateDate(rs.getTimestamp("CREATE_DATE"));
			paymentManual.setUpdateBy(rs.getString("UPDATE_BY"));
			paymentManual.setUpdateDate(rs.getTimestamp("UPDATE_DATE"));
			paymentManual.setRecordStatus(rs.getString("RECORD_STATUS"));
			paymentManual.setRefid(rs.getLong("REF_ID"));
			paymentManual.setAccountNo(rs.getString("ACCOUNT_NO"));
			paymentManual.setClearingSap(rs.getString("CLEARING_SAP"));
			return paymentManual;
		}

	}
	
	
	

}
