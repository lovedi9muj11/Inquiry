package th.co.maximus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import th.co.maximus.bean.PaymentManualBean;

@Repository("PaymentManualDao")
public class PaymentManualDaoImpl implements PaymentManualDao{

	private JdbcTemplate jdbcTemplate;
	public PaymentManualDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int insertPayment(PaymentManualBean paymentManualBean) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO payment_manual (INVOICE_NO, RECEIPT_NO_MANUAL, PAID_DATE, BRANCH_AREA, BRANCH_CODE,PAID_AMOUNT,SOURCE,CLEARING,REMARK,CREATE_BY,CREATE_DATE,UPDATE_BY,UPDATE_DATE,RECORD_STATUS,ACCOUNT_NO,PAY_TYPE)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
    	jdbcTemplate.update( new PreparedStatementCreator() { public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
            PreparedStatement pst =con.prepareStatement(sql, new String[] {"MANUAL_ID"});
            pst.setString(1,  paymentManualBean.getInvoiceNo());
            pst.setString(2, paymentManualBean.getReceiptNoManual());
            pst.setTimestamp(3, paymentManualBean.getPaidDate());
            pst.setString(4, paymentManualBean.getBrancharea());
            pst.setString(5, paymentManualBean.getBranchCode());
            pst.setDouble(6, paymentManualBean.getPaidAmount());
            pst.setString(7, paymentManualBean.getSource());
            pst.setString(8, paymentManualBean.getClearing());
            pst.setString(9, paymentManualBean.getRemark());
            pst.setString(10, paymentManualBean.getCreateBy());
            pst.setTimestamp(11, paymentManualBean.getCreateDate());
            pst.setString(12, paymentManualBean.getUpdateBy());
            pst.setTimestamp(13, paymentManualBean.getUpdateDate());
            pst.setString(14, paymentManualBean.getRecordStatus());
            pst.setString(15, paymentManualBean.getAccountNo());
            pst.setString(16, paymentManualBean.getPaytype());
            return pst;
        }
    },
    keyHolder);
    	int newUserId= keyHolder.getKey().intValue();
	return newUserId;
	}




}
