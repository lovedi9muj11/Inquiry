package th.co.maximus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.bean.InvEpisOfflineByInsaleBean;
import th.co.maximus.bean.InvEpisOfflineReportBean;
import th.co.maximus.bean.InvPaymentOrderTaxBean;
@Repository("ReportDao")
public class ReportDaoImpl implements ReportDao{
	@Autowired
	DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	
	
	@Override
	public List<InvEpisOfflineReportBean> inqueryEpisOfflineJSONHandler(String documentNo) throws SQLException {
		Connection connect = dataSource.getConnection();
		List<InvEpisOfflineReportBean> collections = new ArrayList<InvEpisOfflineReportBean>();
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT py.BRANCH_AREA ,py.BRANCH_CODE, py.SOURCE ,py.ACCOUNT_NO , pim.CUSTOMER_NAME ,py.RECEIPT_NO_MANUAL,pim.AMOUNT ,py.INVOICE_NO,py.CREATE_DATE,pim.CUSTOMER_ADDRESS,pim.TAXNO,py.REMARK,tm.CODE ,pim.VAT_RATE,pay.VAT_AMOUNT, ");
			sql.append(" pay.BEFOR_VAT,tm.METHOD_MANUAL_ID,pay.ACCOUNTSUBNO,pay.DISCOUNT,pay.PAID_AMOUNT,pim.PERIOD,py.DOCTYPE ");
			sql.append(" FROM receipt_manual py");
			sql.append(" INNER JOIN payment_invoice_manual pim ON pim.MANUAL_ID = py.MANUAL_ID AND pim.INVOICE_NO = py.INVOICE_NO ");
			sql.append(" INNER JOIN trsmethod_manual tm ON tm.MANUAL_ID = py.MANUAL_ID");
			sql.append(" INNER JOIN payment_invoice pay ON pay.MANUAL_ID = py.MANUAL_ID");
			sql.append(" WHERE py.RECEIPT_NO_MANUAL = ?");
			sql.append(" GROUP BY tm.NAME ");
			PreparedStatement preparedStatement = connect.prepareStatement(sql.toString());
			preparedStatement.setString(1, documentNo);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				collections.add(new InvEpisOfflineReportBean(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getBigDecimal(7), 
						resultSet.getString(8), resultSet.getDate(9), resultSet.getString(10), resultSet.getString(11), resultSet.getString(12), resultSet.getString(13), resultSet.getString(14), resultSet.getBigDecimal(15),
						resultSet.getBigDecimal(16), resultSet.getLong(17), resultSet.getString(18), resultSet.getBigDecimal(19), resultSet.getBigDecimal(20),resultSet.getString(21),resultSet.getString(22)));		
						
			}
		} finally {
			connect.close();
		}
		return collections;
		
	}



	@Override
	public List<InvEpisOfflineByInsaleBean> inqueryEpisOfflineByInsaleJSONHandler(String documentNo) throws SQLException {
		Connection connect = dataSource.getConnection();
		List<InvEpisOfflineByInsaleBean> collections = new ArrayList<InvEpisOfflineByInsaleBean>();
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT py.BRANCH_AREA ,py.BRANCH_CODE, pim.SERVICENAME ,py.ACCOUNT_NO , pim.CUSTOMER_NAME ,py.RECEIPT_NO_MANUAL,py.PAID_AMOUNT ,py.INVOICE_NO,py.CREATE_DATE,pim.CUSTOMER_ADDRESS,pim.TAXNO,py.REMARK,tm.CODE ,pim.VAT_RATE,pim.DISCOUNTSPECIAL,pim.AMOUNT,pim.DISCOUNTBEFORVAT,tm.METHOD_MANUAL_ID");
			sql.append(" FROM receipt_manual py");
			sql.append(" INNER JOIN payment_invoice_manual pim ON pim.MANUAL_ID = py.MANUAL_ID ");
			sql.append(" INNER JOIN trsmethod_manual tm ON tm.MANUAL_ID = py.MANUAL_ID");
			sql.append(" WHERE py.RECEIPT_NO_MANUAL = ?");
			//sql.append(" GROUP BY pim.SERVICENAME ");
			PreparedStatement preparedStatement = connect.prepareStatement(sql.toString());
			preparedStatement.setString(1, documentNo);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				collections.add(new InvEpisOfflineByInsaleBean(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getBigDecimal(7), 
						resultSet.getString(8), resultSet.getDate(9), resultSet.getString(10), resultSet.getString(11), resultSet.getString(12), resultSet.getString(13), resultSet.getString(14),resultSet.getBigDecimal(15),resultSet.getBigDecimal(16),resultSet.getBigDecimal(17),resultSet.getLong(18)))	;		
						
			}
		} finally {
			connect.close();
		}
		return collections;
	}



	@Override
	public List<InvPaymentOrderTaxBean> inqueryInvPaymentOrderTaxBeanJSONHandler(HistoryReportBean creteria)
			throws SQLException {
		Connection connect = dataSource.getConnection();
		List<InvPaymentOrderTaxBean> collections = new ArrayList<InvPaymentOrderTaxBean>();
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT py.CREATE_DATE ,py.RECEIPT_NO_MANUAL,pim.CUSTOMER_NAME,py.CREATE_BY, pim.TAXNO ,py.INVOICE_NO , py.BRANCH_AREA, py.BRANCH_CODE ,py.PAID_AMOUNT,py.RECORD_STATUS,pim.VAT_RATE");
			sql.append(" FROM receipt_manual py");
			sql.append(" INNER JOIN payment_invoice_manual pim ON pim.MANUAL_ID = py.MANUAL_ID ");
			sql.append(" WHERE  ");
			sql.append(" py.DOCTYPE = ? ");
			if(StringUtils.isNoneEmpty(creteria.getDateFrom())) {
				
				String dateFrom = convertDateString(creteria.getDateFrom())+ " " + creteria.getDateFromHour()+ ":"+creteria.getDateFromMinute() +":"+"00"+":" +"000000"; 
				sql.append(" AND py.CREATE_DATE >= '").append(" "+dateFrom+" ' ");
				
			}
			if(StringUtils.isNoneEmpty( convertDateString(creteria.getDateTo()))) {
				String dateTo = creteria.getDateTo()+ " "  + creteria.getDateToHour()+ ":"+creteria.getDateToMinute() +":"+"59"+":" +"999999"; 
				sql.append(" AND py.CREATE_DATE <= ' ").append(" "+dateTo+" ' ");
			}
			

			PreparedStatement preparedStatement = connect.prepareStatement(sql.toString());
			preparedStatement.setString(1, creteria.getTypePrint());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				//collections.add(new HistoryPaymen)	;
				collections.add(new InvPaymentOrderTaxBean(resultSet.getDate(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getBigDecimal(9), resultSet.getString(10), resultSet.getInt(11)));
						
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
