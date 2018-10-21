package th.co.maximus.dao;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import th.co.maximus.bean.TmpInvoiceBean;

@Repository("TmpInvoiceDaoImpl")
public class TmpInvoiceDaoImpl implements TmpInvoiceDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void insertTmpInvoice(TmpInvoiceBean tmpInvoiceBean) {
		StringBuilder sql = new StringBuilder();
		 sql.append("INSERT INTO PAYMENT_INVOICE (MANUAL_ID, INVOICE_NO,INVOICE_DATE,DATE_LINE,BEFOR_VAT,VAT_AMOUNT,AMOUNT,VAT_RATE, CUSTOMER_NAME, CUSTOMER_ADDRESS, CUSTOMER_SEGMENT, CUSTOMER_BRANCH, TAXNO, ACCOUNTSUBNO, PERIOD ,CHANG, CREATE_BY, CREATE_DATE,UPDATE_BY,UPDATE_DATE,RECORD_STATUS,PAID_AMOUNT,DISCOUNT,DISCOUNT_FLAG)  ");  
		 sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)  ");
		 
		 jdbcTemplate.update(sql.toString(), tmpInvoiceBean.getManualId(),tmpInvoiceBean.getInvoiceNo(),tmpInvoiceBean.getInvoiceDate(),tmpInvoiceBean.getDateLine()
				 ,tmpInvoiceBean.getBeforVat(),tmpInvoiceBean.getVatAmount(),tmpInvoiceBean.getAmount(),tmpInvoiceBean.getVatRate(),tmpInvoiceBean.getCustomerName()
				 ,tmpInvoiceBean.getCustomerAddress(),tmpInvoiceBean.getCustomerSegment(),tmpInvoiceBean.getCustomerBranch(),tmpInvoiceBean.getTaxno(),tmpInvoiceBean.getAccountSubNo()
				 ,tmpInvoiceBean.getPeriod(),tmpInvoiceBean.getChange(),tmpInvoiceBean.getCreateBy(),tmpInvoiceBean.getCreateDate(),tmpInvoiceBean.getUpdateBy(),tmpInvoiceBean.getUpdateDate(),tmpInvoiceBean.getRecordStatus(),tmpInvoiceBean.getPaidAmount(),tmpInvoiceBean.getDiscount(),tmpInvoiceBean.getIsDiscountFlg()

				 );
		
	}

	@Override
	public TmpInvoiceBean findByManualId(Integer manualId) {
		StringBuilder sql = new StringBuilder();
		TmpInvoiceBean tmp = new TmpInvoiceBean();
		sql.append(" select * from PAYMENT_INVOICE  where PAYMENT_INVOICE.MANUAL_ID = ");
		sql.append(manualId);
		java.util.Map<String, Object> map = new HashMap<String, Object >();
		map  =  jdbcTemplate.queryForMap(sql.toString());
		
			tmp.setIsDiscountFlg(map.get("DISCOUNT_FLAG")+"");
			tmp.setDiscount(Double.parseDouble(map.get("DISCOUNT")+""));	
	
		
		return tmp;
	}

}
