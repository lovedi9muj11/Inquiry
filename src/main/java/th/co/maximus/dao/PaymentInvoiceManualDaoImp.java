package th.co.maximus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import th.co.maximus.bean.PaymentInvoiceManualBean;
import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.bean.UserBean;
import th.co.maximus.constants.Constants;
import th.co.maximus.core.utils.Utils;



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
		Utils utils = new Utils();

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
			paymentManual.setRecordStatus(rs.getString("RECORD_STATUS").equals(Constants.Status.ACTIVE)?Constants.Status.ACTIVE_A:Constants.Status.ACTIVE_AC);
			paymentManual.setBeforVat(rs.getBigDecimal("BEFOR_VAT"));
			paymentManual.setAmount(rs.getBigDecimal("AMOUNT"));
			paymentManual.setVatAmount(rs.getBigDecimal("VAT_AMOUNT"));
			paymentManual.setAccountNo(rs.getString("ACCOUNT_NO"));
			paymentManual.setPeriod(utils.periodFormat(rs.getString("PERIOD")));
			paymentManual.setPayType((rs.getString("PAY_TYPE")));
			paymentManual.setCreateBy(rs.getString("CREATE_BY"));
			paymentManual.setCustomerName((rs.getString("CUSTOMER_NAME")));
			
			return paymentManual;
		}

	}

	@Override
	public void insert(PaymentInvoiceManualBean paymentInvoiceManualBean) {
		StringBuilder sql = new StringBuilder();
		 sql.append("INSERT INTO payment_invoice_manual (MANUAL_ID,SOURCE, INVOICE_NO,BEFOR_VAT,VAT_AMOUNT,AMOUNT,VAT_RATE, CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_SEGMENT, CUSTOMER_BRANCH, TAXNO, ACCOUNTSUBNO, PERIOD,SERVICE_TYPE, CLEARING, PRINT_RECEIPT, REMARK, CREATE_BY, CREATE_DATE,UPDATE_BY,UPDATE_DATE,RECORD_STATUS,QUANTITY,INCOMETYPE,DISCOUNTBEFORVAT,DISCOUNTSPECIAL,AMOUNTTYPE,DEPARTMENT)  ");  
		 sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)  ");
		 
		 jdbcTemplate.update(sql.toString(),  paymentInvoiceManualBean.getManualId(), paymentInvoiceManualBean.getSource(),paymentInvoiceManualBean.getInvoiceNo(),
				paymentInvoiceManualBean.getBeforVat(),paymentInvoiceManualBean.getVatAmount(),paymentInvoiceManualBean.getAmount(),paymentInvoiceManualBean.getVatRate(),
				paymentInvoiceManualBean.getCustomerName(),paymentInvoiceManualBean.getCustomerAddress(),paymentInvoiceManualBean.getCustomerSegment(),paymentInvoiceManualBean.getCustomerBranch(),paymentInvoiceManualBean.getTaxNo(),paymentInvoiceManualBean.getSubNo(),paymentInvoiceManualBean.getPeriod(),
				paymentInvoiceManualBean.getServiceType(),paymentInvoiceManualBean.getClearing(),paymentInvoiceManualBean.getPrintReceipt(),paymentInvoiceManualBean.getRemark());
//				paymentInvoiceManualBean.getCreateBy(),paymentInvoiceManualBean.getCreateDate(),paymentInvoiceManualBean.getUpdateBy(),paymentInvoiceManualBean.getUpdateDate(),paymentInvoiceManualBean.getRecordStatus(),paymentInvoiceManualBean.getQuantity(),
//				paymentInvoiceManualBean.getIncometype(),paymentInvoiceManualBean.getDiscountbeforvat(),paymentInvoiceManualBean.getDiscountspecial(),paymentInvoiceManualBean.getAmounttype(),paymentInvoiceManualBean.getDepartment());
		
	}

	@Override
	public List<PaymentMMapPaymentInvBean> findPaymentMuMapPaymentInVAccountId(String accountNo) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM payment_manual payment_m ");
		sql.append(" INNER JOIN payment_invoice_manual paument_inv ON payment_m.INVOICE_NO = paument_inv.INVOICE_NO ");
		sql.append(" where payment_m.ACCOUNT_NO like ");
		sql.append("'%"+ accountNo+ "%'");
		return jdbcTemplate.query(sql.toString() , new PaymentManual());
	}

	@Override
	public List<PaymentMMapPaymentInvBean> findPaymentMuMapPaymentInVFromId(long manual_id) {
		// TODO Auto-generated method stub
		return null;
	}	

}
