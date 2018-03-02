package th.co.maximus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.bean.ReportPaymentBean;
import th.co.maximus.bean.ReportPaymentCriteria;
import th.co.maximus.constants.Constants;
import th.co.maximus.payment.bean.PaymentResultReq;


@Repository("PaymentManualDao")
public class PaymentManualDaoImpl implements PaymentManualDao {
	@Autowired
	DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public PaymentManualDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public int insertPayment(PaymentManualBean paymentManualBean) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO payment_manual (INVOICE_NO, RECEIPT_NO_MANUAL, PAID_DATE, BRANCH_AREA, BRANCH_CODE,PAID_AMOUNT,SOURCE,CLEARING,REMARK,CREATE_BY,CREATE_DATE,UPDATE_BY,UPDATE_DATE,RECORD_STATUS,ACCOUNT_NO,PAY_TYPE,DOCTYPE)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
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
				pst.setString(17, paymentManualBean.getDocType());
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
			sqlStmt.append("SELECT py.ACCOUNT_NO , pim.CUSTOMER_NAME ,py.RECEIPT_NO_MANUAL,py.PAID_AMOUNT ,py.INVOICE_NO,py.CREATE_DATE,py.PAID_DATE , pim.BEFOR_VAT , pim.VAT_AMOUNT ,pim.AMOUNT,(SELECT SUM(dud.AMOUNT) FROM deduction_manual dud WHERE dud.MANUAL_ID = py.MANUAL_ID AND dud.INVOICE_NO = py.INVOICE_NO GROUP BY dud.INVOICE_NO ) , py.PAID_AMOUNT , pim.PERIOD ");
			sqlStmt.append(" FROM payment_manual py ");
			sqlStmt.append(" INNER JOIN payment_invoice_manual pim ON pim.MANUAL_ID =  py.MANUAL_ID AND pim.INVOICE_NO = py.INVOICE_NO ");
			sqlStmt.append(" WHERE  py.MANUAL_ID = ? ");
			
			
			PreparedStatement preparedStatement = connect.prepareStatement(sqlStmt.toString());
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				beanReReq = new PaymentResultReq(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getBigDecimal(4), resultSet.getString(5), 
						resultSet.getDate(6), resultSet.getDate(7), resultSet.getBigDecimal(8), resultSet.getBigDecimal(9), resultSet.getBigDecimal(10), resultSet.getBigDecimal(11), resultSet.getBigDecimal(12), resultSet.getString(13));
			}

		} finally {
			connect.close();
		}
		return beanReReq;
	}

	@Override
	public List<PaymentManualBean> findPaymentManualFromNanualId(long manualId) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM payment_manual payment_m  ");
		sql.append(" WHERE payment_m.MANUAL_ID =  ");
		sql.append(manualId);
		return jdbcTemplate.query(sql.toString() , new PaymentManual());
	}
	
	private static final class PaymentManual implements RowMapper<PaymentManualBean> {

		@Override
		public PaymentManualBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			PaymentManualBean paymentManual = new PaymentManualBean();
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
			paymentManual.setRecordStatus(rs.getString("RECORD_STATUS").equals(Constants.Status.ACTIVE)?Constants.Status.ACTIVE_A:Constants.Status.ACTIVE_AC);
			paymentManual.setRefid(rs.getLong("REF_ID"));
			paymentManual.setAccountNo(rs.getString("ACCOUNT_NO"));
			paymentManual.setPaytype(rs.getString("PAY_TYPE"));
			paymentManual.setDocType(rs.getString("DOCTYPE"));
			return paymentManual;
		}

	}

	@Override
	public List<ReportPaymentBean> getReportPayment(ReportPaymentCriteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT *,  CASE PM.RECORD_STATUS WHEN 'A' THEN 'ปรกติ' WHEN 'N' THEN 'ชำระใหม่' ");
		sql.append(" WHEN 'S' THEN 'ส่งออนไลน์สำเร็จ'  WHEN 'E' THEN 'เกิดข้อผิดพลาด' WHEN 'C' THEN 'ยกเลิกรายการ' ELSE '' END AS STATUS_NAME ");
		sql.append(" FROM payment_manual PM ");
		sql.append(" INNER JOIN payment_invoice_manual PIM ON PM.INVOICE_NO = PIM.INVOICE_NO ");
		sql.append(" WHERE PM.CREATE_DATE >=").append("'"+criteria.getDateFrom()+"'").append("  AND PM.CREATE_DATE <= ").append("'"+criteria.getDateTo()+"'");
		if(!"".equals(criteria.getVatRate()) && criteria.getVatRate() != null) {
			sql.append(" AND PIM.VAT_RATE = ").append("'"+criteria.getVatRate()+"'");
		}
		if(!"".equals(criteria.getAccountId()) && criteria.getAccountId() != null) {
			sql.append(" AND PM.CREATE_BY = ").append("'"+criteria.getAccountId()+"'");
		}
		if(!"".equals(criteria.getServiceType()) && criteria.getServiceType() != null) {
			sql.append(" AND PIM.SERVICE_TYPE = ").append("'"+criteria.getServiceType()+"'");
		}
		return jdbcTemplate.query(sql.toString() , new reportPaymentMapper());
	}
	
	private static final class reportPaymentMapper implements RowMapper<ReportPaymentBean> {

		@Override
		public ReportPaymentBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			ReportPaymentBean reportPayment = new ReportPaymentBean();
			reportPayment.setManualId(rs.getLong("MANUAL_ID"));
			reportPayment.setServiceType(rs.getString("SERVICE_TYPE"));
			reportPayment.setReceiptNoManual(rs.getString("RECEIPT_NO_MANUAL"));
			reportPayment.setAccountSubNo(rs.getString("ACCOUNTSUBNO"));
			reportPayment.setCustomerName(rs.getString("CUSTOMER_NAME"));
			reportPayment.setDepartment(rs.getString("DEPARTMENT"));
			reportPayment.setInvoiceNo(rs.getString("INVOICE_NO"));
			reportPayment.setServiceName(rs.getString("SERVICENAME"));
			reportPayment.setCreateBy(rs.getString("CREATE_BY"));
//			reportPayment.setNoRefer(rs.getString(""));
			reportPayment.setBeforVat(rs.getBigDecimal("BEFOR_VAT"));
			reportPayment.setAmount(rs.getBigDecimal("AMOUNT"));
			reportPayment.setVatAmount(rs.getBigDecimal("VAT_RATE"));
			reportPayment.setStatus(rs.getString("RECORD_STATUS"));
			reportPayment.setStatusStr(rs.getString("STATUS_NAME"));
		
			return reportPayment;
		}

	}


}
