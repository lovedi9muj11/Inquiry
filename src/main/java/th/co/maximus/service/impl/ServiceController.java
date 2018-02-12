package th.co.maximus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

public class ServiceController {
	
	@Autowired PaymentManualServiceImpl serviceImpl;
	
	void paymanet() {
		serviceImpl.insertPaymentManual(null);
		serviceImpl.insertPaymentManual(null);
		serviceImpl.insertPaymentManual(null);
	}

}
