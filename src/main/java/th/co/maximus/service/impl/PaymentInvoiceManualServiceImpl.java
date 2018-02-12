package th.co.maximus.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.PaymentInvoiceManualBean;
import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.service.PaymentInvoiceManualService;

@Service
public class PaymentInvoiceManualServiceImpl implements PaymentInvoiceManualService{

	private JdbcTemplate jdbcTemplate;
	
	public PaymentInvoiceManualServiceImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insertPaymentInvoiceManual(PaymentInvoiceManualBean paymentInvoiceManualBean) {
		String sql = "INSERT INTO payment_manual (PAYMENT_INVOICE_MANUAL_ID,MANUAL_ID,SOURCE, INVOICE_NO,BEFOR_VAT,VAT_AMOUNT,AMOUNT,VAT_RATE, CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_SEGMENT, CUSTOMER_BRANCH, TAXNO, SUB_NO, PERIOD, SERVICE_TYPE, CLEARING, PRINT_RECEIPT, REMARK, CREATE_BY, CREATE_DATE,UPDATE_BY,UPDATE_DATE,RECORD_STATUS)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, paymentInvoiceManualBean.getPaymentInvoiceManualId(), paymentInvoiceManualBean.getManualId(), paymentInvoiceManualBean.getSource());
	
	}
	
	@Override
	public List<PaymentInvoiceManualBean> PaymentInvoiceManualAll() {
		return jdbcTemplate.query("select * from payment_manual", new PaymentInvoiceManualJoin());
	}
	
	/*public PaymentInvoiceManualBean xx() {
		return jdbcTemplate.queryForObject("select * from payment_manual", new PaymentInvoiceManualJoin());
	}*/
	
	private static final class PaymentInvoiceManualJoin implements RowMapper<PaymentInvoiceManualBean> {

		@Override
		public PaymentInvoiceManualBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			PaymentInvoiceManualBean invoiceManualBean = new PaymentInvoiceManualBean();
			invoiceManualBean.setPaymentInvoiceManualId(rs.getLong("PAYMENT_INVOICE_MANUAL_ID"));
			invoiceManualBean.setManualId(rs.getLong("MANUAL_ID"));
			invoiceManualBean.setSource(rs.getString("SOURCE"));
			invoiceManualBean.setInvoiceNo(rs.getString("INVOICE_NO"));
			invoiceManualBean.setBeforVat(rs.getLong("BEFOR_VAT"));
			invoiceManualBean.setVatAmount(rs.getLong("VAT_AMOUNT"));
			invoiceManualBean.setAmount(rs.getLong("AMOUNT"));
			invoiceManualBean.setVatRate(rs.getInt("VAT_RATE"));
			invoiceManualBean.setCustomerName(rs.getInt("CUSTOMER_NAME"));
			invoiceManualBean.setCustomerAddress(rs.getString("CUSTOMER_ADDRESS"));
			invoiceManualBean.setCustomerSegment(rs.getString("CUSTOMER_SEGMENT"));
			invoiceManualBean.setCustomerBranch(rs.getString("CUSTOMER_BRANCH"));
			invoiceManualBean.setTaxNo(rs.getString("TAXNO"));
			invoiceManualBean.setSubNo(rs.getString("SUB_NO"));
			invoiceManualBean.setPeriod(rs.getString("PERIOD"));
			invoiceManualBean.setServiceType(rs.getString("SERVICE_TYPE"));
			invoiceManualBean.setClearing(rs.getString("CLEARING"));
			invoiceManualBean.setPrintReceipt(rs.getString("PRINT_RECEIPT"));
			invoiceManualBean.setRemark(rs.getString("REMARK"));
			invoiceManualBean.setCreateBy(rs.getString("CREATE_BY"));
			invoiceManualBean.setCreateDate(rs.getTimestamp("CREATE_DATE"));
			invoiceManualBean.setUpdateBy(rs.getString("UPDATE_BY"));
			invoiceManualBean.setUpdateDate(rs.getTimestamp("UPDATE_DATE"));
			invoiceManualBean.setRecordStatus(rs.getString("RECORD_STATUS"));
			return invoiceManualBean;
		}

	}

}
