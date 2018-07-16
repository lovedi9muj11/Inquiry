package th.co.maximus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.payment.bean.PaymentResultReq;

@Service
public class PaymentOtherManualDaoImpl implements PaymentOtherManualDao {
	@Autowired
	DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public PaymentOtherManualDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public int insertPayment(PaymentManualBean paymentManualBean) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO RECEIPT_MANUAL (INVOICE_NO, RECEIPT_NO_MANUAL, PAID_DATE, BRANCH_AREA, BRANCH_CODE,PAID_AMOUNT,SOURCE,CLEARING,REMARK,CREATE_BY,CREATE_DATE,UPDATE_BY,UPDATE_DATE,RECORD_STATUS,ACCOUNT_NO,PAY_TYPE)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
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
			sqlStmt.append("SELECT py.ACCOUNT_NO,py.RECEIPT_NO_MANUAL,py.VAT_AMOUNT,py.PAID_AMOUNT ");
			sqlStmt.append(" ,py.INVOICE_NO,py.CREATE_DATE, py.PAID_DATE  ");
			sqlStmt.append("  , (SELECT SUM(dud.AMOUNT) FROM DEDUCTION_MANUAL dud WHERE dud.MANUAL_ID =  	py.MANUAL_ID )as DEDUCTION ");
			sqlStmt.append(" ,(SELECT SUM(pim.DISCOUNTBEFORVAT) FROM PAYMENT_INVOICE_MANUAL pim WHERE pim.MANUAL_ID = py.MANUAL_ID )  as DISCOUNTBEFORVAT ");

//			sqlStmt.append(
//					",(SELECT SUM(pim.DISCOUNTBEFORVAT) FROM PAYMENT_INVOICE_MANUAL pim WHERE pim.MANUAL_ID = py.MANUAL_ID )  as DISCOUNTBEFORVAT ");

			sqlStmt.append(",(SELECT SUM(pim.DISCOUNTSPECIAL) FROM PAYMENT_INVOICE_MANUAL pim WHERE pim.MANUAL_ID = py.MANUAL_ID )  as DISCOUNTSPECIAL ");
			
			sqlStmt.append(",(SELECT DISTINCT pim.VAT_RATE FROM PAYMENT_INVOICE_MANUAL pim WHERE pim.MANUAL_ID = py.MANUAL_ID )  as VATRATE ");

			sqlStmt.append("  FROM RECEIPT_MANUAL py WHERE  py.MANUAL_ID = ?");
			PreparedStatement preparedStatement = connect.prepareStatement(sqlStmt.toString());
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				beanReReq = new PaymentResultReq();
				beanReReq.setCustNo(resultSet.getString("ACCOUNT_NO"));
				beanReReq.setDocumentNo(resultSet.getString("RECEIPT_NO_MANUAL"));
				beanReReq.setBalanceSummary(resultSet.getBigDecimal("PAID_AMOUNT"));
				beanReReq.setBalanceSummaryStr(String.format("%,.2f", resultSet.getBigDecimal("PAID_AMOUNT")));
//				System.out.println(resultSet.getBigDecimal("DISCOUNTBEFORVAT"));
				beanReReq.setDiscount(resultSet.getBigDecimal("DISCOUNTBEFORVAT"));
				beanReReq.setDiscountStr(String.format("%,.2f", resultSet.getBigDecimal("DISCOUNTBEFORVAT")));
				beanReReq.setVat(resultSet.getBigDecimal("VAT_AMOUNT"));
				
				if(StringUtils.isBlank(resultSet.getString("VATRATE"))) {
					beanReReq.setVatStr("-");
				}else {
					beanReReq.setVatStr(String.format("%,.2f", beanReReq.getVat()));
				}
				
				beanReReq.setDiscountspacal(resultSet.getBigDecimal("DISCOUNTSPECIAL"));
				beanReReq.setDiscountspacalStr(String.format("%,.2f",beanReReq.getDiscountspacal()));
				beanReReq.setPaid_amount(resultSet.getBigDecimal("PAID_AMOUNT"));

			}

		} finally {
			connect.close();
		}
		return beanReReq;
	}

	@Override
	public List<PaymentResultReq> findListById(Long id) throws Exception {
		Connection connect = dataSource.getConnection();
		List<PaymentResultReq> bList = new ArrayList<>();
		PaymentResultReq beanReReq = new PaymentResultReq();
		try {
			StringBuilder sqlStmt = new StringBuilder();
			sqlStmt.append("SELECT  (select REVENUE_TYPE_NAME from MAP_GL_SERVICE_TYPE where  REVENUE_TYPE_CODE = py.AMOUNTTYPE GROUP BY REVENUE_TYPE_NAME) as AMOUNTTYPE");
			sqlStmt.append(" ,py.SERVICENAME ,py.SERVICECODE,py.QUANTITY,py.VAT_AMOUNT,py.AMOUNT,py.BEFOR_VAT ,py.CUSTOMER_NAME");
			sqlStmt.append(" ,py.INVOICE_NO,py.CREATE_DATE  , py.DISCOUNTBEFORVAT, py.DISCOUNTSPECIAL, py.VAT_RATE  ");

			sqlStmt.append("    FROM PAYMENT_INVOICE_MANUAL py  WHERE  py.MANUAL_ID = ?");
			PreparedStatement preparedStatement = connect.prepareStatement(sqlStmt.toString());
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
//				String.format("%,.2f", paymentResultReq.getBalanceOfvat())
				beanReReq = new PaymentResultReq();
				beanReReq.setCustName(resultSet.getString("CUSTOMER_NAME"));
				beanReReq.setServiceName(resultSet.getString("SERVICENAME"));
				beanReReq.setServiceCode(resultSet.getString("SERVICECODE"));
				beanReReq.setAmountType(resultSet.getString("AMOUNTTYPE"));
				beanReReq.setQuantity(resultSet.getString("QUANTITY"));
				beanReReq.setAmount(resultSet.getBigDecimal("AMOUNT"));
				beanReReq.setAmountStr(String.format("%,.2f", beanReReq.getAmount()));
				beanReReq.setVat(resultSet.getBigDecimal("VAT_AMOUNT"));
				
				if(StringUtils.isBlank(resultSet.getString("VAT_RATE"))) {
					beanReReq.setVatStr("-");
				}else {
					beanReReq.setVatStr(String.format("%,.2f", beanReReq.getVat()));
				}
				
				beanReReq.setDiscountspacal(resultSet.getBigDecimal("DISCOUNTSPECIAL"));
				beanReReq.setDiscountspacalStr(String.format("%,.2f", beanReReq.getDiscountspacal()));
				beanReReq.setBeforeVat(resultSet.getBigDecimal("BEFOR_VAT"));
				beanReReq.setBeforeVatStr(String.format("%,.2f", beanReReq.getBeforeVat()));
				beanReReq.setDiscount(resultSet.getBigDecimal("DISCOUNTBEFORVAT"));
				beanReReq.setDiscountStr(String.format("%,.2f", beanReReq.getDiscount()));
				bList.add(beanReReq);

			}

		} finally {
			connect.close();
		}
		return bList;
	}
	

}
