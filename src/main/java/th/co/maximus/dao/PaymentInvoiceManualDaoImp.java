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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import th.co.maximus.auth.model.UserProfile;
import th.co.maximus.bean.HistoryPaymentRS;
import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.bean.HistorySubFindBean;
import th.co.maximus.bean.InvoiceBean;
import th.co.maximus.bean.PaymentInvoiceManualBean;
import th.co.maximus.bean.PaymentMMapPaymentInvBean;
import th.co.maximus.model.PaymentInvoiceEpisOffline;

@Repository("PaymentInvoiceManualDao")
public class PaymentInvoiceManualDaoImp implements PaymentInvoiceManualDao {



	@Autowired
	DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public PaymentInvoiceManualDaoImp(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<PaymentMMapPaymentInvBean> findPaymentMuMapPaymentInV() {
		UserProfile profile = (UserProfile) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		sql.append(" SELECT * FROM RECEIPT_MANUAL payment_m ");
		sql.append(" INNER JOIN PAYMENT_INVOICE_MANUAL paument_inv ON payment_m.MANUAL_ID = paument_inv.MANUAL_ID");
		if(!profile.getRoles().get(0).getName().equals("sup")) {
			sql.append(" WHERE payment_m.CREATE_BY = ?");
			param.add(profile.getUsername());
		}
		Object[] paramArr = param.toArray();
		return jdbcTemplate.query(sql.toString(), paramArr, PaymentManual);
	}

	private static final RowMapper<PaymentMMapPaymentInvBean> PaymentManual = new RowMapper<PaymentMMapPaymentInvBean>() {
		// Utils utils = new Utils();

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
			paymentManual.setServiceType(rs.getString("SERVICE_TYPE"));

			return paymentManual;
		}

	};

