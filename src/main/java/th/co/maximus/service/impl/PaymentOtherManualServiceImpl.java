package th.co.maximus.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.payment.bean.PaymentFirstBean;
import th.co.maximus.payment.bean.PaymentOtherFirstBean;
import th.co.maximus.service.PaymentOtherManualService;
@Service
public class PaymentOtherManualServiceImpl implements PaymentOtherManualService{
	@Autowired
	PaymentManualDao paymentManualDao;
	

	@Override
	public int insertPaymentManual(PaymentOtherFirstBean paymentBean) {
		PaymentManualBean paymentManualBean = new PaymentManualBean();
		Date date = new Date();
		int userId=0;
		if(StringUtils.isNotBlank(paymentBean.getInputCustomerBillNo())){
			paymentManualBean.setInvoiceNo(paymentBean.getInputCustomerBillNo());
			paymentManualBean.setReceiptNoManual(paymentBean.getInputCustomerBranch());
			paymentManualBean.setBrancharea("CAT นนทบุรี");
			paymentManualBean.setBranchCode("001");
			paymentManualBean.setPaidAmount(paymentBean.getSummaryTax());
			paymentManualBean.setSource("OFFLINE");
			paymentManualBean.setClearing("N");
			paymentManualBean.setRemark(paymentBean.getInputAdditionalRemark());
			paymentManualBean.setCreateBy("ADMIN");
			paymentManualBean.setCreateDate(new Timestamp(date.getTime()));
			paymentManualBean.setUpdateBy("ADMIN");
			paymentManualBean.setUpdateDate(new Timestamp(date.getTime()));
			paymentManualBean.setRecordStatus("A");
			//paymentManualBean.setAccountNo(paymentBean.getCustNo());
			
			if(paymentBean.getBalanceSummary()>= paymentBean.getBalanceSummary()){
				paymentManualBean.setPaytype("เต็มจำนวน");
			}else{
				paymentManualBean.setPaytype("ไม่เต็มจำนวน");
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
