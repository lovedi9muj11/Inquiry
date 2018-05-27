package th.co.maximus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

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
import th.co.maximus.model.ReceiptOfflineModel;
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
	@Transactional
	public int insertPayment(PaymentManualBean paymentManualBean) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO receipt_manual (INVOICE_NO, RECEIPT_NO_MANUAL, PAID_DATE, BRANCH_AREA, BRANCH_CODE,PAID_AMOUNT,SOURCE, CLEARING, REMARK, CREATE_BY, CREATE_DATE, UPDATE_BY, UPDATE_DATE, RECORD_STATUS, ACCOUNT_NO, PAY_TYPE, DOCTYPE, CHANG,AMOUNT,VAT_RATE,VAT_AMOUNT)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
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
				pst.setDouble(18, paymentManualBean.getChange());
				pst.setBigDecimal(19, paymentManualBean.getAmount());
				pst.setInt(20, paymentManualBean.getVatRate());
				pst.setBigDecimal(21, paymentManualBean.getVatAmount());
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
			sqlStmt.append("SELECT py.ACCOUNT_NO , pim.CUSTOMER_NAME ,py.RECEIPT_NO_MANUAL,py.PAID_AMOUNT ,py.INVOICE_NO,tmp.INVOICE_DATE,py.PAID_DATE ,  SUM(pim.BEFOR_VAT) , SUM(pim.VAT_AMOUNT) ,SUM(pim.AMOUNT), (SELECT SUM(dud.AMOUNT) FROM deduction_manual dud WHERE dud.MANUAL_ID = py.MANUAL_ID AND dud.INVOICE_NO = py.INVOICE_NO GROUP BY dud.INVOICE_NO ) , py.PAID_AMOUNT , pim.PERIOD,tmp.AMOUNT,tmp.DISCOUNT ");
			sqlStmt.append(" FROM receipt_manual py ");
			sqlStmt.append(" INNER JOIN payment_invoice_manual pim ON pim.MANUAL_ID =  py.MANUAL_ID AND pim.INVOICE_NO = py.INVOICE_NO ");
			sqlStmt.append(" INNER JOIN payment_invoice tmp ON tmp.MANUAL_ID =  py.MANUAL_ID AND tmp.INVOICE_NO = py.INVOICE_NO ");
			sqlStmt.append(" WHERE  py.MANUAL_ID = ? ");
			
			
			PreparedStatement preparedStatement = connect.prepareStatement(sqlStmt.toString());
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				beanReReq = new PaymentResultReq(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getBigDecimal(4), resultSet.getString(5), 
						resultSet.getDate(6), resultSet.getDate(7), resultSet.getBigDecimal(8), resultSet.getBigDecimal(9), resultSet.getBigDecimal(10), resultSet.getBigDecimal(11), resultSet.getBigDecimal(12), resultSet.getString(13),resultSet.getBigDecimal(14),resultSet.getBigDecimal(15));
			}

		} finally {
			connect.close();
		}
		return beanReReq;
	}

	@Override
	public List<PaymentManualBean> findPaymentManualFromNanualId(long manualId) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM receipt_manual payment_m  ");
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
			paymentManual.setChange(rs.getDouble("CHANG"));
			paymentManual.setAmount(rs.getBigDecimal("AMOUNT"));
			paymentManual.setVatRate(rs.getInt("VAT_RATE"));
			paymentManual.setVatAmount(rs.getBigDecimal("VAT_AMOUNT"));
			return paymentManual;
		}

	}

	@Override
	public List<ReportPaymentBean> getReportPayment(ReportPaymentCriteria criteria) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT PM.*,PIM.* ");
		sql.append(" FROM receipt_manual PM ");
		sql.append(" INNER JOIN payment_invoice_manual PIM ON PM.MANUAL_ID = PIM.MANUAL_ID ");
		sql.append(" WHERE PM.CREATE_DATE >=").append("'"+criteria.getDateFrom()+"'").append("  AND PM.CREATE_DATE <= ").append("'"+criteria.getDateTo()+"'");
		if(!"".equals(criteria.getVatRate()) && criteria.getVatRate() != null) {
			sql.append(" AND PIM.VAT_RATE = ").append("'"+criteria.getVatRate()+"'");
		}
		if(!"".equals(criteria.getUser()) && criteria.getUser() != null) {
			sql.append(" AND PM.CREATE_BY = ").append("'"+criteria.getUser()+"'");
		}
		if(!"".equals(criteria.getServiceType()) && criteria.getServiceType() != null) {
			sql.append(" AND PIM.SERVICE_TYPE = ").append("'"+criteria.getServiceType()+"'");
		}
		if(!"".equals(criteria.getAccountId()) && criteria.getAccountId() != null) {
			sql.append(" AND PIM.SERVICECODE = ").append("'"+criteria.getAccountId()+"'");
		}
		sql.append(" GROUP BY PM.RECEIPT_NO_MANUAL ");
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
			reportPayment.setCreateDate(rs.getTimestamp("CREATE_DATE"));
			reportPayment.setRemake(rs.getString("REMARK"));
//			reportPayment.setNoRefer(rs.getString(""));
			reportPayment.setBeforVat(rs.getBigDecimal("AMOUNT").subtract( rs.getBigDecimal("VAT_AMOUNT")));
			reportPayment.setAmount(rs.getBigDecimal("AMOUNT"));
			reportPayment.setVatAmount(rs.getBigDecimal("VAT_AMOUNT"));
			reportPayment.setStatus(rs.getString("RECORD_STATUS"));
			return reportPayment;
		}

	}

	@Override
	public ReceiptOfflineModel findByManualId(long manualId) throws SQLException{
		Connection connect = dataSource.getConnection();
		ReceiptOfflineModel beanReReq = new ReceiptOfflineModel();
		try {
			StringBuilder sqlStmt = new StringBuilder();
			sqlStmt.append("SELECT py.INVOICE_NO , py.RECEIPT_NO_MANUAL ,py.PAID_DATE,py.BRANCH_AREA ,py.BRANCH_CODE,py.PAID_AMOUNT,py.SOURCE,py.REMARK,py.ACCOUNT_NO,py.MANUAL_ID ");
			sqlStmt.append(" FROM receipt_manual py ");
			sqlStmt.append(" WHERE  py.MANUAL_ID = ? AND py.CLEARING = 'N' AND py.RECORD_STATUS = 'A' ");
			
			
			PreparedStatement preparedStatement = connect.prepareStatement(sqlStmt.toString());
			preparedStatement.setLong(1, manualId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				beanReReq = new ReceiptOfflineModel(resultSet.getString(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getString(4), resultSet.getString(5), resultSet.getBigDecimal(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return beanReReq; 
	}


}
