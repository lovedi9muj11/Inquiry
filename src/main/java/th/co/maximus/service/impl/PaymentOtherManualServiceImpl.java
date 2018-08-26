package th.co.maximus.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.constants.Constants;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.payment.bean.PaymentOtherFirstBean;
import th.co.maximus.service.PaymentOtherManualService;
@Service
public class PaymentOtherManualServiceImpl implements PaymentOtherManualService{
	@Autowired
	PaymentManualDao paymentManualDao;
	

	@Override
	public int insertPaymentManual(PaymentOtherFirstBean paymentBean) {
		//UserProfile profile = (UserProfile)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		PaymentManualBean paymentManualBean = new PaymentManualBean();
		Date date = new Date();
		int userId=0;
		if(StringUtils.isNotBlank(paymentBean.getDocumentNo())){
//			paymentManualBean.setReceiptNoManual(paymentBean.getDocumentNo());
//			paymentManualBean.setBrancharea(Constants.dataUser.BRANCHAREA);
//			paymentManualBean.setBranchCode("001");
//			paymentManualBean.setPaidAmount(paymentBean.getSummaryTax());
//			paymentManualBean.setSource(Constants.dataUser.SOURCE);
//			paymentManualBean.setClearing("N");
//			paymentManualBean.setRemark(paymentBean.getRemark());
//			paymentManualBean.setCreateBy(profile.getUsername());
//			paymentManualBean.setCreateDate(new Timestamp(date.getTime()));
//			paymentManualBean.setUpdateBy(profile.getUsername());
//			paymentManualBean.setUpdateDate(new Timestamp(date.getTime()));
//			paymentManualBean.setRecordStatus("A");
//			paymentManualBean.setAccountNo(paymentBean.getInputCustomerBillNo());
//			
//			if(paymentBean.getBalanceSummary()>= paymentBean.getBalanceSummary()){
//				paymentManualBean.setPaytype("F");
//			}else{
//				paymentManualBean.setPaytype("P");
//			}
			paymentManualBean.setReceiptNoManual(paymentBean.getDocumentNo());
			paymentManualBean.setBrancharea(Constants.dataUser.BRANCHAREA);
			paymentManualBean.setBranchCode(paymentBean.getCustBrach());
			
			double resRQ = paymentBean.getBalanceSum();
			if(resRQ > paymentBean.getBalanceSum()) {
				paymentManualBean.setPaidAmount(paymentBean.getBalanceSum()- paymentBean.getChange());
				paymentManualBean.setAmount(new BigDecimal(paymentBean.getBalanceSum()));
			}else {
				paymentManualBean.setPaidAmount(resRQ- paymentBean.getChange());
				paymentManualBean.setAmount(new BigDecimal(resRQ));
			}
			paymentManualBean.setVatAmount(new BigDecimal(paymentBean.getVats()));
			paymentManualBean.setSource(Constants.dataUser.SOURCE);
			paymentManualBean.setClearing("N");
			paymentManualBean.setRemark(paymentBean.getRemark());
			paymentManualBean.setCreateBy(paymentBean.getUserName());
			paymentManualBean.setCreateDate(new Timestamp(date.getTime()));
			paymentManualBean.setUpdateBy(paymentBean.getUserName());
			paymentManualBean.setUpdateDate(new Timestamp(date.getTime()));
			paymentManualBean.setRecordStatus("A");
			paymentManualBean.setChange(paymentBean.getChange());
			paymentManualBean.setAccountNo(paymentBean.getCustNo());
//			paymentBean.getc
			
			if(paymentBean.getBalanceSum()>= paymentBean.getBalanceSummary()){
				paymentManualBean.setPaytype("F");
			}else{
				paymentManualBean.setPaytype("P");
			}
			
//			if(paymentBean.getUserGroup().equals("01") || paymentBean.getUserGroup().equals("02") ) {
//				if(StringUtils.isNotBlank(paymentBean.getCustName()) ||StringUtils.isNotBlank(paymentBean.getCustAddress() )) {
//					paymentManualBean.setDocType("F");
//				}else {
//					paymentManualBean.setDocType("S");
//				}
//			}else if(paymentBean.getUserGroup().equals("03")) {
//				if(StringUtils.isNotBlank(paymentBean.getCustName()) ||StringUtils.isNotBlank(paymentBean.getCustAddress() ) || StringUtils.isNotBlank(paymentBean.getTaxId())|| StringUtils.isNotBlank(paymentBean.getCustBrach()) ) {
//					paymentManualBean.setDocType("F");
//				}else {
//					paymentManualBean.setDocType("S");
//				}
//			}else {
//				paymentManualBean.setDocType("F");
//			}
			
			if(paymentBean.getUserGroup().equals("2") || paymentBean.getUserGroup().equals("3") ) {
				if(StringUtils.isNotBlank(paymentBean.getCustName()) &&StringUtils.isNotBlank(paymentBean.getCustAddress() )) {
					
					paymentManualBean.setDocType("F");
				}else {
					paymentManualBean.setDocType("S");
				}
			}else if(paymentBean.getUserGroup().equals("1")) {
				if(StringUtils.isNotBlank(paymentBean.getCustName()) && StringUtils.isNotBlank(paymentBean.getCustAddress() ) && StringUtils.isNotBlank(paymentBean.getTaxId())&& StringUtils.isNotBlank(paymentBean.getCustBrach()) ) {
					
					paymentManualBean.setDocType("F");
				}else {
					paymentManualBean.setDocType("S");
				}
			}else {
				paymentManualBean.setDocType("F");
			}
			
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
