package th.co.maximus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.maximus.model.PaymentInvoiceManualModel;
import th.co.maximus.payment.bean.PaymentFirstBean;
import th.co.maximus.repository.PaymentInvoiceManualRepository;
import th.co.maximus.repository.PaymentManualRepository;
import th.co.maximus.repository.TrsChequeRefManualRepository;
import th.co.maximus.repository.TrsMethodManualRepository;
import th.co.maximus.repository.TrscreDitrefManualRepository;
import th.co.maximus.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentInvoiceManualRepository paymentInvoiceMonualRepo;
	@Autowired
	private PaymentManualRepository paymentInvoiceRepo;
	@Autowired
	private TrsMethodManualRepository trsMethodManualRepo;
	@Autowired
	private TrsChequeRefManualRepository trsChequeRefManualRepo;
	@Autowired
	private TrscreDitrefManualRepository trsCreDitrefManualRepo;

	@Override
	public void insert(PaymentFirstBean paymentBean) {
		PaymentFirstBean paymentRS = new PaymentFirstBean();
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(PaymentFirstBean paymentBean) {
		// TODO Auto-generated method stub
		
	}

}