	@Override
	public void insert(PaymentInvoiceManualBean paymentInvoiceManualBean) {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"INSERT INTO PAYMENT_INVOICE_MANUAL (MANUAL_ID,SOURCE, INVOICE_NO,BEFOR_VAT,VAT_AMOUNT,AMOUNT,VAT_RATE, CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_SEGMENT, CUSTOMER_BRANCH, TAXNO, ACCOUNTSUBNO, PERIOD,SERVICE_TYPE, CLEARING, PRINT_RECEIPT, REMARK, CREATE_BY, CREATE_DATE,UPDATE_BY,UPDATE_DATE,RECORD_STATUS,QUANTITY,INCOMETYPE,DISCOUNTBEFORVAT,DISCOUNTSPECIAL,AMOUNTTYPE,DEPARTMENT,SERVICENAME,INVOICE_DATE,SERVICECODE)  ");
		sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)  ");

		jdbcTemplate.update(sql.toString(), paymentInvoiceManualBean.getManualId(),
				paymentInvoiceManualBean.getSource(), paymentInvoiceManualBean.getInvoiceNo(),
				paymentInvoiceManualBean.getBeforVat(), paymentInvoiceManualBean.getVatAmount(),
				paymentInvoiceManualBean.getAmount(), paymentInvoiceManualBean.getVatRate(),
				paymentInvoiceManualBean.getCustomerName(), paymentInvoiceManualBean.getCustomerAddress(),
				paymentInvoiceManualBean.getCustomerSegment(), paymentInvoiceManualBean.getCustomerBranch(),
				paymentInvoiceManualBean.getTaxNo(), paymentInvoiceManualBean.getSubNo(),
				paymentInvoiceManualBean.getPeriod(), paymentInvoiceManualBean.getServiceType(),
				paymentInvoiceManualBean.getClearing(), paymentInvoiceManualBean.getPrintReceipt(),
				paymentInvoiceManualBean.getRemark(), paymentInvoiceManualBean.getCreateBy(),
				paymentInvoiceManualBean.getCreateDate(), paymentInvoiceManualBean.getUpdateBy(),
				paymentInvoiceManualBean.getUpdateDate(), paymentInvoiceManualBean.getRecordStatus(),
				paymentInvoiceManualBean.getQuantity(), paymentInvoiceManualBean.getIncometype(),
				paymentInvoiceManualBean.getDiscountbeforvat(), paymentInvoiceManualBean.getDiscountspecial(),
				paymentInvoiceManualBean.getAmounttype(), paymentInvoiceManualBean.getDepartment(),
				paymentInvoiceManualBean.getServiceName(), paymentInvoiceManualBean.getInvoiceDate(),
				paymentInvoiceManualBean.getServiceCode());

	}

	@Override
	public List<PaymentMMapPaymentInvBean> findPaymentMuMapPaymentInVAccountId(String accountNo) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		sql.append(" SELECT * FROM RECEIPT_MANUAL payment_m ");
		sql.append(" INNER JOIN PAYMENT_INVOICE_MANUAL paument_inv ON payment_m.MANUAL_ID = paument_inv.MANUAL_ID ");
		sql.append(" WHERE 1 = 1");
		if (!accountNo.equals("")) {
			sql.append(" AND payment_m.ACCOUNT_NO like ?");
			param.add("%" + accountNo + "%");
		}
		sql.append(" GROUP by payment_m.MANUAL_ID  ORDER BY payment_m.CREATE_DATE DESC");
		Object[] paramArr = param.toArray();
		return jdbcTemplate.query(sql.toString(), paramArr, PaymentManual);
	}

	@Override
	public List<PaymentMMapPaymentInvBean> findPaymentMuMapPaymentInVFromId(long manual_id) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		sql.append(" SELECT * FROM RECEIPT_MANUAL payment_m ");
		sql.append(" INNER JOIN PAYMENT_INVOICE_MANUAL paument_inv ON payment_m.MANUAL_ID = paument_inv.MANUAL_ID ");
		sql.append(" WHERE  payment_m.MANUAL_ID  =  ?");
		param.add(manual_id);
		sql.append(" GROUP by payment_m.MANUAL_ID  ORDER BY payment_m.CREATE_DATE DESC");
		Object[] paramArr = param.toArray();
		return jdbcTemplate.query(sql.toString(), paramArr, PaymentManual);
	}

	@Override
	public List<PaymentMMapPaymentInvBean> findCriteriaFromInvoiceOrReceiptNo(String receiptNo, String invoiceNo) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		UserProfile profile = (UserProfile) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		sql.append(" SELECT * FROM RECEIPT_MANUAL payment_m ");
		sql.append(" INNER JOIN PAYMENT_INVOICE_MANUAL paument_inv ON payment_m.MANUAL_ID = paument_inv.MANUAL_ID ");
		sql.append(" WHERE 1 = 1 ");
		if (receiptNo != "" && "".equals(invoiceNo)) {
			sql.append(" AND payment_m.RECEIPT_NO_MANUAL = ?");
			param.add(receiptNo);
		}
		if (invoiceNo != "" && "".equals(receiptNo)) {
			sql.append(" AND  payment_m.INVOICE_NO = ?");
			param.add(invoiceNo);
		}
		if(!profile.getRoles().get(0).getName().equals("sup")) {
			sql.append(" AND payment_m.CREATE_BY = ?");
			param.add(profile.getUsername());
		}
		// if (receiptNo != "" && invoiceNo != "") {
		// sql.append(" AND payment_m.RECEIPT_NO_MANUAL = ?");
		// param.add(receiptNo);
		// sql.append(" AND ");
		// sql.append(" payment_m.INVOICE_NO = ?");
		// param.add(invoiceNo);
		// }
		sql.append(" GROUP by payment_m.MANUAL_ID  ORDER BY payment_m.CREATE_DATE DESC ");
		Object[] paramArr = param.toArray();
		return jdbcTemplate.query(sql.toString(), paramArr, PaymentManual);
	}

	@Override
	public void updateRecodeStatusFromReceiptNo(String status, long manualId, String cancel, String user) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE RECEIPT_MANUAL payment_m ");
		sql.append(" SET payment_m.RECORD_STATUS =  ? ");
		sql.append(" , payment_m.CANCEL_REASON =  ? ");
		sql.append(" , payment_m.CANCEL_DATE =  ? ");
		sql.append(" , payment_m.CANCEL_BY =  ? ");
		sql.append(" WHERE payment_m.MANUAL_ID = ? ");
		jdbcTemplate.update(sql.toString(), status, cancel, null, user, manualId);

	}

	@Override
	public List<PaymentInvoiceManualBean> findPaymentInvoiceFromManualId(long manualId) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		sql.append(" SELECT * FROM PAYMENT_INVOICE_MANUAL PAYMENT_INVOICE where PAYMENT_INVOICE.MANUAL_ID = ?");
		param.add(manualId);
		sql.append("  GROUP by PAYMENT_INVOICE.MANUAL_ID ORDER BY PAYMENT_INVOICE.CREATE_DATE DESC");
		Object[] paramArr = param.toArray();
		return jdbcTemplate.query(sql.toString(), paramArr, PaymentInvoice);
	}

	@Override
	public void updateStatusPaymentInvoice(long manualId) {
		StringBuilder sql = new StringBuilder();
		sql.append(" UPDATE PAYMENT_INVOICE_MANUAL payment_m ");
		sql.append(" SET payment_m.RECORD_STATUS =  'C' ");
		sql.append(" WHERE payment_m.MANUAL_ID = ? ");
		jdbcTemplate.update(sql.toString(), manualId);
	}

	@Override
	public List<PaymentMMapPaymentInvBean> findPayOrder(HistorySubFindBean paymentInvBean) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM RECEIPT_MANUAL pm");
		sql.append(" INNER JOIN PAYMENT_INVOICE_MANUAL pim on pm.INVOICE_NO = pim.INVOICE_NO ");
		if (paymentInvBean.getPayDate() != null && paymentInvBean.getPayDateTo() != null) {
			sql.append(" where ");
			sql.append(" pm.PAID_DATE BETWEEN '" + paymentInvBean.getPayDate() + "'");
			sql.append(" and '" + paymentInvBean.getPayDateTo() + "'");
		}
		if (StringUtils.isNotBlank(paymentInvBean.getVatRate())) {
			sql.append(" and pm.VAT_RATE = '" + paymentInvBean.getVatRate() + "'");
		} else {
			sql.append(" and pm.VAT_RATE like '%" + paymentInvBean.getVatRate() + "%'");
		}
		if (StringUtils.isNotBlank(paymentInvBean.getUser())) {
			sql.append(" and pm.UPDATE_BY = '" + paymentInvBean.getUser() + "'");
		}
		if (StringUtils.isNotBlank(paymentInvBean.getPayType())) {
			sql.append(" and pim.SERVICE_TYPE like '%" + paymentInvBean.getPayType() + "%'");
		}
		sql.append(" GROUP by pm.MANUAL_ID  ORDER BY pm.CREATE_DATE DESC");
		return jdbcTemplate.query(sql.toString(), PaymentManual);
	}

	@Override
	public List<PaymentMMapPaymentInvBean> findPayOrderFulln(HistorySubFindBean paymentInvBean) {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT * FROM RECEIPT_MANUAL pm");
		sql.append(" INNER JOIN PAYMENT_INVOICE_MANUAL pim on pm.INVOICE_NO = pim.INVOICE_NO ");
		if (paymentInvBean.getPayDate() != null && paymentInvBean.getPayDateTo() != null) {
			sql.append(" where ");
			sql.append(" pm.PAID_DATE BETWEEN '" + paymentInvBean.getPayDate() + "'");
			sql.append(" and '" + paymentInvBean.getPayDateTo() + "'");
		}
		if (StringUtils.isNotBlank(paymentInvBean.getPayType())) {
			sql.append(" and pm.PAY_TYPE like '%" + paymentInvBean.getPayType() + "%'");
		}
		sql.append("  GROUP by pm.MANUAL_ID  ORDER BY pm.CREATE_DATE DESC");
		return jdbcTemplate.query(sql.toString(), PaymentManual);
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
			sql.append(
					" SELECT py.CREATE_DATE ,py.RECEIPT_NO_MANUAL,pim.CUSTOMER_NAME , pim.TAXNO ,py.BRANCH_CODE , py.RECORD_STATUS ,py.RECEIPT_NO_MANUAL,py.PAID_AMOUNT,pim.VAT_RATE");
			sql.append(" FROM RECEIPT_MANUAL py");
			sql.append(" INNER JOIN PAYMENT_INVOICE_MANUAL pim ON pim.MANUAL_ID = py.MANUAL_ID ");
			sql.append(" WHERE  ");
			sql.append(" py.DOCTYPE = ? ");
			if (StringUtils.isNoneEmpty(historyRpt.getDateFrom())
					&& StringUtils.isNoneEmpty(historyRpt.getDateFromHour())
					&& StringUtils.isNoneEmpty(historyRpt.getDateFromMinute())) {

				String dateFrom = convertDateString(historyRpt.getDateFrom()) + " " + historyRpt.getDateFromHour() + ":"
						+ historyRpt.getDateFromMinute() + ":" + "00" + ":" + "000000";
				sql.append(" AND py.CREATE_DATE >= '").append(" " + dateFrom + " ' ");

			}

			if (StringUtils.isNoneEmpty(convertDateString(historyRpt.getDateTo()))
					&& StringUtils.isNoneEmpty(historyRpt.getDateToHour())
					&& StringUtils.isNoneEmpty(historyRpt.getDateToMinute())) {
				String dateTo = historyRpt.getDateTo() + " " + historyRpt.getDateToHour() + ":"
						+ historyRpt.getDateToMinute() + ":" + "59" + ":" + "999999";
				sql.append(" AND py.CREATE_DATE <= ' ").append(" " + dateTo + " ' ");
			}

			sql.append(" GROUP by py.MANUAL_ID  ORDER BY py.CREATE_DATE DESC");
			// sql.append(" GROUP BY tm.NAME ");
			PreparedStatement preparedStatement = connect.prepareStatement(sql.toString());
			preparedStatement.setString(1, historyRpt.getTypePrint());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				// collections.add(new HistoryPaymen) ;
				collections.add(new HistoryPaymentRS(resultSet.getDate(1), resultSet.getString(2),
						resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6),
						resultSet.getString(7), resultSet.getBigDecimal(8), resultSet.getInt(9)));

			}
		} finally {
			connect.close();
		}

		return collections;
	}

	public static final String convertDateString(String str) {
		return str.replaceAll("([0-9]{2})/([0-9]{2})/([0-9]{4})", "$3-$2-$1");

	}

	@Override
	public List<PaymentInvoiceEpisOffline> findByManualId(long manualId) throws SQLException {
		Connection connect = dataSource.getConnection();
		List<PaymentInvoiceEpisOffline> beanReReq = new ArrayList<PaymentInvoiceEpisOffline>();
		PaymentInvoiceEpisOffline bean = new PaymentInvoiceEpisOffline();
		try {
			StringBuilder sqlStmt = new StringBuilder();
			sqlStmt.append(
					"SELECT pim.INVOICE_NO ,pim.BEFOR_VAT,pim.VAT_AMOUNT,pim.AMOUNT,pim.VAT_RATE,pim.CUSTOMER_NAME,pim.CUSTOMER_ADDRESS,pim.CUSTOMER_SEGMENT,pim.CUSTOMER_BRANCH,pim.TAXNO,pim.ACCOUNTSUBNO,pim.PERIOD,pim.SERVICE_TYPE,pim.REMARK,pim.QUANTITY,pim.INCOMETYPE,pim.DISCOUNTBEFORVAT,pim.DISCOUNTSPECIAL,pim.AMOUNTTYPE,pim.DEPARTMENT,pim.SERVICENAME,pim.SERVICECODE,pim.INVOICE_DATE ");
			sqlStmt.append(" FROM PAYMENT_INVOICE_MANUAL pim ");
			sqlStmt.append(" WHERE  pim.MANUAL_ID = ?  ");

			sqlStmt.append(" GROUP by pim.MANUAL_ID ORDER BY pim.CREATE_DATE DESC");
			PreparedStatement preparedStatement = connect.prepareStatement(sqlStmt.toString());
			preparedStatement.setLong(1, manualId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				bean = new PaymentInvoiceEpisOffline(resultSet.getString(1), resultSet.getBigDecimal(2),
						resultSet.getBigDecimal(3), resultSet.getBigDecimal(4), resultSet.getBigDecimal(5),
						resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9),
						resultSet.getString(10), resultSet.getString(11), resultSet.getString(12),
						resultSet.getString(13), resultSet.getString(14), resultSet.getInt(15), resultSet.getString(16),
						resultSet.getBigDecimal(17), resultSet.getBigDecimal(18), resultSet.getString(19),
						resultSet.getString(20), resultSet.getString(21), resultSet.getString(22),
						resultSet.getDate(23));
				beanReReq.add(bean);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return beanReReq;
	}

	@Override
	public void insertInvoice(InvoiceBean invoice) {
		StringBuilder sql = new StringBuilder();
		sql.append(
				"INSERT INTO `PAYMENT_INVOICE` (`MANUAL_ID`, `INVOICE_NO`, `INVOICE_DATE`, `DATE_LINE`, `BEFOR_VAT`, `VAT_AMOUNT`, `PAID_AMOUNT`, `AMOUNT`, `VAT_RATE`, `CUSTOMER_NAME`, `CUSTOMER_ADDRESS`, `CUSTOMER_SEGMENT`, `CUSTOMER_BRANCH`, "
						+ "`TAXNO`, `ACCOUNTSUBNO`, `PERIOD`, `SERVICENAME`, `SERVICE_TYPE`, `CHANG`, `CREATE_BY`, `CREATE_DATE`, `UPDATE_BY`, `UPDATE_DATE`, `RECORD_STATUS`, `DISCOUNT`) ");
		sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)  ");

		jdbcTemplate.update(sql.toString(), invoice.getManualId(), invoice.getInvoiceNo(), invoice.getInvoiceDate(),
				invoice.getDateLine(), invoice.getBeforVat(), invoice.getVatAmount(), invoice.getPaidAmount(),
				invoice.getAmount(), invoice.getVatRate(), invoice.getCustomerName(), invoice.getCustometAddress(),
				invoice.getCustometSegment(), invoice.getCustomerBranch(), invoice.getTaxNo(),
				invoice.getAccountSubNo(), invoice.getPeriod(), invoice.getServiceName(), invoice.getServiceType(),
				invoice.getChang(), invoice.getCreateBy(), invoice.getCreateDate(), invoice.getUpdateBy(),
				invoice.getUpdateDate(), invoice.getRecordStatus(), invoice.getDiscount());

	}

	private static final RowMapper<InvoiceBean> invoice = new RowMapper<InvoiceBean>() {

		@Override
		public InvoiceBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			InvoiceBean invoice = new InvoiceBean();
			invoice.setInvoiceId(rs.getLong("INV_ID"));
			invoice.setManualId(rs.getLong("MANUAL_ID"));
			invoice.setInvoiceNo(rs.getString("INVOICE_NO"));
			invoice.setInvoiceDate(rs.getTimestamp("INVOICE_DATE"));
			invoice.setDateLine(rs.getTimestamp("DATE_LINE"));
			invoice.setBeforVat(rs.getBigDecimal("BEFOR_VAT"));
			invoice.setVatAmount(rs.getBigDecimal("VAT_AMOUNT"));
			invoice.setPaidAmount(rs.getBigDecimal("PAID_AMOUNT"));
			invoice.setAmount(rs.getBigDecimal("AMOUNT"));
			invoice.setVatRate(rs.getString("VAT_RATE"));
			invoice.setCustomerName(rs.getString("CUSTOMER_NAME"));
			invoice.setCustometAddress(rs.getString("CUSTOMER_ADDRESS"));
			invoice.setCustometSegment(rs.getString("CUSTOMER_SEGMENT"));
			invoice.setCustomerBranch(rs.getString("CUSTOMER_BRANCH"));
			invoice.setTaxNo(rs.getString("TAXNO"));
			invoice.setAccountSubNo(rs.getString("ACCOUNTSUBNO"));
			invoice.setPeriod(rs.getString("PERIOD"));
			invoice.setServiceName(rs.getString("SERVICENAME"));
			invoice.setServiceType(rs.getString("SERVICE_TYPE"));
			invoice.setChang(rs.getBigDecimal("CHANG"));
			invoice.setCreateBy(rs.getString("CREATE_BY"));
			invoice.setCreateDate(rs.getTimestamp("CREATE_DATE"));
			invoice.setUpdateBy(rs.getString("UPDATE_BY"));
			invoice.setUpdateDate(rs.getTimestamp("UPDATE_DATE"));
			invoice.setRecordStatus(rs.getString("RECORD_STATUS"));
			invoice.setDiscount(rs.getBigDecimal("DISCOUNT"));
			return invoice;
		}

	};

	@Override
	public InvoiceBean findInvoiceByManualId(Long manualId) {
		InvoiceBean result = new InvoiceBean();
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		sql.append(" SELECT * FROM PAYMENT_INVOICE invoice WHERE invoice.MANUAL_ID = ?");
		param.add(manualId);
		sql.append(" GROUP by invoice.MANUAL_ID  ORDER BY invoice.CREATE_DATE DESC");
		Object[] paramArr = param.toArray();
		try {
			result = jdbcTemplate.queryForObject(sql.toString(), paramArr, invoice);
		}catch (Exception e) {
			
		}
		return result;
	}

	@Override
	public PaymentInvoiceManualBean findInvoiceManualByManualId(Long manualId) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		sql.append(" SELECT * FROM PAYMENT_INVOICE_MANUAL invoice WHERE invoice.MANUAL_ID = ?");
		param.add(manualId);
		sql.append(" GROUP by invoice.MANUAL_ID  ORDER BY invoice.CREATE_DATE DESC");
		Object[] paramArr = param.toArray();
		return jdbcTemplate.queryForObject(sql.toString(), paramArr, PaymentInvoice);
	}

	@Override
	public List<PaymentMMapPaymentInvBean> findPaymentMuMapPaymentInVs(String clearing) {
		StringBuilder sql = new StringBuilder();
		List<Object> param = new LinkedList<Object>();
		sql.append(" SELECT * FROM RECEIPT_MANUAL payment_m ");
		sql.append(" INNER JOIN PAYMENT_INVOICE_MANUAL paument_inv ON payment_m.MANUAL_ID = paument_inv.MANUAL_ID");
		sql.append(" WHERE payment_m.CLEARING = ?");
		param.add(clearing);
		sql.append("  GROUP by payment_m.MANUAL_ID  ORDER BY payment_m.CREATE_DATE DESC");
		Object[] paramArr = param.toArray();
		return jdbcTemplate.query(sql.toString(), paramArr, PaymentManual);
	}

}
