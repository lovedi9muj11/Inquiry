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

import th.co.maximus.bean.PaymentInvoiceManualBean;
import th.co.maximus.bean.PaymentMMapPaymentInvBean;



@Repository("PaymentInvoiceManualDao")
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

	@Override
	public void insert(PaymentInvoiceManualBean paymentInvoiceManualBean) {
		StringBuilder sql = new StringBuilder();
		 sql.append("INSERT INTO payment_invoice_manual (MANUAL_ID,SOURCE, INVOICE_NO,BEFOR_VAT,VAT_AMOUNT,AMOUNT,VAT_RATE, CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_SEGMENT, CUSTOMER_BRANCH, TAXNO, SUB_NO, PERIOD,SERVICE_TYPE, CLEARING, PRINT_RECEIPT, REMARK, CREATE_BY, CREATE_DATE,UPDATE_BY,UPDATE_DATE,RECORD_STATUS)  ");  
		 sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)  ");
		 
		 jdbcTemplate.update(sql.toString(),  paymentInvoiceManualBean.getManualId(), paymentInvoiceManualBean.getSource(),paymentInvoiceManualBean.getInvoiceNo(),
				paymentInvoiceManualBean.getBeforVat(),paymentInvoiceManualBean.getVatAmount(),paymentInvoiceManualBean.getAmount(),paymentInvoiceManualBean.getVatRate(),
				paymentInvoiceManualBean.getCustomerName(),paymentInvoiceManualBean.getCustomerAddress(),paymentInvoiceManualBean.getCustomerSegment(),paymentInvoiceManualBean.getCustomerBranch(),paymentInvoiceManualBean.getTaxNo(),paymentInvoiceManualBean.getSubNo(),paymentInvoiceManualBean.getPeriod(),
				paymentInvoiceManualBean.getServiceType(),paymentInvoiceManualBean.getClearing(),paymentInvoiceManualBean.getPrintReceipt(),paymentInvoiceManualBean.getRemark(),
				paymentInvoiceManualBean.getCreateBy(),paymentInvoiceManualBean.getCreateDate(),paymentInvoiceManualBean.getUpdateBy(),paymentInvoiceManualBean.getUpdateDate(),paymentInvoiceManualBean.getRecordStatus());
		
	}
	
	
	

}
