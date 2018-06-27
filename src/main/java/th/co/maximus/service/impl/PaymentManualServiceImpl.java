package th.co.maximus.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
	public int insertPaymentManual(PaymentFirstBean paymentBean) {
		PaymentManualBean paymentManualBean = new PaymentManualBean();
		UserProfile profile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Date date = new Date();
		int userId=0;
		if(StringUtils.isNotBlank(paymentBean.getInvoiceNo())){
			paymentManualBean.setInvoiceNo(paymentBean.getInvoiceNo());
			paymentManualBean.setReceiptNoManual(paymentBean.getDocumentNo());
			paymentManualBean.setPaidDate(new Timestamp(paymentBean.getDeadlines().getTime()));
			paymentManualBean.setBrancharea(Constants.dataUser.BRANCHAREA);
			paymentManualBean.setBranchCode(paymentBean.getCustBrach());
			paymentManualBean.setPaidAmount(paymentBean.getAmountInvoice());
			if(paymentBean.getTaxOnly() == null ){
				paymentBean.setTaxOnly(0.00);
			}
			double resRQ = (paymentBean.getBalanceSum()+ (paymentBean.getSummaryTax() * -1) + paymentBean.getTaxOnly());
			if(resRQ > paymentBean.getBalanceOfTax()) {
				paymentManualBean.setAmount(new BigDecimal(paymentBean.getBalanceOfTax()));
			}else {
				paymentManualBean.setAmount(new BigDecimal(resRQ));
			}
			if(paymentBean.getNonVat().equals("NON VAT")) {
				paymentManualBean.setVatRate(-1);
			}else {
				paymentManualBean.setVatRate(paymentBean.getVatrate());
			}
			
			paymentManualBean.setVatAmount(new BigDecimal(paymentBean.getVat()));
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
			
			if(resRQ>= paymentBean.getAmountInvoice()){
				paymentManualBean.setPaytype("F");
			}else{
				paymentManualBean.setPaytype("P");
			}
//			if(paymentBean.getUserGroup().equals("1") || paymentBean.getUserGroup().equals("2") ) {
//				if(StringUtils.isNotBlank(paymentBean.getCustName()) &&StringUtils.isNotBlank(paymentBean.getCustAddress() )) {
//					paymentManualBean.setDocType("F");
//				}else {
//					paymentManualBean.setDocType("S");
//				}
//			}else if(paymentBean.getUserGroup().equals("3")) {
//				if(StringUtils.isNotBlank(paymentBean.getCustName()) && StringUtils.isNotBlank(paymentBean.getCustAddress() ) && StringUtils.isNotBlank(paymentBean.getTaxId())&& StringUtils.isNotBlank(paymentBean.getCustBrach()) ) {
//					paymentManualBean.setDocType("F");
//				}else {
//					paymentManualBean.setDocType("S");
//				}
//			}else {
//				paymentManualBean.setDocType("F");
//			}
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
	
	/*public PaymentManualBean xx() {
		return jdbcTemplate.queryForObject("select * from payment_manual", new PaymentManuaJoin());
	}*/
	



}
