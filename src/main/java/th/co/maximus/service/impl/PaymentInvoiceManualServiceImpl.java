package th.co.maximus.service.impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.PaymentInvoiceManualBean;
import th.co.maximus.dao.PaymentInvoiceManualDao;
import th.co.maximus.payment.bean.PaymentFirstBean;
import th.co.maximus.service.PaymentInvoiceManualService;

@Service
public class PaymentInvoiceManualServiceImpl implements PaymentInvoiceManualService{

	@Autowired PaymentInvoiceManualDao paymentInvoiceManualDao;

	@Override
	public void insertPaymentInvoiceManual(PaymentFirstBean paymentBean,int userId) {
		String period = "";
		if(paymentBean.getStartupDate() != null && paymentBean.getEndDate() != null) {
		String[] sResult = paymentBean.getStartupDate().split("-");
		String[] eResult = paymentBean.getEndDate().split("-");
		
		String start = sResult[0]+sResult[1]+sResult[2];
		String end = eResult[0]+eResult[1]+eResult[2];
		
		 period = start+end;
		}
		Date date = new Date();
		if(!paymentBean.getInvoiceNo().equals("")){
		PaymentInvoiceManualBean paymentInvoiceManualBean = new PaymentInvoiceManualBean();
		paymentInvoiceManualBean.setManualId(Long.valueOf(userId));
		paymentInvoiceManualBean.setSource("OFFLINE");
		paymentInvoiceManualBean.setInvoiceNo(paymentBean.getInvoiceNo());
		paymentInvoiceManualBean.setBeforVat(paymentBean.getBalanceBeforeTax());
		paymentInvoiceManualBean.setVatAmount(paymentBean.getVat());
		paymentInvoiceManualBean.setAmount(paymentBean.getBalanceSummary());
		paymentInvoiceManualBean.setVatRate(paymentBean.getVatrate());
		paymentInvoiceManualBean.setCustomerName(paymentBean.getCustName());
		paymentInvoiceManualBean.setCustomerAddress(paymentBean.getCustAddress());
		paymentInvoiceManualBean.setCustomerSegment("1");
		paymentInvoiceManualBean.setCustomerBranch(paymentBean.getCustBrach());
		paymentInvoiceManualBean.setTaxNo(paymentBean.getTaxId());
		paymentInvoiceManualBean.setSubNo(paymentBean.getServiceNo());
		paymentInvoiceManualBean.setPeriod(period);
		paymentInvoiceManualBean.setServiceType("IBASS");
		paymentInvoiceManualBean.setClearing("N");
		paymentInvoiceManualBean.setPrintReceipt("");
		paymentInvoiceManualBean.setRemark(paymentBean.getRemark());
		paymentInvoiceManualBean.setCreateBy(paymentBean.getUserName());
		paymentInvoiceManualBean.setCreateDate(new Timestamp(date.getTime()));
		paymentInvoiceManualBean.setUpdateBy(paymentBean.getUserName());
		paymentInvoiceManualBean.setUpdateDate(new Timestamp(date.getTime()));
		paymentInvoiceManualBean.setRecordStatus("A");
		paymentInvoiceManualBean.setDepartment(paymentBean.getDebtCollection());
		
		paymentInvoiceManualDao.insert(paymentInvoiceManualBean);
		}
	}
	
	@Override
	public List<PaymentInvoiceManualBean> PaymentInvoiceManualAll() {
		
		
		return null;
	}
	
	/*public PaymentInvoiceManualBean xx() {
		return jdbcTemplate.queryForObject("select * from payment_manual", new PaymentInvoiceManualJoin());
	}*/
	
	

}
