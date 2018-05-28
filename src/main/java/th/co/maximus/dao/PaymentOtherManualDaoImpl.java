package th.co.maximus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.payment.bean.PaymentResultReq;

@Service
public class PaymentOtherManualDaoImpl implements PaymentOtherManualDao{
	@Autowired
	DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public PaymentOtherManualDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public int insertPayment(PaymentManualBean paymentManualBean) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO receipt_manual (INVOICE_NO, RECEIPT_NO_MANUAL, PAID_DATE, BRANCH_AREA, BRANCH_CODE,PAID_AMOUNT,SOURCE,CLEARING,REMARK,CREATE_BY,CREATE_DATE,UPDATE_BY,UPDATE_DATE,RECORD_STATUS,ACCOUNT_NO,PAY_TYPE)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(sql, new String[] { "MANUAL_ID" });
				pst.setString(1, paymentManualBean.getInvoiceNo());
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
		}, keyHolder);
		int newUserId = keyHolder.getKey().intValue();
		return newUserId;
	}

	@Override
	public PaymentResultReq findById(int id) throws Exception {
		Connection connect = dataSource.getConnection();
		PaymentResultReq beanReReq = new PaymentResultReq();
		try {
			StringBuilder sqlStmt = new StringBuilder();
			sqlStmt.append("SELECT py.ACCOUNT_NO , pim.CUSTOMER_NAME ,py.RECEIPT_NO_MANUAL,py.PAID_AMOUNT ,py.INVOICE_NO,py.CREATE_DATE,py.PAID_DATE ,  pim.BEFOR_VAT , pim.VAT_AMOUNT ,pim.AMOUNT, (SELECT SUM(dud.AMOUNT) FROM deduction_manual dud WHERE dud.MANUAL_ID = py.MANUAL_ID ) , pim.PERIOD , pim.DISCOUNTSPECIAL ,pim.SERVICENAME ,pim.SERVICECODE ,pim.QUANTITY ,pim.DISCOUNTBEFORVAT ");
			sqlStmt.append(" FROM receipt_manual py ");
			sqlStmt.append(" INNER JOIN payment_invoice_manual pim ON pim.MANUAL_ID =  py.MANUAL_ID  ");
			sqlStmt.append(" WHERE  py.MANUAL_ID = ? ");
			
			
			PreparedStatement preparedStatement = connect.prepareStatement(sqlStmt.toString());
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
//				beanReReq = new PaymentResultReq(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getBigDecimal(4), resultSet.getString(5), 
//						resultSet.getDate(6), resultSet.getDate(7), resultSet.getBigDecimal(8), resultSet.getBigDecimal(9), resultSet.getBigDecimal(10), resultSet.getBigDecimal(11),  resultSet.getString(13), resultSet.getBigDecimal(14),
//						resultSet.getString(15),resultSet.getString(16),resultSet.getString(17));
				beanReReq = new PaymentResultReq();
				beanReReq.setCustNo(resultSet.getString("ACCOUNT_NO"));
				beanReReq.setCustName(resultSet.getString("CUSTOMER_NAME"));
				beanReReq.setDocumentNo(resultSet.getString("RECEIPT_NO_MANUAL"));
				beanReReq.setBalanceSummary(resultSet.getBigDecimal("PAID_AMOUNT"));
				beanReReq.setBeforeVat(resultSet.getBigDecimal("DISCOUNTBEFORVAT"));
				beanReReq.setVat(resultSet.getBigDecimal("VAT_AMOUNT"));
				beanReReq.setDiscountspacal(resultSet.getBigDecimal("DISCOUNTSPECIAL"));
				beanReReq.setServiceCode(resultSet.getString("SERVICECODE"));
				beanReReq.setServiceName(resultSet.getString("SERVICENAME"));
				beanReReq.setQuantity(resultSet.getString("QUANTITY"));
				beanReReq.setPaid_amount(resultSet.getBigDecimal("AMOUNT"));
			}

		} finally {
			connect.close();
		}
		return beanReReq;
	}

}
