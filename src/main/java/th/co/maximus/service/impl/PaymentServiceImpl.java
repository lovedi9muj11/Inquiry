package th.co.maximus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.payment.bean.PaymentFirstBean;
import th.co.maximus.payment.bean.PaymentResultReq;
import th.co.maximus.service.PaymentInvoiceManualService;
import th.co.maximus.service.PaymentManualService;
import th.co.maximus.service.PaymentService;
import th.co.maximus.service.TrsmethodManualService;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired PaymentManualService paymentManualService;
	@Autowired PaymentInvoiceManualService paymentInvoiceManualService;
	@Autowired TrsmethodManualService trsmethodManualService;

	@Override
	public int insert(PaymentFirstBean paymentBean) {
		int paymentId =0;
		int userId = 0;
		
		try {
			paymentId = paymentManualService.insertPaymentManual(paymentBean);
			if(paymentId>0){
				paymentInvoiceManualService.insertPaymentInvoiceManual(paymentBean, paymentId);
				userId = trsmethodManualService.insertTrsmethodManual(paymentBean, paymentId);
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
	public void update(PaymentFirstBean paymentBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaymentResultReq findByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
