package th.co.maximus.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import th.co.maximus.bean.PaymentManualBean;

@Repository("PaymentManualDao")
public class PaymentManualDaoImpl implements PaymentManualDao{

	private JdbcTemplate jdbcTemplate;
	public PaymentManualDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void insertPayment(PaymentManualBean paymentManualBean) {
		String sql = "INSERT INTO payment_manual (INVOICE_NO, RECEIPT_NO_MANUAL, PAID_DATE, BRANCH_AREA, BRANCH_CODE,PAID_AMOUNT,SOURCE,CLEARING,REMARK,CREATE_BY,CREATE_DATE,UPDATE_BY,UPDATE_DATE,RECORD_STATUS,  ACCOUNT_NO)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,   paymentManualBean.getInvoiceNo(),paymentManualBean.getReceiptNoManual(),
				paymentManualBean.getPaidDate(),paymentManualBean.getBrancharea(),paymentManualBean.getBranchCode(),paymentManualBean.getPaidAmount(),paymentManualBean.getSource(),
				paymentManualBean.getClearing(),paymentManualBean.getRemark(),paymentManualBean.getCreateBy(),paymentManualBean.getCreateDate(),paymentManualBean.getUpdateBy(),
				paymentManualBean.getUpdateDate(),paymentManualBean.getRecordStatus(),paymentManualBean.getAccountNo());
	}




}
