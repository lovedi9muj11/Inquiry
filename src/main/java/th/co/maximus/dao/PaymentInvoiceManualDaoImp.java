package th.co.maximus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import th.co.maximus.bean.HistoryPaymentRS;
import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.bean.HistorySubFindBean;
import th.co.maximus.bean.PaymentInvoiceManualBean;
import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.constants.Constants;
import th.co.maximus.core.utils.Utils;



@Repository("PaymentInvoiceManualDao")
public class PaymentInvoiceManualDaoImp implements PaymentInvoiceManualDao{
	
	@Autowired
	DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public PaymentInvoiceManualDaoImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<PaymentMMapPaymentInvBean> findPaymentMuMapPaymentInV() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM receipt_manual payment_m ");
		sql.append(" INNER JOIN payment_invoice_manual paument_inv ON payment_m.MANUAL_ID = paument_inv.MANUAL_ID  ORDER BY payment_m.CREATE_DATE DESC");
		return jdbcTemplate.query(sql.toString() , PaymentManual);
	}
	
	private static final RowMapper<PaymentMMapPaymentInvBean> PaymentManual = new RowMapper<PaymentMMapPaymentInvBean>() {
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
			paymentManual.setRecordStatus(rs.getString("RECORD_STATUS"));
			paymentManual.setBeforVat(rs.getBigDecimal("BEFOR_VAT"));
			paymentManual.setAmount(rs.getBigDecimal("AMOUNT"));
			paymentManual.setVatAmount(rs.getBigDecimal("VAT_AMOUNT"));
			paymentManual.setAccountNo(rs.getString("ACCOUNT_NO"));
			paymentManual.setPeriod(rs.getString("PERIOD"));
			paymentManual.setPayType((rs.getString("PAY_TYPE")));
			paymentManual.setCreateBy(rs.getString("CREATE_BY"));
			paymentManual.setCustomerName((rs.getString("CUSTOMER_NAME")));
			paymentManual.setCustomerAddress(rs.getString("CUSTOMER_ADDRESS"));
			
			return paymentManual;
		}

	};

	@Override
	public void insert(PaymentInvoiceManualBean paymentInvoiceManualBean) {
		StringBuilder sql = new StringBuilder();
		 sql.append("INSERT INTO payment_invoice_manual (MANUAL_ID,SOURCE, INVOICE_NO,BEFOR_VAT,VAT_AMOUNT,AMOUNT,VAT_RATE, CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_SEGMENT, CUSTOMER_BRANCH, TAXNO, ACCOUNTSUBNO, PERIOD,SERVICE_TYPE, CLEARING, PRINT_RECEIPT, REMARK, CREATE_BY, CREATE_DATE,UPDATE_BY,UPDATE_DATE,RECORD_STATUS,QUANTITY,INCOMETYPE,DISCOUNTBEFORVAT,DISCOUNTSPECIAL,AMOUNTTYPE,DEPARTMENT,SERVICENAME,INVOICE_DATE,SERVICECODE)  ");  
		 sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)  ");
		 
		 jdbcTemplate.update(sql.toString(),  paymentInvoiceManualBean.getManualId(), paymentInvoiceManualBean.getSource(),paymentInvoiceManualBean.getInvoiceNo(),
				paymentInvoiceManualBean.getBeforVat(),paymentInvoiceManualBean.getVatAmount(),paymentInvoiceManualBean.getAmount(),paymentInvoiceManualBean.getVatRate(),
				paymentInvoiceManualBean.getCustomerName(),paymentInvoiceManualBean.getCustomerAddress(),paymentInvoiceManualBean.getCustomerSegment(),paymentInvoiceManualBean.getCustomerBranch(),paymentInvoiceManualBean.getTaxNo(),paymentInvoiceManualBean.getSubNo(),paymentInvoiceManualBean.getPeriod(),
				paymentInvoiceManualBean.getServiceType(),paymentInvoiceManualBean.getClearing(),paymentInvoiceManualBean.getPrintReceipt(),paymentInvoiceManualBean.getRemark(),
				paymentInvoiceManualBean.getCreateBy(),paymentInvoiceManualBean.getCreateDate(),paymentInvoiceManualBean.getUpdateBy(),paymentInvoiceManualBean.getUpdateDate(),paymentInvoiceManualBean.getRecordStatus(),paymentInvoiceManualBean.getQuantity(),
				paymentInvoiceManualBean.getIncometype(),paymentInvoiceManualBean.getDiscountbeforvat(),paymentInvoiceManualBean.getDiscountspecial(),paymentInvoiceManualBean.getAmounttype(),paymentInvoiceManualBean.getDepartment(),paymentInvoiceManualBean.getServiceName(),paymentInvoiceManualBean.getInvoiceDate(),paymentInvoiceManualBean.getServiceCode());
		
	}

	@Override
	public List<PaymentMMapPaymentInvBean> findPaymentMuMapPaymentInVAccountId(String accountNo) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		sql.append(" SELECT * FROM receipt_manual payment_m ");
		sql.append(" INNER JOIN payment_invoice_manual paument_inv ON payment_m.MANUAL_ID = paument_inv.MANUAL_ID ");
		sql.append(" WHERE payment_m.ACCOUNT_NO like ?");
		param.add("%"+accountNo+ "%");
		sql.append("ORDER BY payment_m.CREATE_DATE DESC");
		Object[] paramArr  = param.toArray();
		return jdbcTemplate.query(sql.toString(), paramArr ,PaymentManual);
	}

	@Override
	public List<PaymentMMapPaymentInvBean> findPaymentMuMapPaymentInVFromId(long manual_id) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		sql.append(" SELECT * FROM receipt_manual payment_m ");
		sql.append(" INNER JOIN payment_invoice_manual paument_inv ON payment_m.MANUAL_ID = paument_inv.MANUAL_ID ");
		sql.append(" WHERE  payment_m.MANUAL_ID  =  ?");
		param.add(manual_id);
		Object[] paramArr  = param.toArray();
		return jdbcTemplate.query(sql.toString(),paramArr , PaymentManual);
	}

	@Override
	public List<PaymentMMapPaymentInvBean> findCriteriaFromInvoiceOrReceiptNo(String receiptNo, String invoiceNo) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		sql.append(" SELECT * FROM receipt_manual payment_m ");
		sql.append(" INNER JOIN payment_invoice_manual paument_inv ON payment_m.MANUAL_ID = paument_inv.MANUAL_ID ");
		sql.append(" WHERE");
		if(receiptNo != "" && "".equals(invoiceNo)) {
			sql.append(" payment_m.RECEIPT_NO_MANUAL = ?");
			param.add(receiptNo);
		}
		if(invoiceNo != "" && "".equals(receiptNo)) {
			sql.append(" payment_m.INVOICE_NO = ?");
			param.add(invoiceNo);
		}
		if(receiptNo != "" && invoiceNo != "") {
			sql.append(" payment_m.RECEIPT_NO_MANUAL = ?");
			param.add(receiptNo);
			sql.append(" AND ");
			sql.append(" payment_m.INVOICE_NO = ?");
			param.add(invoiceNo);
		}
		sql.append(" ORDER BY payment_m.RECEIPT_NO_MANUAL DESC ");
		Object[] paramArr  = param.toArray();
		return jdbcTemplate.query(sql.toString() ,paramArr , PaymentManual);
	}

	@Override
	public void updateRecodeStatusFromReceiptNo(String status, long manualId) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE receipt_manual payment_m ");
		sql.append(" SET payment_m.RECORD_STATUS =  ? ");
		sql.append(" WHERE payment_m.MANUAL_ID = ? ");
		jdbcTemplate.update(sql.toString(), status, manualId);
		
	}

	@Override
	public List<PaymentInvoiceManualBean> findPaymentInvoiceFromManualId(long manualId) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		sql.append(" SELECT * FROM payment_invoice_manual payment_invoice where payment_invoice.MANUAL_ID = ?");
		param.add(manualId);
		Object[] paramArr = param.toArray();
		return jdbcTemplate.query(sql.toString() ,paramArr ,PaymentInvoice);
	}
	
	@Override
	public void updateStatusPaymentInvoice(long manualId) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE payment_invoice_manual payment_m ");
		sql.append(" SET payment_m.RECORD_STATUS =  'C' ");
		sql.append(" WHERE payment_m.MANUAL_ID = ? ");
		jdbcTemplate.update(sql.toString(), manualId);
	}

	@Override
	public List<PaymentMMapPaymentInvBean> findPayOrder(HistorySubFindBean paymentInvBean) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM receipt_manual pm");
		sql.append(" INNER JOIN payment_invoice_manual pim on pm.INVOICE_NO = pim.INVOICE_NO ");
		if(paymentInvBean.getPayDate() != null && paymentInvBean.getPayDateTo() != null) {
			sql.append(" where ");
			sql.append(" pm.PAID_DATE BETWEEN '"+paymentInvBean.getPayDate()+"'");
			sql.append(" and '"+paymentInvBean.getPayDateTo()+"'");
		}if(StringUtils.isNotBlank(paymentInvBean.getVatRate())) {
			sql.append(" and pim.VAT_RATE = '"+paymentInvBean.getVatRate()+"'");
		}else{
			sql.append(" and pim.VAT_RATE like '%"+paymentInvBean.getVatRate()+"%'");
		}if(StringUtils.isNotBlank(paymentInvBean.getUser())) {
			sql.append(" and pm.UPDATE_BY = '"+paymentInvBean.getUser()+"'");
		}if(StringUtils.isNotBlank(paymentInvBean.getPayType())) {
			sql.append(" and pim.SERVICE_TYPE like '%"+paymentInvBean.getPayType()+"%'");
		}
		
		return jdbcTemplate.query(sql.toString() , PaymentManual);
	}
	
	@Override
	public List<PaymentMMapPaymentInvBean> findPayOrderFulln(HistorySubFindBean paymentInvBean) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM receipt_manual pm");
		sql.append(" INNER JOIN payment_invoice_manual pim on pm.INVOICE_NO = pim.INVOICE_NO ");
		if(paymentInvBean.getPayDate() != null && paymentInvBean.getPayDateTo() != null) {
			sql.append(" where ");
			sql.append(" pm.PAID_DATE BETWEEN '"+paymentInvBean.getPayDate()+"'");
			sql.append(" and '"+paymentInvBean.getPayDateTo()+"'");
		}if(StringUtils.isNotBlank(paymentInvBean.getPayType())) {
			sql.append(" and pm.PAY_TYPE like '%"+paymentInvBean.getPayType()+"%'");
		}
		
		return jdbcTemplate.query(sql.toString() , PaymentManual);
	}
	
	private static final RowMapper<PaymentInvoiceManualBean> PaymentInvoice = new RowMapper<PaymentInvoiceManualBean>() {

		@Override
		public PaymentInvoiceManualBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			PaymentInvoiceManualBean paymentInvoice = new PaymentInvoiceManualBean();
			paymentInvoice.setPaymentInvoiceManualId(rs.getLong("PAYMENT_INVOICE_MANUAL_ID"));
			paymentInvoice.setManualId(rs.getLong("MANUAL_ID"));
			paymentInvoice.setSource(rs.getString("SOURCE"));
			paymentInvoice.setInvoiceNo(rs.getString("INVOICE_NO"));
			paymentInvoice.setBeforVat(rs.getDouble("BEFOR_VAT"));
			paymentInvoice.setVatAmount(rs.getInt("VAT_AMOUNT"));
			paymentInvoice.setAmount(rs.getDouble("AMOUNT"));
			paymentInvoice.setVatRate(rs.getInt("VAT_RATE"));
			paymentInvoice.setCustomerName(rs.getString("CUSTOMER_NAME"));
			paymentInvoice.setCustomerSegment(rs.getString("CUSTOMER_SEGMENT"));
			paymentInvoice.setCustomerBranch(rs.getString("CUSTOMER_BRANCH"));
			paymentInvoice.setTaxNo(rs.getString("TAXNO"));
			paymentInvoice.setAccountSubNo(rs.getString("ACCOUNTSUBNO"));
			paymentInvoice.setPeriod(rs.getString("PERIOD"));
			paymentInvoice.setServiceType(rs.getString("SERVICE_TYPE"));
			paymentInvoice.setClearing(rs.getString("CLEARING"));
			paymentInvoice.setPrintReceipt(rs.getString("PRINT_RECEIPT"));
			paymentInvoice.setRemark(rs.getString("REMARK"));
			paymentInvoice.setCreateBy(rs.getString("CREATE_BY"));
			paymentInvoice.setCreateDate(rs.getTimestamp("CREATE_DATE"));
			paymentInvoice.setUpdateBy(rs.getString("UPDATE_BY"));
			paymentInvoice.setUpdateDate(rs.getTimestamp("UPDATE_DATE"));
			paymentInvoice.setRecordStatus(rs.getString("RECORD_STATUS"));
			paymentInvoice.setQuantity(rs.getInt("QUANTITY"));
			paymentInvoice.setIncometype(rs.getString("INCOMETYPE"));
			paymentInvoice.setDiscountbeforvat(rs.getBigDecimal("DISCOUNTBEFORVAT"));
			paymentInvoice.setDiscountspecial(rs.getBigDecimal("DISCOUNTSPECIAL"));
			paymentInvoice.setAmounttype(rs.getString("AMOUNTTYPE"));
			paymentInvoice.setDepartment(rs.getString("DEPARTMENT"));
			paymentInvoice.setServiceName(rs.getString("SERVICENAME"));
			paymentInvoice.setServiceCode(rs.getString("SERVICECODE"));
			paymentInvoice.setInvoiceDate(rs.getDate("INVOICE_DATE"));
			return paymentInvoice;
		}

	};

	@Override
	public List<HistoryPaymentRS> findPaymentOrder(HistoryReportBean historyRpt) throws SQLException {
		List<HistoryPaymentRS> collections = new ArrayList<HistoryPaymentRS>();
		Connection connect = dataSource.getConnection();
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT py.CREATE_DATE ,py.INVOICE_NO,pim.CUSTOMER_NAME , pim.TAXNO ,py.BRANCH_CODE , py.RECORD_STATUS ,py.RECEIPT_NO_MANUAL,py.PAID_AMOUNT,pim.VAT_RATE");
			sql.append(" FROM receipt_manual py");
			sql.append(" INNER JOIN payment_invoice_manual pim ON pim.MANUAL_ID = py.MANUAL_ID ");
			sql.append(" WHERE  ");
			sql.append(" py.DOCTYPE = ? ");
			if(StringUtils.isNoneEmpty(historyRpt.getDateFrom()) && StringUtils.isNoneEmpty(historyRpt.getDateFromHour()) && StringUtils.isNoneEmpty(historyRpt.getDateFromMinute())) {
				
				String dateFrom = convertDateString(historyRpt.getDateFrom())+ " " + historyRpt.getDateFromHour()+ ":"+historyRpt.getDateFromMinute() +":"+"00"+":" +"000000"; 
				sql.append(" AND py.CREATE_DATE >= '").append(" "+dateFrom+" ' ");
				
			}
			
			if(StringUtils.isNoneEmpty( convertDateString(historyRpt.getDateTo())) && StringUtils.isNoneEmpty(historyRpt.getDateToHour()) && StringUtils.isNoneEmpty(historyRpt.getDateToMinute())) {
				String dateTo = historyRpt.getDateTo()+ " "  + historyRpt.getDateToHour()+ ":"+historyRpt.getDateToMinute() +":"+"59"+":" +"999999"; 
				sql.append(" AND py.CREATE_DATE <= ' ").append(" "+dateTo+" ' ");
			}
			

			
			//sql.append(" GROUP BY tm.NAME ");
			PreparedStatement preparedStatement = connect.prepareStatement(sql.toString());
			preparedStatement.setString(1, historyRpt.getTypePrint());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				//collections.add(new HistoryPaymen)	;
				collections.add(new HistoryPaymentRS(resultSet.getDate(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7),resultSet.getBigDecimal(8),resultSet.getInt(9)));
						
			}
		} finally {
			connect.close();
		}

	
		
		return collections;
	}

	public static final String convertDateString(String str) {
		return str.replaceAll("([0-9]{2})/([0-9]{2})/([0-9]{4})", "$3-$2-$1");

	} 
	
}
