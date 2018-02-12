package th.co.maximus.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.bean.PaymentManualBean;
import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.payment.bean.PaymentFirstBean;
import th.co.maximus.service.PaymentManualService;

@Service
public class PaymentManualServiceImpl implements PaymentManualService{
	@Autowired
	PaymentManualDao paymentManualDao;
	

	@Override
	public void insertPaymentManual(PaymentFirstBean paymentBean) {
		PaymentManualBean paymentManualBean = new PaymentManualBean();
		Date date = new Date();
			paymentManualBean.setInvoiceNo(paymentBean.getInvoiceNo());
			paymentManualBean.setReceiptNoManual("");
			paymentManualBean.setPaidDate(new Timestamp(date.getTime()));
			paymentManualBean.setBrancharea("CAT นนทบุรี");
			paymentManualBean.setBranchCode("001");
			paymentManualBean.setPaidAmount(paymentBean.getBalanceSummary());
			paymentManualBean.setSource("OFFLINE");
			paymentManualBean.setClearing("N");
			paymentManualBean.setRemark("");
			paymentManualBean.setCreateBy("ADMIN");
			paymentManualBean.setCreateDate(new Timestamp(date.getTime()));
			paymentManualBean.setUpdateBy("ADMIN");
			paymentManualBean.setUpdateDate(new Timestamp(date.getTime()));
			paymentManualBean.setRecordStatus("A");
			paymentManualBean.setAccountNo(paymentBean.getCustNo());
			
			
			paymentManualDao.insertPayment(paymentManualBean);
		
	}



	
	@Override
	public List<PaymentManualBean> PaymentManualAll() {
		return null;
	}
	
	/*public PaymentManualBean xx() {
		return jdbcTemplate.queryForObject("select * from payment_manual", new PaymentManuaJoin());
	}*/
	



}
