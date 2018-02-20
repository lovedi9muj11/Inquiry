package th.co.maximus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.dao.PaymentManualDao;
import th.co.maximus.payment.bean.PaymentFirstBean;
import th.co.maximus.payment.bean.PaymentOtherFirstBean;
import th.co.maximus.payment.bean.PaymentResultReq;
import th.co.maximus.service.PaymentOtherInvoiceManualService;
import th.co.maximus.service.PaymentOtherManualService;
import th.co.maximus.service.PaymentOtherService;
import th.co.maximus.service.TrsmethodOtherManualService;
@Service
public class PaymentOtherServiceImpl implements PaymentOtherService{
	@Autowired PaymentOtherManualService paymentOtherManualService;
	@Autowired PaymentOtherInvoiceManualService paymentOtherInvoiceManualService;
	@Autowired TrsmethodOtherManualService trsmethodOtherManualService;
	@Autowired PaymentManualDao paymentManualDao;

	@Override
	public int insert(PaymentOtherFirstBean paymentBean) {
		int paymentId =0;
		int userId = 0;
		
		try {
			paymentId = paymentOtherManualService.insertPaymentManual(paymentBean);
			if(paymentId>0){
				paymentOtherInvoiceManualService.insertPaymentInvoiceManual(paymentBean, paymentId);
				userId = trsmethodOtherManualService.insertTrsmethodManual(paymentBean, paymentId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return paymentId;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PaymentOtherFirstBean paymentBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaymentResultReq findByid(int id) throws Exception{
		// TODO Auto-generated method stub
		return paymentManualDao.findById(id);
	}
}
