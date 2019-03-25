package th.co.maximus.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.HistoryReportBean;
import th.co.maximus.bean.ReportTaxRSBean;

@Service
public class ReportTaxDaoImpl implements ReportTaxDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final class mapTaxRs implements RowMapper<ReportTaxRSBean> {

		@Override
		public ReportTaxRSBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			ReportTaxRSBean reportTaxRSBean = new ReportTaxRSBean();
			reportTaxRSBean.setBeforeVat(rs.getBigDecimal("pim.BEFOR_VAT"));
			reportTaxRSBean.setBranCode(rs.getString("py.BRANCH_CODE"));
			reportTaxRSBean.setCustName(rs.getString("pim.CUSTOMER_NAME"));
			reportTaxRSBean.setDocumentDate(rs.getDate("py.CREATE_DATE"));
			reportTaxRSBean.setDocumentNo(rs.getString("py.RECEIPT_NO_MANUAL"));
			reportTaxRSBean.setInvoice(rs.getString("py.INVOICE_NO"));
			reportTaxRSBean.setNumberRun("");
			reportTaxRSBean.setPaidAmount(rs.getBigDecimal("py.PAID_AMOUNT"));
			reportTaxRSBean.setAmount(rs.getBigDecimal("py.AMOUNT"));
			reportTaxRSBean.setRecordStatus(rs.getString("py.RECORD_STATUS"));
			reportTaxRSBean.setTaxId(rs.getString("pim.TAXNO"));
			reportTaxRSBean.setVat(rs.getBigDecimal("pim.VAT_AMOUNT"));
			reportTaxRSBean.setVatRate(rs.getInt("pim.VAT_RATE"));
			reportTaxRSBean.setCreateBy(rs.getString("py.CREATE_BY"));
			return reportTaxRSBean;
		}

	}

	@Override
	public List<ReportTaxRSBean> findPaymentTaxRs(HistoryReportBean req) {
		List<ReportTaxRSBean> responeData = new ArrayList<ReportTaxRSBean>();
		List<Object> param = new LinkedList<Object>();

		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT py.CREATE_DATE ,py.INVOICE_NO,pim.CUSTOMER_NAME , pim.TAXNO ,py.BRANCH_CODE , py.RECORD_STATUS ,py.RECEIPT_NO_MANUAL,py.PAID_AMOUNT,pim.VAT_RATE,pim.VAT_AMOUNT,pim.BEFOR_VAT, py.AMOUNT, py.CREATE_BY");
			sql.append(" FROM RECEIPT_MANUAL py");
			sql.append(" INNER JOIN PAYMENT_INVOICE_MANUAL pim ON pim.MANUAL_ID = py.MANUAL_ID ");
			sql.append(" WHERE 1=1 ");
			sql.append(" and py.DOCTYPE = ? ");
			if (StringUtils.isNoneEmpty(req.getDateFrom())
					&& StringUtils.isNoneEmpty(req.getDateFromHour())
					&& StringUtils.isNoneEmpty(req.getDateFromMinute())) {

				String dateFrom = convertDateString(req.getDateFrom()) + " " + req.getDateFromHour() + ":"
						+ req.getDateFromMinute() + ":" + "00" + ":" + "000000";
				sql.append(" AND py.CREATE_DATE >= '").append(" " + dateFrom + " ' ");

			}

			if (StringUtils.isNoneEmpty(convertDateString(req.getDateTo()))
					&& StringUtils.isNoneEmpty(req.getDateToHour())
					&& StringUtils.isNoneEmpty(req.getDateToMinute())) {
				String dateTo = req.getDateTo() + " " + req.getDateToHour() + ":"
						+ req.getDateToMinute() + ":" + "59" + ":" + "999999";
				sql.append(" AND py.CREATE_DATE <= ' ").append(" " + dateTo + " ' ");
			}
			
			param.add(req.getTypePrint());
			if(StringUtils.isNotEmpty(req.getUnserLogin())) {
				sql.append(" and pim.CREATE_BY = ? ");
				
				param.add(req.getUnserLogin());
			}

			sql.append(" GROUP by py.MANUAL_ID  ORDER BY py.CREATE_DATE ");
//			sql.append(" GROUP by py.MANUAL_ID  ORDER BY py.CREATE_DATE and py.RECEIPT_NO_MANUAL ASC ");
			
			Object[] paramArr = param.toArray();
			responeData = jdbcTemplate.query(sql.toString(), paramArr, new mapTaxRs());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return responeData;
	}
	
	public static final String convertDateString(String str) {
		return str.replaceAll("([0-9]{2})/([0-9]{2})/([0-9]{4})", "$3-$2-$1");
	}

}
