package th.co.maximus.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import th.co.maximus.auth.model.UserProfile;
import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.constants.Constants;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.payment.bean.PaymentFirstBean;
import th.co.maximus.service.PaymentManualService;

@Service
public class PaymentManualServiceImpl implements PaymentManualService{
	@Autowired
	PaymentManualDao paymentManualDao;


	@Override
	public int insertPaymentManual(PaymentFirstBean paymentBean) throws ParseException {
		PaymentManualBean paymentManualBean = new PaymentManualBean();
		UserProfile profile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Date date = new Date();
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd 00:00.00.000");
//		String da = dt.format(paymentBean.getDeadlines());
		dt.format(date);
		int userId=0;
		if(StringUtils.isNotBlank(paymentBean.getInvoiceNo())){
			paymentManualBean.setInvoiceNo(paymentBean.getInvoiceNo());
			paymentManualBean.setReceiptNoManual(paymentBean.getDocumentNo());
			paymentManualBean.setPaidDate(new Timestamp(date.getTime()));
			paymentManualBean.setBrancharea(Constants.dataUser.BRANCHAREA);
			paymentManualBean.setBranchCode(paymentBean.getCustBrach());
			paymentManualBean.setPaidAmount(paymentBean.getAmountInvoice());
			paymentManualBean.setCustomerGroup(paymentBean.getUserGroup());
			if(paymentBean.getTaxOnly() == null ){
				paymentBean.setTaxOnly(0.00);
			}
			if(null == paymentBean.getChang()){
				paymentBean.setChang(0.00);
			}
			double resRQ = (paymentBean.getBalanceSum()+ (paymentBean.getSummaryTax() * -1));
			if(resRQ > paymentBean.getBalanceOfTax()) {
				paymentManualBean.setAmount(new BigDecimal(paymentBean.getBalanceOfTax()).subtract(new BigDecimal(paymentBean.getTaxOnly()).subtract(new BigDecimal(paymentBean.getChang()))));
			}else {
				paymentManualBean.setAmount(new BigDecimal(resRQ - paymentBean.getChang()));
			}
//			if(paymentBean.getNonVat().equals("NON VAT")) {
//				paymentManualBean.setVatRate(-1);
//			}else {
//				paymentManualBean.setVatRate(paymentBean.getVatrate());
//			}
			
			
			
			paymentManualBean.setVatAmount(calVatAmount(paymentManualBean.getAmount()));
			paymentManualBean.setSource(Constants.dataUser.SOURCE);
			paymentManualBean.setClearing("N");
			paymentManualBean.setRemark(paymentBean.getRemark());
			paymentManualBean.setCreateBy(profile.getUsername());
			paymentManualBean.setCreateDate(new Timestamp(date.getTime()));
			paymentManualBean.setUpdateBy(profile.getUsername());
			paymentManualBean.setUpdateDate(new Timestamp(date.getTime()));
			paymentManualBean.setRecordStatus("A");
			paymentManualBean.setChange(paymentBean.getChang());
			paymentManualBean.setAccountNo(paymentBean.getCustNo());
			
			if(paymentBean.getBalanceOfTax()>= paymentBean.getAmountInvoice()){
				paymentManualBean.setPaytype("F");
			}else{
				paymentManualBean.setPaytype("P");
			}

			paymentManualBean.setDocType(paymentBean.getDocType());
			try {
				userId=	paymentManualDao.insertPayment(paymentManualBean);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return userId;
	}



	
	@Override
	public List<PaymentManualBean> PaymentManualAll() {
		return null;
	}




	@Override
	public BigDecimal calVatAmount(BigDecimal amount) {
		BigDecimal vat = new BigDecimal(7);
		
		amount = amount.multiply(vat);
		amount = amount.divide(new BigDecimal(107),4,RoundingMode.UP);
		
		return amount;
	}
	
	/*public PaymentManualBean xx() {
		return jdbcTemplate.queryForObject("select * from payment_manual", new PaymentManuaJoin());
	}*/
	



}
