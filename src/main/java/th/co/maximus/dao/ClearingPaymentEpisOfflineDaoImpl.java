//package th.co.maximus.dao;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class ClearingPaymentEpisOfflineDaoImpl implements ClearingPaymentEpisOfflineDao{
//	@Autowired
//	DataSource dataSource;
//
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	public ClearingPaymentEpisOfflineDaoImpl(DataSource dataSource) {
//		jdbcTemplate = new JdbcTemplate(dataSource);
//
//	}
//
////	@Override
////	public PaymentEpisOfflineDTO findDataClearing(Integer manaulId){
////		Connection connect = dataSource.getConnection();
////		PaymentEpisOfflineDTO beanReReq = new PaymentEpisOfflineDTO();
////		try {
////			StringBuilder sqlStmt = new StringBuilder();
////			sqlStmt.append("SELECT py.INVOICE_NO , py.RECEIPT_NO_MANUAL ,py.PAID_DATE,py.BRANCH_AREA ,py.BRANCH_CODE,py.PAID_AMOUNT,py.SOURCE,py.REMARK,py.ACCOUNT_NO,py.MANUAL_ID ,");
////			sqlStmt.append(" (SELECT pim.INVOICE_NO ,pim.BEFOR_VAT,pim.VAT_AMOUNT,pim.AMOUNT,pim.VAT_RATE,pim.CUSTOMER_NAME,pim.CUSTOMER_ADDRESS,pim.CUSTOMER_SEGMENT,pim.CUSTOMER_BRANCH,pim.TAXNO,pim.ACCOUNTSUBNO,pim.PERIOD,pim.SERVICE_TYPE,pim.REMARK,pim.QUANTITY,pim.INCOMETYPE,pim.DISCOUNTBEFORVAT,pim.DISCOUNTSPECIAL,pim.AMOUNTTYPE,pim.DEPARTMENT,pim.SERVICENAME,pim.SERVICECODE,pim.INVOICE_DATE FROM PAYMENT_INVOICE_MANUAL pim WHERE pim.MANUAL_ID = py.MANUAL_ID ) as paymentInvoice ,");
////			sqlStmt.append(" (SELECT dm.DEDUCTIONNO,dm.DEDUCTIONTYPE,dm.AMOUNT,dm.PAYMENTDATE,dm.INVOICE_NO,dm.REMARK FROM DEDUCTION_MANUAL dm  WHERE dm.MANUAL_ID = py.MANUAL_ID) as duduction , ");
////			sqlStmt.append(" (SELECT tm.CODE,tm.NAME,tm.CHEQUENO,tm.CREDITNO,tm.ACCOUNTNO,tm.AMOUNT,(SELECT trsm.CREDITNO,trsm.PUBLISHERDEC,trsm.CARDTYPE,trsm.AMOUNT FROM trscreditref_manual trsm WHERE trsm.METHOD_MANUAL_ID = tm.METHOD_MANUAL_ID) as trsCredit,(SELECT trc.CHEQUENO,trc.PUBLISHERID,trc.PUBLISHER,trc.BRANCH,trc.AMOUNT,trc.CHEQUEDATE,trc.BOUNCE_CHEQUE_DATE,trc.REVERSE_AR_DATE,trc.BOUNCE_STATUS FROM TRSCHEQUEREF_MANUAL trc WHERE trc.METHOD_MANUAL_ID = tm.METHOD_MANUAL_ID) as cheq FROM trsmethod_manual tm WHERE tm.MANUAL_ID = py.MANUAL_ID)  ");
////			sqlStmt.append(" FROM RECEIPT_MANUAL py ");
////			sqlStmt.append(" WHERE  py.MANUAL_ID = ? ");
////			
////			
////			PreparedStatement preparedStatement = connect.prepareStatement(sqlStmt.toString());
////			preparedStatement.setInt(1, manaulId);
////			ResultSet resultSet = preparedStatement.executeQuery();
////			while (resultSet.next()) {
////				beanReReq = new PaymentEpisOfflineDTO(resultSet.getString(1), resultSet.getString(2), resultSet.getDate(3), resultSet.getString(4), resultSet.getString(5), resultSet.getBigDecimal(6), resultSet.getString(7), resultSet.getString(8), resultSet.getString(9), resultSet.getString(10)
////						, (List<PaymentInvoiceEpisOffline>)resultSet.getArray(11), (List<DuductionEpisOffline>)resultSet.getArray(12), (List<TrsMethodEpisOffline>)resultSet.getArray(13));
////			}
////
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} finally {
////			connect.close();
////		}
////		return beanReReq;
////	}
//
//	
//
//}
